package test.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
	
	private Scanner x;
	static final int Hand_Size = 5;
	
	static final LinkedList<String> No_Strat = new LinkedList<String>(){{
		add("Royal Flush");
		add("Straight Flush");
		add("Four of a Kind");
		add("Full House");
		add("Flush");
		add("Flush");
		add("Straight");
	}};
	
	
	
	
	static final String Name_of_File = "cardcases.txt";
	static final int First_Card = 0;
	
	private AIPHand hand;
	private String sDeck;
	private String [] AIPHand;
	private String [] otherHand;
	private ArrayList <String> deck;
	public ArrayList <String> inputFile;
	public ArrayList<String> someList;
	private boolean deckGiven;

	public Game () {
		
		intializeVariables();
		openFile();
		readFile();
		
	}
	
	
	public void openFile() {
		try {
			x = new Scanner(new File (Name_of_File ));
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage() + "\n");
		}
	}
	
	
	public void readFile() {
		someList = new ArrayList<String>();
		while (x.hasNext()) {
			someList.add(x.nextLine() + "\n");
		}
		x.close();
		
	}
	
	public void intializeVariables() {
		hand = new AIPHand();
		AIPHand = new String [Hand_Size];
		otherHand = new String [Hand_Size];	
		deckGiven = false;
	}
	
	public void setStringDeck(String str) {
		sDeck = str;
		deck = new ArrayList<String>(Arrays.asList(sDeck.split(" ")));
		deckGiven = true;
	}
	
	public String gameWinner() {
		if(hand.getScore(AIPHand) > hand.getScore(otherHand)) return "AIP";
		else return "Other Player";
	}
	
	public static void main(String [] args)
	{
		
		
		Game aGame = new Game();
		ArrayList<String > someArrList = aGame.someList;
		
		for(int i = 0; i < someArrList.size(); i++) {
			Game newGame = new Game();
			newGame.setStringDeck(someArrList.get(i));
			newGame.runGame();
			System.out.println("\n\n");
		}
		
	}

	public void runGame() {
		if(!deckGiven)return;
		
		for(int i = 0; i < 5; i++) AIPHand[i] = deck.remove(0);
		for(int i = 0; i < 5; i++) otherHand[i] = deck.remove(0);
		System.out.println("----------=====Poker Game Testing=====----------");
		System.out.print("AIP's Cards: ");
		for (int i = 0; i < Hand_Size; i++)System.out.print(AIPHand[i] + " ");
		
		System.out.print("\n");
		
		System.out.print("Other Opponents Cards: ");
		for (int i = 0; i < Hand_Size; i++)System.out.print(otherHand[i] + " ");
		
		System.out.print("\n");
		
		System.out.print("AIP Hand is: " + hand.stratRequired(AIPHand) + "\n");
		
		if(No_Strat.contains(hand.stratRequired(AIPHand))){
			System.out.print("AIP's Strategy Is To...: HOLD\n");
			System.out.print("And The Winner IS...: " + gameWinner() + "\n");
		}
		else {
			System.out.println("Need To Use AIP Strategy: ");
			if(hand.useStrat1(AIPHand) != -1) {
				System.out.print("Replacing Card With: " + AIPHand[hand.useStrat1(AIPHand)] + "\n");
				AIPHand[hand.useStrat1(AIPHand)] = deck.remove(First_Card);
				System.out.print("AIP's New Hand is : ");
				for (int i = 0; i < Hand_Size; i++)
					System.out.print(AIPHand[i] + " ");
				System.out.print("\n");
				System.out.print("And The Winner IS...: " + gameWinner() + "\n");
			}
			else {
				System.out.print("Replacing Card With: ");
				for (int i = 0; i < hand.useStrat2(AIPHand).size(); i++)
					System.out.print(AIPHand[hand.useStrat2(AIPHand).get(i)] + " ");
				System.out.print("\n");
				for (int i = 0; i < hand.useStrat2(AIPHand).size(); i++) 
					AIPHand[hand.useStrat2(AIPHand).get(i)] = deck.remove(First_Card);
				System.out.print("\n");
				System.out.print("AIP's New Hand is : ");
				for (int i = 0; i < Hand_Size; i++)
					System.out.print(AIPHand[i] + " ");
				System.out.print("\n");
				System.out.print("And The Winner IS...: " + gameWinner() + "\n");
				
			}
		}

		
		
		
	}
	
	
	
}
