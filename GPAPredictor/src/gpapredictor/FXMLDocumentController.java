/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpapredictor;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author M Rana Hossain
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private Label lave2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final String HOSTNAME = "localhost";
        final String DBNAME = "predictdb";
        final String USERNAME = "root";
        final String PASSWORD = "BabaManik01915624370";
        final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

        try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.printf("Connected\n");
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleButton2Action(ActionEvent event) {
    }

}
