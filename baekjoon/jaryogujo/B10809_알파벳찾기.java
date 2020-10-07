package jaryogujo;

import java.util.Scanner;

public class B10809_알파벳찾기 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] alNumber = new int['z'-'a'+1] ; // [] 자리에 26 넣어도 됨
		String input ;
		
		input = sc.next();
		 for(int i = 0 ; i< alNumber. length ; i ++){
		  	alNumber[i] = -1 ; // 출력값들 다 -1 로 바꿔놓기
		  }
		  
		  for(int i = 0 ; i < input.length() ; i ++){
		  		char c = input.charAt(i); // 입력받은 문자열의 한문자 빼오기
		  		int index = input.indexOf(c) ; // 문자열에서 그 한문자가 가장 처음에 나오는 위치의 인덱스 값 변수에 넣기
		  		alNumber[c-'a'] = index ; // 출력 문자열의 해당 문자 위치에 넣기 	
		  		                       // 출력 문자열의 인덱스도 0부터 시작하므로 'a'의 인덱스는 0 'b'의 인덱스는 1로
		  		                       // 어떤 문자 c의 인덱스는 c-'a'(a의 아스키코드값) 이란걸 알 수 있다. 
		  
		  }
		  
	 	 for(int i = 0 ; i < alNumber.length ; i++) {
				System.out.print(alNumber[i]+" ");
			}
	 
	}
}
	

/* 다시 짠 코드 (indexOf(), 아스키코드 활용 
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int[] alNumber = new int['z'-'a'+1] ; // [] 자리에 26 넣어도 됨
	String input ;
	
	input = sc.next();
	 for(int i = 0 ; i< alNumber. length ; i ++){
	  	alNumbe[i] = -1 ; // 출력값들 다 -1 로 바꿔놓기
	  }
	  
	  for(int i = 0 ; i < input.length() ; i ++){
	  		char c = input.charAt(i); // 입력받은 문자열의 한문자 빼오기
	  		int index = input.indexOf(c) ; // 문자열에서 그 한문자가 가장 처음에 나오는 위치의 인덱스 값 변수에 넣기
	  		alNum[c-'a'] = index ; // 출력 문자열의 해당 문자 위치에 넣기 	
	  		                       // 출력 문자열의 인덱스도 0부터 시작하므로 'a'의 인덱스는 0 'b'의 인덱스는 1로
	  		                       // 어떤 문자 c의 인덱스는 c-'a'(a의 아스키코드값) 이란걸 알 수 있다. 
	  
	  }
	  
 	 for(int i = 0 ; i < alNumber.length ; i++) {
			System.out.print(alNumber[i]+" ");
		}
 
 
 
  */
/* 다른 사람코드 : 매우 간단 (indexOf() 사용)
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String input = sc.next();

	for (char c = 'a' ; c <= 'z' ; c++)
       System.out.print(input.indexOf(c) + " ");
}
*/