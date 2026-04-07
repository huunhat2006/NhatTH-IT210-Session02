package org.example.it210session02b5.service;

import org.example.it210session02b5.model.Employee;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EmployeeService {
    public List<Employee> getAll() {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            List<Employee> list = new ArrayList<>();
            list.add(new Employee("NV001","Nguyễn Thị Lan","Kế toán",15000000,f.parse("2020-03-01"),"Đang làm"));
            list.add(new Employee("NV002","Trần Văn Hùng","Kỹ thuật",25000000,f.parse("2019-07-15"),"Đang làm"));
            list.add(new Employee("NV003","Lê Minh Đức","Kinh doanh",18500000,f.parse("2021-11-20"),"Nghỉ phép"));
            list.add(new Employee("NV004","Phạm Thu Hương","Kỹ thuật",22000000,f.parse("2022-01-05"),"Đang làm"));
            list.add(new Employee("NV005","Hoàng Văn Nam","Kế toán",12000000,f.parse("2023-06-10"),"Thử việc"));

            return list;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    public Employee findByCode(String code) {
        return getAll().stream().filter(e -> e.getCode().equals(code)).findFirst().orElseThrow(() -> new RuntimeException("Nhân viên " + code + " không tồn tại"));
    }
    public double totalSalaryTech() {
        return getAll().stream().filter(e -> e.getDepartment().equals("Kỹ thuật")).mapToDouble(Employee::getSalary).sum();
    }
}