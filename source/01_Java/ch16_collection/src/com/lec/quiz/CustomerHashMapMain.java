package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain {
	public static void main(String[] args) {
		HashMap<String, Customer> cust = new HashMap<String, Customer>();
		Scanner sca = new Scanner(System.in);
		while(true) {
//			Customer newCustomer = new Customer();
//			System.out.print("가입하실 회원님 이름은?");
//			newCustomer.setName(sca.next());
//			System.out.println("가입하실 회원님 전화는?");
//			String num = sca.next();
//			// 기존에 가입한 전화번호인지 확인하는 방법 
//			if(cust.get(num)!=null) {
//				System.out.println("이미 가입되어 있는 전화번호입니다. 전화번호는 중복하여 가입이 불가합니다");
//				continue;
//			}
//			newCustomer.setPno(num);
//			System.out.print("가입하실 회원님의 주소는?");
//			sca.nextLine(); // 버퍼 지우는 용도
//			newCustomer.setAdress(sca.nextLine());
//			cust.put(num,  newCustomer);
			System.out.println("회원가입 이름을 입력해주세요");
			String temp1 = sca.next();
			System.out.println("회원가입 전화번호를 입력해주세요");
			String temp2 = sca.next();
			sca.nextLine();
			System.out.println("회원가입 주소를 입력해주세요");
			String temp3 = sca.nextLine();
			cust.put(temp2, new Customer(temp1, temp2, temp3));
			System.out.println("추가 회원가입을 하려면 아무키를 눌러주세요. 종료를 원하면 n");
			String end = sca.next();
			if(end.equalsIgnoreCase("n")) {
				if(cust.size()==0) {
					System.out.println("가입한 회원 목록이 없습니다");
				}else {
					System.out.println("종료되었습니다");
					Iterator<String> iterator = cust.keySet().iterator();
					while(iterator.hasNext()) {
						String hac = iterator.next();
						System.out.println(cust.get(hac));
					}
				}
				break;
			}
		}
		sca.close();
	}
}
