package com.lec.ex9_final;
import java.util.Random;
import java.util.Scanner;
// you�� �� ������ �ݺ�
public class Quiz {
	public static void main(String[] args) {
		int you = 0, computer;
		Scanner scanner = new Scanner(System.in);
		Random ran = new Random();
		do{
			System.out.println("����, ����, ���ڱ� �� �ϳ��� �����ϼ���");
			String youStr = scanner.next();
			youStr.trim();
			if (youStr.equals("����")) {
				you = 0;
			}else if (youStr.equals("����")) {
				you = 1;
			}else if (youStr.equals("���ڱ�")) {
				you = 2;
			}else {
				System.out.println("�߸� ���̽��ϴ�.");
				break;
			}
			computer = ran.nextInt(3);
			String computerStr = (computer==0) ? "����" : (computer==1)?"����":"���ڱ�";
			youStr = (you==0) ? "����" : (you==1)?"����":"���ڱ�";
			if(you<0 || you>2) {
				System.out.println("����(0),����(1),��(2) �� �ϳ�");
			}else {
				if( (you+2)%3 == computer ) {
					System.out.printf("����� %s, ��ǻ�ʹ� %s. ����� �̰��� ^.^\n", youStr, computerStr);
				}else if((you+1)%3 == computer){
					System.out.printf("����� %s, ��ǻ�ʹ� %s. ��ǻ�Ͱ� �̰��� ��.��\n", youStr, computerStr);
				}else {
					System.out.printf("����� %s, ��ǻ�ʹ� %s. �����\n",  youStr, computerStr);
				}
			}
		}while((you+2)%3 != computer || you==computer);//do~while
		scanner.close();
		System.out.println("BYE");
	}//main
}//class