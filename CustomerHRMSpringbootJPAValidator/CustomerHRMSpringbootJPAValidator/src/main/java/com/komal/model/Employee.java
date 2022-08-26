package com.komal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long empId;

    @NotNull
    @NotBlank

    //@Pattern(regexp = "^[a-zA-Z0-9]]",message = "Special Characters are Not Allowed")
    @Pattern(regexp = "(^[a-zA-Z0-9]*$)",message = "Special Characters are Not Allowed")
    private String empName;

    @NotNull
    private String empAddress;

    @NotNull
    private int empAge;

    @Column(name="empContactNumber",unique = true)
    //@Size(max = 10,message = "Contact Number must be a 10-digit number")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Contact Number must be a 10-digit number")
    private String empContactNumber;

    private double empSalary;

    @JsonFormat(pattern = "dd-MM-yyyy",timezone = "Asia/Kolkata")
    private Date empDOB;

    @NotBlank
    @Email(message = "Please Enter a valid Email Address")
    @Column(name = "empEmailId",unique = true)
    private String empEmailId;

    @NotBlank
    @Size(min=4 ,message = "Password requires at least 4 Characters ")
    private String empPassword;

}
