package com.example.javacompareandswap;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mtumilowicz on 2018-10-24.
 */
public final class Fibonacci {
    private AtomicInteger first = new AtomicInteger(1);
    private AtomicInteger second = new AtomicInteger(1);
    
    public synchronized int next() {
        int firstCopy = first.getAndSet(second.get());
        return second.getAndAccumulate(firstCopy, (actual, update) -> actual + update);
    }
}
