package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTestMain {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		ArrayList<Customer> cust = new ArrayList<Customer>();
		while(true) {
//			Customer newCustomer = new Customer();
//			System.out.print("�����Ͻ� ȸ���� �̸���?");
//			newCustomer.setName(sca.next());
//			System.out.print("�����Ͻ� ȸ���� ��ȭ��");
//			newCustomer.setPno(sca.next());
//			System.out.print("�����Ͻ� ȸ���� �ּҴ�?");
//			sca.nextLine();
//			newCustomer.setAdress(sca.nextLine());
//			cust.add(newCustomer);
			System.out.println("ȸ������ �̸��� �Է����ּ���");
			String temp1 = sca.next();
			System.out.println("ȸ������ ��ȭ��ȣ�� �Է����ּ���");
			String temp2 = sca.next();
			sca.nextLine();
			System.out.println("ȸ������ �ּҸ� �Է����ּ���");
			String temp3 = sca.nextLine();
			cust.add(new Customer(temp1, temp2, temp3));
			//System.out.printf("%s, %s, %s", temp1, temp2, temp3);
			System.out.println("�߰� ȸ�������� �Ϸ��� �ƹ�Ű�� �����ּ���. ���Ḧ ���ϸ� n");
			String end = sca.next();
			if(end.equalsIgnoreCase("n")) {
				if(cust.size()==0) {
					System.out.println("������ ȸ�� ����� �����ϴ�");
				}else {
					System.out.println("����Ǿ����ϴ�");
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
