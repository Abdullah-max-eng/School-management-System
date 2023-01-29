/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagements.fp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class FXMLDocumentController implements Initializable {
  
     @FXML
    private JFXTextField txtEmailSIN;

    @FXML
    private JFXButton SignInBtn;

    @FXML
    private JFXPasswordField txtPasswordSIN;

    @FXML
    private JFXButton NoaccountSignup;
    
    
    Connection conec = null;
    PreparedStatement stt;
    ResultSet result;
   

    @FXML
    void btnSignin(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
     conec =   dbCOnnection.connect(); 
     
     String sql = "Select * from registration where EMAIL = ?  and PASSWORD = ?";
     
    stt = conec.prepareStatement(sql);
    stt.setString(1,txtEmailSIN.getText() );
    stt.setString(2,txtPasswordSIN.getText() );   
    result = stt.executeQuery();
        
   
   if (result.next()){
   // whtn the eamil and password is OK here is the coding for the next page 
     JOptionPane.showMessageDialog(null, "Valid Credentials");
   
      Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml")); 
      Stage SUstage = new Stage();
      Scene myScene1 = new Scene(root);
   
      SUstage.setScene(myScene1);
      SUstage.show();
   
   
   
   
   
   
   }
   else {
       JOptionPane.showMessageDialog(null, "Invalid Credentials");}   
    }
    
    
    @FXML
    void SignupNExtp(ActionEvent event) throws IOException {
        
        // This coding will take the user when the dont have account to the sign up page by cliking sign up button 
      Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml")); 
      Stage SUstage = new Stage();
      Scene myScene1 = new Scene(root);
   
      SUstage.setScene(myScene1);
      SUstage.show();

    }
    
    
  
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
