package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeePayrollDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @GetMapping(value = {"","/","home"})
    public String getEmployeePayroll(){
        return "Got EmployeePayroll successfully ";
    }

    @GetMapping("/get/{id}")
    public String getEmployeePayrollById(@PathVariable int id){
        return "Got EmployeePayroll with Id: "+id +" successfully";
    }

    @PostMapping("/create")
    public String addEmployeePayroll(@RequestBody EmployeePayrollDto employeePayrollDto){
        return "Employee Created Successfully "+employeePayrollDto;
    }

    @PutMapping("/update")
    public String updateEmployeePayroll(@RequestBody EmployeePayrollDto employeePayrollDto){
        return "Employee Payroll Updated Successfully "+employeePayrollDto;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeePayrollById(@PathVariable int id){
        return "EmployeePayroll with id "+id+" deleted successfully";
    }
}
