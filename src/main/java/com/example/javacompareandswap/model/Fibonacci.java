package com.example.javacompareandswap.model;

/**
 * Created by mtumilowicz on 2018-12-11.
 */
public final class Fibonacci {
    public static final Fibonacci FIRST = new Fibonacci(0, 1);
    
    private final int left;
    private final int right;
    
    private Fibonacci(int left, int right) {
        this.left = left;
        this.right = right;
    }
    
    public Fibonacci next() {
        return new Fibonacci(right, left + right);
    }
    
    public int get() {
        return left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fibonacci fibonacci = (Fibonacci) o;

        if (left != fibonacci.left) return false;
        return right == fibonacci.right;
    }

    @Override
    public int hashCode() {
        int result = left;
        result = 31 * result + right;
        return result;
    }
}
