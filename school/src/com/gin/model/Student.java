package com.gin.model;

public class Student {
    protected int id;
    protected int idschool;
    protected String name;
    protected String email;
    protected String pass;
    protected int phone;
    protected String birthday;
    protected String sex;
    public Student( String name,String pass, int phone, String birthday, String sex) {
        this.name = name;
        this.pass = pass;
        this.phone = phone;
        this.birthday = birthday;
        this.sex = sex;
    }

    public Student(int id,  String name,String pass, int phone, String birthday, String sex) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.phone = phone;
        this.birthday = birthday;
        this.sex = sex;
    }

    public Student(String name, String sex){
        this.name = name;
        this.sex = sex;
    }

    public Student(int idschool, String name) {
        this.idschool = idschool;
        this.name = name;
    }

    public Student(int id,int idschool, String pass,String name,String email,int phone,String birthday,String sex) {
        this.id = id;
        this.idschool = idschool;
        this.pass = pass;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.sex = sex;
    }

    public Student(int idschool, String name, String email, String pass, int phone, String birthday, String sex) {
        this.idschool = idschool;
        this.pass = pass;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdschool() {
        return idschool;
    }

    public void setIdschool(int idschool) {
        this.idschool = idschool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
