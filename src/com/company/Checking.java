package com.company;

public class Checking extends Account {

    private String debitCardNumber;
    private int pinCode;




    public Checking(String customerName, String sSN, double balance) {
        super(customerName, sSN, balance);
        this.accountNumber = "1"+accountNumber;
        this.debitCardNumber =  setDebitCardNumber();
        this.pinCode = setPinCode();

    }

    @Override
    public void setRate() {
       rate = getBaseRate() * .15;
    }

    private String setDebitCardNumber(){
        int random12Numbers = (int) (Math.random() * Math.pow(10,12));
        return ""+random12Numbers ;
    }

    private int setPinCode(){
        int random4Numbers = (int) (Math.random() * Math.pow(10,4));
        return random4Numbers ;

    }

    @Override
    public void showInfo() {
        System.out.println("CHECKING ACCOUNT");
        super.showInfo();
        System.out.println("Your Account Features:" +
                "\nYour Debit card number: " +debitCardNumber+
                "\nYour PIN code: " +pinCode+
                "\n~~~~~~~~~~~~~~~~~~~");
    }

}
