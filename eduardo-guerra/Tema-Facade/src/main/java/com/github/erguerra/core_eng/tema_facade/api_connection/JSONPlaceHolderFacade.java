package com.github.erguerra.core_eng.tema_facade.api_connection;

public class JSONPlaceHolderFacade {

    private JSONPLaceHolderRest todo;

    public JSONPlaceHolderFacade() {
        this.todo = new JSONPLaceHolderRest();
    }

    public String getTodoInformation(Integer todoId) {
        try {
            return todo.todoJSONPlaceHolder(todoId);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return "An error has ocurred";
        }
    }
}

