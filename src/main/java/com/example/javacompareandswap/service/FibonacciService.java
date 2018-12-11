package com.example.javacompareandswap.service;

import com.example.javacompareandswap.model.Fibonacci;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by mtumilowicz on 2018-10-24.
 */
public final class FibonacciService {
    private final AtomicReference<Fibonacci> fibonacci = new AtomicReference<>(Fibonacci.FIRST);
    
    public int next() {
        return fibonacci.getAndUpdate(Fibonacci::next).get();
    }
}
