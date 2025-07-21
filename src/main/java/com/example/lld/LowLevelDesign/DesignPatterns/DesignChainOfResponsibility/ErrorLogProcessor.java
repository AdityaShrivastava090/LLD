package com.example.lld.LowLevelDesign.DesignPatterns.DesignChainOfResponsibility;

public class ErrorLogProcessor extends LoggerProcessor {

    public ErrorLogProcessor(LoggerProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int loglevel, String message) {
        if (loglevel == ERROR) {
            System.out.println("ERROR:" + message);
        }
        super.log(loglevel, message);
    }
}
