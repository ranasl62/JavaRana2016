/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.book.aplication;

import java.util.Comparator;

/**
 *
 * @author M Rana Hossain
 */
public class ContactList {
    private  String firstName;
    private  String lastName;
    private  String gender;
    private  String occupation;
    private  String mobileNo;
    private  String email;
    private  String currentCity;
    private  String homeTown;
    private  String addressLine1;
    private  String addressLine2;
    private  String groupName;
    private  String note;

    public ContactList(String firstName, String lastName, String gender, String occupation, String mobileNo, String email, String currentCity, String homeTown, String addressLine1, String addressLine2, String groupName, String note) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.occupation = occupation;
        this.mobileNo = mobileNo;
        this.email = email;
        this.currentCity = currentCity;
        this.homeTown = homeTown;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.groupName = groupName;
        this.note = note;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public String getNote() {
        return note;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getGroupName() {
        return groupName;
    }
    
   public static class  firstNameComparator implements Comparator<ContactList>
{
    @Override
    public int compare(ContactList contract1, ContactList contract2)
    {
       return contract1.getFirstName().compareTo(contract2.getFirstName());
    }

        
    }
      
}
