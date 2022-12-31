package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    private String acc;

    public BankAccount(String name, double balance, double minBalance) {
        this.name= name;
        this.balance= balance;
        this.minBalance= minBalance;
        this.acc="";
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        if (digits > 0 && sum >= 0)
        {
            char d = '0';
            if (acc.equals(""))
            {
                d = '1';
            }

            while (d <= '9')
            {
                acc= acc + d;
                generateAccountNumber(digits - 1, sum - (d - '0'));
                d++;
            }
        }

        else if(digits==0 && sum==0)
            return acc;

        throw new Exception("Account Number can not be generated");
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+= amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(amount>balance)
        {
            throw new Exception("Insufficient Balance");
        }
        else
            balance= balance-amount;
    }

}