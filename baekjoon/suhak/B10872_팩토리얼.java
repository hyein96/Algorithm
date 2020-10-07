package suhak;

import java.util.Scanner;

public class B10872_팩토리얼 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int answer = 1; // 정수의 범위가 0부터 12라 int가 가능한것,더 크면 long으로 바꿔야 됨 
		
		if(number == 0) System.out.print(1);
		else {
			for(int i = 1 ; i <= number ; i++) {
				answer *= i;
			}
			System.out.print(answer);
		}
	}
////////////////////////// 재귀로 풀어보기 //////////////////////////
}
