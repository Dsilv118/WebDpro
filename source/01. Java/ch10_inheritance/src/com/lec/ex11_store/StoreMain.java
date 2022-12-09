package com.lec.ex11_store;

public class StoreMain {
	public static void main(String[] args) {
		HeadQuarterStore head = new HeadQuarterStore("= = 본사 = =");
		Store1 st1 = new Store1("= = 주택가 1호점 = =");
		Store2 st2 = new Store2("= = 주택가 2호점 = =");
		Store3 st3 = new Store3("= = 주택가 3호점 = =");
		//HeadQuarterStore[] stores = {head, st1, st2, st3};
		HeadQuarterStore[] stores = {new HeadQuarterStore("= = 본사 = ="),
				new HeadQuarterStore("= = 주택가 1호점 = ="),
				new HeadQuarterStore("= = 대학가 2호점 = ="),
				new HeadQuarterStore("= = 증권가 3호점 = =")};
		for(int idx=0 ; idx<stores.length ; idx++) {
			System.out.println(stores[idx].getStoreName());
			stores[idx].kimchi();
			stores[idx].bude();
			stores[idx].bibim();
			stores[idx].sunde();
			stores[idx].gongibab();
		} // 일반 for
		for(HeadQuarterStore store : stores) {
			System.out.println(store.getStoreName());
			store.kimchi();
			store.bude();
			store.bibim();
			store.sunde();
			store.gongibab();
		} // 확장 for
	}
}	
