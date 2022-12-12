package pipboss;

import java.util.*;


public class Player {
    private int pid;
    private int money;
    private int chips;
    private Random rng;
    private ArrayList<Die> dList;

    public Player(int pid) {
        this(pid, new Random());
    }

    public Player(int pid, Random rng) {
        this.pid = pid;
        money = 0;
        chips = 0;
        this.rng = rng;
        dList = new ArrayList<Die>();
    }

    public void setDice(int stdDice, int lrgDice)    {
        for(int i=0; i<stdDice; i++)   {
            dList.add(new Die(pid, rng));
        }
        for(int i=0; i<lrgDice; i++)   {
            dList.add(new Die(pid, true, rng ));
        }
    }
    
    public int getPID() {
        return pid;
    }

    public int getMoney()   {
        return money;
    }

    public Random getRandom()   {
        return rng;
    }

    public void addMoney(int money)   {
        this.money = this.money + money;
    }

    public List<IntBoolPair> rollDice() {
        List<IntBoolPair> rolls = new ArrayList<>();
        for (int i = 0; i < dList.size(); i++) {
            dList.get(i).roll();
            rolls.add(new IntBoolPair(dList.get(i).getValue(), dList.get(i).isBig()));
        }
        return rolls;
    }

    public int getChips()    {
        return chips;
    }

    public void useChip()  {
        chips = chips-1;
    }

    public void setChips(int chips)  {
        this.chips = chips;
    }

    public void addChips(int chips)  {
        this.chips = this.chips + chips;
    }

    public String toString()  {
        int normDice = howManyNormDice();
        Formatter playF = new Formatter();
        playF.format("%9s %5s %5s %5s %6s%n",
        " P" + getPID() + " :", getMoney(), normDice, (dList.size()-normDice), getChips());
        String retString = playF.toString();
        playF.close();
        return retString;
    }

    private int howManyNormDice()   {
        int count=0;
        for (int i = 0; i < dList.size(); i++) {
            if(!dList.get(i).isBig())   {
                count++;
            }
        }
        return count; 
    }

    public boolean isAI()  {
        return false;
    }

    public ArrayList<Die> playDice(int picked)  {
        ArrayList<Die> temp = new ArrayList<Die>();
        int resLen = dList.size();
        for(int i=0; i<resLen;i++)  {
            if(picked == dList.get(i).getValue())  {
                temp.add(dList.get(i));
                dList.remove(i);
                resLen--;
                i--;
            }
        }
        return temp;
    }

    public String getRollString() {
        return ("P" + pid + " You rolled " + dList + ".");
    }

    public int getPDice() {
        return dList.size();
    }
}
