package com.lec.Quiz;
// 배열에 담긴 값을 더하는 프로그램을 작성 int[] arr =  { 10, 20, 30, 40, 50}  
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
