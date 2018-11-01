package com.example.javacompareandswap.controller;

import com.example.javacompareandswap.service.CounterService;
import com.example.javacompareandswap.service.EvenService;
import com.example.javacompareandswap.service.FibonacciService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mtumilowicz on 2018-10-24.
 */
@RestController
public class NumberController {

    private final CounterService counterService = new CounterService();
    private final EvenService evenService = new EvenService();
    private volatile FibonacciService fibonacciService = new FibonacciService();

    @PostMapping("/next/int")
    public int nextInt() {
        return counterService.next();
    }

    @PostMapping("/next/even")
    public int nextEven() {
        return evenService.next();
    }

    @PostMapping("/next/fibonacci")
    public int nextFibonacci() {
        return fibonacciService.next();
    }

}
