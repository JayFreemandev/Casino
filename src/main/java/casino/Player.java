package main.java.com.example.casino;

public class Player {
    private Bag bag;

    public Player(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag(){
        return bag;
    }
}
