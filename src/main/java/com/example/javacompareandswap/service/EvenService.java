package com.example.javacompareandswap.service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mtumilowicz on 2018-11-01.
 */
public class EvenService {
    private final AtomicInteger even = new AtomicInteger(2);
    
    public int next() {
        return even.getAndUpdate(x -> x + 2);
    }
}
