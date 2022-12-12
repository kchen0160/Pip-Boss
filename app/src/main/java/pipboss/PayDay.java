package pipboss;

import java.util.*;

public class PayDay extends MiniGame {

    public PayDay(int i) {
        associatedCasinoNum = i;
    }

    @Override
    public void activate(Player p, Player p2, Controller c, Controller c2, List<Casino> casinos)    {
        int presence = 0;
        for(Casino casino : casinos) {
            if(casino.isPresent(p.getPID()))    {
                presence++;
            }
        }
        if(presence < 3)    {
            p.addChips(presence);
            c.printMiniGameText("P" + p.getPID() + " gained " + presence + 
            " chips: Pay Day (has presence at " + presence + " casinos).");
        } else{
            p.addMoney(presence);
            c.printMiniGameText("P" + p.getPID() + " gained $" + presence + 
            ": Pay Day (has presence at " + presence + " casinos).");
        }
        c.printMiniGameText("The minigame Pay Day at Casino " + associatedCasino() + " has the following update: P"
        + p.getPID() + " has presence at " + presence + " casinos.");
    }

    @Override
    public String getName() {
        return "Pay Day";
    }

    @Override
    public boolean equals(String s) {
        if(s.equals("Pay Day"))  {
            return true;
        }
        return false;
    }

    @Override
    public String toString()    {
        return "Pay Day - Gain $1 for each casino where you have presence.";
    }
    
}
