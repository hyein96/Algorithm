package suhak;

import java.util.Scanner;

public class B10430_나머지 {
	
	public static void main(String[] args) {
	//따로 저장해도, 변수만 더 선언해주는거지 계산하는 건 같음(굳이 변수선언해서 저장 후 ,출력할 필요없음)
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // nextInt는 공백 기준으로 구분
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println((A+B)%C);
		System.out.println( (A%C + B%C)%C);
		System.out.println((A*B)%C);
		System.out.println((A%C * B%C)%C);
			
	}
	

}
