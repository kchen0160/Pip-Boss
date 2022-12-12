package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class PayDayTest {

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
        PayDay p = new PayDay(1);

        assertEquals(1, p.associatedCasino());

        assertThat("Pay Day", is(p.getName()));

    }

    @Test
    void testActivate1() {
        PayDay p = new PayDay(1);

        Player p1 = new Player(1, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        Player p2 = new Player(2, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "4";

        Scanner sc1 = new Scanner(a);

        String b = "6";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        p.activate(p1, p2, x, y, c);

        assertEquals(p1.getMoney(), 0);
    }

    @Test
    void testActivate2() {
        PayDay p = new PayDay(1);

        Player p1 = new Player(1, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        Player p2 = new Player(2, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "2";

        Scanner sc1 = new Scanner(a);

        String b = "2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        p.activate(p1, p2, x, y, c);

        assertEquals(p1.getMoney(), 0);
    }

    @Test
    void testActivate3() {
        PayDay p = new PayDay(1);

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);
        Casino c3 = new Casino(5, 1, 3);
        Casino c4 = new Casino(5, 1, 4);
        Casino c5 = new Casino(5, 1, 5);
        Casino c6 = new Casino(5, 1, 6);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
        c.add(c5);
        c.add(c6);
        List<Die> dList = new ArrayList<Die>();
        dList.add(new Die(1));
        c.get(0).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(1));
        c.get(1).placeDie(dList);
        dList.remove(0);
        dList.add(new Die(1));
        c.get(2).placeDie(dList);
        dList.remove(0);

        String a = "2";

        Scanner sc1 = new Scanner(a);

        String b = "2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        p.activate(p1, p2, x, y, c);

        assertEquals(p1.getMoney(), 3);
    }

    @Test
    void testEquals() {
        PayDay p = new PayDay(1);

        String a = "andr3w";

        assertEquals(false, p.equals(a));

        String s = "Pay Day";

        assertEquals(true, p.equals(s));

    }

    @Test
    void testtoString() {
        PayDay p = new PayDay(1);

        assertThat("Pay Day - Gain $1 for each casino where you have presence.", is(p.toString()));
    }
    
}
