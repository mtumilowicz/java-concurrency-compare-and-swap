package com.example.javacompareandswap.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by mtumilowicz on 2018-11-01.
 */
public class EvenServiceTest {

    private EvenService service = new EvenService();

    @Test
    public void next() {
        assertThat(service.next(), is(2));
        assertThat(service.next(), is(4));
        assertThat(service.next(), is(6));
    }
}