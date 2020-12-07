package com.klasevich.customer.util;

public class CustomerIdGenerator {
    private static int currentId = 0;

    public static int getCurrentId() {
        return currentId++;
    }
}
