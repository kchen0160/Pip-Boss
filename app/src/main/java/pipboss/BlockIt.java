package pipboss;

import java.util.*;

//import javax.lang.model.util.ElementScanner6;

public class BlockIt extends MiniGame{
    private List<Integer> remaining;

    public BlockIt(int i){
        associatedCasinoNum = i;
        remaining = new ArrayList<Integer>();
        remaining.add(1);
        remaining.add(1);
        remaining.add(2);
        remaining.add(2);
        remaining.add(3);
    }

    @Override
    public void activate(Player p, Player p2, Controller c, Controller c2, List<Casino> casinos)  {
        if(remaining.size()>0)  {
            int choice = c.getBlockItPileChoice();
            if(choice == 0) {
                for(int i=0; i<remaining.size();i++)    {
                    if(remaining.get(i) == 1)   {
                        int choice2 = c.getBlockItCasinoChoice();
                        List<Die>  diceList = new ArrayList<Die>();
                        diceList.add(new Die(0));
                        diceList.get(0).setValue(choice2);
                        casinos.get(choice2-1).placeDie(diceList);
                        c.printMiniGameText("The minigame Block It at Casino " + associatedCasino() 
                            + " has the following update: P" + p.getPID() + " has placed " + remaining.get(i)
                            + " Dice in casino " + choice2 );
                        remaining.remove(i);
                        i = remaining.size()+1;
                    }
                }
            } else if(choice == 1) {
                for(int i=0; i<remaining.size();i++)    {
                    if(remaining.get(i) == 2)   {
                        int choice2 = c.getBlockItCasinoChoice();
                        List<Die>  diceList = new ArrayList<Die>();
                        diceList.add(new Die(0));
                        diceList.add(new Die(0));
                        diceList.get(0).setValue(choice2);
                        diceList.get(1).setValue(choice2);
                        casinos.get(choice2-1).placeDie(diceList);
                        c.printMiniGameText("The minigame Block It at Casino " + associatedCasino() 
                            + " has the following update: P" + p.getPID() + " has placed " + remaining.get(i)
                            + " Dice in casino " + choice2 );
                        remaining.remove(i);
                        i = remaining.size()+1;
                    }
                }

            } else if(choice == 2){
                for(int i=0; i<remaining.size();i++)    {
                    if(remaining.get(i) == 3)   {
                        int choice2 = c.getBlockItCasinoChoice();
                        List<Die>  diceList = new ArrayList<Die>();
                        diceList.add(new Die(0));
                        diceList.add(new Die(0));
                        diceList.add(new Die(0));
                        diceList.get(0).setValue(choice2);
                        diceList.get(1).setValue(choice2);
                        diceList.get(2).setValue(choice2);
                        casinos.get(choice2-1).placeDie(diceList);
                        c.printMiniGameText("The minigame Block It at Casino " + associatedCasino() 
                            + " has the following update: P" + p.getPID() + " has placed " + remaining.get(i)
                            + " Dice in casino " + choice2 );
                        remaining.remove(i);
                        i = remaining.size()+1;
                    }
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Block It";
    }

    @Override
    public boolean equals(String s) {
        if(s.equals("Block It"))  {
            return true;
        }
        return false;
    }

    @Override
    public String toString()    {
        return "Block It - Play blank dice to any casino";
    }
}
