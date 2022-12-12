package pipboss;
import java.util.*;

import javax.print.PrintException;

public class Casino {
    private int highMoney;
    private int lowMoney;
    private ArrayList<Die> dList;
    private int casinoID;
    private int playerNum;

    public Casino(int highMoney, int lowMoney, int casinoID){
        dList = new ArrayList<Die>();
        this.highMoney = highMoney;
        this.lowMoney = lowMoney;
        this.casinoID = casinoID;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int n) {
        playerNum = n;
    }

    public int getHighMoney()   {
        return highMoney;
    }

    public void setHighMoney(int hm)  {
        highMoney = hm;
    }

    public void setLowMoney(int lm)  {
        lowMoney = lm;
    }

    public int getLowMoney()   {
        return lowMoney;
    }

    public int getCasinoID()   {
        return casinoID;
    }

    public ArrayList<Die> getDice() {
        return dList;
    }

    public void placeDie(List<Die> d)  {
        for (int i = 0; i < d.size(); i++) {
            dList.add(d.get(i));
        }
    }

    private class Pair implements Comparable<Pair> {
        private int pid;
        private int count;

        public Pair(int pid)   {
            this.pid = pid;
            count = 1;
        }

        public void increase()  {
            count = count +1;
        }

        public int getCount()   {
            return count;
        }

        public int getPid() {
            return pid;
        }
        /*
        @Override
        public String toString()    {
            return "("+pid+","+count+")";
        }
        */

        public int compareTo(Pair otherPair) {
            return Integer.compare(getCount(), otherPair.getCount());
        }
    
    }

    //returns -1 if no one is winning
    public int getWinningPID()  {
        ArrayList<Pair> pidList = createPidList();
        for(int i=0; i<pidList.size(); i++){
            boolean removeCon = false;
            for(int j=i+1; j<pidList.size();j++) {
                if(pidList.get(i).getCount() == pidList.get(j).getCount())   {
                    pidList.remove(j);
                    j--;
                    removeCon = true;
                }
            }
            if(removeCon)   {
                pidList.remove(i);
                i--;
            }
        }

        if (pidList.size() == 0) {
            return -1;
        }

        Collections.sort(pidList, Collections.reverseOrder());
        return pidList.get(0).getPid();
    }

    public int getWinningPID2()  {
        ArrayList<Pair> pidList = createPidList();
        for(int i=0; i<pidList.size(); i++){
            boolean removeCon = false;
            for(int j=i+1; j<pidList.size();j++) {
                if(pidList.get(i).getCount() == pidList.get(j).getCount())   {
                    pidList.remove(j);
                    j--;
                    removeCon = true;
                }
            }
            if(removeCon)   {
                pidList.remove(i);
                i--;
                return -1;
            }
        }

        if (pidList.size() < 2) {
            return -1;
        }
        
        Collections.sort(pidList, Collections.reverseOrder());

        return pidList.get(1).getPid();
    }

    private ArrayList<Pair> createPidArray() {
        ArrayList<Pair> temp = new ArrayList<Pair>();
        for(int i=0; i<dList.size(); i++)    {
            boolean isPresent = false;
            for(int j=0; j<temp.size(); j++) {
                if(temp.get(j).getPid() == dList.get(i).getPlayerId())  {
                    isPresent = true;
                }
            }
            if(!isPresent)  {
                temp.add(new Pair(dList.get(i).getPlayerId()));
            }
        }
        return temp;
    }

    private ArrayList<Pair> createPidList() {
        ArrayList<Pair> pidList = createPidArray();
        for(int i=0; i<dList.size(); i++)    {
            for(int j=0; j<pidList.size(); j++) {
                if(pidList.get(j).getPid() == dList.get(i).getPlayerId())   {
                    pidList.get(j).increase();
                    if(dList.get(i).isBig())    {
                        pidList.get(j).increase();
                    }
                }
            }
        }
        return pidList;
    }

    // if getwinningpid for casino > -1, return $$ if not winning return $ if empty return "";
    public String countPlayerDie(int pid) {
        // if dice in dList does not contain the pid, return empty string
        if (dList.size() == 0) {
            return "   ";
        }
        int temp = 0;
        for(int i=0; i<dList.size(); i++)   {
            if(dList.get(i).getPlayerId() == pid)   {
                temp++;
                if(dList.get(i).isBig())    {
                    temp++;
                }
            }
        }
        if (temp == 0) {
            return "   ";
        }
        //System.out.println("Winner: " + getWinningPID() + " at " + casinoID);
        //System.out.println(getWinningPID2());
        if (getWinningPID() == pid) {
            return ("$$" + Integer.toString(temp));
        } else if (getWinningPID2() == pid) {
            return ("$ " + Integer.toString(temp));
        } else {
            return ("  " + Integer.toString(temp));
        }
    }

    public Boolean isPresent(int pid)   {
        for(int i=0; i<dList.size();i++)    {
            if(dList.get(i).getPlayerId() == pid)   {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String playCas = "";
        Formatter playC = new Formatter();
        for (int i = 1; i <= playerNum; i++) {
            playCas += countPlayerDie(i) + "  ";
        }
        playC.format("%-5s %2s %3s :  %2s%n",
        " [" + getCasinoID() + "] ", getHighMoney(), getLowMoney(), playCas);
        String retString = playC.toString();
        playC.close();
        return retString;
    }

    public void removePlayerDice()  {
        dList = new ArrayList<Die>();
    }
}
