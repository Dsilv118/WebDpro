package com.lec.ex;


public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car() ; // new를 선언했기 때문에 마이 포르쉐는 다 0으로 청소되어 있음.
		myPorsche.setColor("빨강") ; //myPorsche.color = "빨강" ;
		System.out.println(myPorsche.getColor()+"색 차량 배기량 : " + myPorsche.getCc()) ;
		myPorsche.drive() ;
		myPorsche.park() ;
		myPorsche.race() ;
		Car yourPorsche = new Car() ;
		yourPorsche.setColor("진회색") ; //= "진회색" ;
		yourPorsche.drive() ;
		System.out.println("내차 속도 :" + myPorsche.getSpeed()) ;
	}
}
