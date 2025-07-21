package com.example.lld.LowLevelDesign.DesignATM.ATMStates;

import com.example.lld.LowLevelDesign.DesignATM.ATM;
import com.example.lld.LowLevelDesign.DesignATM.Card;
import com.example.lld.LowLevelDesign.DesignATM.TransactionType;

import java.sql.SQLOutput;

public abstract class ATMState {

    public void insertCard(ATM atm, Card card) {
        System.out.println("oops ! something went wrong");
    }

    public void authenticatePIN(ATM atm, Card card, int pin) {
        System.out.println("oops ! something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        System.out.println("oops ! something went wrong");
    }

    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(ATM atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void returnCard() {
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit(ATM atm) {
        System.out.println("OOPS!! Something went wrong");
    }
}
