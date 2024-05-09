package net.creqavn;

import net.creqavn.Generator;

public class Account {

    private String username;
    private String password;
    private String phoneNumber;

    public Account() {
        this.username = Generator.username();
        this.password = Generator.password();
        this.phoneNumber = Generator.phoneNumber();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
