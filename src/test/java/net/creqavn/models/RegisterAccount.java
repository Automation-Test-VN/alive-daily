package net.creqavn.models;

import net.creqavn.tasks.GenerateRandomValue;

public class RegisterAccount {
    private String userName;
    private String phoneNumber;
    private  String pwd;

    public RegisterAccount(String userName, String phoneNumber, String pwd) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.pwd = pwd;
    }

    public RegisterAccount() {
        this.userName = GenerateRandomValue.generateRandomNumericString(10);;
        this.phoneNumber = GenerateRandomValue.generateRandomPhoneNumber();;
        this.pwd = "Creq@123321";
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPwd() {
        return pwd;
    }
}
