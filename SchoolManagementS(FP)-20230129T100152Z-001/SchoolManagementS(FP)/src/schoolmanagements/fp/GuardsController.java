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
import models.modelRegGuards;
import models.modelRegStudents;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class GuardsController implements Initializable {
    
     @FXML
    private TableView<modelRegGuards> GuardsTABLE;

    @FXML
    private TableColumn<modelRegGuards, Integer> GuardsIDColumn;

    @FXML
    private TableColumn<modelRegGuards, String> GuardsNameColumn;

    @FXML
    private TableColumn<modelRegGuards, String> GuardsEmailColumn;

    @FXML
    private TableColumn<modelRegGuards, String> GuardsAddressColumn;

    @FXML
    private TableColumn<modelRegGuards, String> GuardsSalaryColumn;

    @FXML
    private TableColumn<modelRegGuards, String> guardsPhoneColumn;

    @FXML
    private TableColumn<modelRegGuards, String> OffDays_Month;

    @FXML
    private JFXButton AddGuardButton;

    @FXML
    private JFXButton RemoveGuardButton;

    @FXML
    private JFXButton ShowGuardButton;

    @FXML
    private JFXButton updateGuardButton;

    @FXML
    private JFXTextField idGuardsTXT;

    @FXML
    private JFXTextField nameGuardsTXT;

    @FXML
    private JFXTextField emailGuardsTXT;

    @FXML
    private JFXTextField addressGuardsTXT;

    @FXML
    private JFXTextField salaryGuardsTXT;

    @FXML
    private JFXTextField phoneGuardsTXT;

    @FXML
    private JFXTextField OFFDaysTXT;

    @FXML
    private JFXButton GuardsBackButton;

    @FXML
    private JFXButton ClearGuradsButton;
     Connection connection = null;
    PreparedStatement prts = null;
    ResultSet resuls = null;


    @FXML
    void AddButtonGuard(ActionEvent event) throws SQLException {
        
         String  Idd  = idGuardsTXT.getText();
                String name = nameGuardsTXT.getText();
                  String email = emailGuardsTXT.getText();
                    String address = addressGuardsTXT.getText();
                      String salary = salaryGuardsTXT.getText();
                        String phone = phoneGuardsTXT.getText();
                          String offDaysMonth= OFFDaysTXT.getText();
                 
                          
          try {  
              connection =   dbCOnnection.connect();
              
           
              
             
            String sql = " insert into guards values (?,?,?,?,?,?,?)"  ;
              prts = connection.prepareStatement(sql);
                 prts.setString(1,Idd);
                   prts.setString(2,name);
                    prts.setString(3,email);
                     prts.setString(4,address);
                      prts.setString(5,salary);
                       prts.setString(6,phone);
                        prts.setString(7,offDaysMonth);
                     
                      
              prts.execute();
              
                JOptionPane.showMessageDialog(null, "Guard's record inserted Successfully!");
              
              
              
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(GuardsController.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null, "Error in insertion!");
          }
        
        


    }

    @FXML
    void ClearTXTGuards(ActionEvent event) {
        
        idGuardsTXT.clear();
          nameGuardsTXT.clear();
            emailGuardsTXT.clear();
              addressGuardsTXT.clear();
                salaryGuardsTXT.clear();
                  phoneGuardsTXT.clear();
                    OFFDaysTXT.clear();
    }

    @FXML
    void GoBackFromGuards(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));  
         Stage SUstage = new Stage();
         Scene myScene1 = new Scene(root);
   
         SUstage.setScene(myScene1);
        SUstage.show();
        
        
        
        

    }

    @FXML
    void RemoveButtonGuard(ActionEvent event) throws SQLException {
            String myid =  idGuardsTXT.getText();
        
          try {
              connection =   dbCOnnection.connect();
              String sql = "delete from guards where ID = ?";
              prts =connection.prepareStatement(sql);
              prts.setString(1,myid );
              prts.execute();
              
                 JOptionPane.showMessageDialog(null, "Row Deleted!");
      
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(GuardsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "Error!");
          }
        
        
        
        
        
        
        
        

    }

    @FXML
    void ShowButtonGuard(ActionEvent event) {
        
           ObservableList <modelRegGuards> mylist  =  dbCOnnection.getguardsRecord();
          GuardsTABLE.setItems(mylist);
 
    }

    
    
    
    
    
    
    @FXML
    void UpdateButtonGuard(ActionEvent event) {
       
        String id = idGuardsTXT.getText();
        String name = nameGuardsTXT.getText();
        String email= emailGuardsTXT.getText();
        String add = addressGuardsTXT.getText();
        String salary = salaryGuardsTXT.getText();
        String phone = phoneGuardsTXT.getText();
        String OffDAys = OFFDaysTXT.getText();
        
        
         try {
             connection =   dbCOnnection.connect();
             
    //   String sql =" ID ='"+id+"' , NAME = '"+name+"', EMAIL= '"+email+"',	ADDRESS = '"+add+"' ,SALARY = '"+salary+"',PHONE = '"+phone+"', OFF_DAYS = '"+OffDAys+"'    " ;
             
           String sql = "update guards set ID =   '"+id+"', NAME = '"+name+"', "
                     + "EMAIL = '"+email+"' , ADDRESS = '"+add+"',SALARY = '"+salary+"', "
                     + "PHONE = '"+phone+"', OFF_DAYS = '"+OffDAys+"' where ID = '"+id+"'      ";       
     prts =   connection.prepareStatement(sql);       
     prts.execute();
     
     JOptionPane.showMessageDialog(null, "Updated!");
            
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(GuardsController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error!");
              Logger.getLogger(GuardsController.class.getName()).log(Level.SEVERE, null, ex);
          }
        
             
             
             
             
             
             
             
    }
   

   

    
    
    
    @FXML
    void getTheSelectedRow(MouseEvent event) {
           int index =  GuardsTABLE.getSelectionModel().getSelectedIndex();
      idGuardsTXT.setText(GuardsIDColumn.getCellData(index).toString());
         nameGuardsTXT.setText(GuardsNameColumn.getCellData(index));
            emailGuardsTXT.setText(GuardsEmailColumn.getCellData(index));
               addressGuardsTXT.setText(GuardsAddressColumn.getCellData(index));
                  phoneGuardsTXT.setText(guardsPhoneColumn.getCellData(index));
                     OFFDaysTXT.setText(OffDays_Month.getCellData(index));
                        salaryGuardsTXT.setText(GuardsSalaryColumn.getCellData(index));
     
        

    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       GuardsIDColumn.setCellValueFactory(new PropertyValueFactory<modelRegGuards,Integer>( "id" ) );
        GuardsNameColumn.setCellValueFactory(new PropertyValueFactory<modelRegGuards,String>( "name" ) );
        GuardsEmailColumn.setCellValueFactory(new PropertyValueFactory<modelRegGuards,String>( "email" ) );
        GuardsAddressColumn.setCellValueFactory(new PropertyValueFactory<modelRegGuards,String>( "Add" ) );
        GuardsSalaryColumn.setCellValueFactory(new PropertyValueFactory<modelRegGuards,String>( "Salary" ) );
        guardsPhoneColumn.setCellValueFactory(new PropertyValueFactory<modelRegGuards,String>( "Phone" ) );
        OffDays_Month.setCellValueFactory(new PropertyValueFactory<modelRegGuards,String>( "offdays" ) );
        
    }    
    
 }