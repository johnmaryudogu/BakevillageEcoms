package org.johnmaryudogu.bakevillageecoms.model;

public class AdminModel {
    private int id;
    private String firstname;
    private String lastname;
    private String password;
    private String confirmpassword;
    private String itemEntered;

    public AdminModel() {}

    public AdminModel(String firstname, String lastname, String password, String confirmpassword, String itemEntered) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.itemEntered = itemEntered;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getItemEntered() {
        return itemEntered;
    }

    public void setItemEntered(String itemEntered) {
        this.itemEntered = itemEntered;
    }
}
