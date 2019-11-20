package atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AtomicIntegerTest {

    @Test
    public void testDoubleValue(){
//        given
        AtomicInteger atom = new AtomicInteger(2);

//        when
        doubleValue(atom);
        doubleValue(atom);

//        then
        assertThat(atom.get(), is(8));
    }

    @Test
    public void testUpdateAndGet(){
//        given
        AtomicInteger atom = new AtomicInteger(2);

//        when
        atom.updateAndGet(val -> 2 * val);
        atom.updateAndGet(val -> 2 * val);

//        then
        assertThat(atom.get(), is(8));
    }

    private static void doubleValue(AtomicInteger atom) {
        int prev;

        do {
            prev = atom.get();
        } while (!atom.compareAndSet(prev, prev * 2));
    }
}
