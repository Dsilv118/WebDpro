package com.lec.ex;

class Ex01 {
	public static void main(String[] args) {
		int i = 10 ; // int ������ ����� �ʱ�ȭ
		// 1. �迭 ���� ����� �ʱ�ȭ
		int[] iArr = {10,20,30,40,50} ; // �迭�� ��üó�� ������.
		iArr[2] = 300; // �迭�� index�� ����(0~4)
		for(int idx=0 ; idx<iArr.length ; idx++) { // iArr.length : �迭 ���� ����
			System.out.println(iArr[idx]) ;
		} 
		// 2. �迭 ���� ����� �迭 �޸� ���� Ȯ���� �и�
		int[] iArr2 = new int[5] ; //new�� �޸� ���� Ȯ�� int �迭�� 0���� û�� double�� 0.0���� û��, �޸� ���� Ȯ���� �ڵ����� �ʱ�ȭ ��
		iArr2[0] = 999;
		for(int idx=0 ; idx<iArr2.length ; idx++) { // �Ϲ� for��
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]) ;
		}
		// 3. �迭 ���� ����
		int[] iArr3 ;
		iArr3 = new int[3] ; // = {0,0,0} �迭 ���� Ȯ��
		// Ȯ�� for��
		for(int temp : iArr3) {
			System.out.println(temp); 
		}
		// �Ϲ� for���� �̿��� �迭 ���� ����
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			iArr3[idx] = 999;
		}
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			System.out.println(idx+"��° : "+ iArr3[idx]);
		}
		// Ȯ�� for���� �̿��� �迭 ���� ���� �ںҰ���
		for(int ia : iArr3) {
			ia = 111;
		}
		for(int ia : iArr3) {
			System.out.println(ia);
		}
	}

}
