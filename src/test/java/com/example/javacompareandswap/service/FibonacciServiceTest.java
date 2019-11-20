package com.example.javacompareandswap.service;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FibonacciServiceTest {

    @Test
    public void next() {
        FibonacciService service = new FibonacciService();
        
        assertThat(service.next(), is(1));
        assertThat(service.next(), is(1));
        assertThat(service.next(), is(2));
        assertThat(service.next(), is(3));
        assertThat(service.next(), is(5));
        assertThat(service.next(), is(8));
        assertThat(service.next(), is(13));
    }

    @Test
    public void next_asynchronous() {
        FibonacciService service = new FibonacciService();

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf4 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf5 = CompletableFuture.supplyAsync(service::next);

        CompletableFuture.allOf(cf1, cf2, cf3, cf4, cf5).join();

        assertThat(service.next(), is(8));
    }
}