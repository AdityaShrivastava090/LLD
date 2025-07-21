package com.example.lld.LowLevelDesign.DesignPatterns.DesignChainOfResponsibility;

public abstract class LoggerProcessor {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LoggerProcessor nextLogProcessor;

    public LoggerProcessor(LoggerProcessor nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(int loglevel, String message){
        if(nextLogProcessor != null){
            nextLogProcessor.log(loglevel, message);
        }
    }

}
