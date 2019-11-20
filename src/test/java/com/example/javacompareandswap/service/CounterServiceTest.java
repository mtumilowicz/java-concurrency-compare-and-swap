package com.example.javacompareandswap.service;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CounterServiceTest {

    @Test
    public void next() {
        CounterService service = new CounterService();
        
        assertThat(service.next(), is(0));
        assertThat(service.next(), is(1));
        assertThat(service.next(), is(2));
    }
    
    @Test
    public void next_asynchronous() {
        CounterService service = new CounterService();

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf4 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf5 = CompletableFuture.supplyAsync(service::next);
        
        CompletableFuture.allOf(cf1, cf2, cf3, cf4, cf5).join();
        
        assertThat(service.next(), is(5));
    }
}