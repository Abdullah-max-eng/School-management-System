/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagements.fp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
import models.modelRegStudents;


public class StudenstPageController implements Initializable {
      @FXML
    private JFXTextField idSTDtxt;

    @FXML
    private JFXTextField nameSTDtxt;

    @FXML
    private JFXTextField FnameSTDtxt;

    @FXML
    private JFXTextField phoneSTDtxt;

    @FXML
    private JFXTextField emailSTDtxt;

    @FXML
    private JFXTextField addressSTDtxt;
    @FXML
    private JFXButton ClearSTDButton;

    @FXML
    private JFXTextField gradeSTDtxt;
    @FXML
    private TableView<modelRegStudents> studentsTable;

    @FXML
    private TableColumn<modelRegStudents,Integer> StdIDColumn;

    @FXML
    private TableColumn<modelRegStudents,String> STDNameColumn;
    
        @FXML
    private TableColumn<modelRegStudents, String> DateOfBirthColumn;

    @FXML
    private TableColumn<modelRegStudents, String> StdFatherNameCol;

    @FXML
    private TableColumn<modelRegStudents, String> stdPhoneCol;

    @FXML
    private TableColumn<modelRegStudents, String> stdEmailCol;

    @FXML
    private TableColumn<modelRegStudents, String> stdAddressCol;

    @FXML
    private TableColumn<modelRegStudents, String> stdGradeCol;

    @FXML
    private JFXButton AddStudentBTN;

    @FXML
    private JFXButton RemoveStudentBTN;

    @FXML
    private JFXButton ShowStudentsBTN;
    
    @FXML
    private JFXTextField DateOfBirthSTDtxt;
    
    @FXML
    private JFXDatePicker STDdateofBirthPicker;

    @FXML
    private JFXButton UPDateStudenstBTN;
    

    Connection connection = null;
    PreparedStatement prts = null;
    ResultSet resuls = null;



    
    @FXML
    void ClearTXTStudents(ActionEvent event) {
            idSTDtxt.clear();
            nameSTDtxt.clear();
            FnameSTDtxt.clear();
            phoneSTDtxt.clear();
            emailSTDtxt.clear();
            addressSTDtxt.clear();
            gradeSTDtxt.clear();
            DateOfBirthSTDtxt.clear();
               
    }
    

    @FXML
    void BTNADDSTD(ActionEvent event) throws SQLException {
          // Idd = idSTDtxt.getText();
          String  Idd  = idSTDtxt.getText();
                String name = nameSTDtxt.getText();
                  String fatherName = FnameSTDtxt.getText();
                    String phone = phoneSTDtxt.getText();
                      String email = emailSTDtxt.getText();
                        String address = addressSTDtxt.getText();
                          String grade= gradeSTDtxt.getText();
                          LocalDate dateofBirth = STDdateofBirthPicker.getValue();
                          
          try {  
              connection =   dbCOnnection.connect();
              
           
              
             
            String sql = " insert into students values (?,?,?,?,?,?,?,?)"  ;
              prts = connection.prepareStatement(sql);
                 prts.setString(1,Idd);
                   prts.setString(2,name);
                    prts.setString(3,fatherName);
                     prts.setString(4,phone);
                      prts.setString(5,email);
                       prts.setString(6,address);
                        prts.setString(7,grade);
                        prts.setString(8, dateofBirth.toString()); 
                      
              prts.execute();
              
                JOptionPane.showMessageDialog(null, "Students' record inserted Successfully!");
              
              
              
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(StudenstPageController.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null, "Error in insertion!");
          }
        
        
        
    }
      

    @FXML
    void getTheSelectedRow(MouseEvent event) {
             int index =  studentsTable.getSelectionModel().getSelectedIndex();
      idSTDtxt.setText(StdIDColumn.getCellData(index).toString());
         nameSTDtxt.setText(STDNameColumn.getCellData(index));
            FnameSTDtxt.setText(StdFatherNameCol.getCellData(index));
               phoneSTDtxt.setText(stdPhoneCol.getCellData(index));
                emailSTDtxt.setText(stdEmailCol.getCellData(index));
                  addressSTDtxt.setText(stdAddressCol.getCellData(index));
                     gradeSTDtxt.setText(stdGradeCol.getCellData(index));
                        DateOfBirthSTDtxt.setText(DateOfBirthColumn.getCellData(index));
    

    }
   @FXML
    void BTNUpdateSTD(ActionEvent event) {
    
          String Id = idSTDtxt.getText();
          String Name = nameSTDtxt.getText();
            String Fname = FnameSTDtxt.getText();
              String phone = phoneSTDtxt.getText();
                String email = emailSTDtxt.getText();
                  String address = addressSTDtxt.getText();
                    String grade = gradeSTDtxt.getText();
                 //   String dateOFBirth = DateOfBirthSTDtxt.getText();
                        LocalDate dateofBirth = STDdateofBirthPicker.getValue();
          try {
      connection =   dbCOnnection.connect();
      String sql =  "update students set ID=  '"+Id+"' , NAME= '"+Name+"'  ,FATHER_NAME= '"+Fname+"' ,"
              + " PHONE= '"+phone+"'  , EMAIL= '"+email+"' , ADDRESS=  '"+address+"'  , GRADE=   '"+grade+"', "
              + "DATE_OF_BIRTH=   '"+dateofBirth+"' where ID = '"+Id+"'   ";
            
      
      
     prts =   connection.prepareStatement(sql);
            
     prts.execute();
     
     JOptionPane.showMessageDialog(null, "Updated!");
            
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(StudenstPageController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error!");
              Logger.getLogger(StudenstPageController.class.getName()).log(Level.SEVERE, null, ex);
          }
        
 
    }
    
    
    
    

    @FXML // THis button works fine 
    void BtnRemoveSTD(ActionEvent event) throws SQLException  {
          String myid =  idSTDtxt.getText();
        
          try {
              connection =   dbCOnnection.connect();
              String sql = "delete from students where ID = ?";
              prts =connection.prepareStatement(sql);
              prts.setString(1,myid );
              prts.execute();
              
                 JOptionPane.showMessageDialog(null, "Row Deleted!");
      
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(StudenstPageController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "Error!");
          }
       
    }
    
    
    

    @FXML
    void BtnShowSTD(ActionEvent event) {
        ObservableList <modelRegStudents> mylist  =  dbCOnnection.getStudenstRecord();
        studentsTable.setItems(mylist);
    }
    

    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StdIDColumn.setCellValueFactory(new PropertyValueFactory<modelRegStudents,Integer>( "id" ) );
        STDNameColumn.setCellValueFactory(new PropertyValueFactory<modelRegStudents,String>( "name" ) );
        StdFatherNameCol.setCellValueFactory(new PropertyValueFactory<modelRegStudents,String>( "f_name" ) );
        stdPhoneCol.setCellValueFactory(new PropertyValueFactory<modelRegStudents,String>( "phoen" ) );
        stdEmailCol.setCellValueFactory(new PropertyValueFactory<modelRegStudents,String>( "Email" ) );
        stdAddressCol.setCellValueFactory(new PropertyValueFactory<modelRegStudents,String>( "Address" ) );
        stdGradeCol.setCellValueFactory(new PropertyValueFactory<modelRegStudents,String>( "grade" ) );
        DateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<modelRegStudents,String>( "DateOfBirth" ) );
    }    
    
}