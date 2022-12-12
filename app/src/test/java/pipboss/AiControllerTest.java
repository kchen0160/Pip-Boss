package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;


public class AiControllerTest {

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
    void testGetDiceChoice() {
        AiController a = new AiController(1);
        
        List<IntBoolPair> rolls = new ArrayList<IntBoolPair>();
        rolls.add(new IntBoolPair(1, false));
        rolls.add(new IntBoolPair(2, false));
        rolls.add(new IntBoolPair(3, false));
        rolls.add(new IntBoolPair(4, false));
        rolls.add(new IntBoolPair(5, false));
        rolls.add(new IntBoolPair(6, false));
        rolls.add(new IntBoolPair(2, true));

        assertEquals(2, a.getDiceChoice(rolls));
    }

    @Test 
    void testgetfiftyfiftychoice() {
        AiController a = new AiController(1);

        List<IntBoolPair> rolls = new ArrayList<IntBoolPair>();
        rolls.add(new IntBoolPair(2, true));

        assertEquals(1, a.getFiftyFiftyChoice(0, 9));
        assertEquals(2, a.getFiftyFiftyChoice(0, 4));
        assertEquals(0, a.getFiftyFiftyChoice(2, 7));
        assertEquals(1, a.getFiftyFiftyChoice(3, 9));
        assertEquals(2, a.getFiftyFiftyChoice(3, 3));
    }


    @Test
    void testhideTiles()    {
        AiController a = new AiController(1, new MockRandom(List.of(1)));

        assertEquals(1, a.hideTiles());
    }

    @Test
    void testguessTiles()   {
        AiController a = new AiController(1, new MockRandom(List.of(1)));

        assertEquals(1, a.guessTiles());
    }

    @Test
    void testBlackBoxPiles()   {
        AiController a = new AiController(1, new MockRandom(List.of(1)));

        assertEquals(2, a.getBlackboxPiles(0));
    }

    @Test
    void testGetPileChoice()    {
        AiController a = new AiController(1, new MockRandom(List.of(1)));

        assertEquals(1, a.getPileChoice(1, 0));
        assertEquals(2, a.getPileChoice(0, 1));
        assertEquals(2, a.getPileChoice(1, 1));
        assertEquals(2, a.getPileChoice(0, 1));
    }

    @Test
    void testGetPileChoice2()    {
        AiController a = new AiController(1, new MockRandom(List.of(0)));

        assertEquals(2, a.getPileChoice(1, 0));
        assertEquals(1, a.getPileChoice(0, 1));
        assertEquals(2, a.getPileChoice(1, 1));
        assertEquals(1, a.getPileChoice(0, 1));

    }

    @Test
    void testGetBlockItPileChoice() {
        AiController a = new AiController(1, new MockRandom(List.of(0)));

        assertEquals(0, a.getBlockItPileChoice());

    }

    @Test
    void testGetBlockItCasinoChoice() {
        AiController a = new AiController(1, new MockRandom(List.of(1)));

        assertEquals(1, a.getBlockItCasinoChoice());

    }


}
