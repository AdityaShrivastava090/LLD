package com.example.lld.LowLevelDesign.DesignATM.ATMStates;

import com.example.lld.LowLevelDesign.DesignATM.ATM;
import com.example.lld.LowLevelDesign.DesignATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("card inserted");
        atm.setCurrentATMState(new HasCardSate());
    }
}
