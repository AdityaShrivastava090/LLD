package com.example.lld.LowLevelDesign.DesignATM.AmountWithDrawState;

import com.example.lld.LowLevelDesign.DesignATM.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {


    public TwoThousandWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    public void withDraw(ATM atm, int remainingAmount) {

        int required = remainingAmount / 2000;
        int balance = remainingAmount % 2000;

        if(required <= atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(required);
        } else if (required > atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance = balance + (required - atm.getNoOfTwoThousandNotes())*2000;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}
