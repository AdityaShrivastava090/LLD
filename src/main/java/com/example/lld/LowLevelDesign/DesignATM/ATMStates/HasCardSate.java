package com.example.lld.LowLevelDesign.DesignATM.ATMStates;

import com.example.lld.LowLevelDesign.DesignATM.ATM;
import com.example.lld.LowLevelDesign.DesignATM.Card;

public class HasCardSate extends ATMState {

    @Override
    public void authenticatePIN(ATM atm, Card card, int pin) {

        boolean isPinCorrect = card.isCorrectPINEntered(pin);

        if (isPinCorrect) {
            atm.setCurrentATMState(new SelectOperationState());
        } else {
            System.out.println("Inavalid pin");
            exit(atm);
        }
    }
}
