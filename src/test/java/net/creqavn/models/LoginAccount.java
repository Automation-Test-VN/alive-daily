package net.creqavn.models;

public class LoginAccount {
    private String userName;
    private String pwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public LoginAccount(String userName, String pwd) {
        this.userName=userName;
        this.pwd="Creq@123321";
    }

    public LoginAccount() {
        this.userName = "atcasea10";
        this.pwd = "Creq@123321";
    }
}
