package pipboss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;


class DieTest {

    private class MockRandom extends Random {
        private List<Integer> values;
        private int current;
        public MockRandom(List<Integer> values) {
            this.values = values;
            current = 0;
        }

        @Override
        public int nextInt(int bound) {
            int v = values.get(current) % bound;
            current = (current + 1) % values.size();
            return v;
        }

    }

    /*
    Die d = new Die(big=True, player=id);
    d.roll();
    int rolledValue = d.getValue();
    boolean big = d.isBig();
    int id = d.getPlayerId();
    String s = d.toString();
    */
    @Test 
    void testPidOnlyConstructor() {
        Die d = new Die(42);
        assertThat(d.isBig(), is(false));
        assertThat(d.getPlayerId(), is(42));
        assertThat(d.getValue(), is(greaterThan(0)));
        assertThat(d.getValue(), is(lessThan(7)));
    }

    @Test
    void testRoll() {
        Die d = new Die(42, new MockRandom(List.of(10, 2, 1, 6, 3, 5)));
        d.roll();
        assertThat(d.getValue(), is(3));
    }

    @Test
    void testToString() {
        Die d = new Die(42, new MockRandom(List.of(0)));
        Die e = new Die(17, true, new MockRandom(List.of(5)));
        assertThat(d.toString(), is("1"));
        assertThat(e.toString(), is("6+6"));
    }
}