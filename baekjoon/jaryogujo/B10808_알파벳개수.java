package jaryogujo;

import java.util.Scanner;

public class B10808_알파벳개수 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input ; 
		int alNumber[] = new int ['z'-'a'+1];
		
		// 출력값 일단 0 으로 다 만들기 
		for(int i = 0 ; i< alNumber.length ; i++) {
			alNumber[i] = 0 ; 
		}
		
		input = sc.next();
		
		for(int i = 0 ; i < input.length() ; i ++) {
			char c = input.charAt(i); // 한글자 빼오기
			alNumber[c-'a'] ++ ;  // 출력문자열에서 a의 인덱스가 0 b의 인덱스가 1... 이므로 
			                      // 받은 문자에서 'a'의 아스키코드 뺀 값이 출력문자열의 해당 문자에 인덱스가 됨 
		}
		
		for(int i = 0 ; i< alNumber.length ; i ++) {
			System.out.print(alNumber[i]+ " ");
		}
	}

}
