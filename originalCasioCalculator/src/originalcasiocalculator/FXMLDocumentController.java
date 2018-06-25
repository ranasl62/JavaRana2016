/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package originalcasiocalculator;

import static java.lang.Math.acos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author M Rana Hossain
 */
public class FXMLDocumentController implements Initializable {
  static  double num1=0.0f,num2=0.0f,result=0.0f;
  static  boolean op1=false,op2=false,sign=false;
  static  double  pi = acos(-1);
  int operation1=0;
  int operation2=0;
    @FXML
    private TextField displayField;  
    @FXML
    private Button One;
    @FXML
    private Button Two;
    @FXML
    private Button Three;
    @FXML
    private Button Zero;
    @FXML
    private Button C;
    @FXML
    private Button Ac;
    @FXML
    private Button Percentage;
    @FXML
    private Button Seven;
    @FXML
    private Button Eight;
    @FXML
    private Button Nine;
    @FXML
    private Button Div;
    @FXML
    private Button Four;
    @FXML
    private Button Five;
    @FXML
    private Button Six;
    @FXML
    private Button Mult;
    @FXML
    private Button Sub;
    @FXML
    private Button Dot;
    @FXML
    private Button Equal;
    @FXML
    private Button Add;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
       if(event.getSource()==One){
           if(!"0".equals(displayField.getText()) && sign==false ){
               displayField.setText(displayField.getText()+"1");
           }            
            else {
               displayField.setText("1");
               sign =false;
           }
               
       }
       else   if(event.getSource()==Two){
           if(!"0".equals(displayField.getText()) && sign==false ){
               displayField.setText(displayField.getText()+"2");
           }            
            else {
               displayField.setText("2");
               sign =false;
           }
               
       }
       else   if(event.getSource()==Three){
           if(!"0".equals(displayField.getText()) && sign==false ){
               displayField.setText(displayField.getText()+"3");
           }            
            else {
               displayField.setText("3");
               sign =false;
           }
               
       }
       else   if(event.getSource()==Four){
           if(!"0".equals(displayField.getText()) && sign==false ){
               displayField.setText(displayField.getText()+"4");
           }            
            else {
               displayField.setText("4");
               sign =false;
           }
               
       }
       else   if(event.getSource()==Five){
           if(!"0".equals(displayField.getText()) && sign==false ){
               displayField.setText(displayField.getText()+"5");
           }            
            else {
               displayField.setText("5");
               sign =false;
           }
               
       }
       else   if(event.getSource()==Six){
           if(!"0".equals(displayField.getText()) && sign==false ){
               displayField.setText(displayField.getText()+"6");
           }            
            else {
               displayField.setText("6");
               sign =false;
           }
               
       }
       else   if(event.getSource()==Seven){
           if(!"0".equals(displayField.getText()) && sign==false ){
               displayField.setText(displayField.getText()+"7");
           }            
            else {
               displayField.setText("7");
               sign =false;
           }
               
       }
       else   if(event.getSource()==Eight){
           if(!"0".equals(displayField.getText()) && sign==false ){
               displayField.setText(displayField.getText()+"8");
           }            
            else {
               displayField.setText("8");
               sign =false;
           }
               
       }else   if(event.getSource()==Nine){
           if(!"0".equals(displayField.getText()) && sign==false ){
               displayField.setText(displayField.getText()+"9");
           }            
            else {
               displayField.setText("9");
               sign =false;
           }
               
       }
       else  if(event.getSource() == Zero){
            if(!"0".equals(displayField.getText())&& sign==false){
                displayField.setText(displayField.getText()+"0");
            }
else
        displayField.setText("0");        
        }
       else if(event.getSource() == Dot ){
             if(!displayField.getText().contains(".")){
                 if(!"0".equals(displayField.getText()) && sign==false ){
               displayField.setText(displayField.getText()+".");
           }            
            else {
               displayField.setText("0.");
               sign =false;
           }
             }             
         }
       
         else   if(event.getSource()==Add){
          if(operation1==0){
              
       }      
        
    }

    
}
