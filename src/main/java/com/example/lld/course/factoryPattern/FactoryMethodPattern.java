package com.example.lld.course.factoryPattern;

public class FactoryMethodPattern {

    // legacy Code => Simple Factory => Factory Method Pattern
    // => Abstract Factory Pattern

    //Abstract Factory is a creational design pattern
    // that lets you produce families of related objects
    // without specifying their concrete classes.

    //all payments should implement this interface
    interface Payment {
        void processPayment(double amount);

        String getPaymentMethod();

        double getFeePercentage();
    }

    //parent factory
    static abstract class PaymentProcessorFactory {
        public abstract Payment createPayment();
    }

    //concrete factory for RazorPay
    static class RazorPayProcessorFactory extends PaymentProcessorFactory {

        @Override
        public Payment createPayment() {
            return new RazorPay();
        }
    }

    static class RazorPay implements Payment {

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

    //concrete factory for BankTransfer
    static class BankTransferProcessorFactory extends PaymentProcessorFactory {

        @Override
        public Payment createPayment() {
            return new BankTransfer();
        }
    }


    static class BankTransfer implements Payment {

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

    //concrete factory for Paypal
    static class PayPalProcessorFactory extends PaymentProcessorFactory {

        @Override
        public Payment createPayment() {
            return new PayPalPayment();
        }
    }

    static class PayPalPayment implements Payment {

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


    private static void processPaymentWithFactory
            (PaymentProcessorFactory factory,
             double amount) {
        Payment payment = factory.createPayment();
        System.out.println(payment.getPaymentMethod());
        System.out.println(payment.getFeePercentage());
        payment.processPayment(amount);
    }

    public static void main(String[] args) {
        processPaymentWithFactory(new PayPalProcessorFactory(), 45);
        processPaymentWithFactory(new BankTransferProcessorFactory(), 900);
    }


}
