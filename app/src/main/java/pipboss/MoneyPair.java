package pipboss;

import java.util.*;

public class MoneyPair {
    private int highMoney;
    private int lowMoney;
    private Random rand;
    
    public MoneyPair(int highMoney, int lowMoney)  {
        if (lowMoney > highMoney) {
            int temp = highMoney;
            this.highMoney = lowMoney;
            this.lowMoney = temp;
        } else {
            this.lowMoney = lowMoney;
            this.highMoney = highMoney;
        }
    }

    // public MoneyPair(Random r)  {
    //    rand = r;
    // }

    public int getHighMoney()   {
        return highMoney;
    }

    public int getLowMoney()    {
        return lowMoney;
    }

    public int compareTo(MoneyPair mp)  {
        int thisAdded = highMoney + lowMoney;
        int passedInAdded = mp.getHighMoney() + mp.getLowMoney();
        if(thisAdded - passedInAdded == 0)   {
            return highMoney - mp.getHighMoney();
        }
        return thisAdded - passedInAdded;
    }

    @Override
    public String toString()    {
        return "("+highMoney+","+lowMoney+")";
        //String moneyString = "High: " + highMoney + " Low: " + lowMoney;

        //return moneyString;
    }
}