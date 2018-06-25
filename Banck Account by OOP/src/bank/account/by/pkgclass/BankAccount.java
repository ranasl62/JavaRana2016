/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.by.pkgclass;

/**
 *
 * @author M Rana Hossain
 */
public class BankAccount {
    private String acountName ,accountNumber;
    private double balance;
    public String address;

    /**
     *constructor
     * @param accountName
     * @param accountNumber
     * @param address
     * @param balance
     */
    public void BankAccount(String accountName, String accountNumber, String address ,double balance ){
        this.accountNumber = accountNumber;
        this.acountName= accountName;
        this.address=address;
        this.balance=balance;        
    }

    /**
     *
     * @param amount deposit
     */
    public  void deposit(int amount){
        if(amount>0){
            balance+=amount;
        }
    }

    /**
     *
     * @param amount withdrew
     */
    public  void withdrew(int amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
        }
    }

    /**
     *
     * @return balance
     */
    public double getbalance(){
        return balance;
    }
    
    
}
