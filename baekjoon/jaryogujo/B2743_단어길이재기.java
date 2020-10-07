package jaryogujo;

import java.util.Scanner;

public class B2743_단어길이재기 {
	
	// String의 length()는 함수이므로 문자가 길어질수록 반복을 그만큼 도는 것 -> 시간 오래걸리므로 / 배열에 넣어서 length 쓰는게 효율적 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s ; 
		
		s = sc.next();
		System.out.print(s.length());
	}
}