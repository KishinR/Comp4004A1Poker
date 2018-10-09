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