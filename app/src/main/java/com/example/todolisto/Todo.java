package com.example.todolisto;

public class Todo {
    private String name;
    private boolean realizado;

    public Todo(String actionName){
        this.name = actionName;
        realizado = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

}
