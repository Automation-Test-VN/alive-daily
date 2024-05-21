package net.creqavn.models;

import net.serenitybdd.screenplay.targets.Target;

public class LoginAccount {
    private String userName;
    private String pwd;
    private Target userName_Field;
    private Target pwd_Field;
    private Target submit_BTN;
    private Target AVATAR_USER;

    public Target getUserName_Field() {
        return userName_Field;
    }

    public void setUserName_Field(Target userName_Field) {
        this.userName_Field = userName_Field;
    }

    public Target getPwd_Field() {
        return pwd_Field;
    }

    public void setPwd_Field(Target pwd_Field) {
        this.pwd_Field = pwd_Field;
    }

    public Target getSubmit_BTN() {
        return submit_BTN;
    }

    public void setSubmit_BTN(Target submit_BTN) {
        this.submit_BTN = submit_BTN;
    }

    public Target getAVATAR_USER() {
        return AVATAR_USER;
    }

    public void setAVATAR_USER(Target AVATAR_USER) {
        this.AVATAR_USER = AVATAR_USER;
    }

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

    public LoginAccount(Target userName_Field, String userName, Target pwd_Field,Target Submit_BTN,Target AVATAR_USER) {
        this.userName=userName;
        this.pwd="Creq@123321";
        this.userName_Field = userName_Field;
        this.pwd_Field = pwd_Field;
        this.submit_BTN = Submit_BTN;
        this.AVATAR_USER = AVATAR_USER;
    }

    public LoginAccount(String userName) {
        this.userName=userName;
        this.pwd="Creq@123321";

    }

    public LoginAccount() {
        this.userName = "atcasea10";
        this.pwd = "Creq@123321";
    }
}
