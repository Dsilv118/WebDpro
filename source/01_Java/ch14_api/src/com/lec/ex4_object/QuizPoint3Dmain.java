package com.lec.ex4_object;

public class QuizPoint3Dmain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p3d = new Point3D();
		Point3D po3d1 = new Point3D(48, 24, 30);
		Point3D po3d2 = (Point3D) po3d1.clone();
		System.out.println(p3d);
		System.out.println(po3d1);
		System.out.println(po3d2);
		if(po3d1.equals(po3d2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		if(po3d1.equals(po3d2)) {
			System.out.println("복제");
		}else {
			System.out.println("실패");
		}
		if(po3d1==po3d2) {
			System.out.println("같은 주소");
		}else {
			System.out.println("다른 주소");
		}
	}
}
