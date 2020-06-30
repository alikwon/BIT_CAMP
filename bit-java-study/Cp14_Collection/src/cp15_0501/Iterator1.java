package cp15_0501;

import java.util.Iterator;

import java.util.LinkedList;

public class Iterator1 {
	
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Fourth");
		
		
		Iterator <String> itr = list.iterator();
	}
}
