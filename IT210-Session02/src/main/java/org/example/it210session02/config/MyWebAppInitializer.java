package org.example.it210session02.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}

//1. Lỗi trong MyWebAppInitializer.java
//Phương thức:
//@Override
//protected String[] getServletMappings() {
//    return new String[] { "/api/*" };
//}
//
//Cấu hình này khiến DispatcherServlet chỉ tiếp nhận các request có URL bắt đầu bằng /api/.
//Điều đó có nghĩa là các đường dẫn như /api/welcome sẽ được xử lý bởi Spring MVC,
//nhưng các đường dẫn như /welcome sẽ không được ánh xạ đến DispatcherServlet.
//Khi người dùng truy cập http://localhost:8080/demo/welcome,
//URL này không khớp với pattern /api/*, nên request không đi qua DispatcherServlet mà được xử lý trực tiếp bởi container (Tomcat).
//Do không có servlet nào xử lý URL này, hệ thống trả về lỗi HTTP 404.
