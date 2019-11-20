package com.example.javacompareandswap.service;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EvenServiceTest {

    @Test
    public void next() {
        EvenService service = new EvenService();
        
        assertThat(service.next(), is(2));
        assertThat(service.next(), is(4));
        assertThat(service.next(), is(6));
    }

    @Test
    public void next_asynchronous() {
        EvenService service = new EvenService();

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf4 = CompletableFuture.supplyAsync(service::next);
        CompletableFuture<Integer> cf5 = CompletableFuture.supplyAsync(service::next);

        CompletableFuture.allOf(cf1, cf2, cf3, cf4, cf5).join();

        assertThat(service.next(), is(12));
    }
}