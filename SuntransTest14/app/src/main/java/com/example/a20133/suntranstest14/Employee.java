package com.example.a20133.suntranstest14;

/**
 * Created by 20133 on 2017/3/28.
 */

public class Employee {
    private String firstname;
    private String lastname;
    private String Voltage;

    public Employee(String firstname, String lastname,String Voltage) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.Voltage = Voltage;

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
    public String getVoltage(){
        return Voltage;
    }
    public void setVoltage(String Voltage){
        this.Voltage = Voltage;
    }
}
