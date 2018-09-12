package com.github.erguerra.core_eng.tema_proxy.app;

import com.github.erguerra.core_eng.tema_proxy.models.Employee;
import com.github.erguerra.core_eng.tema_proxy.models.ListOfEmployeesProxy;

public class Main {

    public static void main(String[] args) {
        Employee employeeManager = new Employee("Cleber", "Manager");
        Employee regularEmployee = new Employee("Carlos", "MobileDeveloper");
        Employee anEmployeeToAdd = new Employee("Juca", "CloudNativeDeveloper");

        ListOfEmployeesProxy listOfEmployees = new ListOfEmployeesProxy(employeeManager);
        try{
            if(listOfEmployees.hireEmployee(anEmployeeToAdd))
                System.out.println("Employee hired by a manager");
            else
                System.out.println("Employee not hired by a manager");
        }catch(RuntimeException runTimeException){
            System.out.println(runTimeException.getMessage());
        }

        ListOfEmployeesProxy listOfEmployeesProxy = new ListOfEmployeesProxy(regularEmployee);

        try{
            if(listOfEmployeesProxy.dismissEmployee(anEmployeeToAdd))
                System.out.println("Employee dismissed by a regular employee");
            else
                System.out.println("Employee was not dismissed by a regular employee");
        }catch(RuntimeException runTimeException){
            System.out.println(runTimeException.getMessage());
        }

    }
}
