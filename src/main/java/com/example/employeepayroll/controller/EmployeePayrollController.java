package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.dto.ResponseDTO;
import com.example.employeepayroll.model.EmployeePayrollData;
import jdk.management.resource.ResourceId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @GetMapping(value = {"","/","home"})
    public ResponseEntity<ResponseDTO> getEmployeePayroll(){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Shatakshi",50000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful",empData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollById(@PathVariable int id){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Shatakshi",50000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID Successful",empData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayroll(@RequestBody EmployeePayrollDTO employeePayrollDto){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,employeePayrollDto);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successfully",empData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@RequestBody EmployeePayrollDTO employeePayrollDto){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,employeePayrollDto);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successfully",empData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully",+id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);

    }
}
