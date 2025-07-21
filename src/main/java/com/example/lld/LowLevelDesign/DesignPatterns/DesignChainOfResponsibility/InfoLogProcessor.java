package com.example.lld.LowLevelDesign.DesignPatterns.DesignChainOfResponsibility;

public class InfoLogProcessor extends LoggerProcessor {


    public InfoLogProcessor(LoggerProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }


    @Override
    public void log(int loglevel, String message) {
        if (loglevel == INFO) {
            System.out.println("INFO : " + message);
        }
        super.log(loglevel, message);
    }
}
