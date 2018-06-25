/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinocalculator;

import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.tan;
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
    
    int newoperation=0;
    int oldoperation=0;
    double number1=0.0f;
    double number2=0.0f;
    int signed=0;
    boolean sign =false;
    double pi =2*acos(0.0);
    @FXML
    private TextField displayField;
    @FXML
    private Button Mrc;
    @FXML
    private Button Mmin;
    @FXML
    private Button Mplus;
    @FXML
    private Button Percentange;
    @FXML
    private Button Power;
    @FXML
    private Button Pi;
    @FXML
    private Button Div;
    @FXML
    private Button Signed;
    @FXML
    private Button Seven;
    @FXML
    private Button Eight;
    @FXML
    private Button Nine;
    @FXML
    private Button Mult;
    @FXML
    private Button Four;
    @FXML
    private Button Five;
    @FXML
    private Button Six;
    @FXML
    private Button Min;
    @FXML
    private Button Sqrt;
    @FXML
    private Button One;
    @FXML
    private Button Two;
    @FXML
    private Button Three;
    @FXML
    private Button Plus;
    @FXML
    private Button Ac;
    @FXML
    private Button C;
    @FXML
    private Button Zero;
    @FXML
    private Button Dot;
    @FXML
    private Button Equal;    
    @FXML
    private Button Sin;
    @FXML
    private Button Cos;
    @FXML
    private Button Tan;
    @FXML
    private Button Log;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleButtonAction(ActionEvent event) {
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
               
       }
       
       
       else   if(event.getSource()==Nine){
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
            else{
                displayField.setText("0");
                sign = false;
            }                         
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
        
       
       else if (event.getSource()==C){
           int len = displayField.getText().length();
           if(displayField.getText().equals("NaN") || displayField.getText().equals("Infinity") )
               displayField.setText("0");
           else if(len>0){
               displayField.setText(displayField.getText().substring(0, len-1) );
           }
         if(--len<=0)
               displayField.setText("0"); 
        
       }
       
       
       else  if(event.getSource() == Ac){
            displayField.setText("0");
            newoperation=0;
            oldoperation=0;
            number1=0.0f;
            number2=0.0f;
            signed=0;  
            sign = false;
       }
         

       else if(event.getSource()==Log){
             displayField.setText((log(Double.parseDouble(displayField.getText())))/log(10)+"");
             sign = true; 
             number1=number2=0.0f;
         }
       
       
       else if(event.getSource()==Signed){
             String a;
            a = displayField.getText();
             if(displayField.getText().charAt(0) != '-' && displayField.getText().charAt(0) != '+'){ 
                     displayField.setText("-"+a);
             }
             else {
                 a = displayField.getText();
                 if(a.charAt(0)=='-'){
                     a = a.replace(a.charAt(0) , '+');
                 }
                 else 
                     a = a.replace(a.charAt(0) , '-');
                 displayField.setText(a);
             }
             
         }

       
       else if (event.getSource()  == Pi){                    
                 displayField.setText(pi+"");
                 sign = true; 
                 number1=number2=0.0f;
             }
        
        
       else if (event.getSource()==Sqrt){
            double sq ;
            sq = Double.parseDouble(displayField.getText());
            sq = sqrt(sq);
            displayField.setText(sq+"");
            sign = true; 
            number1=number2=0.0f;
        }
        
        
       else if(event.getSource()==Plus){
            if(newoperation==0){
                newoperation =1;
            number1=Double.parseDouble(displayField.getText());
             sign=true;
            }
            else if(sign==false)
            {
                switch (newoperation){ 
                case 1 :{
                    number2=Double.parseDouble(displayField.getText());
                   displayField.setText((number1+number2)+"");
                   number1=Double.parseDouble(displayField.getText());
                } break;
                case 2 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1-number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                    
                } break;
                case 3 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1*number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                } break;
                case 4 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1/number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                } break;
            }
            sign =true;
        }
            newoperation=1;
        }
        
        
        else if(event.getSource()==Min){
            if(newoperation==0){
                newoperation =2;
            number1=Double.parseDouble(displayField.getText());
             sign=true;
            }
            else if(sign==false)
            {
                switch (newoperation){ 
                case 1 :{
                    number2=Double.parseDouble(displayField.getText());
                   displayField.setText((number1+number2)+"");
                   number1=Double.parseDouble(displayField.getText());
                } break;
                case 2 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1-number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                    
                } break;
                case 3 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1*number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                } break;
                case 4 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1/number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                } break;
            }
            sign =true;
        }
            newoperation=2;
        }
        
        
        else if(event.getSource()==Mult){            
                if(newoperation==0){
                newoperation =3;
            number1=Double.parseDouble(displayField.getText());
             sign=true;
            }
                else if(sign==false)
            {
                switch (newoperation){ 
                case 1 :{
                    number2=Double.parseDouble(displayField.getText());
                   displayField.setText((number1+number2)+"");
                   number1=Double.parseDouble(displayField.getText());
                } break;
                case 2 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1-number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                    
                } break;
                case 3 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1*number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                } break;
                case 4 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1/number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                } break;
            }
            sign =true;
        }
            newoperation=3;          
            
        }
        
        
        else if(event.getSource()==Div){
            if(newoperation==0){
                newoperation =4;
            number1=Double.parseDouble(displayField.getText());
             sign=true;
            }
            else if(sign==false)
            {
                switch (newoperation){ 
                case 1 :{
                    number2=Double.parseDouble(displayField.getText());
                   displayField.setText((number1+number2)+"");
                   number1=Double.parseDouble(displayField.getText());
                } break;
                case 2 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1-number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                    
                } break;
                case 3 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1*number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                } break;
                case 4 :{
                    number2=Double.parseDouble(displayField.getText());
                    displayField.setText((number1/number2)+"");
                    number1=Double.parseDouble(displayField.getText());
                } break;
            }
            sign =true;
        }
            newoperation=4;
        }
        
        
        else if(event.getSource()==Percentange){  
            if(newoperation!=0){
                  number2=Double.parseDouble(displayField.getText());                        
                switch (newoperation) {
                    case 1:
                        displayField.setText((number1+number1*number2/100.0)+"");
                        number1=Double.parseDouble(displayField.getText());
                             break;
                    case 2:
                        displayField.setText((number1-number1*number2/100.0)+"");
                        number1=Double.parseDouble(displayField.getText());
                        break;
                    case 3:
                        displayField.setText((number1*(number2/100.0))+"");
                        number1=Double.parseDouble(displayField.getText());
                        break;
                    case 4:
                      displayField.setText((number1/((number1*number2)/100.0))+"");
                        number1=Double.parseDouble(displayField.getText());
                        break;
                }                    
                        
        }
            newoperation = 0;
            sign = false;
        }
        
        
        else if (event.getSource()==Power){
              newoperation =5;
            number1=Double.parseDouble(displayField.getText());
             sign=true;
        }
        
        
        else if(event.getSource()==Sin){
            displayField.setText(sin(Double.parseDouble(displayField.getText())*pi/180)+"");
            sign = true;               
            number1=number2=0.0f;
        }
        
        
        else if(event.getSource()==Cos){
                if(Double.parseDouble(displayField.getText())==90.0) 
                    displayField.setText("0");
                  else
                    displayField.setText(cos(Double.parseDouble(displayField.getText())*pi/180)+"");
                sign = true;
                number1=number2=0.0f;
        }
        
        
        else if(event.getSource()==Tan){
            if(Double.parseDouble(displayField.getText())==90.0)           
            displayField.setText("Infinity");
            else
                 displayField.setText(tan(Double.parseDouble(displayField.getText())*pi/180)+"");
            sign = true;
                number1=number2=0.0f;
        }
        
        
        else if (event.getSource()== Equal){ 
            int len;
            do{
                number2  = Double.parseDouble(displayField.getText()); 
                len = displayField.getText().length();
            }while(len==0);
            switch (newoperation){ 
                case 1 :
                   displayField.setText((number1+number2)+"");
                 break;
                case 2 :
                    displayField.setText((number1-number2)+"");
                    
                break;
                case 3 :
                    displayField.setText((number1*number2)+"");
                 break;
                case 4 :
                    displayField.setText((number1/number2)+"");
                 break;
                case 5 :
                    displayField.setText((pow(number1,number2))+"");
                    break; 
             }
            newoperation = 0;
        }       
    }  
}
