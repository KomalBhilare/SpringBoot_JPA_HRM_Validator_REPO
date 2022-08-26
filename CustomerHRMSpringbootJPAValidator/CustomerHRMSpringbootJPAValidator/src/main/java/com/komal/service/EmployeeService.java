package com.komal.service;

import com.komal.EmployeeRepository.EmployeeRepository;
import com.komal.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;
    public Employee signUp(Employee employee)
    {
        return  employeeRepositoryImpl.save(employee);
    }
    public boolean signIn(String empEmailId,String empPassword)
    {
        boolean flag=false;
        for(Employee emp:getAllData())
        {
            if(emp.getEmpEmailId().equals(empEmailId) && emp.getEmpPassword().equals(empPassword))
                flag=true;
        }

        return flag;
    }

    public List<Employee> getAllData()
    {
        return employeeRepositoryImpl.findAll();
    }

    public Employee getDataById(long empId)
    {
        return employeeRepositoryImpl.findById(empId).get();
    }

    public Employee getDataByContactNumber(String empContactNumber)
    {
        Employee emp1=null;
        for(Employee emp:getAllData())
        {
            if(emp.getEmpContactNumber().equals(empContactNumber))
                emp1=emp;
        }

        return emp1;
    }

    public List<Employee> getDataByName(String empName)
    {
        List<Employee> employees=new ArrayList<>();
        for(Employee emp:getAllData())
        {
            if(emp.getEmpName().equals(empName))
                employees.add(emp);
        }
        return employees;
    }

    public Employee getDataByEmailId(String empEmailId)
    {
        Employee emp1=null;
        for(Employee emp:getAllData())
        {
            if(emp.getEmpEmailId().equals(empEmailId))
                emp1=emp;
        }
        return emp1;
    }

    public List<Employee> filterDataBySalary(double empSalary)
    {
        return getAllData().stream().filter(emp->emp.getEmpSalary()>=empSalary).collect(Collectors.toList());
    }

    public List<Employee> sortByName()
    {
        return getAllData().stream().sorted((e1,e2)->e1.getEmpName().compareTo(e2.getEmpName())).collect(Collectors.toList());
    }

    public List<Employee> sortBySalary()
    {
        return getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList());
    }

    public List<Employee> sortByDOB()
    {
        return getAllData().stream().sorted((e1,e2)->e1.getEmpDOB().compareTo(e1.getEmpDOB())).collect(Collectors.toList());
    }

    public List<Employee> sortByAge()
    {
        return getAllData().stream().sorted(Comparator.comparingLong(Employee::getEmpAge)).collect(Collectors.toList());
    }

    public Employee updateData(long empId)
    {
        Employee emp1=employeeRepositoryImpl.findById(empId).get();
        for(Employee emp:getAllData())
        {
            if(emp.getEmpId()==empId)
            {
                emp1.setEmpName(emp.getEmpName());
                emp1.setEmpAddress(emp.getEmpAddress());
                emp1.setEmpAge(emp.getEmpAge());
                emp1.setEmpContactNumber(emp.getEmpContactNumber());
                emp1.setEmpSalary(emp.getEmpSalary());
                emp1.setEmpDOB(emp.getEmpDOB());
                emp1.setEmpEmailId(emp.getEmpEmailId());
                emp1.setEmpPassword(emp.getEmpPassword());
            }
        }
        return emp1;
    }

    public void deleteDataById(long empId)
    {
        employeeRepositoryImpl.deleteById(empId);
    }


    public void deleteAllData()
    {
        employeeRepositoryImpl.deleteAll();
    }
}
