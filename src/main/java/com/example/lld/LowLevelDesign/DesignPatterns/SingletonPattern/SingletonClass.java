package com.example.lld.LowLevelDesign.DesignPatterns.SingletonPattern;

public class SingletonClass {
    private static SingletonClass obj;
    public SingletonClass() {
    }
    /**
     * return object eager intialization;
     */

//    public static SingletonClass getClassObj() {
//        if (obj == null) {
//            return obj;
//        }
//        return obj;
//    }

    /**
     * return object lazy intialization;
     */

    public static SingletonClass getLazyClassObj() {
        if (obj == null) {
            obj = new SingletonClass();
        }
        return obj;
    }

    /**
     * Single Locking of Synchronized method
     */

    public static synchronized SingletonClass getSynchronizedObj() {
        if (obj == null) {
            obj = new SingletonClass();
        }
        return obj;
    }

    /**
     * Double Locking of Synchronized method
     */

    public static synchronized SingletonClass getDoubleSynchronizedObj() {
        if (obj == null) {
            synchronized (SingletonClass.class) {
                if (obj == null) {
                    obj = new SingletonClass();
                }
            }
        }
        return obj;
    }

    /**
     * BILL PUGH APPROACH
     */
    private static class SingletonNested {
        private static SingletonClass Obj;
    }

    public static SingletonClass getInstance() {
        return SingletonNested.Obj;
    }
}
