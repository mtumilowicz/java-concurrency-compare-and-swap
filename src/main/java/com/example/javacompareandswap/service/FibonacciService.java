package com.example.javacompareandswap.service;

import com.example.javacompareandswap.model.Fibonacci;

import java.util.concurrent.atomic.AtomicReference;

public final class FibonacciService {
    private final AtomicReference<Fibonacci> fibonacci = new AtomicReference<>(Fibonacci.FIRST);
    
    public int next() {
        return fibonacci.updateAndGet(Fibonacci::next).get();
    }
}
