package com.lec.ex10_final;

// speed, running(), stop(final)

public class Dog extends Animal {
	@Override
	public void running() {
		// TODO Auto-generated method stub
		speed += 10;
		System.out.println("�������� �ٸ鼭 ������ �����. ���� �ӵ� : " + speed);
	}
}
