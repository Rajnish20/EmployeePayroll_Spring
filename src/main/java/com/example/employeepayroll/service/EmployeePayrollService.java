package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.exception.EmployeePayrollException;
import com.example.employeepayroll.model.EmployeePayrollData;
import com.example.employeepayroll.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRepository
                .findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO, int id) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(id);
        employeePayrollData.updateEmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);
    }

    @Override
    public List<EmployeePayrollData> getEmployeeByDepartment(String department) {
        return employeePayrollRepository.findEmployeePayrollByDepartment(department);
    }
}
