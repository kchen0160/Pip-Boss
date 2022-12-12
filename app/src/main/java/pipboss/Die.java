package pipboss;

public class Die {
    private boolean big;
    private int value;
    private int pid;
    private java.util.Random prng;

    //pid 0 is marked as not being a die owned by a player
    public Die(int pid) {
        this(pid, false, new java.util.Random());
    }

    public Die(int pid, boolean big) {
        this(pid, big, new java.util.Random());
    }

    public Die(int pid, java.util.Random r) {
        this(pid, false, r);
    }

    public Die(int pid, boolean big, java.util.Random r) {
        this.pid = pid;
        this.big = big;
        prng = r;
        roll();
    }

    public void roll() {
        value = prng.nextInt(6) + 1;
    }

    public int getValue() {
        return value;
    }
    
    public boolean isBig() {
        return big;
    }

    public int getPlayerId() {
        return pid;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return (big)? value + "+" + value : String.valueOf(value);
    }

}