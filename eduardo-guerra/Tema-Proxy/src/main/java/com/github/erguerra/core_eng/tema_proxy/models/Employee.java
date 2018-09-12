package com.github.erguerra.core_eng.tema_proxy.models;

public class Employee {
    private String name;
    private String function;

    public Employee(String name, String funcition) {
        this.name = name;
        this.function = funcition;
    }

    public String getFunction() {
        return this.function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
