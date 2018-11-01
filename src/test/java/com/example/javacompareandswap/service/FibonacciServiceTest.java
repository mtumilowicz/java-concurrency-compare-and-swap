package com.example.javacompareandswap.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mtumilowicz on 2018-11-01.
 */
public class FibonacciServiceTest {

    private FibonacciService service = new FibonacciService();

    @Test
    public void next() {
        assertThat(service.next(), is(1));
        assertThat(service.next(), is(1));
        assertThat(service.next(), is(2));
        assertThat(service.next(), is(3));
        assertThat(service.next(), is(5));
        assertThat(service.next(), is(8));
        assertThat(service.next(), is(13));
    }
}