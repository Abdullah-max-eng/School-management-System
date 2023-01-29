/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagements.fp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.modelRegStudents;
import models.modelRegTeachers;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class TeachersController implements Initializable {
   @FXML
    private TableView<modelRegTeachers> TeacherTABLE;

    @FXML
    private TableColumn<modelRegTeachers, Integer> TechIDColumn;

    @FXML
    private TableColumn<modelRegTeachers, String> TechNameColumn;

    @FXML
    private TableColumn<modelRegTeachers, String> TechEmailColumn;

    @FXML
    private TableColumn<modelRegTeachers, String> TechAddressColumn;

    @FXML
    private TableColumn<modelRegTeachers, String> TechSalaryColumn;

    @FXML
    private TableColumn<modelRegTeachers, String> TechPhoneColumn;

    @FXML
    private TableColumn<modelRegTeachers, String> TechSubjectColumn;

    @FXML
    private JFXButton AddTECHButton;

    @FXML
    private JFXButton RemoveTECHButton;

    @FXML
    private JFXButton ShowTECHButton;

    @FXML
    private JFXButton updateTECHButton;

    @FXML
    private JFXTextField idTECHtxt;

    @FXML
    private JFXTextField nameTechtxt;

    @FXML
    private JFXTextField emailTechtxt;

    @FXML
    private JFXTextField addressTechtxt;

    @FXML
    private JFXTextField salaryTechtxt;

    @FXML
    private JFXTextField phoneTechtxt;

    @FXML
    private JFXTextField SubjectTechtxt;

    @FXML
    private JFXButton techBackButton;

    @FXML
    private JFXButton ClearTeachersButton;
    
    PreparedStatement prts = null;
    Connection connection = null;
      ResultSet resuls = null;

    @FXML
    void AddButtonTeach(ActionEvent event) throws SQLException {
        
        
                String  Idd  = idTECHtxt.getText();
                String name = nameTechtxt.getText();
                  String email = emailTechtxt.getText();
                    String address = addressTechtxt.getText();
                      String salary = salaryTechtxt.getText();
                        String phone = phoneTechtxt.getText();
                          String subject= SubjectTechtxt.getText();
                          
                           try {  
              connection =   dbCOnnection.connect();
              
           
              
             
            String sql = " insert into teachers values (?,?,?,?,?,?,?)"  ;
              prts = connection.prepareStatement(sql);
                 prts.setString(1,Idd);
                   prts.setString(2,name);
                    prts.setString(3,email);
                     prts.setString(4,address);
                      prts.setString(5,salary);
                       prts.setString(6,phone);
                        prts.setString(7,subject);
                      
              prts.execute();
              
                JOptionPane.showMessageDialog(null, "Teachers' record inserted Successfully!");
              
              
              
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TeachersController.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null, "Error in insertion!");
          }
        
        
        
        

    }
    
    
    @FXML
    void getTheSelectedRow(MouseEvent event) {
        
        int index =  TeacherTABLE.getSelectionModel().getSelectedIndex();
      idTECHtxt.setText(TechIDColumn.getCellData(index).toString());
         nameTechtxt.setText(TechNameColumn.getCellData(index));
            emailTechtxt.setText(TechEmailColumn.getCellData(index));
               addressTechtxt.setText(TechAddressColumn.getCellData(index));
                  salaryTechtxt.setText(TechSalaryColumn.getCellData(index));
                     phoneTechtxt.setText(TechPhoneColumn.getCellData(index));
                        SubjectTechtxt.setText(TechSubjectColumn.getCellData(index));
        
        

    }

    @FXML
    void ClearTXTTeachers(ActionEvent event) {
        
        idTECHtxt.clear();
            nameTechtxt.clear();
                emailTechtxt.clear();
                    addressTechtxt.clear();
                        salaryTechtxt.clear();
                            phoneTechtxt.clear();
                                SubjectTechtxt.clear();
                               
    }

    @FXML
    void GoBackFromTeachers(ActionEvent event) throws IOException {
        
      Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));  
      Stage SUstage = new Stage();
      Scene myScene1 = new Scene(root);
   
      SUstage.setScene(myScene1);
      SUstage.show();
        
        
     

    }

    @FXML
    void RemoveButtonTeach(ActionEvent event) throws SQLException {
             String myid =  idTECHtxt.getText();
        
          try {
              connection =   dbCOnnection.connect();
              String sql = "delete from teachers where ID = ?";
              prts =connection.prepareStatement(sql);
              prts.setString(1,myid );
              prts.execute();
              
                 JOptionPane.showMessageDialog(null, "Row Deleted!");
      
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TeachersController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "Error!");
          }
       
    }
        
        
     

    @FXML
    void ShowButtonTeach(ActionEvent event) {
    
           ObservableList <modelRegTeachers> mylist  =  dbCOnnection.getTeachersRecord();
           TeacherTABLE.setItems(mylist);
       
    }
    


    @FXML
    void UpdateButtonTeach(ActionEvent event) {
         String Id = idTECHtxt.getText();
          String Name = nameTechtxt.getText();
            String email = emailTechtxt.getText();
              String add = addressTechtxt.getText();
                String salary = salaryTechtxt.getText();
                  String phone = phoneTechtxt.getText();
                    String subject = SubjectTechtxt.getText();
                   
          try {
      connection =   dbCOnnection.connect();
      String sql = " update teachers set ID = '"+Id+"', NAME = '"+Name+"' , EMAIL = '"+email+"' , 	ADDRESS = '"+add+"', SALARY =  '"+salary+"',	PHONE = '"+phone+"' , 	SUBJECT =  '"+subject+"' where ID = '"+Id+"'       ";
      
      
     prts =   connection.prepareStatement(sql);
              
     prts.execute();
     
     JOptionPane.showMessageDialog(null, "Updated!");
            
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TeachersController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error!");
              Logger.getLogger(TeachersController.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
        
        
        
        
        
        

    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
         TechIDColumn.setCellValueFactory(new PropertyValueFactory<modelRegTeachers,Integer>( "id" ) );
        TechNameColumn.setCellValueFactory(new PropertyValueFactory<modelRegTeachers,String>( "name" ) );
        TechEmailColumn.setCellValueFactory(new PropertyValueFactory<modelRegTeachers,String>( "email" ) );
        TechAddressColumn.setCellValueFactory(new PropertyValueFactory<modelRegTeachers,String>( "Add" ) );
        TechSalaryColumn.setCellValueFactory(new PropertyValueFactory<modelRegTeachers,String>( "Salary" ) );
        TechPhoneColumn.setCellValueFactory(new PropertyValueFactory<modelRegTeachers,String>( "Phone" ) );
        TechSubjectColumn.setCellValueFactory(new PropertyValueFactory<modelRegTeachers,String>( "Subject" ) );
        
        
        
        
    
    }


    
}

        
        
        
        
        
        

    
    
    
    
    
    
    
    
    
