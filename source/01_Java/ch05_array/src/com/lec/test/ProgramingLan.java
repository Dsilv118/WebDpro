package com.lec.test;
// {76,45,34,89,100,50,90,93}  8개의 값을 1차원 배열로 초기화 하고 값에 합계와  평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시요
public class ProgramingLan {
	public static void main(String[] args) {
		int[] num = {76, 45, 34, 89, 100, 50, 90, 93} ;
		int tot = 0 ;
		int maxnum = 0, maxidx = 0 ;       // 합계는 tot 평균은 avg 최대값은 maxnum 최소값은 minnum
		int minnum = 0, minidx = 9999 ;
		for(int i=0 ; i<num.length ; i++) {
			tot += num[i] ;
		}
		double avg = (tot/8.0) ;
		for(int idx=0 ; idx<num.length ; idx++) {
			if(maxidx < num[idx]) {
				maxidx = num[idx];
				maxnum = maxidx ;
			}
			if(minidx > num[idx]) {
				minidx = num[idx];
				minnum = minidx ;
			}
		}
		System.out.printf("합계는 %d 평균은 %.2f\n 최대값은 %d 최소값은 %d", tot, avg, maxnum, minnum);
	}
}
