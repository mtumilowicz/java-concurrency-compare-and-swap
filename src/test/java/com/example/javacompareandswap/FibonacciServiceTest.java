package com.example.javacompareandswap;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by mtumilowicz on 2018-11-01.
 */
public class FibonacciServiceTest {

    private FibonacciService fibonacciService = new FibonacciService();

    @Test
    public void next() {
        assertThat(fibonacciService.next(), is(1));
        assertThat(fibonacciService.next(), is(1));
        assertThat(fibonacciService.next(), is(2));
        assertThat(fibonacciService.next(), is(3));
        assertThat(fibonacciService.next(), is(5));
        assertThat(fibonacciService.next(), is(8));
        assertThat(fibonacciService.next(), is(13));
    }
}