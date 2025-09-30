package com.example.lld.course.factoryPattern;

public class LegacyCode {

    public static void processPayment(String paymentType, double amount)
    {
        if(paymentType.equals("PAYPAL"))
        {
            System.out.println("Connecting to paypal api");
            System.out.println("Paypal credentials validation");
            System.out.println("Deducting payment");
        }
        else if(paymentType.equals("BANK_TRANSFER"))
        {
            System.out.println("Validate bank account details");
            System.out.println("connect to bank api");
            System.out.println("deducting payment");
        }
    }

    public static void main(String[] args) {
        processPayment("PAYPAL", 45);
    }


}
