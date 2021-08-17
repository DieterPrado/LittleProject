package com.example.programa.model;

public enum CourseStatus {
    INPROGRESS("inProgress"), TODO("toDo"), PENDING("pending"), BLOCK("block"), DONE("done");

    //Trate de crear enum con valores para poder usarlo para el status
    private String status;

    private CourseStatus(String status){
        this.status=status;
    }

    public String getStatus() {
        return status;
    }
}
