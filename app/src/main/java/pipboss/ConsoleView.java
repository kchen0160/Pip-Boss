package pipboss;

import java.util.*;

public class ConsoleView {
    
    public void gameStarted(int rounds, int plys, int stdDice, int lrgDice, int chips)    {
        System.out.println("The game has started. It will consist of " + rounds + " round(s) and has " + plys + " player.\n"
            + "Each player has " + stdDice + " regular and " + lrgDice + " large dice with " + chips +" chips per round.");
        
    }

    public void startRound(List<Player> players, List<MiniGame> miniGames, int chips, int rounds)   {
        for(int i=0; i<miniGames.size(); i++)    {
            System.out.println("Casino " + miniGames.get(i).associatedCasino() + " added the minigame " + miniGames.get(i).getName() + ".");
        }
        for(int i=0; i<players.size(); i++)   {
            System.out.println("P" + players.get(i).getPID() + " gained " + chips + " chips: Chips for Round " + rounds + ".");
        }

        System.out.println("Round " + rounds + " has started.");
    }

    public void displayBoard(List<Player> players, List<Casino> casinos, List<MiniGame> miniGames) {
        String header = "----------------------------      PLAYERS      ----------------------------\n";
        String header2 = (" player : money  dice  DICE  chips\n");
        String playString = "";
            for(int i=0;i<players.size();i++)    {
                playString += (players.get(i).toString());
            }
        System.out.println(header + header2 + playString);
        header = ("----------------------------      CASINOS      ----------------------------\n");
        String playerCas = "";
        for (int i = 0; i < players.size(); i++) {
            playerCas += ("P" + (i + 1) + "   ");
        }
        header2 = ("  #   $$   $     " + playerCas+"\n");
        String casString = "";
            for(int i=0;i<casinos.size();i++)    {
                casString += (casinos.get(i).toString());
                for (int j = 0; j < miniGames.size(); j++) {
                    if (miniGames.get(j).associatedCasino() == casinos.get(i).getCasinoID()) {
                        casString += (" " + miniGames.get(j).toString()+"\n");
                    }
                }
            }
            System.out.println(header + header2 + casString);
    }

    public void roundEnd(List<Player> players,  List<Controller> c, List<Casino> casinos, List<MiniGame> miniGames, int round)  {
        System.out.println("Round " + round + " has ended.");
        miniGamePayout(players, c, casinos, miniGames);
        ArrayList<Integer> winners1 = new ArrayList<Integer>();
        ArrayList<Integer> winners2 = new ArrayList<Integer>();
        for (int i = 0; i < casinos.size(); i++) {
            winners1.add(casinos.get(i).getWinningPID());
            winners2.add(casinos.get(i).getWinningPID2());
        }
        for (int j = 0; j < players.size(); j++) {
            for (int i = 0; i < winners1.size(); i++) {
                if (winners1.get(i) == players.get(j).getPID()) {
                    players.get(j).addMoney(casinos.get(i).getHighMoney());

                    System.out.println("P" + players.get(j).getPID() + " gained $" + casinos.get(i).getHighMoney() +":"
                    + " from Casino " + casinos.get(i).getCasinoID() + " for Round " + round + ".");
                }
                if (winners2.get(i) == players.get(j).getPID()) {
                    players.get(j).addMoney(casinos.get(i).getLowMoney());
                    System.out.println("P" + players.get(j).getPID() + " gained $" + casinos.get(i).getLowMoney() +":"
                    + " from Casino " + casinos.get(i).getCasinoID() + " for Round "  + round + ".");
                }
            }
        }
    }

    private void miniGamePayout(List<Player> players, List<Controller> c, List<Casino> casinos, List<MiniGame> miniGames){
        for(int i=0; i<miniGames.size();i++)    {
            miniGames.get(i).payOut(players, c ,casinos);
        }
    }

    public void endGame(List<Player> players, List<Casino> casinos, List<MiniGame> miniGames) {
        System.out.println("The game is over. The final game state is below.");
        displayBoard(players, casinos, miniGames);
    }

    public void placeDice(Casino casino, List<Die> pDice)   {
        casino.placeDie(pDice);
        System.out.println("P" + pDice.get(0).getPlayerId() + " placed " + pDice + ".");
        System.out.println("Casino " + casino.getCasinoID() + " gained " + pDice + " from P" + pDice.get(0).getPlayerId() + ".");
    }

    public void activateMiniGame(MiniGame miniGame, Player p, Player p2, Controller c, Controller c2, List<Casino> casinos)    {
        miniGame.activate(p, p2, c, c2, casinos);
    }
}
