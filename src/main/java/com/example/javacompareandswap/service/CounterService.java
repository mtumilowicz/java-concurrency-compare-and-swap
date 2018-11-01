package com.example.javacompareandswap.service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mtumilowicz on 2018-11-01.
 */
public class CounterService {
    private final AtomicInteger counter = new AtomicInteger();

    public int next() {
        return counter.getAndIncrement();
    }
}
