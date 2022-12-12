package pipboss;

import java.util.*;

//import javax.lang.model.util.ElementScanner6;

public class BlackBox extends MiniGame{
    private int[] tokens;


    public BlackBox(int i){
        associatedCasinoNum = i;
        tokens = new int[6];
        tokens[0] = 0;
        tokens[1] = 0;
        tokens[2] = 0;
        tokens[3] = 2;
        tokens[4] = 2;
        tokens[5] = 6;
    }

    @Override
    public void payOut(List<Player> players, List<Controller> c, List<Casino> casinos)  {
        int winningPID = casinos.get(associatedCasinoNum-1).getWinningPID();
        boolean isWinner=false;
        Player winningPlayer=players.get(0);
        int winningPlayerIndex=0;
        for(int i=0; i<players.size();i++)  {
            if(winningPID == players.get(i).getPID())   {
                winningPlayer = players.get(i);
                winningPlayerIndex = i;
                isWinner = true;
            }
        }
        if(isWinner)    {
            Player leftPlayer=players.get(0);
            int leftIndex = winningPlayerIndex+1;
            try{
                leftPlayer = players.get(leftIndex);
            } catch(Exception e)    {
                leftPlayer = players.get(0);
                leftIndex = 0;
            }
            int leftCount = 0;
            int rightCount = 0;
            List<Integer> leftTemp = new ArrayList<Integer>();
            List<Integer> rightTemp = new ArrayList<Integer>();
            
            for(int i=0; i<tokens.length;i++)   {
                if(i == tokens.length-1 && leftCount == 0)    {
                    leftTemp.add(tokens[i]);
                } else if(i == tokens.length-1 && rightCount == 0)    {
                    rightTemp.add(tokens[i]);
                } else {
                    int pileChoice = c.get(leftIndex).getBlackboxPiles(tokens[i]);
                    if(pileChoice == 1) {
                        leftCount++;
                        leftTemp.add(tokens[i]);
                    } else {
                        rightCount++;
                        rightTemp.add(tokens[i]);
                    }
                }
            }
            String leftStr = pileToStr(leftTemp);
            String rightStr = pileToStr(rightTemp);

            int pileChoice = c.get(winningPlayerIndex).getPileChoice(leftTemp.size(), rightTemp.size());
            int count = 0;
            String chossenString = "";
            if(pileChoice == 1) {
                for(int i=0; i<leftTemp.size();i++) {
                    count = count +leftTemp.get(i);
                }
                players.get(winningPlayerIndex).addMoney(count);
                chossenString = leftStr;
                
                
            } else  {
                for(int i=0; i<leftTemp.size();i++) {
                    count = count +leftTemp.get(i);
                }
                players.get(winningPlayerIndex).addMoney(count);
                chossenString = rightStr;
            }
            c.get(winningPlayerIndex).printMiniGameText("P" +winningPlayer.getPID()
                + " gained $"+count+": Black Box (chose " + chossenString + " out of " + leftStr +"|" + rightStr + ").");

            c.get(winningPlayerIndex).printMiniGameText("The minigame Black Box at Casino " +associatedCasinoNum +
                " has the following update: P" + leftPlayer.getPID() + " split as " + leftStr +"|" + rightStr +
                " and P" + winningPlayer.getPID() + " chose " + chossenString + ".");

        }
    }       

    private String pileToStr(List<Integer> pile)  {
        String retString = "";
        for(int i=0; i<pile.size();i++) {
            retString = retString + Integer.toString(pile.get(i));
        }
        return retString;
    }

    @Override
    public String getName() {
        return "Black Box";
    }

    @Override
    public boolean equals(String s) {
        if(s.equals("Black Box"))  {
            return true;
        }
        return false;
    }

    @Override
    public String toString()    {
        return "Black Box - During payout, the winner plays a split/choose for additional.";
    }
}
