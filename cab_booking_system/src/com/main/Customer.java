package com.main;

public class Customer extends User{
    public Customer(String username, String password, String phonenumber, String role)
    {
        super(username, password, phonenumber, role);
    }

    @Override
    public String toString()
    {
        return "Id = "+ getId() + ", Username = "+ getUsername() + ", Phonenumber = "+ getPhonenumber()+ ", Role = "+ getRole();
    }
}