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
		//System.out.println("Hand is created\n");
		loadVariables();
	}
	
	public void loadVariables() {
		cards = new String [Hand_Size];
	}
}