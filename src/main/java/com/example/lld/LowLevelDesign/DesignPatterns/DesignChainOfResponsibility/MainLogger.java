package com.example.lld.LowLevelDesign.DesignPatterns.DesignChainOfResponsibility;

public class MainLogger {

    public static void main(String[] args) {

        LoggerProcessor logger = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logger.log(LoggerProcessor.ERROR, "exception message");
        logger.log(LoggerProcessor.DEBUG, "need to debug this");
        logger.log(LoggerProcessor.INFO, "just for info");
    }
}
