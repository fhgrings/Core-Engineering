package com.github.erguerra.core_eng.tema_proxy.models;

public class ListOfEmployeesProxy implements ListOfEmployees {

    private RealListOfEmployees realListOfEmployees = new RealListOfEmployees();
    private Employee employee;

    public ListOfEmployeesProxy(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean hireEmployee(Employee employee) {
        if (this.employee.getFunction().equals("Manager")) {
            return realListOfEmployees.hireEmployee(employee);
        }
        throw new RuntimeException("This employee don't have permission to hire or dismiss employees");
    }

    @Override
    public boolean dismissEmployee(Employee employee) {
        if (this.employee.getFunction().equals("Manager")) {
            return realListOfEmployees.dismissEmployee(employee);
        }
        throw new RuntimeException("This employee don't have permission to hire or dismiss employees");
    }
}
