package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.dto.ResponseDTO;
import com.example.employeepayroll.model.EmployeePayrollData;
import com.example.employeepayroll.service.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping(value = {"","/","home"})
    public ResponseEntity<ResponseDTO> getEmployeePayroll(){
        List<EmployeePayrollData> empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful",empDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollById(@PathVariable int id){
        EmployeePayrollData empData = employeePayrollService.getEmployeePayrollDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID Successful",empData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable String department){
        List<EmployeePayrollData> empDataList = employeePayrollService.getEmployeeByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get call for Department Successful",empDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayroll(@Valid @RequestBody EmployeePayrollDTO employeePayrollDto){
        log.debug("Employee DTO :"+employeePayrollDto.toString());
        EmployeePayrollData empData = employeePayrollService.createEmployeePayrollData(employeePayrollDto);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successfully",empData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@Valid @RequestBody EmployeePayrollDTO employeePayrollDto,@PathVariable int id){
        EmployeePayrollData empData = employeePayrollService.updateEmployeePayrollData(employeePayrollDto,id);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successfully",empData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollById(@PathVariable int id){
        employeePayrollService.deleteEmployeePayrollData(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully",+id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
