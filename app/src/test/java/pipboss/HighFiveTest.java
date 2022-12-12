package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class HighFiveTest {

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
    void testGetName() {
        HighFive hf = new HighFive(1);

        assertEquals(1, hf.associatedCasino());

        assertThat("High Five", is(hf.getName()));

    }

    @Test
    void testActivate1() {
        HighFive hf = new HighFive(1);

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        List<Die> dList = new ArrayList<Die>();
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);

        String a = "2";

        Scanner sc1 = new Scanner(a);

        String b = "6";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        hf.activate(p1, p2, x, y, c);

        assertEquals(p1.getMoney(), 0);
    }

    @Test
    void testActivate2() {
        HighFive hf = new HighFive(1);

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        List<Die> dList = new ArrayList<Die>();
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);

        String a = "2";

        Scanner sc1 = new Scanner(a);

        String b = "6";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        hf.activate(p1, p2, x, y, c);

        assertEquals(p1.getMoney(), 10);
    }

    @Test
    void testActivate3() {
        HighFive hf = new HighFive(1);

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        List<Die> dList = new ArrayList<Die>();
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);

        String a = "2";

        Scanner sc1 = new Scanner(a);

        String b = "6";

        Scanner sc2 = new Scanner(b);

        hf.setPrizeAvaliblity(false);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        hf.activate(p1, p2, x, y, c);

        assertEquals(p1.getMoney(), 0);
    }

    @Test
    void testActivate4() {
        HighFive hf = new HighFive(1);

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        List<Die> dList = new ArrayList<Die>();
        dList.add(new Die(2));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(2));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(2));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(2));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(2));
        c.get(0).placeDie(dList);
        dList.remove(0);

        String a = "2";

        Scanner sc1 = new Scanner(a);

        String b = "6";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        hf.activate(p1, p2, x, y, c);

        assertEquals(p1.getMoney(), 0);
    }

    @Test
    void testEquals() {
        HighFive hf = new HighFive(1);

        String a = "tYL3R";

        assertEquals(false, hf.equals(a));

        String s = "High Five";

        assertEquals(true, hf.equals(s));
    }

    @Test
    void testtoString() {
        HighFive hf = new HighFive(1);

        assertThat("High Five - The first player to place at least 5 dice here wins $10.", is(hf.toString()));
    }

    @Test
    void testtoString2() {
        HighFive hf = new HighFive(1);
        hf.setPrizeAvaliblity(false);

        assertThat("High Five - The payout has already been claimed.", is(hf.toString()));
    }
    
}
