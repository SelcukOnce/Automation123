package com.automationpractice.demos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import junit.framework.Assert;

public class MapDemo {

	static Map<Integer, String> map;
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Mushfig");
		list.add("Ahmad");
		list.add("Taisiya");
		list.add("Jon Snow");
		
		list.get(2);
		list.remove(2);
		
		MapDemo mapDemo = new MapDemo();
		
		map = new HashMap<Integer, String>();
//		key --> Integer data type
//		value --> String data type
		
		map.put(19, "Mushfig");//key in the map 
		map.put(12, "Ahmad");
		map.put(13, "Taisiya");
		map.put(20, "Jon Snow");
		
		for ( Map.Entry<Integer, String> map1 : map.entrySet() )
			System.out.println(map1.getKey() + " - " + map1.getValue());
		
		System.out.println("==================" + map.get(12));//get element value by key
		System.out.println("map size " + map.size());
		map.remove(12);//removing element by using key
		
		for ( Map.Entry<Integer, String> map1 : map.entrySet() )
			System.out.println(map1.getKey() + " - " + map1.getValue());
		System.out.println("map size " + map.size());
		///////////////////////////////////////////////////////////
		if ( !map.isEmpty() ) 
			for ( Map.Entry<Integer, String> map1 : map.entrySet() )
				System.out.println("inside if " + map1.getKey() + " - " + map1.getValue());
		
		Set<Integer> keys = map.keySet();
		for ( Integer key : keys )
			System.out.println(" key " + key);
		
		map.put(20, "Black Panther");
		for ( Map.Entry<Integer, String> map1 : map.entrySet() )
			System.out.println(map1.getKey() + " - " + map1.getValue());
		System.out.println("=======================================");
		map.put(21, "Black Panther");
		for ( Map.Entry<Integer, String> map1 : map.entrySet() )
			System.out.println(map1.getKey() + " - " + map1.getValue());
		System.out.println("=======================================");
		map = new TreeMap<Integer, String>(map);
		for ( Map.Entry<Integer, String> map1 : map.entrySet() )
			System.out.println(map1.getKey() + " - " + map1.getValue());
		
		Map<String, String> userInfo = new HashMap<String, String>();
		userInfo.put("user email", "ali@gmail.com");
		
		///success page validate email
		
		Assert.assertEquals(userInfo.get("user email"), "");
	}

}
