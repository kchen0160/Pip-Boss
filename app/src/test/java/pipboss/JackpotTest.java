package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class JackpotTest {

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
        Jackpot j = new Jackpot(1);

        assertEquals(1, j.associatedCasino());

        assertThat("Jackpot", is(j.getName()));

    }

    @Test
    void testActivate1() {

        Jackpot j = new Jackpot(1, new MockRandom(List.of(0)));

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "7";

        Scanner sc1 = new Scanner(a);

        String b = "6";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        j.activate(p1, p2, x, y, c);

        assertEquals(p1.getMoney(), 3);
    }

    @Test
    void testActivate2() {
        Jackpot j = new Jackpot(1, new MockRandom(List.of(0, 1)));

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "4";

        Scanner sc1 = new Scanner(a);

        String b = "3";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        j.activate(p1, p2, x, y, c);

        assertEquals(p1.getMoney(), 0);
        assertEquals(j.getIndex(), 1);
    }

    @Test
    void testActivate3() {
        Jackpot j = new Jackpot(1, new MockRandom(List.of(0, 1)));

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "4";

        Scanner sc1 = new Scanner(a);

        String b = "3";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        j.setIndex(5);
        j.activate(p1, p2, x, y, c);

        assertEquals(p1.getMoney(), 0);
        assertEquals(j.getIndex(), 5);
    }

    @Test
    void testActivate4() {
        Jackpot j = new Jackpot(1, new MockRandom(List.of(2, 3)));

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "4";

        Scanner sc1 = new Scanner(a);

        String b = "3";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        j.setIndex(5);
        j.activate(p1, p2, x, y, c);

        assertEquals(p1.getMoney(), 8);
        assertEquals(j.getIndex(), 0);
    }

    @Test
    void testEquals() {
        Jackpot j = new Jackpot(1);

        String a = "Tyler";

        assertEquals(false, j.equals(a));

        String s = "Jackpot";

        assertEquals(true, j.equals(s));

    }

    @Test
    void testtoString() {
        Jackpot j = new Jackpot(1);

        assertThat("Jackpot - Roll doubles or 7 to win $3.", is(j.toString()));
    }
    
}
