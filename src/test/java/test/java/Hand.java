package test.java;

import java.util.LinkedList;
import java.util.Collections;
import java.util.ArrayList;


public class Hand {

	private String [] cards;
	private int result;
	
	static final int Hand_Size = 5;
	static final LinkedList<Integer> Special_Straight = new LinkedList<Integer>() {{
		
		add(2);
		add(3);
		add(4);
		add(5);
		add(14);
	}};
	
	public Hand() { 
		loadVariables();
	}
	
	public void loadVariables() {
		cards = new String [Hand_Size];
	}
	
	public String[] getHand() {
		return cards;
	}
	
	//Starting to Analyze the hand that the player has
	public boolean HighCard(String[] hand) {
		return false;
	}
	//Method for high card
	public ArrayList<Integer> highCard(String[] hand){
		ArrayList<Integer> rArray = new ArrayList<Integer>();
		LinkedList<String> rank = new LinkedList<String>();
		LinkedList<Integer> intRank = new LinkedList<Integer>();
		
		for(int i = 0; i < hand.length; i++) 
			rank.add(hand[i].substring(1)); 
		
		for(int i = 0; i < rank.size(); i ++) {
			if(rank.get(i).equals("J")) intRank.add(11);
			else if(rank.get(i).equals("Q")) intRank.add(12);
			else if(rank.get(i).equals("K")) intRank.add(13);
			else if(rank.get(i).equals("A")) intRank.add(14);
			else intRank.add(Integer.parseInt(rank.get(i)));
		}
		
		if(intRank.containsAll(Special_Straight)) { // this is to see if the special ace is 1 or 14
			intRank.set(intRank.indexOf(14), 1);
			Collections.sort(intRank);
		}
			
		//sorting system to sort the cards from lowest to highest
		Collections.sort(intRank);
		
		String v1 = "";
		String v2 = "";
		String v3 = ""; 
		
		if(intRank.get(0) == 1) v1 = "A";
		else if(intRank.get(0) == 11) v1 = "J";
		else if(intRank.get(0) == 12) v1 = "Q";
		else if(intRank.get(0) == 13) v1 = "K";
		else if(intRank.get(0) == 14) v1 = "A";
		else v1 = new Integer(intRank.get(0)).toString();
		
		if(intRank.get(1) == 1) v2 = "A";
		else if(intRank.get(1) == 11) v2 = "J";
		else if(intRank.get(1) == 12) v2 = "Q";
		else if(intRank.get(1) == 13) v2 = "K";
		else if(intRank.get(1) == 14) v2 = "A";
		else v2 = new Integer(intRank.get(1)).toString();
		
		if(intRank.get(2) == 1) v3 = "A";
		else if(intRank.get(2) == 11) v3 = "J";
		else if(intRank.get(2) == 12) v3 = "Q";
		else if(intRank.get(2) == 13) v3 = "K";
		else if(intRank.get(2) == 14) v3 = "A";
		else v3 = new Integer(intRank.get(2)).toString();
		
		
		rArray.add(rank.indexOf(v1));
		rArray.add(rank.indexOf(v2));
		rArray.add(rank.indexOf(v3));
		
		if(rArray.size() != 3) {
			rArray.removeAll(rArray);
			rArray.add(-1);
			return rArray;
		}
		
		return rArray;
		
	}
	
	//method for pair
	public boolean Pair(String[] hand) {
		LinkedList<String> rank = new LinkedList<String>();
		for(int i = 0; i < hand.length; i++) {
			rank.add(hand[i].substring(1));
		}
		
		int counter = 0;
		
		for (int i = 0; i < rank.size(); i++) {
			for (int j = 0; j < rank.size(); j++)
				if(rank.get(i).equals(rank.get(j))){
				counter++;
				if(counter == 2) 
					return true;
			}
			counter = 0;
		}
		return false;
	}

	public boolean twoPair(String[] hand) {
		LinkedList<String> rank = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) {
			rank.add(hand[i].substring(1));
		}
		
		int counter = 0;
		String tType = "";
		boolean twoOAKind = false;
		
		for (int i = 0; i < rank.size(); i++) {
			for (int j = 0; j < rank.size(); j++) 
				if(rank.get(i).equals(rank.get(j))) counter++;
			
			if(counter > 2) 
				return false;
			
			if(counter == 2) { 
				tType = rank.get(i); 
				twoOAKind = true;
				}
			counter = 0;
			
		}
		
		if (!twoOAKind) return twoOAKind;
		for (int i = 0; i < rank.size(); i++) {
			for(int j = 0; j < rank.size(); j++) 
				if(rank.get(i).equals(rank.get(j) ) && (!rank.get(i).equals(tType))) 
					counter++;
			
			if(counter == 2) return true;
			counter = 0;
		}
		return false;
	}
	
	public boolean threeOAKind(String[] hand) {
		LinkedList<String> rank = new LinkedList<String>();
		for(int i = 0; i < hand.length; i++) {
			rank.add(hand[i].substring(1));
			
			}
	
		int counter = 0;
		String tType = "";
		boolean threeOAKind = false;
		
		for (int i = 0; i < rank.size(); i++) {
			for (int j = 0; j < rank.size(); j++) 
				if(rank.get(i).equals(rank.get(j))) 
					counter ++;
			
			if (counter > 3)
				return false;
			
			if (counter == 3 ) {
				tType = rank.get(i);
				threeOAKind = true;
				return true;
				
			}
			counter = 0;
		
		}
		
		return false;
		
	}

	public boolean straight(String[] hand) {
		LinkedList<String> rank = new LinkedList<String>();
		for (int i = 0; i < hand.length; i++) {
			rank.add(hand[i].substring(1));
	
			
		}
		LinkedList<Integer> intType = new LinkedList<Integer>();
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i).equals("J")) intType.add(11);
			else if (rank.get(i).equals("Q")) intType.add(12);
			else if (rank.get(i).equals("K")) intType.add(13);
			else if (rank.get(i).equals("A")) intType.add(14);
			else intType.add(Integer.parseInt(rank.get(i)));
		}
		
		Collections.sort(intType);
		
		
		
		if (intType.contains(14)) {
			if (specialAce(intType) == 4)
				intType.set(intType.indexOf(14), 1);
		}
		
		
		Collections.sort(intType);
		
		for (int i = 0; i < intType.size() - 1; i++) {
			if (intType.get(i + 1) - intType.get(i) != 1)
				return false;
			
		}
		
		return true;
		
	}
	
	public int specialAce(LinkedList<Integer> intType) {
		int counter = 0;
		
		if(intType.contains(2)) {
			counter++;
		}
		if(intType.contains(3)) {
			counter++;
		}
		if(intType.contains(4)) {
			counter++;
		}
		if(intType.contains(5)) {
			counter++;
		}
		return counter;
	}
	
	public boolean flush(String[] hand) {
		LinkedList<String> suit = new LinkedList<String>();
		for (int i = 0; i < hand.length; i++) {
			suit.add(hand[i].substring(0, 1));
		}
		
		for (int i = 0; i < suit.size(); i++) {
			for (int j = 0; j < suit.size(); j++) {
				if (! suit.get(i).equals(suit.get(j)))
					return false;
			}
		}
		
		return true;
	}
	
}