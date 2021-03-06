package package_linkedlist;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 需求：
 * 	1.生成54张扑克牌（花色+ 数字）
 * 	2.洗牌
 * 	3.模拟三个玩家发牌，留底牌
 * 
*/   

public class TestDemo03Poker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 定义一个集合来存数字（3-10 J， Q  K A 2）
		ArrayList<String> number = new ArrayList<String>();
		for (int i = 2; i <=10; i++) {
			number.add(i + "");
		}
		Collections.addAll(number, "J","Q", "K", "A"); 
//		number.add("J");
//		number.add("Q");
//		number.add("K");
//		number.add("A");
		
		//2.定义一个集合来存花色
		ArrayList<String> color = new ArrayList<String>();
		Collections.addAll(color, "♥", "♠", "♦", "♣");
		
		//3.将数字和花色合并成扑克牌
		ArrayList<String> poker = new ArrayList<String>();
		for (String num : number) {
			for (String col : color) {
				poker.add(col+num);
			}
		}
		
		
		//4.添加大小王
		poker.add("小王");
		poker.add("大王");
		
		//5.洗牌
		Collections.shuffle(poker);
		
		
		//6:发牌
		ArrayList<String> player1 = new ArrayList<String>();
		ArrayList<String> player2 = new ArrayList<String>();
		ArrayList<String> player3 = new ArrayList<String>();
		ArrayList<String> dipai = new ArrayList<String>();
		for(int i = 0; i < 54; i++) {
			if(i >= 51) {
			//留三张底牌
			dipai.add(poker.get(i));
			}
			else {
				if(i % 3 == 0) {
					player1.add(poker.get(i));
				}
				else if(i % 3 == 1) {
					player2.add(poker.get(i));
				}
				else if(i % 3 == 2) {
					player3.add(poker.get(i));
				}
			}
		}
		
		System.out.println(player1);
		System.out.println(player2);
		System.out.println(player3);
		System.out.println(dipai);
		
	}

}
