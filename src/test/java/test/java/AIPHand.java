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
	


}
