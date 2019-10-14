package warm_up_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import utils.Common;

public class WarmUpDay77 {
	
	@Test
	public void mapTask () {
		/* Create map object
		 * add 5 elements to it
		 * key = Integer, value = String
		 * print summary of all keys
		 */
		Map<Integer, String> map = new HashMap<Integer, String>();
//		map.put(32, "Poly");
//		map.put(12, "Ali");
//		map.put(23, "Mushfig");
//		map.put(45, "Jahid");
//		map.put(55, "Erlan");
		//add random values to map elements
		for ( int index = 1; index <= 5; index++ ) {
			map.put(Common.getRandomInt(0, 60), Common.getRandomFirstName());
		}
		
		//print each map element
		for ( Map.Entry<Integer, String> map1 : map.entrySet() ) {
			System.out.println(map1.getKey() + " - " + map1.getValue());
		}
		
		//print map keys and sum them
		Set<Integer> setOfKeys = map.keySet();
		int sumOfKeys = 0;
		for ( Integer key : setOfKeys )
			sumOfKeys += key;
		
		System.out.println(sumOfKeys);
	}
}
