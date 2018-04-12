package com.company;

public abstract class Account implements IRate{

    protected String accountNumber;
    private String customerName;
    private String sSN;
    private double balance;
    protected double rate;

    private static int uniqueNumber = 1234;

    public Account(String customerName, String sSN, double initDeposit) {
        this.customerName = customerName;
        this.sSN = sSN;
        this.balance = initDeposit;
        uniqueNumber++;
        this.accountNumber = setAccountNumber(sSN);
        setRate();

    }


    private String setAccountNumber(String sSN){
        String lastTwoSSN = sSN.substring(sSN.length()-2,sSN.length());
        int uniqueNum = uniqueNumber;
        int random3Numbers = (int) (Math.random() * Math.pow(10,3));
        return lastTwoSSN + uniqueNum + random3Numbers;

    }
    public void compound(){

        double accruedInterest  = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrues interest: $"+accruedInterest);
        printBalance();


    }
    public abstract void setRate();

    public void showInfo(){
        System.out.println("NAME: "+customerName+
                            "\nACCOUNT NUMBER: "+accountNumber+
                            "\nSSN: "+sSN+
                            "\nBALANCE: "+balance+
                            "\nRATE: "+rate+"%"+
                            "\n~~");

    }
    public double getBalance(){
        return balance;
    }

    public void printBalance(){
        System.out.println("Your balance now is $"+balance);

    }

    public void deposit(double amount){
        this.balance = balance + amount;
        System.out.println("Depositing $" +amount);
        printBalance();
    }

    public void withdraw(double amount){
        this.balance = balance - amount;
        System.out.println("Withdwrawing $"+amount);
        printBalance();

    }

    public void transfer(String toWho,double amount){
        this.balance = balance - amount;
        System.out.println("Transfering $"+ amount +" to "+ toWho);
        printBalance();

    }
}
