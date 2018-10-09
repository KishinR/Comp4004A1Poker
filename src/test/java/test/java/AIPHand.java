package test.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class AIPHand {
	
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
	
	public AIPHand() { 
		//System.out.println("Hand is created\n");
		loadVariables();
	}
	public void loadVariables() {
		cards = new String [Hand_Size];
	}
	
	public ArrayList<Integer> highCardAIP(String[] hand){
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

}
