package com.jvs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ts1 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		int schars = 98;
		for(int i = 0; i < 10; i++) {
			map.put(String.valueOf( ((char)schars++) ), (int)(Math.random() * 10));
		}
		
		for(Entry<String, Integer> entry: map.entrySet()){
			System.out.println(entry.getKey() + " ::::::::::: " + entry.getValue());
		}
		
		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
		list.sort((Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> o2.getValue().compareTo(o1.getValue()));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		for(Map.Entry<String, Integer> entry: list) {
			System.out.println(entry.getKey() + " :::::::::::: " + entry.getValue());
		}
	}
}
