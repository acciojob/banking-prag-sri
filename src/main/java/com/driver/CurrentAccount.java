package com.driver;
import java.util.*;
public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId= tradeLicenseId;

        if(balance<5000)
        {
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        boolean flag= true;
        int n= tradeLicenseId.length();
        for(int i=0; i<n-1; i++)
        {
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1))
            {
                flag= false;
                break;
            }
        }
        if(flag)
        {
            int[] count = new int[26];

            for (int i = 0; i < n; i++)
                count[tradeLicenseId.charAt(i) - 'a']++;

            PriorityQueue<Key> pq= new PriorityQueue<>(new KeyComparator());
            for (char c = 'a'; c <= 'z'; c++) {
                int val = c - 'a';
                if (count[val] > 0)
                    pq.add(new Key(count[val], c));
            }

            tradeLicenseId = "";

            Key prev = new Key(-1, '#');

            while (pq.size() != 0) {

                Key k = pq.peek();
                pq.poll();
                tradeLicenseId = tradeLicenseId + k.ch;

                if (prev.freq > 0)
                    pq.add(prev);

                (k.freq)--;
                prev = k;
            }

            if (n != tradeLicenseId.length())
                throw new Exception("Valid License can not be generated");
        }
    }

}



