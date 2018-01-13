package com.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * 斗地主
 * 
 * @author IamZY
 * 
 */
public class PokerDemo {

	public static void main(String[] args) {

		// 存储牌
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		// 存储编号
		ArrayList<Integer> array = new ArrayList<Integer>();

		// 创建花色数组和点数数组
		// 定义一个花色数组
		String[] colors = { "♠", "♥", "♣", "♦" };
		// 定义一个点数数组
		String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q",
				"K", "A", "2", };

		int index = 0;

		// 存牌
		// 将牌存入map中
		for (String i : numbers) {
			for (String color : colors) {
				hm.put(index, color.concat(i));
				// 将编号存入集合当中
				array.add(index);
				index++;
			}
		}

		// 存大王小王
		array.add(index);
		hm.put(index, "小王");
		index++;
		array.add(index);
		hm.put(index, "大王");

		// 洗牌
		Collections.shuffle(array);
	
		// 发牌
		TreeSet<Integer> tomSet = new TreeSet<Integer>();
		TreeSet<Integer> hellenSet = new TreeSet<Integer>();
		TreeSet<Integer> mikeSet = new TreeSet<Integer>();
		TreeSet<Integer> diPaiSet = new TreeSet<Integer>();

		for (int i = 0; i < array.size(); i++) {
			if (i >= array.size() - 3) {
				diPaiSet.add(array.get(i));
			} else if (i % 3 == 0) {
				tomSet.add(array.get(i));
			} else if (i % 3 == 1) {
				hellenSet.add(array.get(i));
			} else if (i % 3 == 2) {
				mikeSet.add(array.get(i));
			}
		}
		
		
		 
		//看牌   TreeSet中存的是编号
		lookPoker("Tom", hm, tomSet);
		lookPoker("Hellen", hm, hellenSet);
		lookPoker("Mike", hm, mikeSet);
		lookPoker("底牌", hm, diPaiSet);

		
		
		
	}//main
	
	public static void lookPoker(String name,HashMap<Integer, String> map,TreeSet<Integer> set){
		
		System.out.print(name + "的牌是: ");
		
		//遍历TreeSet
		for(Integer i : set){
			//取出编号
			System.out.print(map.get(i) + " ");
		}
		
		System.out.println();
		
	}
	
	
	
}
