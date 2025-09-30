package com.example.lld.course.factoryPattern;

public class SimpleFactory {

    //all payments should implement this interface
    interface Payment
    {
        void processPayment(double amount);
        String getPaymentMethod();
        double getFeePercentage();
    }

    static class RazorPay implements Payment
    {

        @Override
        public void processPayment(double amount) {

        }

        @Override
        public String getPaymentMethod() {
            return "";
        }

        @Override
        public double getFeePercentage() {
            return 0;
        }
    }

    static class BankTransfer implements Payment
    {

        @Override
        public void processPayment(double amount) {
            System.out.println("Validate bank account details");
            System.out.println("connect to bank api");
            System.out.println("deducting payment");
        }

        @Override
        public String getPaymentMethod() {
            return "BankTransfer";
        }

        @Override
        public double getFeePercentage() {
            return 0.1;
        }
    }

    static class PayPalPayment implements Payment
    {

        @Override
        public void processPayment(double amount) {
            System.out.println("Connecting to paypal api");
            System.out.println("Paypal credentials validation");
            System.out.println("Deducting payment");
        }

        @Override
        public String getPaymentMethod() {
            return "Paypal";
        }

        @Override
        public double getFeePercentage() {
            return 2;
        }
    }

    class SimplePaymentFactory
    {
        public static Payment createPayment(String type)
        {
            if(type.equalsIgnoreCase("PAYPAL"))
            {
                return new PayPalPayment();
            }
            else if(type.equalsIgnoreCase("BANK_TRANSFER"))
            {
                return new BankTransfer();
            }
            else
            {
                throw new IllegalArgumentException("Unknown payment type");
            }
        }
    }

    private static void processPaymentWithFactory(String type, double amount)
    {
        Payment payment = SimplePaymentFactory.createPayment(type);
        payment.processPayment(amount);
    }

    public static void main(String[] args) {
        processPaymentWithFactory("PAYPAL", 45);
    }





}
