/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author pc
 */
public class modelRegJanitors {
         private int id;
       private String name;
          private String email;
             private String Add;
                private String phone;
                   private int   Worked_Hourse_week;
                      private int Wages_Hour;
                         private int netSalary;
                         
                         
                         public modelRegJanitors(){
                         
                         
                         
                         
                         }

    public modelRegJanitors(int id, String name, String email, String Add, String phone, int Worked_Hourse_week, int Wages_Hour, int netSalary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.Add = Add;
        this.phone = phone;
        this.Worked_Hourse_week = Worked_Hourse_week;
        this.Wages_Hour = Wages_Hour;
        this.netSalary = netSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String Add) {
        this.Add = Add;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getWorked_Hourse_week() {
        return Worked_Hourse_week;
    }

    public void setWorked_Hourse_week(int Worked_Hourse_week) {
        this.Worked_Hourse_week = Worked_Hourse_week;
    }

    public int getWages_Hour() {
        return Wages_Hour;
    }

    public void setWages_Hour(int Wages_Hour) {
        this.Wages_Hour = Wages_Hour;
    }

    public int getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(int netSalary) {
        this.netSalary = netSalary;
    }
    
    
}
