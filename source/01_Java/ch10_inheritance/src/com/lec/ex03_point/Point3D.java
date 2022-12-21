package com.lec.ex03_point;

// x, y / infoPrint() 

public class Point3D extends Point {
	private int z;
	public Point3D(int x, int y, int z) {
		System.out.println("매개변수 있는 Point3D 생성자 함수 - x, y, z값 초기화");
		setX(x);
		setY(y);
		this.z = z;
	}
	public void infoPrint3D() {
		System.out.println("좌표 : x=" + getX() + ", y =" + getY() + ", z =" + z);
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
