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
	
	public void testThreeKindCase1() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "DA";
	      cards[2] = "S8";
	      cards[3] = "HA";
	      cards[4] = "S8";
	      
	      assertEquals(true, testHand.threeOAKind(cards));
	}
	
	public void testThreeKindCase2() {
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "S2";
	      cards[2] = "H9";
	      cards[3] = "CK";
	      cards[4] = "S8";
	      
	      assertEquals(false, testHand.threeOAKind(cards));
	}
	
	public void testAIPThreeKindCase1() {
		  AIPHand Hand = new AIPHand();
	      String [] cards = new String [5];
	      
	      cards[0] = "S8";
	      cards[1] = "DA";
	      cards[2] = "S8";
	      cards[3] = "HA";
	      cards[4] = "S8";
	      
	      assertEquals(true, Hand.threeOAKindAIP(cards));
	}
	
	public void testAIPThreeKindCase2() {
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
	
	
	
	
}