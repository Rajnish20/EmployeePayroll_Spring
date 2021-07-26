package com.example.employeepayroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayrollApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(EmployeePayrollApplication.class, args);
        log.info("Employee Payroll App Started in {} Environment",context.getEnvironment().getProperty("environment"));
        log.info("Employee Payroll DB user is {} ",context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
