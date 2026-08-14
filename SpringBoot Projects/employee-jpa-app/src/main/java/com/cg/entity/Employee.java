package com.cg.entity;
import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity //mandatoru
@Table(name="EMPLOYEES") //optional
public class Employee {

    @Id//mandatory
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    @Column(name="ENAME",length = 30)
    private String empName;
    private float salary;
    private String address;
    @Transient //ignores this field
    private String password;

    public Employee() {
    }

    public Employee(String empName, float salary, String address) {
        this.empName = empName;
        this.salary = salary;
        this.address = address;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }
}
