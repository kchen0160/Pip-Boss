package pipboss;

import java.util.*;

public class HighFive extends MiniGame{
    private boolean prizeAvailable;

    public HighFive(int i){
        associatedCasinoNum = i;
        prizeAvailable = true;
    }

    @Override
    public void activate(Player p, Player p2, Controller c, Controller c2, List<Casino> casinos)  {
        if(prizeAvailable)  {
            Casino curCasino = casinos.get(associatedCasinoNum-1);
            List<Die> casinoDice = curCasino.getDice();
            int count = 0;
            for(int i=0; i<casinoDice.size();i++)   {
                if(casinoDice.get(i).getPlayerId() == p.getPID())   {
                    count++;
                    if(casinoDice.get(i).isBig() == true)   {
                        count++;
                    }
                }
            }
            if(count >= 5)  {
                p.addMoney(10);
                prizeAvailable = false;
                c.printMiniGameText("P" + p.getPID() + " gained $10: High Five");
            }
        }
    
        
    }

    @Override
    public String getName() {
        return "High Five";
    }

    public void setPrizeAvaliblity(boolean prizeAvailable)  {
        this.prizeAvailable = prizeAvailable;
    }

    @Override
    public boolean equals(String s) {
        if(s.equals("High Five"))  {
            return true;
        }
        return false;
    }

    @Override
    public String toString()    {
        if(prizeAvailable)  {
            return "High Five - The first player to place at least 5 dice here wins $10.";
        }
        return "High Five - The payout has already been claimed.";
    }
}
