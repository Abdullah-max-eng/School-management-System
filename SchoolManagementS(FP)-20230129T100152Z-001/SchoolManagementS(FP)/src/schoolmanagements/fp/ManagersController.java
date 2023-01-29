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
import models.modelRegManagers;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ManagersController implements Initializable {

       @FXML
    private TableView<modelRegManagers> ManagersTable;

    @FXML
    private TableColumn< modelRegManagers, Integer> ManagerIDColumn;

    @FXML
    private TableColumn< modelRegManagers, String> ManagerNameColumn;

    @FXML
    private TableColumn< modelRegManagers, String> ManagerEmailColumn;

    @FXML
    private TableColumn< modelRegManagers, String> ManagerAddressColumn;

    @FXML
    private TableColumn< modelRegManagers, String> ManagerSalaryColumn;

    @FXML
    private TableColumn< modelRegManagers, String> ManagerPhoneColumn;

    @FXML
    private TableColumn< modelRegManagers, String> ManagerLevelColumn;

    @FXML
    private TableColumn< modelRegManagers, String> ManagerDepartmentColumn;

    @FXML
    private JFXButton AddManagerButton;

    @FXML
    private JFXButton removeManagerButton;

    @FXML
    private JFXButton ShowManagerButton;

    @FXML
    private JFXButton updateManagerButton;

    @FXML
    private JFXTextField IdManagersTXT;

    @FXML
    private JFXTextField nameManagersTXT;

    @FXML
    private JFXTextField emailManagersTXT;

    @FXML
    private JFXTextField AddressManagersTXT;

    @FXML
    private JFXTextField SalaryManagersTXT;

    @FXML
    private JFXTextField phoneManagersTXT;

    @FXML
    private JFXTextField levelManagersTXT;

    @FXML
    private JFXButton ManagersBackButton;

    @FXML
    private JFXButton ClearManagersButton;

    @FXML
    private JFXTextField DepartmentManagersTXT;
    
    Connection connection = null;
    PreparedStatement prts = null;
    ResultSet resuls = null;

    @FXML
    void AddButtonManager(ActionEvent event) throws SQLException {
        
        
            String  Idd  = IdManagersTXT.getText();
                String name = nameManagersTXT.getText();
                  String email = emailManagersTXT.getText();
                    String address = AddressManagersTXT.getText();
                      String salary = SalaryManagersTXT.getText();
                        String phone = phoneManagersTXT.getText();
                          String level= levelManagersTXT.getText();
                         String department = DepartmentManagersTXT.getText();
                          
          try {  
              connection =   dbCOnnection.connect();
              
           
              
             
            String sql = " insert into managers values (?,?,?,?,?,?,?,?)"  ;
              prts = connection.prepareStatement(sql);
                 prts.setString(1,Idd);
                   prts.setString(2,name);
                    prts.setString(3,email);
                     prts.setString(4,address);
                      prts.setString(5,salary);
                       prts.setString(6,phone);
                        prts.setString(7,level);
                        prts.setString(8, department); 
                      
              prts.execute();
              
                JOptionPane.showMessageDialog(null, "Manager's record inserted Successfully!");
              
              
              
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(ManagersController.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null, "Error in insertion!");
          }
        
 
        
        
     

    }

    @FXML
    void UpdateButtonManagers(ActionEvent event) {
        
        String id = IdManagersTXT.getText();
        String name = nameManagersTXT.getText();
        String email= emailManagersTXT.getText();
        String add = AddressManagersTXT.getText();
        String salary = SalaryManagersTXT.getText();
        String phone = phoneManagersTXT.getText();
        String level = levelManagersTXT.getText();
        String department = DepartmentManagersTXT.getText();
        
        
           try {
               connection =   dbCOnnection.connect();
               
             String sql = "update managers set ID =   '"+id+"', NAME = '"+name+"', "
                     + "EMAIL = '"+email+"' , ADDRESS = '"+add+"',SALARY = '"+salary+"', "
                     + "PHONE = '"+phone+"', LEVEL = '"+level+"'  , DEPARTMENT = '"+department+"' where ID = '"+id+"'       ";        
               
               
                 prts =   connection.prepareStatement(sql);    
              
                 prts.execute();
                  JOptionPane.showMessageDialog(null, "Updated!");  
               
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ManagersController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Error!");
               Logger.getLogger(ManagersController.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        
        
        
        
        
        
        
        

    }
    
    
    

    @FXML
    void ClearTXTManagers(ActionEvent event) {
            IdManagersTXT.clear();
            nameManagersTXT.clear();
            emailManagersTXT.clear();
            phoneManagersTXT.clear();
            levelManagersTXT .clear();
            AddressManagersTXT.clear();
            SalaryManagersTXT.clear();
            DepartmentManagersTXT.clear();
        
    

    }

    @FXML
    void GoBackFromManagers(ActionEvent event) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));  
      Stage SUstage = new Stage();
      Scene myScene1 = new Scene(root);
   
      SUstage.setScene(myScene1);
      SUstage.show();

    }
    
    

    @FXML
    void RemoveButtonManagers(ActionEvent event) throws SQLException {
            String myid =  IdManagersTXT.getText();
        
          try {
              connection =   dbCOnnection.connect();
              String sql = "delete from  managers where ID = ?";
              prts =connection.prepareStatement(sql);
              prts.setString(1,myid );
              prts.execute();
              
                 JOptionPane.showMessageDialog(null, "Row Deleted!");
      
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(ManagersController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "Error!");
          }
        
        
        

    }

    @FXML
    void ShowButtonManagers(ActionEvent event) {
    
                   ObservableList <modelRegManagers> mylist  =  dbCOnnection.getManagersRecord();
       ManagersTable.setItems(mylist);  
        
  
    }

    @FXML
    void getTheSelectedRow(MouseEvent event) {
             int index =  ManagersTable.getSelectionModel().getSelectedIndex();
      IdManagersTXT.setText(ManagerIDColumn.getCellData(index).toString());
         nameManagersTXT.setText(ManagerNameColumn.getCellData(index));
            emailManagersTXT.setText(ManagerEmailColumn.getCellData(index));
               AddressManagersTXT.setText(ManagerAddressColumn.getCellData(index));
                  SalaryManagersTXT.setText(ManagerSalaryColumn.getCellData(index));
                     phoneManagersTXT.setText(ManagerPhoneColumn.getCellData(index));
                        levelManagersTXT.setText(ManagerNameColumn.getCellData(index));
                            DepartmentManagersTXT.setText(ManagerDepartmentColumn.getCellData(index));
        
        
        
        
        
        
        

    }
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ManagerIDColumn.setCellValueFactory(new PropertyValueFactory<modelRegManagers,Integer>( "id" ) );
        ManagerNameColumn.setCellValueFactory(new PropertyValueFactory<modelRegManagers,String>( "name" ) );
        ManagerEmailColumn.setCellValueFactory(new PropertyValueFactory<modelRegManagers,String>( "email" ) );
        ManagerAddressColumn.setCellValueFactory(new PropertyValueFactory<modelRegManagers,String>( "Add" ) );
        ManagerSalaryColumn.setCellValueFactory(new PropertyValueFactory<modelRegManagers,String>( "Salary" ) );
        ManagerPhoneColumn.setCellValueFactory(new PropertyValueFactory<modelRegManagers,String>( "Phone" ) );
        ManagerLevelColumn.setCellValueFactory(new PropertyValueFactory<modelRegManagers,String>( "level" ) );
        ManagerDepartmentColumn.setCellValueFactory(new PropertyValueFactory<modelRegManagers,String>( "department" ) );
        
        
        
        
        
        
    }    
    
}
