package pipboss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class MainTest {
    private Main main;


    @Test
    void testSetUp() {
        main = new Main();
        int rounds = 3;
        int stdDice = 7;
        int lrgDice = 1;
        int chips = 2;
        int plyHuman = 1;
        int plyAI = 2;
        List<String> miniGameList = new ArrayList<String>();
        miniGameList.add("Lucky Punch");
        miniGameList.add("High Five");
        miniGameList.add("Black Box");

        main.testInit(rounds, stdDice, lrgDice, chips, plyHuman, plyAI, miniGameList);

        assertThat(6, is(main.getGame().getNumCasinos()));
        assertThat(3, is(main.getGame().getMiniGames().size()));
    }

    @Test
    void testResetRound() {
        main = new Main();
        int rounds = 3;
        int stdDice = 7;
        int lrgDice = 1;
        int chips = 2;
        int plyHuman = 1;
        int plyAI = 2;
        List<String> miniGameList = new ArrayList<String>();
        miniGameList.add("Lucky Punch");
        miniGameList.add("High Five");
        miniGameList.add("Black Box");

        main.testInit(rounds, stdDice, lrgDice, chips, plyHuman, plyAI, miniGameList);
        main.resetRound();

        assertThat(6, is(main.getGame().getNumCasinos()));
        assertThat(3, is(main.getGame().getMiniGames().size()));
    }
    
}
