package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name,balance,0);
        this.rate= rate;
        this.maxWithdrawalLimit=  maxWithdrawalLimit;

    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        if(amount>maxWithdrawalLimit)
            throw new Exception("Maximum Withdraw Limit Exceed");
        else if(amount>super.getBalance())
            throw new Exception("Insufficient Balance" );
        else
            super.setBalance(getBalance()-amount);

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double principal= super.getBalance();
        double amount= (principal*rate*years)/100;
        return amount;

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double principal= super.getBalance();
        int pow= times*years;
        double tmp= (1+rate/times);
        double amount= principal* Math.pow(tmp,pow);
        return amount;
    }

}
