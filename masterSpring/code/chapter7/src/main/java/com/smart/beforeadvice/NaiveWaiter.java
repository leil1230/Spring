package com.smart.beforeadvice;

public class NaiveWaiter implements Waiter {
    public void greetTo(String clientName) {
        System.out.println("greet to " + clientName + "...");
    }

    public void serveTo(String clientName) {
        System.out.println("serving to " + clientName + "...");
    }
}
