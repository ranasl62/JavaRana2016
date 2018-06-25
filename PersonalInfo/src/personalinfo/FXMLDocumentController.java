/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalinfo;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author M Rana Hossain
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField nameField;
    @FXML
    private TextField mobileNoFiled;
    @FXML
    private TextField eamilIdField;
    @FXML
    private Label labelField;
    @FXML
    private TextArea addressField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
    }    
    public void reset(){
          nameField.setText("");
         mobileNoFiled.setText("");
         eamilIdField.setText("");
         addressField.setText("");
    }
    @FXML
    private void handleSaveInDatabaseAction(ActionEvent event) {
    final String HOSTNAME = "127.0.0.1";
    final String DBNAME = "personalinfo";
    final String USERNAME = "root";
    final String PASSWORD = "BabaManik01915624370";
    final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;   
    
        String name = nameField.getText();
        String mobileNo = mobileNoFiled.getText();
        String emailId = eamilIdField.getText();
        String address = addressField.getText();
         try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);            
            Statement statement = connection.createStatement();
            String query = "insert into personalInfo values('" + name + "', '" + mobileNo + "', '" + emailId + "','" + address + "');";
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println("Connected.............");
         reset();
         labelField.setText("save please try with new");
        
    }
    
}
