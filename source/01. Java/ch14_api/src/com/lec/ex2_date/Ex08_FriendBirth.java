package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex4_object.Friend;

// 오늘 생일인 친구들 출력

public class Ex08_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "12-18", "서울 서대문"),
						    new Friend("마길동", "010-8867-4599", "12-19", "수원 영통"),
						    new Friend("김길동", "010-9921-9929", "02-10", "서울 용산"),
						    new Friend("신길동", "010-5129-5539", "03-03", "인천 송도")};
		Date birthDay = new Date();
		SimpleDateFormat mont = new SimpleDateFormat("MM-dd");
		String today = mont.format(birthDay);
		boolean none = true;
		System.out.println("오늘 생일인 친구 목록을 검색합니다........");
		for(Friend friend : friends) {
			if(today.equals(friend.getBirth())) {
				System.out.println(friend);
				none = false;
			}
		}//for
//		for(int idx=0 ; idx<friends.length ; idx++) {
//			String birth = friends[idx].getBirth();
//			if(today.equals(birth)) {
//				System.out.println(friends[idx]);
//				none = false; // 한명 이상 출력 시 none은 false
//			}//if
//		}//for
		if(none) {
			System.out.println("오늘 생일인 친구가 없습니다");
		}
	}//main
}//class
