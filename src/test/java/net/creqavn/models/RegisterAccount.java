package net.creqavn.models;

import net.creqavn.tasks.GenerateRandomValue;

public class RegisterAccount {
    private String userName;
    private String phoneNumber;
    private String pwd;

    public RegisterAccount(String userName) {
        this.userName = userName;
        this.phoneNumber = GenerateRandomValue.generatePhoneNumber();
        this.pwd = "Creq@123321";
    }

    public RegisterAccount() {
        this.userName = GenerateRandomValue.generateUserName(10);
        this.phoneNumber = GenerateRandomValue.generatePhoneNumber();
        this.pwd = "Creq@123321";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
