package com.lec.loop;

public class EX03_for_star {
	public static void main(String[] args) {
		for(int i=1 ; i<6 ; i++) {
			for(int j=1 ; j<=i ; j++) {
				System.out.print('*');
			} // for j
			System.out.println();
		} // for i
			 
	}
}
