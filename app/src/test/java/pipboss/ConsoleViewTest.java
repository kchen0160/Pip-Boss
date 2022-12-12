package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class ConsoleViewTest {

    @Test
    void testStartRound() {
        ConsoleView c = new ConsoleView();
        int rounds = 1;
        int plys = 2;
        int stdDice = 6;
        int lrgDice = 1;
        int chips = 2;
        c.gameStarted(rounds, plys, stdDice, lrgDice, chips);
        assertEquals(1, rounds);
        assertEquals(2, plys);
    }

    @Test
    void testGameStart() {
        ConsoleView c = new ConsoleView();
        List<Player> players = new ArrayList<Player>();
        Player p1 = new Player(1);
        players.add(p1);
        p1.setDice(6, 1);
        Player p2 = new Player(2);
        players.add(p2);
        p2.setDice(6, 1);

        List<MiniGame> miniStrGameList = new ArrayList<MiniGame>();
        Jackpot m = new Jackpot(1);
        miniStrGameList.add(m);

        int chips = 2;
        int rounds = 1;

        c.startRound(players, miniStrGameList, chips, rounds);
        assertEquals(2, players.size());
        assertEquals(1, miniStrGameList.size());
    }

    @Test
    void testDisplayBoard() {
        ConsoleView c = new ConsoleView();
        List<Player> players = new ArrayList<Player>();
        Player p1 = new Player(1);
        players.add(p1);
        p1.setDice(6, 1);
        Player p2 = new Player(2);
        players.add(p2);
        p2.setDice(6, 1);

        List<MiniGame> miniStrGameList = new ArrayList<MiniGame>();
        Jackpot m = new Jackpot(1);
        miniStrGameList.add(m);

        int chips = 2;
        int rounds = 1;

        List<Casino> cas = new ArrayList<Casino>();
        Casino c1 = new Casino(3, 1, 1);
        Casino c2 = new Casino(6, 2, 2);
        cas.add(c1);
        cas.add(c2);
        c.displayBoard(players, cas, miniStrGameList);
        assertEquals(3, cas.get(0).getHighMoney());
        assertEquals(7, players.get(1).getPDice());
    }

    @Test
    void testRoundEnd() {
        ConsoleView c = new ConsoleView();
        List<Player> players = new ArrayList<Player>();
        Player p1 = new Player(1);
        players.add(p1);
        p1.setDice(6, 1);
        Player p2 = new Player(2);
        players.add(p2);
        p2.setDice(6, 1);

        List<MiniGame> miniStrGameList = new ArrayList<MiniGame>();
        Jackpot m = new Jackpot(1);
        miniStrGameList.add(m);

        int rounds = 1;

        List<Casino> cas = new ArrayList<Casino>();
        Casino c1 = new Casino(3, 1, 1);
        ArrayList<Die> dL = new ArrayList<Die>();
        dL.add(new Die(1));
        dL.add(new Die(1));
        c1.placeDie(dL);
        Casino c2 = new Casino(6, 2, 2);
        ArrayList<Die> dL2 = new ArrayList<Die>();
        dL2.add(new Die(1));
        dL2.add(new Die(1));
        dL2.add(new Die(2));
        c2.placeDie(dL2);
        cas.add(c1);
        cas.add(c2);

        List<Controller> controller = new ArrayList<Controller>();

        c.roundEnd(players, controller, cas, miniStrGameList, rounds);
        assertEquals(7, players.get(1).getPDice());
        assertEquals(1, cas.get(0).getWinningPID());
        assertEquals(2, cas.get(1).getWinningPID2());
    }

}
