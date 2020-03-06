package cn.itcast.jdbc.domain;

import java.util.Date;

public class User {
    private  int  uId;
    private String uName;
    private String uPassword;
    private Date uBirthday;
    private String uAddress;
    private String uBankId;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Date getuBirthday() {
        return uBirthday;
    }

    public void setuBirthday(Date uBirthday) {
        this.uBirthday = uBirthday;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuBankId() {
        return uBankId;
    }

    public void setuBankId(String uBankId) {
        this.uBankId = uBankId;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uBirthday=" + uBirthday +
                ", uAddress='" + uAddress + '\'' +
                ", uBankId='" + uBankId + '\'' +
                '}';
    }
}
