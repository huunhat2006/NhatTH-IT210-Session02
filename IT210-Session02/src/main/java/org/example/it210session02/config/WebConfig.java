package org.example.it210session02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.example.it210session02")
public class WebConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}

//2. Lỗi trong WebConfig.java
//@ComponentScan(basePackages = "com.demo.service")
//
//Cấu hình này chỉ định Spring quét các bean trong package com.demo.service.
//Tuy nhiên, lớp WelcomeController lại nằm trong package org.example.it210session02.controller.
//Do đó, Spring không phát hiện được lớp WelcomeController vì nó nằm ngoài phạm vi quét.
//Hệ quả là:
//Không tạo bean cho controller
//Không đăng ký mapping /welcome
//Khi request đến /welcome, Spring không tìm thấy handler phù hợp

//3. Tổng hợp
//Nếu chỉ sửa lỗi thứ nhất (thay mapping từ /api/* thành /), thì DispatcherServlet sẽ nhận được request /welcome.
//Tuy nhiên, do lỗi thứ hai vẫn tồn tại, Spring vẫn không tìm thấy WelcomeController.
//Khi đó:
//Request đã vào được DispatcherServlet
//Nhưng không có controller nào xử lý /welcome
//Hệ thống vẫn trả về HTTP 404
//Kết luận: Việc sửa riêng lỗi mapping là chưa đủ.
//Ứng dụng chỉ hoạt động đúng khi cả hai vấn đề đều được khắc phục: DispatcherServlet phải nhận được request và Spring phải tìm thấy controller để xử lý request đó.