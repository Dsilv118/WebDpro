package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

// x를 입력할때까지 재고등록(물건명, 가격, 재고수량) : file출력 -> x를 입력하면 이때까지 등록된 모든 재고 목록을 출력

public class Ex03_Product {
	public static void main(String[] args) {
		// x를 입력할때까지 재고등록(물건명, 가격, 재고수량) : file출력
		OutputStream fos = null;
		DataOutputStream dos = null;
		Scanner sca = new Scanner(System.in);
		try {
			fos = new FileOutputStream("src/com/lec/ex2_datastream/product.dat", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.print("입력된 재고가 더 있나요? (입력 : Y/종료 : X) : ");
				if(sca.next().trim().equals("x"))
					break;
				System.out.print("입고된 상품명 : ");
				dos.writeUTF(sca.next());
				System.out.println("입고된 상품 가격 : ");
				dos.writeInt(sca.nextInt());
				System.out.println("입고된 상품 재고량 : ");
				dos.writeInt(sca.nextInt());
			}
			System.out.println("재고 등록 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}// close
		}// 재고 등록 try-catch-finally
		// x를 입력하면 이때까지 등록된 모든 재고 목록을 출력
		ArrayList<Product> products = new ArrayList<Product>();
		InputStream     fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("src/com/lec/ex2_datastream/product.dat");
			dis = new DataInputStream(fis);
			int i = 1;
			while(true) {
//				String name = dis.readUTF();
//				int    price = dis.readInt();
//				int    stock = dis.readInt();
//				products.add(new Product(name, price, stock));
				Product product = new Product();
				product.setName(dis.readUTF());
				product.setPrice(dis.readInt());
				product.setStock(dis.readInt());
				products.add(product);
				System.out.println(i++);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("재고 목록 출력합니다");
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		if(products.isEmpty()) {
			System.out.println("등록된 재고가 없습니다");
		} else {
			System.out.println("물품명\t가격\t재고수량");
			for(Product product : products) {
				System.out.println(product);
			}
			System.out.println("이상" + products.size() + "가지 재고 물품 입력됨");
		}
		sca.close();
	}
}
