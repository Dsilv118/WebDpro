package com.lec.Quiz;
// �迭�� ��� ���� ���ϴ� ���α׷��� �ۼ� int[] arr =  { 10, 20, 30, 40, 50}  
public class Quiz1 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50} ;
		int tot = 0 ;
		for(int idx=0 ; idx<arr.length ; idx++) {
			tot += arr[idx] ;
		}
		System.out.println(tot);
	}

}
