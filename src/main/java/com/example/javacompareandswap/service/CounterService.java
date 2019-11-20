package com.example.javacompareandswap.service;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterService {
    private final AtomicInteger counter = new AtomicInteger();

    public int next() {
        return counter.getAndIncrement();
    }
}
