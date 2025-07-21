package com.example.lld.LowLevelDesign.DesignATM.AmountWithDrawState;

import com.example.lld.LowLevelDesign.DesignATM.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor {


    public OneHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount) {

        int required = remainingAmount / 100;
        int balance = remainingAmount % 100;

        if (required <= atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(required);
        } else if (required > atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
            balance = balance + (required - atm.getNoOfOneHundredNotes()) * 100;
        }

        if (balance != 0) {
            System.out.println("Something went wrong");
        }
    }
}
