package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;


public class ConsoleControllerTest {

    @Test
    void testGetDiceChoice() {
        String input = "2";
        Scanner s = new Scanner(input);
        ConsoleController a = new ConsoleController(s, 2);

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
    void testGetDiceChoice2() {
        String input = "2";
        Scanner s = new Scanner(input);
        ConsoleController a = new ConsoleController(s, 2);

        List<IntBoolPair> rolls = new ArrayList<IntBoolPair>();
        rolls.add(new IntBoolPair(2, true));

        assertEquals(2, a.getDiceChoice(rolls));
    }

    @Test
    void testFiftyFiftyChoice() {
        String input = "2";
        Scanner s = new Scanner(input);
        ConsoleController a = new ConsoleController(s, 2);
        a.getFiftyFiftyChoice(1, 1);
        assertEquals("2", input);
    }
}
