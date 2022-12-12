package pipboss;

import java.util.*;

public class Jackpot extends MiniGame{
    private int[] jackPotList;
    private int index, casinoNum;
    private Random rng;

    public Jackpot(int i, Random r){
        rng = r;
        associatedCasinoNum = i;
        jackPotList = new int[6];
        index = 0;
        for(int j=0; j<jackPotList.length; j++)   {
            jackPotList[j] = 3 + j;
        }
    }

    public Jackpot(int i){
        this(i, new Random());
    }

    @Override
    public String getName() {
        return "Jackpot";
    }

    @Override
    public void activate(Player p, Player p2, Controller c, Controller c2, List<Casino> casinos)  {
        Die dice1 = new Die(0, rng);
        Die dice2 = new Die(0, rng);
        dice1.roll();
        dice2.roll();
        if(dice1.getValue()==dice2.getValue() || (dice1.getValue()+dice2.getValue()) == 7 ) {
            int winnings = jackPotList[index];
            p.addMoney(winnings);
            c.printMiniGameText( "P"+ p.getPID() + " gained $" + jackPotList[index] + 
                ": Jackpot ( [" + dice1.getValue() + "," +  dice2.getValue() + "] -> $" + jackPotList[index] + ").\n" +
                "The minigame Jackpot at Casino "
                + casinoNum + " has the following update: [" + dice1.getValue()
                + "," + dice2.getValue() + "] was rolled, and payout was $" +
                winnings + ". Potential payout is now $" + jackPotList[0]+".");
                index = 0;
        } else {
            if(index < 5)   {
                index++;
            }
            c.printMiniGameText("The minigame Jackpot at Casino "
                + casinoNum + " has the following update: [" + dice1.getValue()
                + "," + dice2.getValue() + "] was rolled. Potential payout is now $" + jackPotList[index]+".");
        }

    }

    public void setIndex(int index)  {
        this.index = index;
    }

    public int getIndex()   {
        return index;
    }

    @Override
    public boolean equals(String s) {
        if(s.equals("Jackpot"))  {
            return true;
        }
        return false;
    }

    @Override
    public String toString()    {
        return "Jackpot - Roll doubles or 7 to win $" + jackPotList[index] + ".";
    }
}
