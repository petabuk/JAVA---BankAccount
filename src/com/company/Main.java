package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();


        String file = "C:\\NewBankAccounts.csv";

        List<String[]> newCustomers = CSV.read(file);

        for (String[] accountHolder : newCustomers) {

            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")) {
                    accounts.add(new Saving(name,sSN,initDeposit));

            } else if (accountType.equals("Checking")) {
                        accounts.add(new Checking(name,sSN,initDeposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }
        for (Account acc : accounts){

            acc.showInfo();
        }


    }
}
