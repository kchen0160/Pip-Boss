package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class GameTest {

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

    //@Test
    void TestConstructor()   {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(1));
        players.add(new Player(2));

        List<String> miniStrGameList = new ArrayList<String>();

        List<ConsoleView> consoleview = new ArrayList<ConsoleView>();

        List<Controller> controller = new ArrayList<Controller>();

        Game g = new Game(players, miniStrGameList, consoleview, controller);
        assertEquals(2, players.size());
    }

    @Test
    void testResetCasinos() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(1));
        players.add(new Player(2));

        List<String> miniStrGameList = new ArrayList<String>();
        miniStrGameList.add("Jackpot");
        miniStrGameList.add("Pay Day");
        miniStrGameList.add("Fifty Fifty");

        List<ConsoleView> consoleview = new ArrayList<ConsoleView>();

        List<Controller> controller = new ArrayList<Controller>();

        Game g = new Game(players, miniStrGameList, consoleview, controller);

        g.setCasino();

        g.setUpMiniGames();



        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(1));
        dL.add(new Die(2));

        g.getCasino(1).placeDie(dL);

        g.resetCasino();

        assertEquals("   ", g.getCasino(1).countPlayerDie(1));
        assertEquals(6, g.getNumCasinos());
    }



    @Test
    void testMinigames() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(1));
        players.add(new Player(2));

        List<String> miniStrGameList = new ArrayList<String>();
        miniStrGameList.add("Jackpot");
        miniStrGameList.add("Pay Day");

        List<ConsoleView> consoleview = new ArrayList<ConsoleView>();

        List<Controller> controller = new ArrayList<Controller>();

        Game g = new Game(players, miniStrGameList, consoleview, controller);

        g.setCasino();

        g.setUpMiniGames();

        assertEquals(2, g.getMiniGames().size());
    }


    @Test
    void testMinigames2() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(1));
        players.add(new Player(2));

        List<String> miniStrGameList = new ArrayList<String>();
        miniStrGameList.add("Jackpot");

        List<ConsoleView> consoleview = new ArrayList<ConsoleView>();
        ConsoleView cv = new ConsoleView();
        consoleview.add(cv);

        List<Controller> controller = new ArrayList<Controller>();
        String a = "5";

        Scanner sc1 = new Scanner(a);

        Controller x = new ConsoleController(sc1, players.get(0).getPID());

        controller.add(x);

        Game g = new Game(players, miniStrGameList, consoleview, controller);

        g.setCasino();

        g.setUpMiniGames();

        g.playMiniGame(1, 0);

        assertEquals("Jackpot", g.getMiniGames().get(0).getName());
    }

    @Test
    void testMinigames3() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(1));
        players.add(new Player(2));

        List<String> miniStrGameList = new ArrayList<String>();
        miniStrGameList.add("Jackpot");
        miniStrGameList.add("Pay Day");
        miniStrGameList.add("Fifty Fifty");
        List<ConsoleView> consoleview = new ArrayList<ConsoleView>();

        List<Controller> controller = new ArrayList<Controller>();

        Game g = new Game(players, miniStrGameList, consoleview, controller);

        g.setCasino();

        g.setUpMiniGames();
        assertEquals(3, g.getMiniGames().size());
    }


    @Test
    void testPlayTurn() {
        List<Player> players = new ArrayList<Player>();
        Player p1 = new Player(1, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        players.add(p1);
        p1.setDice(6, 1);

        List<String> miniStrGameList = new ArrayList<String>();

        List<ConsoleView> consoleview = new ArrayList<ConsoleView>();

        ConsoleView c = new ConsoleView();

        consoleview.add(c);

        List<Controller> controller = new ArrayList<Controller>();
        String a = "4";

        Scanner sc1 = new Scanner(a);

        Controller x = new ConsoleController(sc1, p1.getPID());
        controller.add(x);

        Game g = new Game(players, miniStrGameList, consoleview, controller);

        g.setCasino();

        for (int j = 0; j < players.size(); j++) {
            g.playTurn(j);
        }
        assertEquals(6, players.get(0).getPDice());
    }

    @Test
    void testPlayTurn2() {
        List<Player> players = new ArrayList<Player>();
        Player p1 = new Player(1, new MockRandom(List.of(0, 1, 2, 3, 4, 5, 0)));
        players.add(p1);
        p1.setDice(6, 1);
        p1.setChips(2);

        List<String> miniStrGameList = new ArrayList<String>();

        List<ConsoleView> consoleview = new ArrayList<ConsoleView>();

        ConsoleView c = new ConsoleView();

        consoleview.add(c);

        List<Controller> controller = new ArrayList<Controller>();
        String a = "0";

        Scanner sc1 = new Scanner(a);

        Controller x = new ConsoleController(sc1, p1.getPID());
        controller.add(x);

        Game g = new Game(players, miniStrGameList, consoleview, controller);

        g.setCasino();

        for (int j = 0; j < players.size(); j++) {
            g.playTurn(j);
        }

        assertEquals(7, players.get(0).getPDice());
        assertEquals(1, players.get(0).getChips());


    }

    @Test
    void testRoundEnd() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(1));

        List<String> miniStrGameList = new ArrayList<String>();

        List<ConsoleView> consoleview = new ArrayList<ConsoleView>();

        List<Controller> controller = new ArrayList<Controller>();

        Game g = new Game(players, miniStrGameList, consoleview, controller);

        g.setCasino();

        players.get(0).setDice(0, 0);

        assertEquals(true, g.roundEnd());

        players.get(0).setDice(1, 0);

        assertEquals(false, g.roundEnd());
    }

    @Test
    void testRollDices() {
        Player p = new Player(1, new MockRandom(List.of(1, 2, 3)));
        List<Player> players = new ArrayList<Player>();
        players.add(p);

        List<String> miniStrGameList = new ArrayList<String>();

        List<ConsoleView> consoleview = new ArrayList<ConsoleView>();

        List<Controller> controller = new ArrayList<Controller>();

        Game g = new Game(players, miniStrGameList, consoleview, controller);

        assertEquals("P1 You rolled [].", g.rollDices(0));
    }

    //@Test
    void testOrder() {
        Player p = new Player(1, new MockRandom(List.of(1, 2, 3)));
        List<Player> players = new ArrayList<Player>();
        players.add(p);

        List<String> miniStrGameList = new ArrayList<String>();

        List<ConsoleView> consoleview = new ArrayList<ConsoleView>();

        List<Controller> controller = new ArrayList<Controller>();

        Game g = new Game(players, miniStrGameList, consoleview, controller);

        MoneyPair[] mp = {new MoneyPair(2,4), new MoneyPair(3,3)};

        //g.order(mp);

        assertEquals("P1 You rolled [].", g.rollDices(0));
    }



    
}
