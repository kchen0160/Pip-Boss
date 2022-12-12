package pipboss;

import java.util.*;

public class FiftyFifty extends MiniGame{
    private int[] rewards;
    private Random rng;
    private int index, marker, guess;

    public FiftyFifty(int i, Random r){
        rng = r;
        index = 0;
        marker = 0;
        guess = 0;
        associatedCasinoNum = i;
        rewards = new int[5];
        rewards[0] = 0;
        rewards[1] = 1;
        rewards[2] = 3;
        rewards[3] = 4;
        rewards[4] = 6;
    }

    public FiftyFifty(int i){
        this(i, new Random());
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getMarker() {
        return marker;
    }

    public void setMarker(int marker) {
        this.marker = marker;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public void activate(Player p, Player p2, Controller c, Controller c2, List<Casino> casinos)  {
        boolean miniGameOver = false;
        Die dice1 = new Die(0, rng);
        Die dice2 = new Die(0, rng);
        dice1.roll();
        dice2.roll();
        while(!miniGameOver) {
            marker = dice1.getValue() + dice2.getValue();
            guess = c.getFiftyFiftyChoice(rewards[index], marker);
            if(guess == 0 || index >= 4)  {
                miniGameOver = true;
            } else if(guess == 1)   {
                dice1.roll();
                dice2.roll();
                int temp = dice1.getValue() + dice2.getValue();
                if(marker > temp)   {
                    index++;
                    marker = temp;
                    c.printMiniGameText("The minigame Fifty Fifty at Casino " + associatedCasino() 
                        + " has the following update: new marker is " + marker );
                } else  {
                    index = 0;
                    miniGameOver = true;
                    c.printMiniGameText("The minigame Fifty Fifty at Casino " + associatedCasino() 
                        + " has the following update: P" + p.getPID() + " guessed lower and the roll was "  + temp);
                }
            } else  {
                dice1.roll();
                dice2.roll();
                int temp = dice1.getValue() + dice2.getValue();
                if(marker < temp)   {
                    index++;
                    marker = temp;
                    c.printMiniGameText("The minigame Fifty Fifty at Casino " + associatedCasino() 
                        + " has the following update: new marker is " + marker );
                } else  {
                    index = 0;
                    miniGameOver = true;
                    c.printMiniGameText("The minigame Fifty Fifty at Casino " + associatedCasino() 
                        + " has the following update: P" + p.getPID() + " guessed higher and the roll was "  + temp );
                }
            }
            
        }
        if(index == 1)  {
            p.addChips(1);
            c.printMiniGameText("P" + p.getPID() + " gained 1 chip: Fifty Fifty");
        } else  {
            p.addMoney(rewards[index]);
            c.printMiniGameText("P" + p.getPID() + " gained $" + rewards[index] + ": Fifty Fifty");
        }
        index=0;

    }

    @Override
    public String getName() {
        return "Fifty Fifty";
    }

    @Override
    public boolean equals(String s) {
        if(s.equals("Fifty Fifty"))  {
            return true;
        }
        return false;
    }

    @Override
    public String toString()    {
        return "Fifty Fifty - Keep rolling more/less than target or stop and take payout.";
    }
}
