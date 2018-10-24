package com.example.javacompareandswap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mtumilowicz on 2018-10-24.
 */
@RestController
public class NumberController {
    
    private AtomicInteger counter = new AtomicInteger();
    private AtomicInteger even = new AtomicInteger(2);
    
    @PostMapping
    public int nextInt() {
        return counter.getAndIncrement();
    }

    @PostMapping
    public int nextEven() {
        return even.getAndUpdate(x -> x+2);
    }
    
    
    
}
