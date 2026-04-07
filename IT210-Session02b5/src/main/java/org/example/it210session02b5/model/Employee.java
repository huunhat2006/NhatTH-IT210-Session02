package org.example.it210session02b5.model;

import java.util.Date;

public class Employee {
    private String code;
    private String name;
    private String department;
    private double salary;
    private Date joinDate;
    private String status;

    public Employee(String code, String name, String department,
                    double salary, Date joinDate, String status) {
        this.code = code;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
        this.status = status;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public Date getJoinDate() { return joinDate; }
    public String getStatus() { return status; }
}