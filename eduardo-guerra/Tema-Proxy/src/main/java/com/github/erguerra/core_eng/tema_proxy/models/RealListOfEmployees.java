package com.github.erguerra.core_eng.tema_proxy.models;

import java.util.ArrayList;
import java.util.List;

class RealListOfEmployees implements ListOfEmployees{

    private List<Employee> listOfEmployees = new ArrayList<>();

    @Override
    public boolean hireEmployee(Employee employee) {
        return listOfEmployees.add(employee);
    }

    @Override
    public boolean dismissEmployee(Employee employee) {
        return listOfEmployees.remove(employee);
    }
}
