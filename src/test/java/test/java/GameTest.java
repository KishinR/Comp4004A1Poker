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
		  Hand testHand = new Hand();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "DA";
	      cards[2] = "D3";
	      cards[3] = "D4";
	      cards[4] = "D2";
	      
	      assertEquals(true, testHand.Pair(cards));
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
	
	
}