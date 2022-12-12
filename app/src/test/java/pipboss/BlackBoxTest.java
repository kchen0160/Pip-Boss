package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class BlackBoxTest {

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
        BlackBox b = new BlackBox(1);

        assertEquals(1, b.associatedCasino());

        assertThat("Black Box", is(b.getName()));

    }

    @Test
    void testActivate1() {
        BlackBox bb = new BlackBox(1);

        List<Player> p = new ArrayList<Player>();
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        p.add(p1);
        p.add(p2);

        List<Casino> c = new ArrayList<Casino>();
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(2, 1, 2);
        Casino c3 = new Casino(2, 1, 3);
        Casino c4 = new Casino(2, 1, 4);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(2));
        c1.placeDie(dL);
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);

        String a = "0";

        Scanner sc1 = new Scanner(a);

        String b = "0";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());

        List<Controller> xy = new ArrayList<Controller>();
        xy.add(x);
        xy.add(y);
        bb.payOut(p, xy, c);

        assertEquals(p1.getMoney(), 0);
    }

    @Test
    void testActivate2() {
        BlackBox bb = new BlackBox(1);

        List<Player> p = new ArrayList<Player>();
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        p.add(p1);
        p.add(p2);

        List<Casino> c = new ArrayList<Casino>();
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(2, 1, 2);
        Casino c3 = new Casino(2, 1, 3);
        Casino c4 = new Casino(2, 1, 4);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(2));
        c1.placeDie(dL);
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);

        String a = "0";

        Scanner sc1 = new Scanner(a);

        String b = "0 0 0 0 0";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());

        List<Controller> xy = new ArrayList<Controller>();
        xy.add(x);
        xy.add(y);
        bb.payOut(p, xy, c);

        assertEquals(p1.getMoney(), 6);
    }

    @Test
    void testActivate3() {
        BlackBox bb = new BlackBox(1);

        List<Player> p = new ArrayList<Player>();
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        p.add(p1);
        p.add(p2);

        List<Casino> c = new ArrayList<Casino>();
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(2, 1, 2);
        Casino c3 = new Casino(2, 1, 3);
        Casino c4 = new Casino(2, 1, 4);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(2));
        c1.placeDie(dL);
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);

        String a = "1";

        Scanner sc1 = new Scanner(a);

        String b = "0 0 0 0 0";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());

        List<Controller> xy = new ArrayList<Controller>();
        xy.add(x);
        xy.add(y);
        bb.payOut(p, xy, c);

        assertEquals(p1.getMoney(), 6);
    }

    @Test
    void testEquals() {
        BlackBox b = new BlackBox(1);

        String a = "k3vvy";

        assertEquals(false, b.equals(a));

        String s = "Black Box";

        assertEquals(true, b.equals(s));

    }

    @Test
    void testtoString() {
        BlackBox b = new BlackBox(1);

        assertThat("Black Box - During payout, the winner plays a split/choose for additional.", is(b.toString()));
    }
    
}
