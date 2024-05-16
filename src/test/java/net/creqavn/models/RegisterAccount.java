package net.creqavn.models;

import net.creqavn.tasks.GenerateRandomValue;

public class RegisterAccount {
    private String userName;
    private String phoneNumber;
    private String pwd;
    private String email;

    public RegisterAccount(String userName) {
        this.userName = userName;
        this.phoneNumber = GenerateRandomValue.generatePhoneNumber();
        this.pwd = "Creq@123321";
        this.email = GenerateRandomValue.generateEmail();
    }

    public RegisterAccount() {
        this.userName = GenerateRandomValue.generateUserName(10);
        this.phoneNumber = GenerateRandomValue.generatePhoneNumber();
        this.pwd = "Creq@123321";
        this.email = GenerateRandomValue.generateEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
