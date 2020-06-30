package com.gin.model;

public class HighSchool {
    protected int idschool;
    protected int nameschool;
    public HighSchool(){
    }

    public HighSchool(int idschool, int nameschool) {
        this.idschool = idschool;
        this.nameschool = nameschool;
    }

    public int getIdschool() {
        return idschool;
    }

    public void setIdschool(int idschool) {
        this.idschool = idschool;
    }

    public int getNameschool() {
        return nameschool;
    }

    public void setNameschool(int nameschool) {
        this.nameschool = nameschool;
    }
}