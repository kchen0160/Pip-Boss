package pipboss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;


class DeckTest {
    /*
    Deck d = new Deck();
    d.suffle();
    d.draw();
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
    void testConstructor(){
        int[] solution = {3,4,5,5,6,7,7,7,8,9,10};
        int[] passin = {3,1,4,1,5,2,6,1,7,3,8,1,9,1,10,1};
        Deck deckk = new Deck(passin, false);
        for (int i = 0; i < solution.length; i++) {
            assertEquals(solution[i], deckk.draw());
        }
    }

    //@Test
    void testDeckShuffle() {
        //Deck deckk = new Deck(passin, false);
        int[] solution = {4,1,2,3};
        int[] passin = {1,2,3,4};
        List<Integer> mockPassin = new ArrayList<Integer>();
        mockPassin.add(0);
        Deck d = new Deck(passin, false, new MockRandom(mockPassin));
        d.shuffle();
        for (int i = 0; i < solution.length; i++) {
            assertEquals(solution[i], d.draw());

     }

 }


}