package com.example.myapplication;

class Contact {
    private String name;
    private int id;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact(){

    }
    public Contact(String name, String phoneNumber){
        setName(name);
        setPhoneNumber(phoneNumber);
    }
    public Contact(String name){
        setName(name);
    }
}
