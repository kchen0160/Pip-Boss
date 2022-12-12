package pipboss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;


class PlayerTest {
    /* 
    Player p = new Player(int=pid);
    int pid = p.getPID()
    int money = p.getMoney();
    p.addMoney();
    List<Integer> listOfRolls= p.roll();
    int chips = p.getChips();
    p.addChips();
    p.toString();
    */

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
    void testDefaultConstructor() {
        Player p = new Player(1);
        assertEquals(p.getPID(), 1);
        assertEquals(p.getMoney(), 0);
        assertEquals(p.getChips(), 0);
    }

    @Test
    void testGetPID(){
        Player p = new Player(1);
        assertEquals(p.getPID(), 1);
    }
    @Test
    void testGetMoney(){
        Player p = new Player(2);
        p.addMoney(1000);
        assertEquals(p.getMoney(), 1000);
    }
    @Test
    void testSetDice(){
        Player p = new Player(3);
        p.setDice(6, 1);
        assertEquals(p.getPDice(), 7);
    }
    @Test
    void testIsAI(){
        Player p = new Player(1);
        assertEquals(p.isAI(), false);
    }
    @Test
    void testGetChips(){
        Player p = new Player(1);
        p.setChips(2);
        assertEquals(p.getChips(), 2);
        }
    @Test
    void testAddChips(){
        Player p = new Player(1);
        p.setChips(2);
        p.addChips(2);
        assertEquals(p.getChips(), 4);
    }
    @Test
    void testUseChips(){
        Player p = new Player(1);
        p.setChips(2);
        p.useChip();
        assertEquals(p.getChips(), 1);
    }
    @Test
    void testgetRollString(){
        Player p = new Player(1);
        String str = p.getRollString();
        String ans = "P1 You rolled [].";
        assertEquals(str, ans);
        
    }

    @Test
    void testRollDice()  {
        Player p = new Player(1, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        p.setDice(6, 1);
        List<IntBoolPair> solutionList = new ArrayList<IntBoolPair>();
        solutionList.add(new IntBoolPair(1, false));
        solutionList.add(new IntBoolPair(2, false));
        solutionList.add(new IntBoolPair(3, false));
        solutionList.add(new IntBoolPair(4, false));
        solutionList.add(new IntBoolPair(5, false));
        solutionList.add(new IntBoolPair(6, false));
        solutionList.add(new IntBoolPair(1, true));
        List<IntBoolPair> rollList = new ArrayList<IntBoolPair>();
        rollList = p.rollDice();
        for(int i=0; i<solutionList.size();i++) {
            assertEquals(solutionList.get(i).getInt(), rollList.get(i).getInt());
            assertEquals(solutionList.get(i).getBool(), rollList.get(i).getBool());
        }
    }

    //@Test
    void testPlayerToString() {
        Player p = new Player(1);
        p.setDice(7, 1);
        p.setChips(2);
        assertThat(p.toString(), is("     P1 :     0     7     1      2\r\n"));
    }

    @Test
    void testPlayDice()  {
        Player p = new Player(1, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        p.setDice(6, 1);
        List<IntBoolPair> rollList = new ArrayList<IntBoolPair>();
        rollList = p.rollDice();
        //ArrayList<Die> temp = p.playDice(1);
        ArrayList<Die> temp2 = new ArrayList<Die>();
        Die d = new Die(1, new MockRandom(List.of(0)));
        Die e = new Die(1, true, new MockRandom(List.of(0)));
        temp2.add(d);
        temp2.add(e);
        
        assertEquals(p.playDice(1).get(0).toString(), temp2.get(0).toString());
    }

}