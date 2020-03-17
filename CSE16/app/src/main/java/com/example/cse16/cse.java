package com.example.cse16;

public class cse {

    private String ID;
    private String Reg;
    private String Name;
    private String Phone;
    private String Email;
    private String Date;
    private String blood;

    public cse()
    {

    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public cse(String ID, String name, String phone, String Date, String email, String reg, String blood) {
        this.ID = ID;
        Reg = reg;
        Name = name;
        Phone = phone;
        Email = email;
        this.Date = Date;
        this.blood = blood;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getReg() {
        return Reg;
    }

    public void setReg(String reg) {
        Reg = reg;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
