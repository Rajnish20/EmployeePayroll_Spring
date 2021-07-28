package com.example.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString
class EmployeePayrollDTO {
    @NotEmpty(message = "Name cannot be Empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$",message = "Employee name invalid")
    public String name;

    @Min(value = 500,message = "Min wage should be more than 500")
    public long salary;

    @Pattern(regexp = "Male|Female",message = "Gender needs to be Male or Female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "startDate should not be empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    public String note;

    @NotBlank(message = "profilePic cannot be empty")
    public String profilePic;

    @NotNull(message = "departments should not be empty")
    public List<String> departments;



}
