package com.lec.test;
// {76,45,34,89,100,50,90,93}  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� ���� �հ��  ��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ� �Ͻÿ�
public class ProgramingLan {
	public static void main(String[] args) {
		int[] num = {76, 45, 34, 89, 100, 50, 90, 93} ;
		int tot = 0 ;
		int maxnum = 0, maxidx = 0 ;       // �հ�� tot ����� avg �ִ밪�� maxnum �ּҰ��� minnum
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
		System.out.printf("�հ�� %d ����� %.2f\n �ִ밪�� %d �ּҰ��� %d", tot, avg, maxnum, minnum);
	}
}
