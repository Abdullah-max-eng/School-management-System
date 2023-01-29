/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagements.fp;
import java.sql.PreparedStatement;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class SignUpController implements Initializable {
  
        @FXML
    private JFXTextField textEmailSP;

    @FXML
    private JFXPasswordField txtpasswordSP;

    @FXML
    private JFXTextField txtNameSP;

    @FXML
    private JFXTextField txtPhoneSP;

     @FXML
    private JFXButton SignUpBtn;

    
    
 Connection conn = null;
 PreparedStatement  preStamemnt;
 
    @FXML
    void btnSignup(ActionEvent event) throws SQLException {
         try {
         conn =  dbCOnnection.connect();
         String sql = "insert into registration (NAME , EMAIL, PHONE, PASSWORD ) values (? , ?, ?, ?)";
         preStamemnt = conn.prepareStatement(sql);
         // preStamemnt =   conn.prepareStatement(sql);         
         preStamemnt.setString(1,txtNameSP.getText());
         preStamemnt.setString(2,textEmailSP.getText());
         preStamemnt.setString(3,txtPhoneSP.getText());
         preStamemnt.setString(4,txtpasswordSP.getText());
         preStamemnt.execute();
            JOptionPane.showMessageDialog(null," You have signed up ");         
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("Sign Up cannot work ");
          } 


    }


 

    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
