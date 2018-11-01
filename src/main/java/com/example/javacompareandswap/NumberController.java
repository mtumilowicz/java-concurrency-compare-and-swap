package com.example.javacompareandswap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mtumilowicz on 2018-10-24.
 */
@RestController
public class NumberController {

    private final AtomicInteger counter = new AtomicInteger();
    private final AtomicInteger even = new AtomicInteger(2);
    private volatile FibonacciService fibonacciService = new FibonacciService();

    @PostMapping("/next/int")
    public int nextInt() {
        return counter.getAndIncrement();
    }

    @PostMapping("/next/even")
    public int nextEven() {
        return even.getAndUpdate(x -> x + 2);
    }

    @PostMapping("/next/fibonacci")
    public int nextFibonacci() {
        return fibonacciService.next();
    }

}
