package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class LuckyPunchTest {

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
        LuckyPunch lp = new LuckyPunch(1);

        assertEquals(1, lp.associatedCasino());

        assertThat("Lucky Punch", is(lp.getName()));

    }

    @Test
    void testActivate1() {
        LuckyPunch lp = new LuckyPunch(1);

        Player p1 = new Player(1, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        Player p2 = new Player(2, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "2";

        Scanner sc1 = new Scanner(a);

        String b = "0";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        lp.activate(p1, p2, x, y, c);
    }

    @Test
    void testActivate2() {
        LuckyPunch lp = new LuckyPunch(1);

        Player p1 = new Player(1, new MockRandom(List.of(0, 0, 0, 0, 0, 5, 0)));
        Player p2 = new Player(2, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        p1.rollDice();

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "1";

        Scanner sc1 = new Scanner(a);

        String b = "2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        lp.activate(p1, p2, x, y, c);
    }

    @Test
    void testActivate3() {
        LuckyPunch lp = new LuckyPunch(1);

        Player p1 = new Player(1, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        Player p2 = new Player(2, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "1";

        Scanner sc1 = new Scanner(a);

        String b = "1";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        lp.activate(p1, p2, x, y, c);
    }

    @Test
    void testActivate4() {
        LuckyPunch lp = new LuckyPunch(1);

        Player p1 = new Player(1, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        Player p2 = new Player(2, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "1";

        Scanner sc1 = new Scanner(a);

        String b = "2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        lp.activate(p1, p2, x, y, c);
    }

    @Test
    void testActivate5() {
        LuckyPunch lp = new LuckyPunch(1);

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "0";

        Scanner sc1 = new Scanner(a);

        String b = "2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        lp.activate(p1, p2, x, y, c);
    }

    @Test
    void testEquals() {
        LuckyPunch lp = new LuckyPunch(1);

        String a = "3st3f@nl";

        assertEquals(false, lp.equals(a));

        String s = "LuckyPunch";

        assertEquals(true, lp.equals(s));
    }

    @Test
    void testtoString() {
        LuckyPunch lp = new LuckyPunch(1);

        assertThat("Lucky Punch - Choose 1, 2, or 3 to win 2 chips, $3, or $4.", is(lp.toString()));
    }
    
}
