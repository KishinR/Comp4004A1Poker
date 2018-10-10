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
	
	public boolean fullHouse(String[] hand) {
		LinkedList<String> rank = new LinkedList<String>();
		for (int i = 0; i < hand.length; i++) {
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
		
		if (!threeOAKind) return threeOAKind;
		
		for (int i = 0; i < rank.size(); i++) {
			for (int j = 0; j < rank.size(); j++)
				if (rank.get(i).equals(rank.get(j)) && (!rank.get(i).equals(tType)))
					counter++;
		}
			
		return false;
	}

	public boolean fourOAKind(String[] hand) {
		LinkedList<String> rank = new LinkedList<String>();
		for (int i = 0; i < hand.length; i++) {
			rank.add(hand[i].substring(1));
		}
		int counter = 0;
		
		for (int i = 0; i < rank.size(); i++) {
			for (int j = 0; j < rank.size(); j++) {
				if (rank.get(i).equals(rank.get(j))) {
					counter++;
						if (counter == 4)
							return true;
					}
					
				}	
			counter = 0;
			}
			return false;
	
		}
	
	public boolean straightFlush(String[] hand) {
		
		
		LinkedList<String> suit = new LinkedList<String>();
		LinkedList<String> rank = new LinkedList<String>();
		for (int i = 0; i < hand.length; i++) {
			suit.add(hand[i].substring(0, 1));
			rank.add(hand[i].substring(1));
	
		}
		
		for (int i = 0; i < suit.size(); i++) {
			for (int j = 0; j < suit.size(); j++) {
				if (!suit.get(i).equals(suit.get(j))) 
					return false;
			}
		}
		
		LinkedList<Integer> intType = new LinkedList<Integer>();
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i).equals("J")) intType.add(11);
			else if (rank.get(i).equals("Q")) intType.add(12);
			else if (rank.get(i).equals("J")) intType.add(13);
			else if (rank.get(i).equals("K")) intType.add(14);
			else intType.add(Integer.parseInt(rank.get(i))); 
		}
		Collections.sort(intType);
		if (intType.containsAll(Special_Straight)) {
			intType.set(intType.indexOf(14), 1);
			Collections.sort(intType);
		}
		for (int i = 0; i < intType.size() - 1; i++) {
			if (intType.get(i + 1) - intType.get(i) != 1)
				return false;
		}
		return true;
		
	}

	public boolean royalFlush(String[] hand) {
		LinkedList<String> suit = new LinkedList<String>();
		LinkedList<String> rank = new LinkedList<String>();
		for (int i = 0; i < hand.length; i++) {
			suit.add(hand[i].substring(0, 1));
			rank.add(hand[i].substring(1));
	
		}
		
		for (int i = 0; i < suit.size(); i++) {
			for (int j = 0; j < suit.size(); j++) {
				if (!suit.get(i).equals(suit.get(j))) 
					return false;
			}
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
		for (int i = 0; i < intType.size() - 1; i++) {
			if (intType.get(i + 1) - intType.get(i) != 1)
				return false;
		}
		
		if (intType.get(0) != 10 && intType.get(4) != 14)
			return false;
		
		return true;
	}
	
	public int suitPoints(String [] hand, int index) {
		LinkedList<String> suit = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) {
			suit.add(hand[i].substring(0, 1));
		}
		
		if(suit.get(index).equals("C")) return 1;
		else if(suit.get(index).equals("D")) return 2;
		else if(suit.get(index).equals("H")) return 3;
		else if(suit.get(index).equals("S")) return 4;
		
		return 0;
	}
	
	public int getHighCardScore(String [] hand) {
		LinkedList<String> rank = new LinkedList<String>();
		LinkedList<Integer> intType = new LinkedList<Integer>();
		
		for(int i = 0; i < hand.length; i++)
			rank.add(hand[i].substring(1)); 
		
		for(int i = 0; i < rank.size(); i ++) {
			if(rank.get(i).equals("J")) intType.add(11);
			else if(rank.get(i).equals("Q")) intType.add(12);
			else if(rank.get(i).equals("K")) intType.add(13);
			else if(rank.get(i).equals("A")) intType.add(14);
			else intType.add(Integer.parseInt(rank.get(i)));
		}
		if(intType.containsAll(Special_Straight)) {
			intType.set(intType.indexOf(14), 1);
			Collections.sort(intType);
		}
		Collections.sort(intType);
		
		return 100000 * intType.get(intType.size() - 1);
		
	}
	
	public int highOrderScoring(String [] hand , int redo) {
		LinkedList<String> type = new LinkedList<String>();
		LinkedList<String> suit = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) {
			suit.add(hand[i].substring(0, 1));
			type.add(hand[i].substring(1));
		
		}
		int counter = 0;
		int score = 0;
		for (int i = 0; i < type.size(); i++) {
			for (int j = 0; j < type.size(); j++) 
				if(type.get(i).equals(type.get(j))) 
					counter++;
			
			if(counter == redo) {
				if(type.get(i).equals("J")) score += 11;
				else if(type.get(i).equals("Q")) score += 12;
				else if(type.get(i).equals("K")) score += 13;
				else if(type.get(i).equals("A")) score += 14;
				else score += 100000 * Integer.parseInt(type.get(i));
				return score;
				
			}
			counter = 0;
			
		}
		
		return score;
	}

	public int twoPairScore(String [] hand) {
		LinkedList<String> rank = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) {
			rank .add(hand[i].substring(1));
			
		}
		int counter = 0;
		String tType1 = "";
		String tType2 = "";
		
		boolean twoOAKind1 = false;
		boolean twoOAKind2 = false;
		for (int i = 0; i < rank.size(); i++) {
			
			for (int j = 0; j < rank.size(); j++)
				if(rank.get(i).equals(rank.get(j))) 
					counter++;
			
			if(counter > 2) return -1;
			
			if(counter == 2) { 
				if (!twoOAKind1) {
					tType1 = rank.get(i); 
					twoOAKind1 = true;
				}
					
			}
			counter = 0;
		}
		for (int i = 0; i < rank.size(); i++) {
			
			for(int j = 0; j < rank.size(); j++)
				if(rank.get(i).equals(rank.get(j)) && (!rank.get(i).equals(tType1)))
				counter++;
			
			if(counter > 2) return -1;
			
			if(counter == 2) { 
				if (!twoOAKind2) {
					tType2 = rank.get(i); 
					twoOAKind2 = true;
				}
				
			}
			counter = 0;
		}
		String oddCard = "";
		
		int pScore1 = 0;
		int pScore2 = 0;
		int oddScore = 0;
		
		for(int i = 0; i < rank.size(); i++)
			if( !(rank.get(i).equals(tType1)) && !(rank.get(i).equals(tType2)))
				oddCard = rank.get(i);
		
		if(oddCard.equals(""))
			return -1;
		
		if(tType1.equals("J")) pScore1 += 11;
		else if(tType1.equals("Q")) pScore1 += 12;
		else if(tType1.equals("K")) pScore1 += 13;
		else if(tType1.equals("A")) pScore1 += 14;
		else pScore1 += Integer.parseInt(tType1);
		
		
		if(tType2.equals("J")) pScore2 += 11;
		else if(tType2.equals("Q")) pScore2 += 12;
		else if(tType2.equals("K")) pScore2 += 13;
		else if(tType2.equals("A")) pScore2 += 14;
		else pScore2 += Integer.parseInt(tType2);
		
		if(oddCard.equals("J")) oddScore  += 11;
		else if(oddCard.equals("Q")) oddScore  += 12;
		else if(oddCard.equals("K")) oddScore  += 13;
		else if(oddCard.equals("A")) oddScore  += 14;
		else oddScore += Integer.parseInt(oddCard);
		
		if(pScore1 > pScore2) 
			return 100000 * pScore1 + 1000 * pScore2 + 10 * oddScore + suitPoints(hand, rank.indexOf(oddCard));
		else return 100000 * pScore2 + 1000 * pScore1 + 10 * oddScore + suitPoints(hand, rank.indexOf(oddCard));
		
		
		
	}
	
	public int getScore (String [] hand) {
		int handScore = 0;
		if(royalFlush(hand)) {
			handScore += 90000000;
			handScore += suitPoints(hand, 0);
		}
		else if(straightFlush(hand)) {
			handScore += 80000000;
			handScore += getHighCardScore(hand);
			handScore += suitPoints(hand, 0);
		}
		else if(fourOAKind(hand)) {
			handScore += 70000000;
			handScore += highOrderScoring(hand, 4);
		}
		else if(fullHouse(hand)) {
			handScore += 60000000;
			handScore += highOrderScoring(hand, 3);
		}
		else if(flush(hand)) {
			handScore += 50000000;
			handScore += getHighCardScore(hand);
			handScore += suitPoints(hand, 0);
		}
		else if(straight(hand)) {
			handScore += 40000000;
			handScore += getHighCardScore(hand);
		}
		else if(threeOAKind(hand)) {
			handScore += 30000000;
			handScore += highOrderScoring(hand, 2);
		}
		else if(twoPair(hand)) {
			
			handScore += 20000000;
			handScore += twoPairScore(hand);
		}
		else if(Pair(hand)) {
			handScore += 10000000;
			handScore += highOrderScoring(hand, 2);
		}
		else{
			handScore += handScore += getHighCardScore(hand);
		}
		
		
		return handScore;
	}






}