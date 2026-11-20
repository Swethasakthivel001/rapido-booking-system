package com.main;

public class Driver extends User{

    private String vehicaltype;

    public Driver(String username, String password, String phonenumber, String role, String vehicaltype)
    {
        super(username, password, phonenumber, role);
        this.vehicaltype = vehicaltype;
    }

    public String getVehicaltype()
    {
        return vehicaltype;
    }

    public void setVehicaltype(String vehicaltype)
    {
        this.vehicaltype = vehicaltype;
    }
}