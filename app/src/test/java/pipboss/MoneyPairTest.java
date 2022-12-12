package pipboss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;


class MoneyPairTest {
    /*
    MoneyPair mp = new MoneyPair();
    MoneyPair mp2 = new MoneyPair(new Random());
    mp.getHighMoney();
    mp.getLowMoney();
    mp.compareTo(mp2);
    //maybe toString()
    */
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

    @Test 
    void testConstructor() {
        MoneyPair mp = new MoneyPair(4,8);
        //MoneyPair mp = new MoneyPair(new MockRandom(List.of(4, 8)));
        assertEquals(mp.getHighMoney(), 8);
        assertEquals(mp.getLowMoney(), 4);
    }

    @Test
    void testCompareTo()    {
        MoneyPair mp = new MoneyPair(4, 8);
        MoneyPair mp2 = new MoneyPair(2, 9);
        MoneyPair mp3 = new MoneyPair(7, 6);
        MoneyPair mp4 = new MoneyPair(6, 6);
        assertEquals(mp.compareTo(mp2), 1);
        assertEquals(mp.compareTo(mp3), -1);
        assertEquals(mp.compareTo(mp4), 2);
    }

    @Test
    void TestToString() {
        MoneyPair mp = new MoneyPair(4, 8);
        String mpString = mp.toString();
        String solString = "(8,4)";
        assertEquals(mpString, solString);
    }
}