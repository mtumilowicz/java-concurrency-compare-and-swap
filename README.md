# java-compare-and-swap
The main goal of this project is to describe compare and swap approach
to concurrency and provide basic examples (using Atomic classes).

_Reference_: https://dzone.com/articles/how-cas-compare-and-swap-java  
_Reference_: https://www.javaworld.com/article/2078848/java-concurrency/java-concurrency-java-101-the-next-generation-java-concurrency-without-the-pain-part-2.html?page=3  

# preface
The compare-and-swap (CAS) instruction is an uninterruptible instruction 
that reads a memory location, compares the read value with an expected 
value, and stores a new value in the memory location when the read value 
matches the expected value. Otherwise, nothing is done. The actual 
microprocessor instruction may differ somewhat (e.g., return true if 
CAS succeeded or false otherwise instead of the read value).

1. Read value v from address X.
1. Perform a multistep computation to derive a new value v2.
1. Use CAS to change the value of X from v to v2. CAS succeeds 
when X's value hasn't changed while performing these steps.

**CAS offers better performance (and scalability) over synchronization.**

Java's traditional synchronization mechanism (`synchronized` keyword) 
impacts hardware utilization and scalability:
1. Multiple threads constantly competing for a lock is expensive because
of frequent context switching (can take many processor cycles). 
1. When a thread holding a lock is delayed (e.g., because of a scheduling 
delay), no thread that requires that lock makes any progress.

# java
Java 5 introduced a synchronization alternative that offers mutual 
exclusion combined with the performance of volatile. This atomic 
variable alternative is based on a microprocessor's compare-and-swap 
instruction and largely consists of the types in the 
`java.util.concurrent.atomic` package.

The easiest implementation in java will be:
```
class EmulatedCAS {
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int readValue = value;
        if (readValue == expectedValue)
            value = newValue;
        return readValue;
    }
}

class Counter {
    private EmulatedCAS value = new EmulatedCAS();

    public int getValue() {
        return value.getValue();
    }

    public int increment() {
        int readValue = value.getValue();
        while (value.compareAndSwap(readValue, readValue + 1) != readValue)
            readValue = value.getValue();
        return readValue + 1;
    }
}
```
**Note that `increment()` is not synchronized, but compareAndSwap is.**

# project description
We provide three classes (based on Atomic variables):
* `CounterService`
    ```
    public final int getAndIncrement() {
        return unsafe.getAndAddInt(this, valueOffset, 1);
    }
    
    public final int getAndAddInt(Object var1, long var2, int var4) {
        int var5;
        do {
            var5 = this.getIntVolatile(var1, var2);
        } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

        return var5;
    }        
    ```
* `EvenService`
    ```
    public final int getAndUpdate(IntUnaryOperator updateFunction) {
        int prev, next;
        do {
            prev = get();
            next = updateFunction.applyAsInt(prev);
        } while (!compareAndSet(prev, next));
        return prev;
    }    
    ```
* `FibonacciService`
    ```
    public final int getAndSet(int newValue) {
        return unsafe.getAndSetInt(this, valueOffset, newValue);
    }
    
    public final int getAndSetInt(Object var1, long var2, int var4) {
        int var5;
        do {
            var5 = this.getIntVolatile(var1, var2);
        } while(!this.compareAndSwapInt(var1, var2, var5, var4));

        return var5;
    }
    
    public final int getAndAccumulate(int x,
                                      IntBinaryOperator accumulatorFunction) {
        int prev, next;
        do {
            prev = get();
            next = accumulatorFunction.applyAsInt(prev, x);
        } while (!compareAndSet(prev, next));
        return prev;
    }            
    ```