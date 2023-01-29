/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagements.fp;

import com.jfoenix.controls.JFXButton;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class MainPageController implements Initializable {
    @FXML
    private JFXButton ManagersBTN;

    @FXML
    private JFXButton teachersBTN;

    @FXML
    private JFXButton janitorsBTN;

    @FXML
    private JFXButton GuardsBTN;

    @FXML
    private JFXButton StudentsBTN;
    
    
    @FXML
    private  Hyperlink HyperFacebook ;


   

   
     @FXML
    void FacebookHyperlink(ActionEvent event) throws URISyntaxException {
            if(Desktop.isDesktopSupported())
    {
        try {
            Desktop.getDesktop().browse(new URI("https://www.facebook.com/abdullah.fazli.58"));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    };

    }
    
    
        
 
       @FXML
    private ImageView fbHyperlinkImage;
    
        @FXML
    void imageFBHyper(MouseEvent event) throws URISyntaxException {
        
        
                if(Desktop.isDesktopSupported())
    {
        try {
            Desktop.getDesktop().browse(new URI("http://www.facebook.com"));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    };

    }

  
    
        @FXML
    void LogoutfromMianpage(ActionEvent event) throws IOException {
        
                    
      Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));   
      Stage stg1 = new Stage();
   
      Scene myScene1 = new Scene(root);
   
      stg1.setScene(myScene1);
      stg1.show();
        
        
        

    }


    @FXML
    void GuardsCTG(ActionEvent event) throws IOException {
        
               
      Parent root = FXMLLoader.load(getClass().getResource("Guards.fxml"));   
      
            Stage stg2 = new Stage();
      Scene myScene1 = new Scene(root);
   
      stg2.setScene(myScene1);
      stg2.show();

    }

    @FXML
    void janitorsCTG(ActionEvent event) throws IOException {
        
      Parent root = FXMLLoader.load(getClass().getResource("Janitors.fxml"));  
    //  Stage SUstage = new Stage();
      Scene myScene1 = new Scene(root);
   Stage stg3 = new Stage();
      stg3.setScene(myScene1);
      stg3.show();

    }

    @FXML
    void mangersCtg(ActionEvent event) throws IOException {
        
      Parent root = FXMLLoader.load(getClass().getResource("Managers.fxml"));  
     
      Scene myScene1 = new Scene(root);
      Stage stg3 = new Stage();
      stg3.setScene(myScene1);
      stg3.show();
        

    }

    @FXML
    void studentsCTG(ActionEvent event) throws IOException {
        
      Parent root = FXMLLoader.load(getClass().getResource("StudenstPage.fxml"));  
  ///   Stage SUstage = new Stage();
      Scene myScene1 = new Scene(root);
    Stage stg3 = new Stage();
      stg3.setScene(myScene1);
      stg3.show();

    }

    @FXML
    void teachersCTG(ActionEvent event) throws IOException { 
        
       Parent root = FXMLLoader.load(getClass().getResource("Teachers.fxml"));  
 //     Stage SUstage = new Stage();
      Scene myScene1 = new Scene(root);
      Stage stg3 = new Stage();
      stg3.setScene(myScene1);
      stg3.show();
      
      

    }

    

    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
