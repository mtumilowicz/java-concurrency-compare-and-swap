package com.example.javacompareandswap.service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mtumilowicz on 2018-10-24.
 */
public final class FibonacciService {
    private final AtomicInteger first = new AtomicInteger(0);
    private final AtomicInteger second = new AtomicInteger(1);
    
    public synchronized int next() {
        int firstCopy = first.getAndSet(second.get());
        return second.getAndAccumulate(firstCopy, (actual, update) -> actual + update);
    }
}
