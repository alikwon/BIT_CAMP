package main;

import ex.Member;

public class TestMain1 {

	public static void main(String[] args) {
		//컨트롤 스페이스
		Member member = new Member();
		
		System.out.println(member.getId()); //생성자 안바꾸면 오류
		System.out.println(member.getName());

	}

}
