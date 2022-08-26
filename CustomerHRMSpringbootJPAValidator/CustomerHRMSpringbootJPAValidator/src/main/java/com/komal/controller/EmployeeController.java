package com.komal.controller;

import com.komal.model.Employee;
import com.komal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee)
    {
        return ResponseEntity.ok(employeeServiceImpl.signUp(employee));
    }

    @PostMapping("/signIn/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId,@PathVariable String empPassword)
    {
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Employee> getDataById(@PathVariable long empId)
    {
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData()
    {
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyname/{empName}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName)
    {
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));
    }

    @GetMapping("/getdatabyemailid/{empEmailId}")
    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String empEmailId)
    {
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmailId(empEmailId));
    }

    @GetMapping("/getdatabycontactnumber/{empContactNumber}")
    public ResponseEntity<Employee> getDataByContactNumber(@PathVariable String empContactNumber)
    {
        return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(empContactNumber));
    }

    @GetMapping("/filterdatabysalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterDataBySalary(@PathVariable double empSalary)
    {
        return ResponseEntity.ok(employeeServiceImpl.filterDataBySalary(empSalary));
    }
    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName()
    {
        return ResponseEntity.ok(employeeServiceImpl.sortByName());
    }

    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortBySalary()
    {
        return ResponseEntity.ok(employeeServiceImpl.sortBySalary());
    }

    @GetMapping("/sortbyage")
    public ResponseEntity<List<Employee>> sortByAge()
    {
        return ResponseEntity.ok(employeeServiceImpl.sortByAge());
    }

    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>> sortByDOB()
    {
        return ResponseEntity.ok(employeeServiceImpl.sortByDOB());
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee> updateDataById(@PathVariable long empId,@Valid @RequestBody Employee employee)
    {
        return ResponseEntity.ok(employeeServiceImpl.updateData(empId));
    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable long empId)
    {
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Record deleted successfully.....");
    }
    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData()
    {
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("All Records deleted Successfully.....");
    }
}
