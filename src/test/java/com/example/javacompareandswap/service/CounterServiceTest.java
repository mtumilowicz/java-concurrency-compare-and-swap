package com.example.javacompareandswap.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by mtumilowicz on 2018-11-01.
 */
public class CounterServiceTest {
    
    private CounterService service = new CounterService();

    @Test
    public void next() {
        assertThat(service.next(), is(0));
        assertThat(service.next(), is(1));
        assertThat(service.next(), is(2));
    }
}