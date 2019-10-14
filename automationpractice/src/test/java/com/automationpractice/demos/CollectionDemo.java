package com.automationpractice.demos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionDemo {

	public static void main(String[] args) {
		
		System.out.println("===================List===================");
		
		List<String> myToDoList = new ArrayList<>();
		myToDoList.add("do grocery");
		myToDoList.add("car wash");
		myToDoList.add("laundry");
		myToDoList.add("laundry");
		
//		System.out.println(myToDoList.get(0));
//		for(String list:myToDoList) {
//			System.out.println(list);
//		}
		
		for(int i=0;i<myToDoList.size();i++) {
			System.out.println(myToDoList.get(i));
		}
		
		System.out.println("===================Set===================");
		
		Set<String> setList = new HashSet<String>();
		setList.add("handle1");
		setList.add("handle2");
		setList.add("handle3");
		setList.add("handle3");
		
		for(String s:setList) {
			System.out.println(s);
		}
		
		Iterator it=setList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		setList.forEach(data->{
			System.out.println(data);
		});
	}
}
