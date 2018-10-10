package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import junit.framework.TestCase;

public class GameTest extends TestCase{

	@Test
	public void testOtherHand() {
		Hand otherHand = new Hand();
		assertEquals(5, otherHand.Hand_Size);
	}
	
	public void testAIPHand() {
		AIPHand Hand = new AIPHand();
		assertEquals(5, AIPHand.Hand_Size);
	}
	
	public void testHighCard() {
		ArrayList<Integer> otherCards = new ArrayList<Integer> ();
		Hand testHand = new Hand();
	     String [] cards = new String [5];
	      
	     cards[0] = "SK";
	     cards[1] = "C2";
	     cards[2] = "SQ";
	     cards[3] = "D6";
	     cards[4] = "C4";
	     
	     otherCards.add(4);
	     otherCards.add(3);
	     otherCards.add(1);
		 assertEquals(true, otherCards.containsAll(testHand.highCard(cards)));
	}
	
	public void testHighCardAIP() {
		ArrayList<Integer> otherCards = new ArrayList<Integer> ();
		AIPHand Hand = new AIPHand();
	     String [] cards = new String [5];
	      
	     cards[0] = "DK";
	     cards[1] = "S2";
	     cards[2] = "CQ";
	     cards[3] = "H6";
	     cards[4] = "S4";
	     
	     otherCards.add(4);
	     otherCards.add(3);
	     otherCards.add(1);
		 assertEquals(true, otherCards.containsAll(Hand.highCardAIP(cards)));
	}
	
	public void testPairCase1() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "DA";
	      cards[2] = "D3";
	      cards[3] = "D4";
	      cards[4] = "D2";
	      
	      assertEquals(true, testHand.Pair(cards));
	}
	
	public void testPairCase2() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "D3";
	      cards[2] = "D4";
	      cards[3] = "D5";
	      cards[4] = "D6";
	      
	      assertEquals(false, testHand.Pair(cards));
	}
	
	public void testAIPPairCase1() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "DA";
	      cards[2] = "D3";
	      cards[3] = "D4";
	      cards[4] = "D2";
	      
	      assertEquals(true, Hand.PairAIP(cards));
	}
	
	public void testAIPPairCase2() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "D3";
	      cards[2] = "D4";
	      cards[3] = "D5";
	      cards[4] = "D6";
	      
	      assertEquals(false, Hand.PairAIP(cards));
	}
	
	public void testTwoPairCase1() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S2";
	      cards[1] = "HA";
	      cards[2] = "S2";
	      cards[3] = "C8";
	      cards[4] = "C8";
	      
	      assertEquals(true, testHand.twoPair(cards));
	}
	
	public void testTwoPairCase2() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "C2";
	      cards[1] = "CA";
	      cards[2] = "CJ";
	      cards[3] = "H3";
	      cards[4] = "C2";
	      
	      assertEquals(false, testHand.twoPair(cards));
	}
	
	public void testAIPTwoPairCase1() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S2";
	      cards[1] = "HA";
	      cards[2] = "S2";
	      cards[3] = "C8";
	      cards[4] = "C8";
	      
	      assertEquals(true, Hand.twoPairAIP(cards));
	}
	
	public void testAIPTwoPairCase2() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "C2";
	      cards[1] = "CA";
	      cards[2] = "CJ";
	      cards[3] = "H3";
	      cards[4] = "C2";
	      
	      assertEquals(false, Hand.twoPairAIP(cards));
	}
	
	public void testThreeOAKindCase1() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "DA";
	      cards[2] = "S8";
	      cards[3] = "HA";
	      cards[4] = "S8";
	      
	      assertEquals(true, testHand.threeOAKind(cards));
	}
	
	public void testThreeOAKindCase2() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "S2";
	      cards[2] = "H9";
	      cards[3] = "CK";
	      cards[4] = "S8";
	      
	      assertEquals(false, testHand.threeOAKind(cards));
	}
	
	public void testAIPThreeOAKindCase1() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "DA";
	      cards[2] = "S8";
	      cards[3] = "HA";
	      cards[4] = "S8";
	      
	      assertEquals(true, Hand.threeOAKindAIP(cards));
	}
	
	public void testAIPThreeOAKindCase2() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "S2";
	      cards[2] = "H9";
	      cards[3] = "CK";
	      cards[4] = "S8";
	      
	      assertEquals(false, Hand.threeOAKindAIP(cards));
	}
	
	public void testStraightCase1() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "S9";
	      cards[2] = "C10";
	      cards[3] = "HJ";
	      cards[4] = "SQ";
	      
	      assertEquals(true, testHand.straight(cards));
	}
	
	public void testStraightCase2() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "C4";
	      cards[1] = "S5";
	      cards[2] = "D7";
	      cards[3] = "D5";
	      cards[4] = "S6";
	      
	      assertEquals(false, testHand.straight(cards));
	}

	public void testAIPStraightCase1() {
		  AIPHand Hand = new AIPHand();
		 
	      String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "S9";
	      cards[2] = "C10";
	      cards[3] = "HJ";
	      cards[4] = "SQ";
	      
	      assertEquals(true, Hand.straightAIP(cards));
	}
	
	public void testAIPStraightCase2() {
		  AIPHand Hand = new AIPHand();
		  
	      String [] cards = new String [5];
	      
	      cards[0] = "C4";
	      cards[1] = "S5";
	      cards[2] = "D7";
	      cards[3] = "D5";
	      cards[4] = "S6";
	      
	      assertEquals(false, Hand.straightAIP(cards));
	}
	
	public void testFlushCase1() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "CK";
	      cards[1] = "C2";
	      cards[2] = "CQ";
	      cards[3] = "C8";
	      cards[4] = "C5";
	      
	      assertEquals(true, testHand.flush(cards));
	}
	
	public void testFlushCase2() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "HA";
	      cards[1] = "H3";
	      cards[2] = "HQ";
	      cards[3] = "D8";
	      cards[4] = "D2";
	      
	      assertEquals(false, testHand.flush(cards));
	}
	
	public void testAIPFlushCase1() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "CK";
	      cards[1] = "C2";
	      cards[2] = "CQ";
	      cards[3] = "C8";
	      cards[4] = "C5";
	      
	      assertEquals(true, Hand.flushAIP(cards));
	}
	
	public void testAIPFlushCase2() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "HA";
	      cards[1] = "H3";
	      cards[2] = "HQ";
	      cards[3] = "D8";
	      cards[4] = "D2";
	      
	      assertEquals(false, Hand.flushAIP(cards));
	}
	
	public void testFullHouseCase1() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "C8";
	      cards[1] = "C8";
	      cards[2] = "D5";
	      cards[3] = "D5";
	      cards[4] = "D8";
	      
	      assertEquals(true, testHand.fullHouse(cards));
	}
	
	public void testFullHouseCase2() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "C2";
	      cards[1] = "D3";
	      cards[2] = "C5";
	      cards[3] = "S5";
	      cards[4] = "H8";
	      
	      assertEquals(false, testHand.fullHouse(cards));
	}
	
	public void testAIPFullHouseCase1() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "C8";
	      cards[1] = "C8";
	      cards[2] = "D5";
	      cards[3] = "D5";
	      cards[4] = "D8";
	      
	      assertEquals(true, Hand.fullHouseAIP(cards));
	}
	
	public void testAIPFullHouseCase2() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "C2";
	      cards[1] = "D3";
	      cards[2] = "C5";
	      cards[3] = "S5";
	      cards[4] = "H8";
	      
	      assertEquals(false, Hand.fullHouseAIP(cards));
	}
	
	public void testFourOAKindCase1() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "C8";
	      cards[1] = "S8";
	      cards[2] = "H8";
	      cards[3] = "D8";
	      cards[4] = "C2";
	      
	      assertEquals(true, testHand.fourOAKind(cards));
	}
	
	public void testFourOAKindCase2() {
		  Hand testHand = new Hand();
		  
	      String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "SJ";
	      cards[2] = "C9";
	      cards[3] = "DQ";
	      cards[4] = "D9";
	      
	      assertEquals(false, testHand.fourOAKind(cards));
	}
	
	public void testAIPFourOAKindCase1() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "C8";
	      cards[1] = "S8";
	      cards[2] = "H8";
	      cards[3] = "D8";
	      cards[4] = "C2";
	      
	      assertEquals(true, Hand.fourOAKindAIP(cards));
	}
	
	public void testAIPFourOAKindCase2() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "SJ";
	      cards[2] = "C9";
	      cards[3] = "DQ";
	      cards[4] = "D9";
	      
	      assertEquals(false, Hand.fourOAKindAIP(cards));
	}

	public void testStraightFlushCase1() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "C8";
	      cards[1] = "C9";
	      cards[2] = "C10";
	      cards[3] = "CJ";
	      cards[4] = "CQ";
	      
	      assertEquals(true, testHand.straightFlush(cards));
	}
	
	public void testStraightFlushCase2() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "H2";
	      cards[1] = "S5";
	      cards[2] = "SJ";
	      cards[3] = "HJ";
	      cards[4] = "SK";
	      
	      assertEquals(false, testHand.straightFlush(cards));
	}
	
	public void testAIPStraightFlushCase1() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "C8";
	      cards[1] = "C9";
	      cards[2] = "C10";
	      cards[3] = "CJ";
	      cards[4] = "CQ";
	      
	      assertEquals(true, Hand.straightFlushAIP(cards));
	}
	
	public void testAIPStraightFlushCase2() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "H2";
	      cards[1] = "S5";
	      cards[2] = "SJ";
	      cards[3] = "HJ";
	      cards[4] = "SK";
	      
	      assertEquals(false, Hand.straightFlushAIP(cards));
	}
	
	public void testRoyalFlushCase1() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S10";
	      cards[1] = "SQ";
	      cards[2] = "SJ";
	      cards[3] = "SK";
	      cards[4] = "SA";
	      
	      assertEquals(true, testHand.royalFlush(cards));
	}

	public void testRoyalFlushCase2() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "H9";
	      cards[1] = "C10";
	      cards[2] = "DJ";
	      cards[3] = "CK";
	      cards[4] = "HA";
	      
	      assertEquals(false, testHand.royalFlush(cards));
	}
	
	public void testAIPRoyalFlushCase1() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S10";
	      cards[1] = "SQ";
	      cards[2] = "SJ";
	      cards[3] = "SK";
	      cards[4] = "SA";
	      
	      assertEquals(true, Hand.royalFlushAIP(cards));
	}

	public void testAIPRoyalFlushCase2() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "H9";
	      cards[1] = "C10";
	      cards[2] = "DJ";
	      cards[3] = "CK";
	      cards[4] = "HA";
	      
	      assertEquals(false, Hand.royalFlushAIP(cards));
	}

	public void testOneAFFlushCase1AIP() {
		 AIPHand testHand = new AIPHand();
	     String [] cards = new String [5];
	      
	      cards[0] = "C5";
	      cards[1] = "C9";
	      cards[2] = "C2";
	      cards[3] = "C10";
	      cards[4] = "D4";
	      
	      assertEquals(4, testHand.cardAFFlushAIP(cards));
	}
	
	public void testOneAFFlushCase2AIP() {
		 AIPHand testHand = new AIPHand();
	     String [] cards = new String [5];
	      
	      cards[0] = "HA";
	      cards[1] = "H2";
	      cards[2] = "C3";
	      cards[3] = "H8";
	      cards[4] = "HK";
	      
	      assertEquals(2, testHand.cardAFFlushAIP(cards));
		
	}

	public void testOneAFStraightCase1AIP() {
		 AIPHand testHand = new AIPHand();
	     String [] cards = new String [5];
	      
	      cards[0] = "D5";
	      cards[1] = "S2";
	      cards[2] = "D3";
	      cards[3] = "H4";
	      cards[4] = "C10";
	      
	      assertEquals(4, testHand.cardAFStraightAIP(cards));
	}
	
	public void testOneAFStraightCase2AIP() {
		 AIPHand testHand = new AIPHand();
	     String [] cards = new String [5];
	      
	      cards[0] = "C4";
	      cards[1] = "H5";
	      cards[2] = "D2";
	      cards[3] = "CA";
	      cards[4] = "H6";
	      
	      assertEquals(3, testHand.cardAFStraightAIP(cards));
	}
	
	public void testOneAStraightFlushCase1AIP() {
		 AIPHand testHand = new AIPHand();
	     String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "S9";
	      cards[2] = "D10";
	      cards[3] = "SJ";
	      cards[4] = "SQ";
	      
	      assertEquals(2, testHand.cardAFStraightFlushAIP(cards));
	}
	
	public void testOneAFStraightFlushCase2AIP() {
		 AIPHand testHand = new AIPHand();
	     String [] cards = new String [5];
	      
	      cards[0] = "D4";
	      cards[1] = "D5";
	      cards[2] = "S8";
	      cards[3] = "D7";
	      cards[4] = "D8";
	      
	      assertEquals(2, testHand.cardAFStraightFlushAIP(cards));
		
	}
	
	public void testOneAFRoyaleFlushCase1AIP() {
		 AIPHand testHand = new AIPHand();
	     String [] cards = new String[5];
	      
	      cards[0] = "S10";
	      cards[1] = "SQ";
	      cards[2] = "SJ";
	      cards[3] = "SK";
	      cards[4] = "DA";
	      //using the same method for royalflush as used for straight flush
	      assertEquals(4, testHand.cardAFStraightFlushAIP(cards));
	}

	public void testOneARoyaleFlushCase2AIP() {
		 AIPHand testHand = new AIPHand();
	     String [] cards = new String [5];
	      
	      cards[0] = "S10";
	      cards[1] = "CQ";
	      cards[2] = "SJ";
	      cards[3] = "SK";
	      cards[4] = "SA";
	      //using the same method for royalflush as used for straight flush
	      assertEquals(1, testHand.cardAFStraightFlushAIP(cards));
	}
	
	public void testSameThreeSuitAIP() {
		 ArrayList<Integer> otherCards = new ArrayList<Integer> ();
		 AIPHand testHand = new AIPHand();
	     String [] cards = new String [5];
	      
	     cards[0] = "H3";
	     cards[1] = "C2";
	     cards[2] = "HQ";
	     cards[3] = "D10";
	     cards[4] = "H8";
	     
	     otherCards.add(1);
	     otherCards.add(3);
		 assertEquals(true, otherCards.containsAll(testHand.sameThreeSuitAIP(cards)));
		 
	}
	
	public void testSameThreeRankAIP() {
	     ArrayList<Integer> otherCards = new ArrayList<Integer> ();

		 AIPHand testHand = new AIPHand();
	     String [] cards = new String [5];
	      
	     cards[0] = "DQ";
	     cards[1] = "CQ";
	     cards[2] = "SQ";
	     cards[3] = "S5";
	     cards[4] = "H2";
	     
	     otherCards.add(3);
	     otherCards.add(4);
		 assertEquals(true, otherCards.containsAll(testHand.sameThreeRankAIP(cards)));
	}
	
	public void testSameThreeSequenceAIP() {
	     ArrayList<Integer> otherCards = new ArrayList<Integer> ();

		 AIPHand testHand = new AIPHand();
	     String [] cards = new String [5];
	      
	     cards[0] = "D6";
	     cards[1] = "S8";
	     cards[2] = "H7";
	     cards[3] = "D8";
	     cards[4] = "S2";
	     
	     otherCards.add(4);
	     otherCards.add(1);
	     
		 assertEquals(true, otherCards.containsAll(testHand.sameThreeSequenceAIP(cards)));
	}
	
	
	
}