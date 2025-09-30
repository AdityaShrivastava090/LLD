package com.example.lld.course.singletonPattern;

public class BasicSingleton {

    //Step 1: Private Static Instance Variable
    //Eager Initialisation
   // private static BasicSingleton instance = new BasicSingleton();
    private static BasicSingleton instance;

    //Step 2: Private Constructor (prevent direct instantiation)
    private BasicSingleton()
    {
        //prevent reflection
        if (instance != null)
        {
            throw new RuntimeException("use getInstance() method to create");
        }
        System.out.println("Instance Created");
    }

    //method to maintain singleton property during deserialization
    protected Object readResolve()
    {
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned");
    }

    //Step 3: Public static method to get instance
    public static BasicSingleton getInstance()
    {
        //your app is running
        //then the first request came after 5 mins
        //Logging, Email Notification
        //Lazy Initialisation
       if(instance == null)
       {
           //thread safety
           synchronized (BasicSingleton.class)
           {
               //double check locking
               if(instance == null)
               {
                   instance = new BasicSingleton();
               }

           }

        }
        return instance;
    }

    //Step 4: Add some business method
    public void doSomething()
    {
        System.out.println("Singleton is working");
        System.out.println(this.hashCode());
    }



}
