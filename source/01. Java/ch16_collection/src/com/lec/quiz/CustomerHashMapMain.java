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
//			System.out.print("�����Ͻ� ȸ���� �̸���?");
//			newCustomer.setName(sca.next());
//			System.out.println("�����Ͻ� ȸ���� ��ȭ��?");
//			String num = sca.next();
//			// ������ ������ ��ȭ��ȣ���� Ȯ���ϴ� ��� 
//			if(cust.get(num)!=null) {
//				System.out.println("�̹� ���ԵǾ� �ִ� ��ȭ��ȣ�Դϴ�. ��ȭ��ȣ�� �ߺ��Ͽ� ������ �Ұ��մϴ�");
//				continue;
//			}
//			newCustomer.setPno(num);
//			System.out.print("�����Ͻ� ȸ������ �ּҴ�?");
//			sca.nextLine(); // ���� ����� �뵵
//			newCustomer.setAdress(sca.nextLine());
//			cust.put(num,  newCustomer);
			System.out.println("ȸ������ �̸��� �Է����ּ���");
			String temp1 = sca.next();
			System.out.println("ȸ������ ��ȭ��ȣ�� �Է����ּ���");
			String temp2 = sca.next();
			sca.nextLine();
			System.out.println("ȸ������ �ּҸ� �Է����ּ���");
			String temp3 = sca.nextLine();
			cust.put(temp2, new Customer(temp1, temp2, temp3));
			System.out.println("�߰� ȸ�������� �Ϸ��� �ƹ�Ű�� �����ּ���. ���Ḧ ���ϸ� n");
			String end = sca.next();
			if(end.equalsIgnoreCase("n")) {
				if(cust.size()==0) {
					System.out.println("������ ȸ�� ����� �����ϴ�");
				}else {
					System.out.println("����Ǿ����ϴ�");
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
