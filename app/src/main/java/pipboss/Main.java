package pipboss;

import java.util.*;

public class Main {
    private static int rounds, stdDice, chips, lrgDice, plyHuman, plyAI;
    private static List<Player> players;
    private static Game game;
    private static Scanner sc;
    private static List<String> miniGameList;
    private static List<MiniGame> miniGames;
    private static List<ConsoleView> consoleView;
    private static List<Controller> controller;
    public static void main(String[] args) {
        
    }

    public static void phase0()    {
        rounds = 1;
        stdDice = 7;
        lrgDice = 0;
        chips = 0;
        plyHuman = 1;
        plyAI = 0;
        miniGameList = new ArrayList<String>();
        setUp();
        playRound();
    }

    public static void phase1()    {
        rounds = 1;
        stdDice = 7;
        lrgDice = 0;
        chips = 2;
        plyHuman = 1;
        plyAI = 0;
        miniGameList = new ArrayList<String>();
        setUp();
        playRound();
    }

    public static void phase2()    {
        rounds = 1;
        stdDice = 7;
        lrgDice = 1;
        chips = 2;
        plyHuman = 1;
        plyAI = 0;
        miniGameList = new ArrayList<String>();
        setUp();
        playRound();
    }

    public static void phase3()    {
        rounds = 1;
        stdDice = 7;
        lrgDice = 1;
        chips = 2;
        plyHuman = 1;
        plyAI = 2;
        miniGameList = new ArrayList<String>();
        setUp();
        playRound();
    }

    public static void phase4()    {
        rounds = 3;
        stdDice = 7;
        lrgDice = 1;
        chips = 2;
        plyHuman = 1;
        plyAI = 2;
        miniGameList = new ArrayList<String>();
        setUp();
        playRound();
    }

    public static void phase5()    {
        rounds = 3;
        stdDice = 7;
        lrgDice = 1;
        chips = 2;
        plyHuman = 1;
        plyAI = 2;
        miniGameList = new ArrayList<String>();
        miniGameList.add("Jackpot");
        setUp();
        playRound();
    }

    public static void phase6()    {
        rounds = 3;
        stdDice = 7;
        lrgDice = 1;
        chips = 2;
        plyHuman = 1;
        plyAI = 2;
        miniGameList = new ArrayList<String>();
        miniGameList.add("Jackpot");
        miniGameList.add("Pay Day");
        setUp();
        playRound();
    }

    public static void phase7()    {
        rounds = 3;
        stdDice = 7;
        lrgDice = 1;
        chips = 2;
        plyHuman = 1;
        plyAI = 2;
        miniGameList = new ArrayList<String>();
        miniGameList.add("Jackpot");
        miniGameList.add("Pay Day");
        miniGameList.add("Fifty Fifty");
        setUp();
        playRound();
    }

    public static void phase8()    {
        rounds = 3;
        stdDice = 7;
        lrgDice = 1;
        chips = 2;
        plyHuman = 1;
        plyAI = 2;
        miniGameList = new ArrayList<String>();
        miniGameList.add("Pay Day");
        miniGameList.add("Fifty Fifty");
        miniGameList.add("Lucky Punch");
        setUp();
        playRound();
    }

    public static void phase9()    {
        rounds = 3;
        stdDice = 7;
        lrgDice = 1;
        chips = 2;
        plyHuman = 1;
        plyAI = 2;
        miniGameList = new ArrayList<String>();
        miniGameList.add("Fifty Fifty");
        miniGameList.add("Lucky Punch");
        miniGameList.add("High Five");
        setUp();
        playRound();
    }

    public static void phase10()    {
        rounds = 3;
        stdDice = 7;
        lrgDice = 1;
        chips = 2;
        plyHuman = 1;
        plyAI = 2;
        miniGameList = new ArrayList<String>();
        miniGameList.add("Lucky Punch");
        miniGameList.add("High Five");
        miniGameList.add("Black Box");
        setUp();
        playRound();
    }

    public static void phase11()    {
        rounds = 3;
        stdDice = 7;
        lrgDice = 1;
        chips = 2;
        plyHuman = 1;
        plyAI = 2;
        miniGameList = new ArrayList<String>();
        miniGameList.add("High Five");
        miniGameList.add("Black Box");
        miniGameList.add("Block It");
        setUp();
        playRound();
    }

    public static void testInit(int r, int sD, int lD, int c, int pH, int pA, List<String> mGList)   {
        rounds = r;
        stdDice = sD;
        lrgDice = lD;
        chips = c;
        plyHuman = pH;
        plyAI = pA;
        miniGameList = new ArrayList<String>();
        for(int i=0; i<mGList.size(); i++)  {
            miniGameList.add(mGList.get(i));
        }
        setUp();
    }

    public static void setUp() {
        sc = new Scanner(System.in);
        consoleView = new ArrayList<>();
        controller = new ArrayList<>();

        players = new ArrayList<Player>();
        for(int i=0; i<plyHuman; i++)   {
            players.add(new Player(i+1));
            players.get(i).setDice(stdDice, lrgDice);
            consoleView.add(new ConsoleView());
            controller.add(new ConsoleController(sc, players.get(i).getPID()));
        }
        for(int i=0; i<plyAI; i++)   {
            players.add(new Player(plyHuman + i +1));
            players.get(i+plyHuman).setDice(stdDice, lrgDice);
            controller.add(new AiController(players.get(i+plyHuman).getPID()));
        }

        game = new Game(players, miniGameList, consoleView, controller);
        game.setCasino();

        for (ConsoleView v : consoleView) {
            v.gameStarted(rounds, (plyHuman+plyAI), stdDice, lrgDice, chips);
        }

        miniGames = game.getMiniGames();
    }

    public static void resetRound() {
        for(int i=0; i <players.size(); i++)    {
            players.get(i).setDice(stdDice, lrgDice);
            game.resetCasino();
        }
    }

    public static void playRound()   {
        for(int i=1; i<=rounds; i++)    {
            for(int j=0; j<(plyHuman+plyAI); j++) {
                players.get(j).addChips(chips);
             }

             for (ConsoleView v : consoleView) {
                v.startRound(players, miniGames, chips, i);
             }
             
        
             while(!game.roundEnd())    {
                for (ConsoleView v : consoleView) {
                    v.displayBoard(players, game.getCasinos(), game.getMiniGames());
                 }
                for(int j=0; j<players.size();j++) {
                    if(players.get(j).getPDice() != 0)    {
                        game.playTurn(j);
                    }
                }
            }

            for (ConsoleView v : consoleView) {
                v.roundEnd(players, controller, game.getCasinos(), game.getMiniGames(), i);
            }
            if (i == rounds) {
                for (ConsoleView v : consoleView) {
                    v.endGame(players, game.getCasinos(), game.getMiniGames());
                 }
            } else  {
                resetRound();
            }

        }
        sc.close();
    }
    public static Game getGame() {
        return game;
    }
}