/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagements.fp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.collections.ArrayChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.modelRegJanitors;
import models.modelRegTeachers;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class JanitorsController implements Initializable {


  
    @FXML
    private TableView<modelRegJanitors> JanitorsTABLE;

    @FXML
    private TableColumn<modelRegJanitors, Integer> JanitorIDColumn;

    @FXML
    private TableColumn<modelRegJanitors, String> JanitorNameColumn;

    @FXML
    private TableColumn<modelRegJanitors, String> JanitorEmailColumn;

    @FXML
    private TableColumn<modelRegJanitors, String> JanitorAddressColumn;

    @FXML
    private TableColumn<modelRegJanitors, String> JanitorPhoneColumn;

    @FXML
    private TableColumn<modelRegJanitors, Integer> JanitWorkedHperW;

    @FXML
    private TableColumn<modelRegJanitors, Integer> WagesPerHour;

    @FXML
    private TableColumn<modelRegJanitors, Integer> NetSalary;

    @FXML
    private JFXButton AddJanitorButton;

    @FXML
    private JFXButton RemoveJanitorButton;

    @FXML
    private JFXButton ShowJanitorButton;

    @FXML
    private JFXButton updateJanitorButton;

    @FXML
    private JFXTextField idJanitortxt;

    @FXML
    private JFXTextField nameJanitortxt;

    @FXML
    private JFXTextField emailJanitortxt;

    @FXML
    private JFXTextField addressJanitortxt;

    @FXML
    private JFXTextField WorkedHoursWTXT;

    @FXML
    private JFXTextField wagesPerHourTXT;

    @FXML
    private JFXTextField NetSalaryTXT;

    @FXML
    private JFXButton JanitorBackButton;

    @FXML
    private JFXButton ClearJanitorButton;

    @FXML
    private JFXTextField phoneJanitortxt;
      PreparedStatement prts = null;
      Connection connection = null;
      ResultSet resuls = null;

    @FXML
    void AddButtonJanitor(ActionEvent event) throws SQLException {
         String  Idd  = idJanitortxt.getText();
                String name = nameJanitortxt.getText();
                  String email = emailJanitortxt.getText();
                    String address = addressJanitortxt.getText();
                         String phone = phoneJanitortxt.getText();
                         Integer workedHoursPerWeek = Integer.parseInt(WorkedHoursWTXT.getText());
                          Integer Wages_H= Integer.parseInt(wagesPerHourTXT.getText());
                    //      Integer NSalary = Integer.parseInt(NetSalaryTXT.getText());
                          
                          
                          int Net_salary = workedHoursPerWeek*Wages_H;
                          
                          
                           try {  
                            connection =   dbCOnnection.connect();
              
           
              
             
            String sql = " insert into janitors values (?,?,?,?,?,?,?,?)"  ;
              prts = connection.prepareStatement(sql);
                 prts.setString(1,Idd);
                   prts.setString(2,name);
                    prts.setString(3,email);
                     prts.setString(4,address);
                      prts.setString(5,phone);
                       prts.setInt(6,workedHoursPerWeek);
                        prts.setInt(7,Wages_H);
                          prts.setInt(8,Net_salary);
                      
              prts.execute();
              
                JOptionPane.showMessageDialog(null, "Janitors' record inserted Successfully!");
     
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(JanitorsController.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null, "Error in insertion!");
          }


    }

    @FXML
    void ClearTXTJanitor(ActionEvent event) {
        idJanitortxt.clear();
         nameJanitortxt.clear();
          emailJanitortxt.clear();
           addressJanitortxt.clear();
            WorkedHoursWTXT.clear();
             wagesPerHourTXT.clear();
              NetSalaryTXT.clear();
               phoneJanitortxt.clear();
        

    }

    @FXML
    void GoBackFromJanitor(ActionEvent event) throws IOException {
        
     Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));  
      Stage SUstage = new Stage();
      Scene myScene1 = new Scene(root);
   
      SUstage.setScene(myScene1);
      SUstage.show();

    }
    
 
    @FXML
    void RemoveButtonJanitor(ActionEvent event) throws SQLException {
                     String myid =  idJanitortxt.getText();
        
          try {
              connection =   dbCOnnection.connect();
              String sql = "delete from janitors where ID = ?";
              prts =connection.prepareStatement(sql);
              prts.setString(1,myid );
              prts.execute();
              
                 JOptionPane.showMessageDialog(null, "Row Deleted!");
      
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(JanitorsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "Error!");
          }
        

    }
  

    @FXML
    void ShowButtonJanitor(ActionEvent event) {
        
        
        
           ObservableList <modelRegJanitors> mylist  =  dbCOnnection.getjanitorsRecord();
           JanitorsTABLE.setItems(mylist);

    }
 
    @FXML
    void UpdateButtonJanitor(ActionEvent event) {
        String id = idJanitortxt.getText();
        String name = nameJanitortxt.getText();
        String email= emailJanitortxt.getText();
        String add = addressJanitortxt.getText();
        String phone = phoneJanitortxt.getText();
          Integer workedHoursPerWeek = Integer.parseInt(WorkedHoursWTXT.getText());
        Integer Wages_H= Integer.parseInt(wagesPerHourTXT.getText());
      //  String netSalary = NetSalaryTXT.getText();
              int Net_salary = workedHoursPerWeek*Wages_H;
          
        
        
           try {
               connection =   dbCOnnection.connect();
               
                   String sql = "update janitors set ID =   '"+id+"', NAME = '"+name+"', "
                     + "EMAIL = '"+email+"' , ADDRESS = '"+add+"',	PHONE = '"+phone+"', "
                     + "WORKED_H = '"+workedHoursPerWeek+"', WAGES_H = '"+Wages_H+"'  , NET_SALARY	 = '"+Net_salary+"' where ID = '"+id+"'      ";        
               
               
                 prts =   connection.prepareStatement(sql);    
               
                 prts.execute();
                 JOptionPane.showMessageDialog(null, "Updated!");  
               
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(JanitorsController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Error!");
               Logger.getLogger(JanitorsController.class.getName()).log(Level.SEVERE, null, ex);
           }
        

 
    }
 

    @FXML
    void getTheSelectedRow(MouseEvent event) {
            int index =  JanitorsTABLE.getSelectionModel().getSelectedIndex();
      idJanitortxt.setText(JanitorIDColumn.getCellData(index).toString());
         nameJanitortxt.setText(JanitorNameColumn.getCellData(index));
            emailJanitortxt.setText(JanitorEmailColumn.getCellData(index));
               addressJanitortxt.setText(JanitorAddressColumn.getCellData(index));
                phoneJanitortxt.setText(JanitorPhoneColumn.getCellData(index));
                  WorkedHoursWTXT.setText(JanitWorkedHperW.getCellData(index).toString());
                     wagesPerHourTXT.setText(WagesPerHour.getCellData(index).toString());
                        NetSalaryTXT.setText(NetSalary.getCellData(index).toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         JanitorIDColumn.setCellValueFactory(new PropertyValueFactory<modelRegJanitors, Integer>( "id" ) );
        JanitorNameColumn.setCellValueFactory(new PropertyValueFactory<modelRegJanitors,String>( "name" ) );
        JanitorEmailColumn.setCellValueFactory(new PropertyValueFactory<modelRegJanitors,String>( "email" ) );
        JanitorAddressColumn.setCellValueFactory(new PropertyValueFactory<modelRegJanitors,String>( "Add" ) );
        JanitorPhoneColumn.setCellValueFactory(new PropertyValueFactory<modelRegJanitors,String>( "phone" ) );
        
        
        
        JanitWorkedHperW.setCellValueFactory(new PropertyValueFactory<modelRegJanitors, Integer>( "Worked_Hourse_week" ) );
         
        WagesPerHour.setCellValueFactory(new PropertyValueFactory<modelRegJanitors, Integer>( "Wages_Hour" ) );
        NetSalary.setCellValueFactory(new PropertyValueFactory<modelRegJanitors, Integer>( "netSalary" ) );
        
        
        
        
       
    }
    


    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    

