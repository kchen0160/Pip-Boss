package pipboss;

import java.util.*;

public class Deck {
    private ArrayList<Integer> deck;
    private Random prng;
    

    public Deck(int[] ranges)    {
        this(ranges, true, new Random());
    }

    public Deck(int[] ranges, boolean shuffle)  {
        this(ranges, shuffle, new Random());
    }

    public Deck(int[] ranges, boolean shuffle, Random r)    {
        deck = new ArrayList<Integer>();
        prng = r;
        for(int i=0; i<ranges.length;i++)    {
            for(int j=0; j<ranges[i+1]; j++)    {
                deck.add(ranges[i]);
            }
            i++;
        }
        if(shuffle) {
            shuffle();
        }
    }

    public void shuffle()   {
        for(int i=0; i<deck.size();i++) {
            int ranNum = prng.nextInt(deck.size()-1);
            int temp =deck.get(i);
            deck.set(i, deck.get(ranNum));
            deck.set(ranNum, temp);
        }
    }

    public int draw()   {
        try {
            int temp = deck.get(0);
            deck.remove(0);
        return temp;
        } catch(Exception e)    {
            return 0;
        }
    }

    public int getSize()    {
        return deck.size();
    }

}