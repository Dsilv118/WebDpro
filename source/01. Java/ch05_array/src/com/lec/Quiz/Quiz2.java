package com.lec.Quiz;
// 2���� �迭�� ����� ���� �հ踦 ���Ͻÿ�. int[][] arr = { {   5,  5,   5,   5,   5}, {10, 10, 10, 10, 10}, {20, 20, 20, 20, 20}, {30, 30, 30, 30, 30}};	
public class Quiz2 {
	public static void main(String[] args) {
		int[][] arr = {{5, 5, 5, 5, 5},
					   {10, 10, 10, 10, 10}, 
					   {20, 20, 20, 20, 20}, 
					   {30, 30, 30, 30, 30}} ;
		int tot = 0 ;
		for(int a=0 ; a<arr.length ; a++) {
			for(int b=0 ; b<arr[0].length ; b++) {
				tot += arr[a][b] ;
			}
		}
		System.out.println(tot);
	}
}
