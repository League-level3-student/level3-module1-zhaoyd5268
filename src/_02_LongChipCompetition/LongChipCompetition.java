package _02_LongChipCompetition;

import java.util.ArrayList;
import java.util.Random;

public class LongChipCompetition {
    /*
     * The Beatles are eating lunch and playing a game to see who has the
     * longest chip. (In England, french fries are called "chips".)
     * Find the Beatle with the longest chip. You may not edit the Chip or
     * Beatle classes. Make sure to initialize The Beatles before you start
     * your search.
     */
    private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

    public static void main(String[] args) {      
    	LongChipCompetition lcc = new LongChipCompetition();
    	lcc.initializeBeatles();
    	String mostChips = "none";
    	ArrayList<Chip> beatle0 = lcc.theBeatles.get(0).getChips();
    	ArrayList<Chip> beatle1 = lcc.theBeatles.get(1).getChips();
    	ArrayList<Chip> beatle2 = lcc.theBeatles.get(2).getChips();
    	ArrayList<Chip> beatle3 = lcc.theBeatles.get(3).getChips();
		if(beatle0.size() > beatle1.size() && beatle0.size() > beatle2.size() && beatle0.size() > beatle3.size()) {
			mostChips = "George";
		}
		if(beatle1.size() > beatle0.size() && beatle1.size() > beatle2.size() && beatle1.size() > beatle3.size()) {
			mostChips = "John";
		}
		if(beatle2.size() > beatle1.size() && beatle2.size() > beatle0.size() && beatle2.size() > beatle3.size()) {
			mostChips = "Paul";
		}
		if(beatle3.size() > beatle1.size() && beatle3.size() > beatle2.size() && beatle3.size() > beatle0.size()) {
			mostChips = "Ringo";
		}
		System.out.println("The beatles member with the most chips is " + mostChips);
    }

    private void initializeBeatles() {
        Beatle george = new Beatle("George");
        Beatle john = new Beatle("John");
        Beatle paul = new Beatle("Paul");
        Beatle ringo = new Beatle("Ringo");
        theBeatles.add(george);
        theBeatles.add(john);
        theBeatles.add(paul);
        theBeatles.add(ringo);
    }

    public ArrayList<Beatle> getTheBand(){
        return theBeatles;
    }
}

class Beatle {
    private String name;
    private ArrayList<Chip> chips = new ArrayList<Chip>();

    public Beatle(String name) {
        this.name = name;
        initializePlateOfChips();
    }

    private void initializePlateOfChips() {
        int numberOfChips = new Random().nextInt(100);
        for (int i = 0; i < numberOfChips; i++) {
            chips.add(new Chip(new Random().nextDouble() * 10));
        }
    }

    public ArrayList<Chip> getChips() {
        return this.chips;
    }

    public String getName() {
        return this.name;
    }
}

class Chip {
    private double length;

    public double getLength() {
        return length;
    }

    Chip(double d) {
        this.length = d;
    }
}
