package com.company;

public class Saving extends Account {

    private int safetyDepositBox;
    private int boxCode;

    public Saving(String customerName, String sSN, double balance) {
        super(customerName, sSN, balance);
        this.accountNumber = "2"+accountNumber;
        this.safetyDepositBox = setSafetyDepositBox();
        this.boxCode = setBoxCode();

    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private int setSafetyDepositBox(){
        int random3Numbers = (int) (Math.random() * Math.pow(10,3));
        return random3Numbers;
    }

    private int setBoxCode() {
        int random4Numbers = (int) (Math.random() * Math.pow(10,4));
        return random4Numbers;
    }
    @Override
    public void showInfo() {
        System.out.println("SAVING ACCOUNT");
        super.showInfo();
        System.out.println("Your Account Features:" +
                            "\nSafety deposit box ID: " +safetyDepositBox+
                            "\nSafety deposit box key: " +boxCode+
                            "\n~~~~~~~~~~~~~~~~~~~");
    }
}
