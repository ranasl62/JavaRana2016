/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.by.oop;

import bank.account.by.pkgclass.BankAccount;

/**
 *
 * @author M Rana Hossain
 */
public class BanckAccountByOOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       BankAccount[] bankAccount;
        bankAccount = new BankAccount[5];
       bankAccount[2].BankAccount("Rana", "01615624370", "North Badda", 1200.0);
      bankAccount[2].withdrew(100);
      System.out.println(bankAccount[2].getbalance());
    }
    
}
