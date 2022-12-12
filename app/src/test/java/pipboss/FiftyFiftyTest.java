package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class FiftyFiftyTest {

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
        FiftyFifty f = new FiftyFifty(1);

        assertEquals(1, f.associatedCasino());

        assertThat("Fifty Fifty", is(f.getName()));
    }

    @Test
    void testSetIndex() {
        FiftyFifty f= new FiftyFifty(1);
        f.setIndex(2);
        assertEquals(f.getIndex(), 2);
    }

    @Test
    void testSetGuess() {
        FiftyFifty f= new FiftyFifty(1);
        f.setGuess(2);
        assertEquals(f.getGuess(), 2);
    }

    @Test
    void testSetMarker() {
        FiftyFifty f= new FiftyFifty(1);
        f.setMarker(2);
        assertEquals(f.getMarker(), 2);
    }

    @Test
    void testActivate1() {
        FiftyFifty f = new FiftyFifty(1, new MockRandom(List.of(1)));

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

        f.activate(p1, p2, x, y, c);

        assertEquals(0, f.getIndex());
        assertEquals(0, p1.getMoney());

    }

    @Test
    void testActivate2() {
        FiftyFifty f = new FiftyFifty(1, new MockRandom(List.of(1)));

        Player p1 = new Player(1);
        Player p2 = new Player(2);
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

        f.setIndex(4);
        f.activate(p1, p2, x, y, c);

        

        assertEquals(0, f.getIndex());
        assertEquals(6, p1.getMoney());

    }

    @Test
    void testActivate3() {
        FiftyFifty f = new FiftyFifty(1, new MockRandom(List.of(1,2,3,4)));

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "1 0";

        Scanner sc1 = new Scanner(a);

        String b = "2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        f.activate(p1, p2, x, y, c);
        

        assertEquals(0, f.getIndex());
        assertEquals(0, p1.getMoney());

    }

    @Test
    void testActivate4() {
        FiftyFifty f = new FiftyFifty(1, new MockRandom(List.of(4,3,2,1)));

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "2 0";

        Scanner sc1 = new Scanner(a);

        String b = "2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        f.activate(p1, p2, x, y, c);
        

        assertEquals(0, f.getIndex());
        assertEquals(0, p1.getMoney());

    }

    @Test
    void testActivate5() {
        FiftyFifty f = new FiftyFifty(1, new MockRandom(List.of(4,3,2,1)));

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "1 0";

        Scanner sc1 = new Scanner(a);

        String b = "2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        f.activate(p1, p2, x, y, c);
        

        assertEquals(0, f.getIndex());
        assertEquals(0, p1.getMoney());

    }

    @Test
    void testActivate6() {
        FiftyFifty f = new FiftyFifty(1, new MockRandom(List.of(1,2,3,4)));

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "2 0";

        Scanner sc1 = new Scanner(a);

        String b = "2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        f.activate(p1, p2, x, y, c);
        

        assertEquals(0, f.getIndex());
        assertEquals(0, p1.getMoney());

    }

    @Test
    void testEquals() {
        FiftyFifty f = new FiftyFifty(1);

        String a = "Kevvy";

        assertEquals(false, f.equals(a));

        String s = "Fifty Fifty";

        assertEquals(true, f.equals(s));

    }

    @Test
    void testtoString() {
        FiftyFifty f = new FiftyFifty(1);

        assertThat("Fifty Fifty - Keep rolling more/less than target or stop and take payout.", is(f.toString()));
    }
    
}
