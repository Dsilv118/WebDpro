package com.lec.ex;


public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car() ; // new�� �����߱� ������ ���� �������� �� 0���� û�ҵǾ� ����.
		myPorsche.setColor("����") ; //myPorsche.color = "����" ;
		System.out.println(myPorsche.getColor()+"�� ���� ��ⷮ : " + myPorsche.getCc()) ;
		myPorsche.drive() ;
		myPorsche.park() ;
		myPorsche.race() ;
		Car yourPorsche = new Car() ;
		yourPorsche.setColor("��ȸ��") ; //= "��ȸ��" ;
		yourPorsche.drive() ;
		System.out.println("���� �ӵ� :" + myPorsche.getSpeed()) ;
	}
}