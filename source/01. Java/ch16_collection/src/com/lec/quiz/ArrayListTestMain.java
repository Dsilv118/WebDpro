package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTestMain {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		ArrayList<Customer> cust = new ArrayList<Customer>();
		while(true) {
//			Customer newCustomer = new Customer();
//			System.out.print("가입하실 회원님 이름은?");
//			newCustomer.setName(sca.next());
//			System.out.print("가입하실 회원님 전화는");
//			newCustomer.setPno(sca.next());
//			System.out.print("가입하실 회원님 주소는?");
//			sca.nextLine();
//			newCustomer.setAdress(sca.nextLine());
//			cust.add(newCustomer);
			System.out.println("회원가입 이름을 입력해주세요");
			String temp1 = sca.next();
			System.out.println("회원가입 전화번호를 입력해주세요");
			String temp2 = sca.next();
			sca.nextLine();
			System.out.println("회원가입 주소를 입력해주세요");
			String temp3 = sca.nextLine();
			cust.add(new Customer(temp1, temp2, temp3));
			//System.out.printf("%s, %s, %s", temp1, temp2, temp3);
			System.out.println("추가 회원가입을 하려면 아무키를 눌러주세요. 종료를 원하면 n");
			String end = sca.next();
			if(end.equalsIgnoreCase("n")) {
				if(cust.size()==0) {
					System.out.println("가입한 회원 목록이 없습니다");
				}else {
					System.out.println("종료되었습니다");
					for(int i=0 ; i<cust.size() ; i++) {
						System.out.println(cust.get(i));
				    }
				}
				break;
			}
		}
		sca.close();
	}
}
