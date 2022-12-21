package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.lec.ex1_list.Friend;

public class Ex03_iteratorEx {
	public static void main(String[] args) {
		// 1. list °è¿­
		ArrayList<String> list = new ArrayList<String>();
		list.add("SAMPLE1"); list.add("SAMPLE2");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + "\t");
		}
		System.out.println();
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i) + "\t");
		}
		for(String temp : list) {
			System.out.println(temp + "\t");
		}
		System.out.println("\n = = = 2. Map °è¿­ = = =");
		HashMap<String, Friend> map = new HashMap<String, Friend>();
		map.put("È«±æµ¿", new Friend("È«±æµ¿", "010-2312-4231"));
		map.put("¼ºÃáÇâ", new Friend("¼ºÃáÇâ", "010-9822-2032", 
			   new Date(new GregorianCalendar(1995, 0, 1).getTimeInMillis())));
		map.put("¾ç¸¸´ö", new Friend("¾ç¸¸´ö", "010-2312-2231"));
		Iterator<String> iterator2 = map.keySet().iterator();
		while(iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("= = = 3. set °è¿­ = = =");
		HashSet<Friend> set = new HashSet<Friend>();
		set.add(new Friend("È«±æµ¿", "02-121-2012"));
		set.add(new Friend("È«±æµ¿", "02-121-2012"));
		set.add(new Friend("ÀÓ±æµ¿", "02-784-8762"));
		set.add(new Friend("½Å±æµ¿", "02-631-4251"));
		Iterator<Friend> iterator3 = set.iterator();
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next());
		}
	}
 }
