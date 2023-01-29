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
public class modelRegStudents {
    
     private int id;
     private String name;
     private String f_name;
     private String phoen;
     private String Email;
     private String Address;
     private String grade;
     private String DateOfBirth;
    
    public modelRegStudents(){
    
    
    
    }

    public modelRegStudents(int id, String name, String f_name, String phoen, String Email, String Address, String grade, String DoB) {
        this.id = id;
        this.name = name;
        this.f_name = f_name;
        this.phoen = phoen;
        this.Email = Email;
        this.Address = Address;
        this.grade = grade;
        this.DateOfBirth = DoB;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
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

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getPhoen() {
        return phoen;
    }

    public void setPhoen(String phoen) {
        this.phoen = phoen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
     
     
}
