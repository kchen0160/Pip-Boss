package pipboss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class AppTest {
    
    //@Test 
    void exampleTest() {
        App testedClass = new App();
        assertThat("this is an informative message about the test", 1, is(1));
    }
/* 
    //@Test
    void diceTest() {
        Dice dice = new Dice();
        dice.setSeed(0);
        dice.roll();
        assertEquals(dice.hasBeenPlayed(), true);
        assertEquals(dice.toString(), "1");
        assertEquals(dice.getValue(), 1);
        dice.reset();
        assertEquals(dice.hasBeenPlayed(), false);
    }
*/
/* 
    @Test
    void playerTest()   {
        Player player = new Player("Player 1", 80000, 7, 0);
        player.setDiceSeed(0);
        assertEquals(player.getMoney(), 80000);
        player.setMoney(20000);
        assertEquals(player.getMoney(), 20000);
        player.rollDice();

    }
    */
}
