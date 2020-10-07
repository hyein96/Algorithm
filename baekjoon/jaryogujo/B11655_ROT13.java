package jaryogujo;

import java.util.Scanner;

public class B11655_ROT13 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		char[] c ; // 들어온 문자열 한 문자씩 나눠서 저장하는 변수 
		String answer = "";
		String s ;

		s = sc.nextLine();
		
		c = s.toCharArray();
		
		for(int i = 0 ; i < c.length ; i++) {
			// 공백이거나 숫자일때
			if(c[i] == ' ' || ('0' <= c[i] && c[i]<= '9') ) continue;
			
			// 소문자,대문자일때는 13 더해주고, z가 넘어가면 a로 돌아가야 하므로 알파벳 수 만큼 빼주기
			else if('a'<= c[i] && c[i] <= 'z') {
				c[i] = (char) (c[i]+13);
				if(c[i]> 'z') {
					c[i] = (char)(c[i] -('z'-'a'+1));
				}
			}
			else if('A'<= c[i] && c[i] <= 'Z') {
				c[i] = (char) (c[i]+13);
				if(c[i]> 'Z') {
					c[i] = (char)(c[i] -('Z'-'A'+1));
				}
			}	
		}
		
		for(int i = 0 ; i< c.length ; i ++) {
			answer += c[i];
		}
		
		// 자바에서 프린트시에 큰 따옴표가 없는 것은 모두 변수명으로 인식 (큰 따옴표에 있으면 문자열이라 생각하고 그대로 출력)
		// 문자열과 변수명 연결 시 + 로 연결 
		// ""에 + 에 되있으면 int형 변수 또는 숫자도 문자열로 인식 한뒤 단순히 문자열 합치기를 하므로 잘 생각해서 코드 짜기 
		System.out.print(answer);
		
	}
}

