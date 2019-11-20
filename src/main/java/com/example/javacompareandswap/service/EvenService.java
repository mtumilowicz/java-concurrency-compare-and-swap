package com.example.javacompareandswap.service;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenService {
    private final AtomicInteger even = new AtomicInteger(2);
    
    public int next() {
        return even.getAndUpdate(x -> x + 2);
    }
}
