package com.example.lld.LowLevelDesign.DesignPatterns.DesignChainOfResponsibility;

public class DebugLogProcessor extends LoggerProcessor {

    public DebugLogProcessor(LoggerProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int loglevel, String message) {
        if (loglevel == DEBUG) {
            System.out.println("DEBUG:" + message);
        }
        super.log(loglevel, message);
    }
}
