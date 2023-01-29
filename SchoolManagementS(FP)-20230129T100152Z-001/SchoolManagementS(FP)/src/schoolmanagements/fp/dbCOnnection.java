package schoolmanagements.fp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import models.modelRegGuards;
import models.modelRegJanitors;
import models.modelRegManagers;
import models.modelRegStudents;
import models.modelRegTeachers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class dbCOnnection {
        
   public static Connection connect() throws ClassNotFoundException{
       String url, user, pass;
       
      Connection conection = null;
       
        Class.forName("com.mysql.jdbc.Driver");    
        url = "jdbc:mysql://localhost:3306/db_school"; 
        user = "root";
        pass = "";
        
        
        
        try {
          conection =   DriverManager.getConnection(url,user,pass); 
          System.out.println("Connected with the database sucessfully ");
          
        } catch (SQLException ex) {
            Logger.getLogger(dbCOnnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conection;
    
    }
   
   public static ObservableList <modelRegStudents> getStudenstRecord(){
       
       ObservableList<modelRegStudents> mylist = FXCollections.observableArrayList();
   
       try {
           
           
           Connection conn = connect();
           PreparedStatement preStatement = conn.prepareStatement("select*from students");
           ResultSet result =   preStatement.executeQuery();
           
           while(result.next()){
           
               modelRegStudents mymodel = new modelRegStudents();
               
           int ID =   result.getInt("ID");
           String name =    result.getString("NAME");
             String f_Name = result.getString("FATHER_NAME");
               String phone =    result.getString("PHONE");
                 String Email =    result.getString("EMAIL");
                     String Address =    result.getString("ADDRESS");
                            String Grade =    result.getString("GRADE");
                            String Dob = result.getString("DATE_OF_BIRTH");
              
             mymodel.setId(ID);
             mymodel.setName(name);
             mymodel.setF_name(f_Name);
             mymodel.setPhoen(phone);
             mymodel.setEmail(Email);
             mymodel.setAddress(Address);
             mymodel.setGrade(Grade);
             mymodel.setDateOfBirth(Dob);
             
             mylist.addAll(mymodel);
           }
           
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(dbCOnnection.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(dbCOnnection.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   
   return mylist;
   
   
   }
   
   
   
   
   
   
   
   
   
   
   
   
      public static ObservableList <modelRegTeachers> getTeachersRecord(){
       
       ObservableList<modelRegTeachers> mylist = FXCollections.observableArrayList();
   
       try {
           
           
           Connection conn = connect();
           PreparedStatement preStatement = conn.prepareStatement("select*from teachers");
           ResultSet result =   preStatement.executeQuery();
           
           while(result.next()){
           
             modelRegTeachers   mymodel = new modelRegTeachers();
               
           int ID =   result.getInt("ID");
           String name =    result.getString("NAME");
             String email = result.getString("EMAIL");
               String adress =    result.getString("ADDRESS");
                 String Salary =    result.getString("SALARY");
                     String phone =    result.getString("PHONE");
                            String subject =    result.getString("SUBJECT");
              
             mymodel.setId(ID);
             mymodel.setName(name);
             mymodel.setEmail(email);
             mymodel.setAdd(adress);
             mymodel.setSalary(Salary);
             mymodel.setPhone(phone);
             mymodel.setSubject(subject);
             
             
             mylist.addAll(mymodel);
           }
           
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(dbCOnnection.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(dbCOnnection.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   
   return mylist;
   
   
   }
   
   
   
   
   
      
      
      
public static ObservableList <modelRegManagers> getManagersRecord(){
       
       ObservableList<modelRegManagers> mylist = FXCollections.observableArrayList();
   
       try {
           
           
           Connection conn = connect();
           PreparedStatement preStatement = conn.prepareStatement("select*from managers");
           ResultSet result =   preStatement.executeQuery();
           
           while(result.next()){
           
             modelRegManagers   mymode2 = new modelRegManagers();
               
           int ID =   result.getInt("ID");
           String name =    result.getString("NAME");
             String email = result.getString("EMAIL");
               String adress =    result.getString("ADDRESS");
                 String Salary =    result.getString("SALARY");
                     String phone =    result.getString("PHONE");
                            String level =    result.getString("LEVEL");
                                  String department =    result.getString("DEPARTMENT");
              
             mymode2.setId(ID);
             mymode2.setName(name);
             mymode2.setEmail(email);
             mymode2.setAdd(adress);
             mymode2.setSalary(Salary);
             mymode2.setPhone(phone);
             mymode2.setLevel(level);
               mymode2.setDepartment(department);
             
             
             mylist.addAll(mymode2);
           }
           
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(dbCOnnection.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(dbCOnnection.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   
   return mylist;
   
   
   }
   
   
   
   
   
   


public static ObservableList <modelRegJanitors> getjanitorsRecord(){
       
       ObservableList<modelRegJanitors> mylist = FXCollections.observableArrayList();
   
       try {
           
           
           Connection conn = connect();
           PreparedStatement preStatement = conn.prepareStatement("select*from janitors");
           ResultSet result =   preStatement.executeQuery();
           
           while(result.next()){
           
             modelRegJanitors   mymode2 = new modelRegJanitors();
               
           int ID =   result.getInt("ID");
           String name =    result.getString("NAME");
             String email = result.getString("EMAIL");
               String adress =    result.getString("ADDRESS");
                 String phone =    result.getString("PHONE");
                     int Worked_hours =    result.getInt("WORKED_H");
                          int  Wages_H =    result.getInt("WAGES_H");
                                  int netSalary =    result.getInt("NET_SALARY");
              
             mymode2.setId(ID);
             mymode2.setName(name);
             mymode2.setEmail(email);
             mymode2.setAdd(adress);
             mymode2.setPhone(phone);
             mymode2.setWorked_Hourse_week(Worked_hours);
                 mymode2.setWages_Hour(Wages_H);
                  mymode2.setNetSalary(netSalary);
          
             
             
             mylist.addAll(mymode2);
           }
           
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(dbCOnnection.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(dbCOnnection.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   
   return mylist;
   
   
   }





















public static ObservableList <modelRegGuards> getguardsRecord(){
       
       ObservableList<modelRegGuards> mylist = FXCollections.observableArrayList();
   
       try {
           
           
           Connection conn = connect();
           PreparedStatement preStatement = conn.prepareStatement("select*from guards");
           ResultSet result =   preStatement.executeQuery();
           
           while(result.next()){
           
             modelRegGuards   mymode4 = new modelRegGuards();
               
           int ID =   result.getInt("ID");
           String name =    result.getString("NAME");
             String email = result.getString("EMAIL");
               String adress =    result.getString("ADDRESS");
                 String salary =    result.getString("SALARY");
                     String phone =    result.getString("PHONE");
                         String offDays =    result.getString("OFF_DAYS");
                    
              
             mymode4.setId(ID);
             mymode4.setName(name);
             mymode4.setEmail(email);
             mymode4.setAdd(adress);
             mymode4.setSalary(salary);
              mymode4.setPhone(phone);
               mymode4.setOffdays(offDays);
         
          
             
             
             mylist.addAll(mymode4);
           }
           
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(dbCOnnection.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(dbCOnnection.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   
   return mylist;
   
   
   }

















   
   
   
   
   
   
   
   
   
    
}
