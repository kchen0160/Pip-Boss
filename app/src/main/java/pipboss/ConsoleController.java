package pipboss;

import java.util.*;

public class ConsoleController extends Controller {
    private Scanner scanner;
    private int pid;

    public ConsoleController(Scanner scanner, int pid)  {
        this.scanner = scanner;
        this.pid = pid;
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
        System.out.println("P" + pid + " You rolled " + rollString + ".");
        
        System.out.println("Which casino will you place?");
        return scanner.nextInt();
    }

    @Override
    public int getFiftyFiftyChoice(int reward, int diceRoll)   {
        if(reward == 1) {
            System.out.println("Fifty Fifty prize is: 1 chip and marker is: " + diceRoll);
        } else{
            System.out.println("Fifty Fifty prize is: $"+ reward +" and marker is: " + diceRoll);
        }
        System.out.println("Whould you like to take the payout?");
        return scanner.nextInt();
    }

    @Override
    public int hideTiles()  {
        System.out.println("What is your choice?");
        return scanner.nextInt();
    }

    @Override
    public int guessTiles() {
        System.out.println("What is your choice?");
        return scanner.nextInt();
    }

    @Override
    public int getBlackboxPiles(int num)  {
        System.out.println(num + ": which pile would you like to place");
        return scanner.nextInt();
    }

    @Override
    public int getPileChoice(int leftSize, int rightSize)  {
        System.out.println("Pile 1 is: " + leftSize + " -- Pile 2 is: " + rightSize);
        System.out.println("Which pile would you like?");
        return scanner.nextInt();
    }

    @Override
    public int getBlockItPileChoice()    {
        System.out.println("What is your choice?");
        return scanner.nextInt();
    }

    @Override
    public int getBlockItCasinoChoice() {
        System.out.println("What casino will you place?");
        return scanner.nextInt();
    }
}
