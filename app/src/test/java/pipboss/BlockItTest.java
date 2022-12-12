package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class BlockItTest {

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
        BlockIt bt = new BlockIt(1);

        assertEquals(1, bt.associatedCasino());

        assertThat("Block It", is(bt.getName()));

    }

    @Test
    void testActivate1() {
        BlockIt bt = new BlockIt(1);

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "1 1";

        Scanner sc1 = new Scanner(a);

        String b = "2 2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        bt.activate(p1, p2, x, y, c);

        List<Die> dList = c.get(0).getDice();
        assertEquals(dList.size(), 2);
        for(int i=0; i<dList.size();i++)    {
            assertEquals(dList.get(i).getPlayerId(), 0);
        }
        
    }

    @Test
    void testActivate2() {
        BlockIt bt = new BlockIt(1);

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "0 1";

        Scanner sc1 = new Scanner(a);

        String b = "2 2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        bt.activate(p1, p2, x, y, c);

        List<Die> dList = c.get(0).getDice();
        assertEquals(dList.size(), 1);
        for(int i=0; i<dList.size();i++)    {
            assertEquals(dList.get(i).getPlayerId(), 0);
        }
        
    }

    @Test
    void testActivate3() {
        BlockIt bt = new BlockIt(1);

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Casino c1 = new Casino(2, 1, 1);
        Casino c2 = new Casino(5, 1, 2);

        ArrayList<Casino> c = new ArrayList<Casino>();
        c.add(c1);
        c.add(c2);

        String a = "2 1";

        Scanner sc1 = new Scanner(a);

        String b = "2 2";

        Scanner sc2 = new Scanner(b);

        Controller x = new ConsoleController(sc1, p1.getPID());
        Controller y = new ConsoleController(sc2, p2.getPID());
        bt.activate(p1, p2, x, y, c);

        List<Die> dList = c.get(0).getDice();
        assertEquals(dList.size(), 3);
        for(int i=0; i<dList.size();i++)    {
            assertEquals(dList.get(i).getPlayerId(), 0);
        }
        
    }

    @Test
    void testEquals() {
        BlockIt bt = new BlockIt(1);

        String a = "@ndr3w";

        assertEquals(false, bt.equals(a));

        String s = "Block It";

        assertEquals(true, bt.equals(s));

    }

    @Test
    void testtoString() {
        BlockIt bt = new BlockIt(1);

        assertThat("Block It - Play blank dice to any casino", is(bt.toString()));
    }
    
}
