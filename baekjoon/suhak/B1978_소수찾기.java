package suhak;

import java.util.Scanner;

// �� ������ �ڵ�, ȿ������ �ڵ� �ֳ� ? 

public class B1978_�Ҽ�ã�� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int inputNum = sc.nextInt();
		int isPrime = 0 ;
		
		for(int i = 0 ; i < inputNum ; i ++) {
			
			int count = 0 ;
			int number = sc.nextInt();
			for(int j = 1 ; j <= number ; j ++) { // 1�� �Ҽ��� �ƴ� 
				if(number % j == 0 )
					count ++;
			}
			
			if(count == 2)
				isPrime ++;
		}
		
		System.out.print(isPrime);
		
	}

}
