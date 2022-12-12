package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

class CasinoTest {

    @Test
    void TestConstructor()   {
        Casino c = new Casino(2, 1, 1);
        assertEquals(2, c.getHighMoney());
        assertEquals(1, c.getLowMoney());
        assertEquals(1, c.getCasinoID());
    }

    @Test
    void TestMoney() {
        Casino c = new Casino(2, 1, 1);
        c.setHighMoney(4);
        c.setLowMoney(3);
        assertEquals(4, c.getHighMoney());
        assertEquals(3, c.getLowMoney());
    }

    @Test
    void TestSetPlayerNum() {
        Casino c = new Casino(2, 1, 1);
        c.setPlayerNum(1);
        assertEquals(1, c.getPlayerNum());
    }

    @Test
    void TestRemovePlayerDice() {
        Casino c = new Casino(2, 1, 1);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        dL.add(new Die(4));
        c.placeDie(dL);
        c.removePlayerDice();
        assertEquals("   ", c.countPlayerDie(1));
    }


    @Test
    void testAddingDice()   {
        Casino c = new Casino(1, 0, 1);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        dL.add(new Die(4));
        c.placeDie(dL);
        ArrayList<Die> testArray = c.getDice();
        for(int i=0; i<dL.size();i++)   {
            assertEquals(dL.get(i), testArray.get(i));
        }
    }

    @Test
    void testWinningPID()   {
        Casino c = new Casino(1, 0, 1);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        dL.add(new Die(4));
        c.placeDie(dL);
        int winningPID = c.getWinningPID();
        assertEquals(3, winningPID);
    }

    @Test
    void testWinningPID2()   {
        Casino c = new Casino(1, 0, 1);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        c.placeDie(dL);
        int winningPID2 = c.getWinningPID2();
        assertEquals(2, winningPID2);
    }

    @Test
    void testWinningPID3()   {
        Casino c = new Casino(1, 0, 1);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        dL.add(new Die(3));
        c.placeDie(dL);
        int winningPID = c.getWinningPID();
        assertEquals(3, winningPID);
    }

    @Test
    void testWinningPID5()   {
        Casino c = new Casino(1, 0, 1);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        c.placeDie(dL);
        int winningPID = c.getWinningPID();
        assertEquals(-1, winningPID);
    }
    
    @Test
    void testWinningPID4()   {
        Casino c = new Casino(7, 5, 3);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        c.placeDie(dL);
        int winningPID = c.getWinningPID();
        assertEquals(2, winningPID);
    }

    @Test
    void testWinningPID6()   {
        Casino c = new Casino(7, 5, 3);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(2));
        dL.add(new Die(2));
        c.placeDie(dL);
        int winningPID2 = c.getWinningPID2();
        assertEquals(-1, winningPID2);
    }

    @Test
    void testWinningPID7()   {
        Casino c = new Casino(7, 5, 3);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3, true));
        c.placeDie(dL);
        int winningPID2 = c.getWinningPID();
        assertEquals(3, winningPID2);
    }

    @Test
    void testCounterPlayerDie()   {
        Casino c = new Casino(1, 0, 1);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        dL.add(new Die(4));
        c.placeDie(dL);
        String winningPID = c.countPlayerDie(1);
        assertEquals("$$4", winningPID);
    }


    @Test
    void testCounterPlayerDie2()   {
        Casino c = new Casino(1, 0, 1);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        dL.add(new Die(3));
        dL.add(new Die(3));
        c.placeDie(dL);
        String winningPID = c.countPlayerDie(2);
        assertEquals("$ 2", winningPID);
    }

    @Test
    void testCounterPlayerDie3()   {
        Casino c = new Casino(1, 0, 1);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        dL.add(new Die(3));
        dL.add(new Die(3));
        c.placeDie(dL);
        String winningPID = c.countPlayerDie(2);
        assertEquals("  2", winningPID);
    }

    @Test
    void testCounterPlayerDie4()   {
        Casino c = new Casino(9, 7, 5);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        dL.add(new Die(3));
        c.placeDie(dL);
        String winningPID = c.countPlayerDie(3);
        assertEquals("$$3", winningPID);
    }


    @Test
    void testCounterPlayerDie5()   {
        Casino c = new Casino(7, 5, 3);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2, true));
        dL.add(new Die(3));
        dL.add(new Die(3));
        c.placeDie(dL);
        String winningPID = c.countPlayerDie(2);
        assertEquals("$$6", winningPID);
    }

    @Test
    void testCounterPlayerEmpty()   {
        Casino c = new Casino(7, 5, 3);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        c.placeDie(dL);
        String winningPID = c.countPlayerDie(2);
        assertEquals("   ", winningPID);
    }

    @Test
    void testisPresent() {
        Casino c = new Casino(7, 5, 3);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        c.placeDie(dL);
        assertEquals(false, c.isPresent(1));
    }

    @Test
    void testisPresent2() {
        Casino c = new Casino(7, 5, 3);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(2));
        dL.add(new Die(3));
        dL.add(new Die(3));
        c.placeDie(dL);
        assertEquals(true, c.isPresent(2));
    }

    //@Test
    void testCasinoToString() {
        Casino c = new Casino(7, 5, 3);
        c.setPlayerNum(2);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(2));
        dL.add(new Die(2));
        c.placeDie(dL);
        assertThat(c.toString(), is(" [3]   7   5 :  $$5  $ 2  \n"));
    }

}