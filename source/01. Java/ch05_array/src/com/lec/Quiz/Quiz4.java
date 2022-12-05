package com.lec.Quiz;
// 76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 이들 값들을 크기 순으로 나타내는 프로그램을 작성 하시요.
public class Quiz4 {
	public static void main(String[] args) {
		int[] num = {76, 45, 34, 89, 100, 50, 90, 92} ;
		int temp ;
		for(int i=0 ; i<num.length-1 ; i++) {
			for(int j=i+1 ; j<num.length ; j++) {
				if(num[i]>num[j]) {
					temp = num[i] ;
					num[i] = num[j] ;
					num[j] = temp ;
				}
			}
		}
		for(int a : num) {
			System.out.print(a + ",\t");
		}
			
	}
}
