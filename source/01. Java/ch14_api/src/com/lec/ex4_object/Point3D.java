package com.lec.ex4_object;

public class Point3D implements Cloneable{
	private double x = 0;
	private double y = 0;
	private double z = 0;
	
	public Point3D() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	} 
	
	@Override
	public String toString() {
		return "[x°ª : " + x + ", y°ª : " + y + ", z°ª : " + z + "]"; 
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && getClass()==obj.getClass()) {
			Point3D other = (Point3D)obj;
			return x==other.x && y==other.y && z==other.z;
		}
		return false;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
