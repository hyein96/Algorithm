package suhak;

import java.util.Scanner;

// 더 간단한 코드, 효율적인 코드 있나 ? 

public class B1978_소수찾기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int inputNum = sc.nextInt();
		int isPrime = 0 ;
		
		for(int i = 0 ; i < inputNum ; i ++) {
			
			int count = 0 ;
			int number = sc.nextInt();
			for(int j = 1 ; j <= number ; j ++) { // 1은 소수가 아님 
				if(number % j == 0 )
					count ++;
			}
			
			if(count == 2)
				isPrime ++;
		}
		
		System.out.print(isPrime);
		
	}

}
