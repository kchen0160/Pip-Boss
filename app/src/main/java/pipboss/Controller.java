package pipboss;

import java.util.*;

public abstract class Controller {
    public abstract int getDiceChoice(List<IntBoolPair> rolls); 

    public abstract int getFiftyFiftyChoice(int reward, int diceRoll);

    public abstract int hideTiles();
    
    public abstract int guessTiles();

    public abstract int getBlackboxPiles(int num);

    public abstract int getPileChoice(int leftSize, int rightSize);

    public abstract int getBlockItPileChoice();

    public abstract int getBlockItCasinoChoice();
    
    public void useChip(Player p)   {
        p.useChip();
        System.out.println("P" + p.getPID() + " used a chip and has " + p.getChips() + " chips left." );
    }

    public void printMiniGameText(String s) {
        System.out.println(s);
    }
}
