package pipboss;

import java.util.*;


public class AiController extends Controller {
    private int pid;
    private Random rng;

    public AiController(int pid, Random r)  {
        this.pid = pid;
        rng = r;
    }

    public AiController(int pid)  {
        this(pid, new Random());
    }
    
    @Override
    public int getDiceChoice(List<IntBoolPair> rolls) {
        String rollString = "[";
        for(int i=0;i<rolls.size();i++) {
            if(i == 0)    {
                if(rolls.get(i).getBool()) {
                    rollString = rollString + rolls.get(i).getInt() + "+" + rolls.get(i).getInt();
                } else {
                    rollString = rollString + rolls.get(i).getInt();
                }
            }else if(rolls.get(i).getBool()) {
                rollString = rollString + ", " + rolls.get(i).getInt() + "+" + rolls.get(i).getInt();
            } else {
                rollString = rollString + ", " + rolls.get(i).getInt();
            }
        }
        rollString = rollString + "]";
        System.out.println("P" + pid + " rolled " + rollString + ".");

        ArrayList<Integer> countList = new ArrayList<Integer>();
        countList.add(0);
        countList.add(0);
        countList.add(0);
        countList.add(0);
        countList.add(0);
        countList.add(0);
        countList.add(0);
        for(int i=0; i<rolls.size(); i++)   {
            int index = rolls.get(i).getInt();
            countList.set(index, countList.get(index) + 1);
            if(rolls.get(i).getBool())    {
                countList.set(index, countList.get(index) + 1);
            }
        }
        int max = countList.get(1);
        int maxIndex = 1;
        for(int i=2; i<countList.size(); i++)   {
            if(countList.get(i) >= max) {
                max = countList.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @Override
    public int getFiftyFiftyChoice(int reward, int diceRoll)    {
        if(reward == 0) {
            if(diceRoll> 7) {
                return 1;
            } else  {
                return 2;
            }
        } else{
            if(diceRoll >= 5 && diceRoll <= 8)  {
                return 0;
            } else if(diceRoll > 5) {
                return 1;
            } else  {
                return 2;
            }
        }
    }

    @Override
    public int hideTiles()  {
        return rng.nextInt(3);
    }

    @Override
    public int guessTiles() {
        return rng.nextInt(3);
    }


    @Override
    public int getBlackboxPiles(int num)  {
        return rng.nextInt(2) + 1;
    }

    @Override
    public int getPileChoice(int leftSize, int rightSize)  {
        int ranNum = rng.nextInt(4);
        if(leftSize > rightSize && ranNum>0)    {
            return 1;
        } else if(leftSize < rightSize && ranNum==0)    {
            return 1;
        } else if(leftSize < rightSize && ranNum>0)    {
            return 2;
        } else  {
            return 2;
        }
    }

    @Override
    public int getBlockItPileChoice() {
        return rng.nextInt(3);
    }

    @Override
    public int getBlockItCasinoChoice() {
        return rng.nextInt(7);
    }
}
