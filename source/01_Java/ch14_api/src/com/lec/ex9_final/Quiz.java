package com.lec.ex9_final;
import java.util.Random;
import java.util.Scanner;
// you가 질 때까지 반복
public class Quiz {
	public static void main(String[] args) {
		int you = 0, computer;
		Scanner scanner = new Scanner(System.in);
		Random ran = new Random();
		do{
			System.out.println("가위, 바위, 보자기 중 하나를 선택하세요");
			String youStr = scanner.next();
			youStr.trim();
			if (youStr.equals("가위")) {
				you = 0;
			}else if (youStr.equals("바위")) {
				you = 1;
			}else if (youStr.equals("보자기")) {
				you = 2;
			}else {
				System.out.println("잘못 내셨습니다.");
				break;
			}
			computer = ran.nextInt(3);
			String computerStr = (computer==0) ? "가위" : (computer==1)?"바위":"보자기";
			youStr = (you==0) ? "가위" : (you==1)?"바위":"보자기";
			if(you<0 || you>2) {
				System.out.println("가위(0),바위(1),보(2) 중 하나");
			}else {
				if( (you+2)%3 == computer ) {
					System.out.printf("당신은 %s, 컴퓨터는 %s. 당신이 이겼어요 ^.^\n", youStr, computerStr);
				}else if((you+1)%3 == computer){
					System.out.printf("당신은 %s, 컴퓨터는 %s. 컴퓨터가 이겼어요 ㅠ.ㅠ\n", youStr, computerStr);
				}else {
					System.out.printf("당신은 %s, 컴퓨터는 %s. 비겼어요\n",  youStr, computerStr);
				}
			}
		}while((you+2)%3 != computer || you==computer);//do~while
		scanner.close();
		System.out.println("BYE");
	}//main
}//class