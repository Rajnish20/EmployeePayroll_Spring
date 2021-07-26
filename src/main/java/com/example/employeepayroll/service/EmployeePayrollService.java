package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.exception.EmployeePayrollException;
import com.example.employeepayroll.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollDataList.stream()
                .filter(employeePayrollData -> employeePayrollData.getEmployeeId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
        this.employeePayrollDataList.add(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO, int id) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(id);
        employeePayrollData.setName(employeePayrollDTO.getName());
        employeePayrollData.setSalary(employeePayrollDTO.getSalary());
        this.employeePayrollDataList.set(id-1,employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollDataList.remove(empId - 1);
    }
}
