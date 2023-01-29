/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


public class modelRegGuards {
    
     private int id;
       private String name;
          private String email;
             private String Add;
                private String Salary;
                   private String   Phone;
                      private String offdays;
                      
    
    public modelRegGuards(){
    
    
    
    
    }

    
    
    public modelRegGuards(int id, String name, String email, String Add, String Salary, String Phone, String offdays) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.Add = Add;
        this.Salary = Salary;
        this.Phone = Phone;
        this.offdays = offdays;
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

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getOffdays() {
        return offdays;
    }

    public void setOffdays(String offdays) {
        this.offdays = offdays;
    }
    
    
    
    
    
    
    
}
