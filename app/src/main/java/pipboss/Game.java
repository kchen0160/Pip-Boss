package pipboss;
import java.util.*;

public class Game {
    private List<Player> players;
    private List<Casino> casinos;
    private List<String> miniStrGameList;
    private List<MiniGame> miniGames;
    private Deck deckk;
    private List<ConsoleView> consoleView;
    private List<Controller> controller;

    public Game(List<Player> players, List<String> miniStrGameList, List<ConsoleView> consoleview, List<Controller> controller){
        this.consoleView = consoleview;
        this.controller = controller;
        this.players = players;
        this.miniStrGameList = miniStrGameList;
        miniGames = new ArrayList<MiniGame>();
        casinos = new ArrayList<Casino>();
    }

    public void resetCasino() {
        MoneyPair[] pairs = new MoneyPair[6];
        
        for (int i = 0; i < 6; i++) {
            if(deckk.getSize() < 2) {
                int[] passin = {3,11,4,11,5,13,6,15,7,13,8,11,9,9,10,7};
                deckk = new Deck(passin, true);
            }
            pairs[i] = (new MoneyPair(deckk.draw(), deckk.draw()));
        }
        order(pairs);

        for (int i = 0; i<6; i++) {
            casinos.get(i).setHighMoney(pairs[i].getHighMoney());
            casinos.get(i).setLowMoney(pairs[i].getLowMoney());
            casinos.get(i).removePlayerDice();
        }

    }

    public void setCasino() {
        int[] passin = {3,11,4,11,5,13,6,15,7,13,8,11,9,9,10,7};
        deckk = new Deck(passin, true);

        MoneyPair[] pairs = new MoneyPair[6];
        
        for (int i = 0; i < 6; i++) {
            pairs[i] = (new MoneyPair(deckk.draw(), deckk.draw()));
        }

        order(pairs);

        for (int i = 0; i<6; i++) {
            casinos.add(new Casino(pairs[i].getHighMoney(), pairs[i].getLowMoney(), i+1));
            casinos.get(i).setPlayerNum(players.size());
        }

        setUpMiniGames();
    }

    public void setUpMiniGames()    {
        Random rng = new Random();
        int count = 1;
        int listSize = miniStrGameList.size();
        while(listSize>0 && count <= 3)   {
            int ranNum = rng.nextInt(listSize); 
            if(miniStrGameList.get(ranNum).equals("Jackpot"))   {
                miniGames.add(new Jackpot(count));
                miniStrGameList.remove(ranNum);
            } else if(miniStrGameList.get(ranNum).equals("Pay Day"))   {
                miniGames.add(new PayDay(count));
                miniStrGameList.remove(ranNum);
            } else if(miniStrGameList.get(ranNum).equals("Fifty Fifty"))   {
                miniGames.add(new FiftyFifty(count));
                miniStrGameList.remove(ranNum);
            } else if(miniStrGameList.get(ranNum).equals("Lucky Punch"))   {
                miniGames.add(new LuckyPunch(count));
                miniStrGameList.remove(ranNum);
            } else if(miniStrGameList.get(ranNum).equals("High Five"))   {
                miniGames.add(new HighFive(count));
                miniStrGameList.remove(ranNum);
            } else if(miniStrGameList.get(ranNum).equals("Black Box"))   {
                miniGames.add(new BlackBox(count));
                miniStrGameList.remove(ranNum);
            } else if(miniStrGameList.get(ranNum).equals("Block It"))   {
                miniGames.add(new BlockIt(count));
                miniStrGameList.remove(ranNum);
            }
            listSize = miniStrGameList.size();
            count++;
        }
    }

    public List<MiniGame> getMiniGames()   {
        return miniGames;
    }

    public Casino getCasino(int index)  {
        return casinos.get(index);
    }

    public int getNumCasinos()  {
        return casinos.size();
    }

    public String rollDices(int index) {
        players.get(index).rollDice();
        return players.get(index).getRollString();
    }

    private void order(MoneyPair[] pairs) {
        for (int i = 0; i < pairs.length - 1; i++) {
            for (int j = 0; j < pairs.length - i - 1; j++) {
                if (pairs[j].compareTo(pairs[j + 1]) > 0) {
                    MoneyPair temp = pairs[j];
                    pairs[j] = pairs[j + 1];
                    pairs[j + 1] = temp;
                } else if (pairs[j].compareTo(pairs[j + 1]) == 0) {
                    if (pairs[j].getHighMoney() > pairs[j+1].getHighMoney()) {
                        MoneyPair temp = pairs[j + 1];
                        pairs[j + 1] = pairs[j];
                        pairs[j] = temp;
                    } else if (pairs[j].getLowMoney() > pairs[j+1].getLowMoney()) {
                        MoneyPair temp = pairs[j + 1];
                        pairs[j + 1] = pairs[j];
                        pairs[j] = temp;
                    }
                }
            }
        }
    }

    public boolean roundEnd()   {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPDice() != 0) {
                return false;
            }
        }
        return true;
    }

    public void playTurn(int index) {
        Player p = players.get(index);
        List<IntBoolPair> rolls = p.rollDice();
        int choice = controller.get(index).getDiceChoice(rolls);
        if (choice == 0 && p.getChips() > 0) {
            controller.get(index).useChip(p);
        } else {
            ArrayList<Die> pDice = p.playDice(choice);
            for (ConsoleView v : consoleView) {
                v.placeDice(casinos.get(choice-1), pDice);
            }
            playMiniGame(pDice.get(0).getValue(), index);
        }
    }
    
    public void playMiniGame(int casinoNum, int index)  {
        for(int i=0; i<miniGames.size(); i++)   {
            if(miniGames.get(i).associatedCasino() == casinoNum) {
                int index2 = index+1;
                for (ConsoleView v : consoleView) {
                    try{
                        v.activateMiniGame(miniGames.get(i), players.get(index), players.get(index2), 
                            controller.get(index), controller.get(index2), casinos);
                    } catch(Exception e)    {
                        v.activateMiniGame(miniGames.get(i), players.get(index), players.get(0), 
                        controller.get(index), controller.get(0), casinos);
                    }
                }
            }
        }
    }

    public List<Casino> getCasinos()    {
        return casinos;
    }
}