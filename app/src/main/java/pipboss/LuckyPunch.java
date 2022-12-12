package pipboss;

import java.util.*;

public class LuckyPunch extends MiniGame{

    public LuckyPunch(int i) {
        associatedCasinoNum = i;
    }

    @Override
    public void activate(Player p, Player p2, Controller c, Controller c2, List<Casino> casinos)  {
        int hidden = c.hideTiles();
        int guessed = c2.guessTiles();
        if(hidden == guessed)   {
            c.printMiniGameText("The minigame Jackpot has the following update: Guess " + guessed 
                + " was correct.");
            c.printMiniGameText("P" + p.getPID() + " gained $0: Lucky Punch");
        } else    {
            if(hidden == 0)  {
                p.addChips(2);
                c.printMiniGameText("The minigame Jackpot has the following update: Guess "+ guessed 
                    + " was incorrect.");
                c.printMiniGameText("P" + p.getPID() + " gained 2 chips: Lucky Punch");
            } else if(hidden == 1)  {
                p.addMoney(3);
                c.printMiniGameText("The minigame Jackpot has the following update: Guess "+ guessed 
                    + " was incorrect.");
                c.printMiniGameText("P" + p.getPID() + " gained $3: Lucky Punch");
            } else  {
                p.addMoney(4);
                c.printMiniGameText("The minigame Jackpot has the following update: Guess "+ guessed 
                    + " was incorrect.");
                c.printMiniGameText("P" + p.getPID() + " gained $4: Lucky Punch");
            }
        }
    }

    @Override
    public String getName() {
        return "Lucky Punch";
    }

    @Override
    public boolean equals(String s) {
        if(s.equals("LuckyPunch"))  {
            return true;
        }
        return false;
    }

    @Override
    public String toString()    {
        return "Lucky Punch - Choose 1, 2, or 3 to win 2 chips, $3, or $4.";
    }
    
}
