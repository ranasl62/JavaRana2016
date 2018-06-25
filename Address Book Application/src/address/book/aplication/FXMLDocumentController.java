/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.book.aplication;
import address.book.aplication.ContactList.firstNameComparator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import static java.lang.System.exit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author M Rana Hossain
 */
public class FXMLDocumentController implements Initializable {

  
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField occupationField;
    @FXML
    private TextField mobileNoField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField currentCityField;
    @FXML
    private TextField addressLine1Field;
    @FXML
    private TextField addressLine2Field;
    @FXML
    private TextField groupNameField;
    @FXML
    private TextField searchField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField homeTownField;
    @FXML
    private TextField noteField;    
    
    public ArrayList <ContactList> temp; 
    
    public ArrayList <ContactList> contact;
    
    public ArrayList <ContactList> newContact;

    public  RandomAccessFile output;
    
    public RandomAccessFile input;
    
    
    @FXML
    private TableView<ContactList> table;
    @FXML
    private TableColumn<ContactList,String>  mobileNoColumn;
    @FXML
    private TableColumn<ContactList,String>  currentCityColumn;
    @FXML
    private TableColumn<ContactList,String>  occupationColumn;
    @FXML
    private TableColumn<ContactList,String>  groupColumn;
    @FXML
    private TableColumn<ContactList,String> genderColumn;
    @FXML
    private TableColumn<ContactList,String> emailColumn;
    @FXML
    private TableColumn<ContactList,String> homeTownColumn;
    public ObservableList <ContactList> listContact;    
    @FXML
    private TableColumn<ContactList, String> firstNameColumn;
    @FXML
    private TableColumn<ContactList, String> lastNameColumn;
    
    
    private Button search;
    @FXML
    private Button delete;
    @FXML
    private Button saves;
    @FXML
    private Button close;
    @FXML
    private Button edit;
    @FXML
    private Button refresh;
    @FXML
    private Button New;
  
   
    @FXML
    private MenuItem searchByGroup;
    @FXML
    private MenuItem searchByLastName;
    @FXML
    private MenuItem searchByMobileNo;
    @FXML
    private MenuItem searchByHomeTown;
    @FXML
    private MenuItem searchByFirstName;
    @FXML
    private MenuItem searchByOccupation;
    @FXML
    private MenuItem searchByEmail;
    @FXML
    private MenuItem searchByGender;
    @FXML
    private MenuItem searchByCurrentCity;
    @FXML
    private MenuButton searchBy;
    
 
    public int list;
    public String key;
    public int index,helper,searcher;
    public String mobile;
    public int editFlag;
  
    public FXMLDocumentController() throws FileNotFoundException {
        output = new RandomAccessFile("contract.txt","rw");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       editable(false);      
        index=0;
        helper=0;
        searcher=0;
        editFlag=0;
       
        contact = new ArrayList <> ();    
        temp =new ArrayList<>();
        try {
            input = new RandomAccessFile("contract.txt","r");
            while(true){
               String firstName =  input.readLine();
               if(firstName==null)break;
               String lastName = input.readLine();
               String gender = input.readLine();
               String occupation=input.readLine();
               String mobileNo = input.readLine();
               String email =input.readLine();
               String currentCity = input.readLine();
               String homeTown=input.readLine();
               String addressLine1 =input.readLine();
               String addressLine2 = input.readLine();
               String groupName = input.readLine();
               String Note=input.readLine();  
               ContactList newContract = new ContactList(firstName, lastName,  gender,  occupation, mobileNo,  email,  currentCity,  homeTown,  addressLine1,  addressLine2, groupName,Note) ;
               contact.add(newContract);
              }
         } catch (FileNotFoundException ex) {
            System.out.printf("accounts.txt file not found. %s\n",ex);
        } catch (IOException ex) {
            System.out.printf("Something went wrong while writing to the file %s\n",ex);
        
        } 
        Collections.sort(contact , new firstNameComparator());
        listContact = FXCollections.observableArrayList(contact);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory < > ("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory < > ("lastName"));
        mobileNoColumn.setCellValueFactory(new PropertyValueFactory < > ("MobileNo"));
        currentCityColumn.setCellValueFactory(new PropertyValueFactory < > ("currentCity"));
        occupationColumn.setCellValueFactory(new PropertyValueFactory < > ("occupation"));
        groupColumn.setCellValueFactory(new PropertyValueFactory < > ("groupName"));       
        genderColumn.setCellValueFactory(new PropertyValueFactory < > ("gender"));
        homeTownColumn.setCellValueFactory(new PropertyValueFactory < > ("homeTown"));
        emailColumn.setCellValueFactory(new PropertyValueFactory < > ("email"));
        table.setItems(listContact);
    }
    public void add (){               
               String firstName =  firstNameField.getText();            
               String lastName = lastNameField.getText();
               String gender = genderField.getText();
               String occupation=occupationField.getText();
               String mobileNo = mobileNoField.getText();
               String email =emailField.getText();
               String currentCity = currentCityField.getText();
               String homeTown=homeTownField.getText();
               String addressLine1 =addressLine1Field.getText();
               String addressLine2 = addressLine2Field.getText();
               String groupName = groupNameField.getText();
               String note = noteField.getText();
               if(!(firstName.equals("") || mobileNo.equals("") || currentCity.equals(""))){
                   ContactList tempContact;
                   tempContact= new ContactList(firstName, lastName,  gender,  occupation, mobileNo,  email,  currentCity,  homeTown,  addressLine1,  addressLine2, groupName,note) ;
                contact.add(tempContact);
               }             
    }
    
    public void save() {
        int size = contact.size();
                       try {            
            output.setLength(0);
            for(int i=0;i<size;i++){             
                 output.writeBytes(contact.get(i). getFirstName() + "\n");
                 output.writeBytes(contact.get(i).getLastName() + "\n");
                 output.writeBytes(contact.get(i).getGender() + "\n");
                 output.writeBytes(contact.get(i).getOccupation() + "\n");
                 output.writeBytes(contact.get(i).getMobileNo() + "\n");
                 output.writeBytes(contact.get(i).getEmail() + "\n");
                 output.writeBytes(contact.get(i).getCurrentCity() + "\n");
                 output.writeBytes(contact.get(i).getHomeTown() + "\n");
                 output.writeBytes(contact.get(i).getAddressLine1() + "\n");
                 output.writeBytes(contact.get(i).getAddressLine2() + "\n");
                 output.writeBytes(contact.get(i).getGroupName() + "\n"); 
                 output.writeBytes(contact.get(i).getNote()+ "\n");                 
                }           
                        
        } catch (FileNotFoundException ex) {
            System.out.printf("accounts.txt file not found. %s\n",ex);
        } catch (IOException ex) {
            System.out.printf("Something went wrong while writing to the file %s\n",ex);
        }
        Collections.sort(contact , new firstNameComparator());
        if(searcher==0){
        listContact.clear();
        listContact.addAll(contact);
        table.setItems(listContact);
        }
        
    }
    public void delete(){
        if(searcher==0){
        contact.remove(index);  
        }
        else {
            for(ContactList a : contact){
                if(newContact.get(index).getMobileNo().equals(a.getMobileNo())){
                   contact.remove(a);
                   newContact.remove(index);
                   break;
                }
            }
            listContact.clear();
        listContact.addAll(newContact); 
        table.setItems(listContact);
        }
        try {
            output.setLength(0);
        } catch (IOException ex) {
             System.out.printf("Something went wrong while writing to the file %s\n",ex);
        }  
        if(searcher==0){
           list=0; 
        save(); 
        }        
    }
    public void reset(){
        firstNameField.setText("");
        lastNameField.setText("");
        genderField.setText("");
        occupationField.setText("");
        mobileNoField.setText("");
        emailField.setText("");
        currentCityField.setText("");
        homeTownField.setText("");
        addressLine1Field.setText("");
        addressLine2Field.setText("");
        groupNameField.setText("");
        noteField.setText("");
        searchField.setText("");
    }
    public void editable(boolean a){
        firstNameField.setEditable(a);
        lastNameField.setEditable(a);
        genderField.setEditable(a);
        occupationField.setEditable(a);
        mobileNoField.setEditable(a);
        emailField.setEditable(a);
        currentCityField.setEditable(a);
        homeTownField.setEditable(a);
        addressLine1Field.setEditable(a);
        addressLine2Field.setEditable(a);
        groupNameField.setEditable(a);
        noteField.setEditable(a);
    }
    public void set(){
        contact.get(index).setFirstName(firstNameField.getText());
        contact.get(index).setLastName(lastNameField.getText());
        contact.get(index).setGender(genderField.getText());
        contact.get(index).setOccupation(occupationField.getText());
        contact.get(index).setEmail(emailField.getText());
        contact.get(index).setMobileNo(mobileNoField.getText());
        contact.get(index).setCurrentCity(currentCityField.getText());
        contact.get(index).setHomeTown(homeTownField.getText());
        contact.get(index).setAddressLine1(addressLine1Field.getText());
        contact.get(index).setAddressLine2(addressLine2Field.getText());
        contact.get(index).setGroupName(groupNameField.getText());
        contact.get(index).setNote(noteField.getText());
    }
    
    public void set2(){
        temp.get(index).setFirstName(firstNameField.getText());
        temp.get(index).setLastName(lastNameField.getText());
        temp.get(index).setGender(genderField.getText());
        temp.get(index).setOccupation(occupationField.getText());
        temp.get(index).setEmail(emailField.getText());
        temp.get(index).setMobileNo(mobileNoField.getText());
        temp.get(index).setCurrentCity(currentCityField.getText());
        temp.get(index).setHomeTown(homeTownField.getText());
        temp.get(index).setAddressLine1(addressLine1Field.getText());
        temp.get(index).setAddressLine2(addressLine2Field.getText());
        temp.get(index).setGroupName(groupNameField.getText());
        temp.get(index).setNote(noteField.getText());
        for(ContactList a :contact){
            if(a.getMobileNo().equals(mobile)){
                contact.remove(a);
                contact.add(temp.get(index));
                break;
            }
        }
        save();
        // 337 338 339 number line may not work but why haven't found .
        listContact.clear();
        listContact.addAll(temp);
        table.setItems(listContact);
        reset();
   }
       public void display(){
        firstNameField.setText(contact.get(index).getFirstName());
        lastNameField.setText(contact.get(index).getLastName());
        genderField.setText(contact.get(index).getGender());
        occupationField.setText(contact.get(index).getOccupation ());
        mobileNoField.setText(contact.get(index).getMobileNo());
        emailField.setText(contact.get(index).getEmail());
        currentCityField.setText(contact.get(index).getCurrentCity());
        homeTownField.setText(contact.get(index).getHomeTown());
        addressLine1Field.setText(contact.get(index).getAddressLine1());
        addressLine2Field.setText(contact.get(index).getAddressLine2());
        groupNameField.setText(contact.get(index).getGroupName());     
        noteField.setText(contact.get(index).getNote());
       }
       public void display2(){
        firstNameField.setText(newContact.get(index).getFirstName());
        lastNameField.setText(newContact.get(index).getLastName());
        genderField.setText(newContact.get(index).getGender());
        occupationField.setText(newContact.get(index).getOccupation ());
        mobileNoField.setText(newContact.get(index).getMobileNo());
        emailField.setText(newContact.get(index).getEmail());
        currentCityField.setText(newContact.get(index).getCurrentCity());
        homeTownField.setText(newContact.get(index).getHomeTown());
        addressLine1Field.setText(newContact.get(index).getAddressLine1());
        addressLine2Field.setText(newContact.get(index).getAddressLine2());
        groupNameField.setText(newContact.get(index).getGroupName());     
        noteField.setText(newContact.get(index).getNote());
       }
    @FXML
    private void handleButtonAction(ActionEvent event) {
         if(event.getSource() == close){
            exit(0);            
        }
        else if (event.getSource() == saves){
            if(editFlag==1 && helper==1){
            set();
            save();
            reset();
            helper=0;
            editable(false);
            editFlag=0;
            }
            else if(searcher!=0 && editFlag==1){
            set2();
            reset();
            editFlag=0;
            }
            else if (editFlag==2 && helper==0){
            add();
            save();
            reset();
            editFlag=0;
            editable(false);
            }
           
        }
        else if (event.getSource() == edit){
            if(helper==1){
            if(searcher!=0) mobile=mobileNoField.getText();
            editable(true);
            editFlag=1;
            }
            
        }
        else if(event.getSource()==delete){
            if(contact.size()>0 && helper==1){
            delete();
            reset();
            helper=0;
            }
        }
        else if(event.getSource()== New){
            reset(); 
            editable(true);
            editFlag=2;
        }
        else if(event.getSource()==search){
             key=searchField.getText();           
         }
        else if (event.getSource()==refresh){
            if(contact.size()>0){
            listContact.clear();
            listContact.addAll(contact);
            table.setItems(listContact);
            newContact.clear();
            searchBy.setText("Search By");
            searcher=0;   
            editFlag=0;
            }
        }
//        else if (event.getSource()==uploadImage && editFlag==2){
//            FileChooser fileChooser = new FileChooser();
//            File source = fileChooser.showOpenDialog(null);
//            if(source!=null){
//        try{
//            
//            imagePath = source.getName();
//         File target = new File("E:\\Program for Java\\Address Book Aplication\\Image"+imagePath);
//
//     Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
//        javafx.scene.image.Image image = new javafx.scene.image.Image(target.toURI().toString()){};
//        imageView.setImage(image);
//        }catch(FileNotFoundException ex){
//            System.out.println("canceled fileChooser");
//        }catch(IOException e){
//            System.out.println("No 😞");
//        }
//            }

        

//    
//    }
   }

    @FXML
    private void handleSelectContractAction(MouseEvent event) {
        if(contact.size()>0){
      index =  table.getSelectionModel().getSelectedIndex();
      if(index>=0){
      helper=1;
      if(searcher!=0){
          display2();
      }
      else
      {
      display();      
      }
      editable(false);
      }
        }
    }

    @FXML
    private void handleSearchAction(ActionEvent event) {
        switch (searcher) {
            case 1:
                {
                    newContact = new ArrayList<>();
                    key=searchField.getText();
                    for(ContactList a : contact){
                        if(a.getFirstName().contains(key))
                            newContact.add(a);
                    }           
                    listContact.clear();
                    listContact.addAll(newContact);
                    table.setItems(listContact);
                    //temp=newContact;
                    break;
                }
            case 2:
                {
                    newContact = new ArrayList<>();
                    key=searchField.getText();
                    for(ContactList a : contact){
                        if(a.getLastName().contains(key))
                            newContact.add(a);
                    }           
                    listContact.clear();
                    listContact.addAll(newContact);
                    table.setItems(listContact);
                   // temp=newContact;
                    break;
                }
            case 3:
                {
                    newContact = new ArrayList<>();
                    key=searchField.getText();
                    for(ContactList a : contact){
                        if(a.getGender().contains(key))
                            newContact.add(a);
                    }           
                    listContact.clear();
                    listContact.addAll(newContact);
                    table.setItems(listContact);
                   // temp=newContact;
                    break;
                }
            case 4:
            {
                newContact = new ArrayList<>();
                    key=searchField.getText();
                    for(ContactList a : contact){
                        if(a.getOccupation().contains(key))
                            newContact.add(a);
                    }           
                    listContact.clear();
                    listContact.addAll(newContact);
                    table.setItems(listContact);
                   // temp=newContact;
                    break;
                }
            case 5:
                {
                    newContact = new ArrayList<>();
                    key=searchField.getText();
                    for(ContactList a : contact){
                        if(a.getMobileNo().contains(key))
                            newContact.add(a);
                    }           
                    listContact.clear();
                    listContact.addAll(newContact);
                    table.setItems(listContact);
                    //temp=newContact;
                    break;
                }
            case 6:
                {
                    newContact = new ArrayList<>();
                    key=searchField.getText();
                    for(ContactList a : contact){
                        if(a.getEmail().contains(key))
                            newContact.add(a);
                    }           
                    listContact.clear();
                    listContact.addAll(newContact);
                    table.setItems(listContact);
                   // temp=newContact;
                    break;
                }
            case 7:
                {
                    newContact = new ArrayList<>();
                    key=searchField.getText();
                    for(ContactList a : contact){
                        if(a.getCurrentCity().contains(key))
                            newContact.add(a);
                    }           
                    listContact.clear();
                    listContact.addAll(newContact);
                    table.setItems(listContact);
                   // temp=newContact;
                    break;
                }
            case 8:
                {
                    newContact = new ArrayList<>();
                    key=searchField.getText();
                    for(ContactList a : contact){
                        if(a.getHomeTown().contains(key))
                            newContact.add(a);
                    }           
                    listContact.clear();
                    listContact.addAll(newContact);
                    table.setItems(listContact);
                    //temp=newContact;
                    break;
                }
            case 9:
                {
                    newContact = new ArrayList<>();
                    key=searchField.getText();
                    for(ContactList a : contact){
                        if(a.getGroupName().contains(key))
                            newContact.add(a);
                    }           
                    listContact.clear();
                    listContact.addAll(newContact);
                    table.setItems(listContact);
                    // temp=newContact;
                    break;
                }
            default:
                break;
        }
        for(ContactList a : contact){
            temp.add(a);
        }
       
        
    }

    @FXML
    private void handleSearchByAction(ActionEvent event) {
        if(event.getSource()==searchByFirstName){
            searcher=1;  
            searchBy.setText("Search By First Name");
        }
        else if(event.getSource()==searchByLastName){
            searcher=2;            
            searchBy.setText("Search By Last Name");
        }
        else if(event.getSource()==searchByGender){
            searcher=3;         
            searchBy.setText("Search By Gender");
        }
        else if(event.getSource()==searchByOccupation){
            searcher=4;  
            searchBy.setText("Search By Occupation");
        }
        else if(event.getSource()==searchByMobileNo){
            searcher=5;        
            searchBy.setText("Search By Mobile Number");
        }
        else if(event.getSource()==searchByEmail){
            searcher=6;            
            searchBy.setText("Search By Email");
        }
        else if(event.getSource()==searchByCurrentCity){
            searcher=7;            
            searchBy.setText("Search By Current City");
        }
        else if(event.getSource()==searchByHomeTown){
            searcher=8;           
            searchBy.setText("Search By Home Town");
        }
         else if(event.getSource()==searchByGroup){
            searcher=9;            
            searchBy.setText("Search By Group");
        }
    }    
   
    }