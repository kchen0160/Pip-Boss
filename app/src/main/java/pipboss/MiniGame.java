package pipboss;

import java.util.*;

public abstract class MiniGame {
    protected int associatedCasinoNum;

    public void activate(Player p, Player p2, Controller c, Controller c2, List<Casino> casinos)    {

    }

    public abstract String getName();

    public int associatedCasino()   {
        return associatedCasinoNum;
    }

    public abstract boolean equals(String s);

    public abstract String toString();

    public void payOut(List<Player> players, List<Controller> c, List<Casino> casinos)  {

    }
}
