package com.example.MyEarn11.Model;

public class UserModel {
    private String  name, mobile,address,password, holding,withdrawed;
    private String add;

    public UserModel() {
    }

    public UserModel(String p_added, String p_holding, String p_name, String p_mobile, String p_withdrawed, String p_address, String p_pwd) {
        add = p_added;
        holding = p_holding;
        name = p_name;
        mobile = p_mobile;
        withdrawed = p_withdrawed;
        address = p_address;
        password = p_pwd;
    }

    public String getAdd() {
        return  add;
    }

    public String getHolding() {
        return  holding;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWithdrawed() {
        return  withdrawed;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

}

