package suhak;

import java.util.Scanner;

public class B9613_GCD�� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i ++) {
			
			int inputNum = sc.nextInt();
			int[] input = new int[inputNum];
			long answer = 0 ; // n�ǹ����� ũ�Ƿ� ���Ѱ��� int������ �� ��� ��찡 ���� -> long���� !
			
			for(int j = 0 ; j < inputNum ; j ++) {
				input[j] = sc.nextInt();
			}
			
			for(int m = 0 ; m < inputNum-1 ; m++) {
				for(int n = m+1 ; n < inputNum ; n++) {
					answer +=  gcd(input[m],input[n]);
					
				}
			}
			System.out.println(answer);
			
		}
		
		
	

	}
	
	static int gcd(int a, int b) { // �ٸ� ������ ����Ϸ��� static ������� �� 
		int r = a % b;
		if(r == 0) return b;
		else return gcd(b,r);
	}
	
	// ��Ŭ���� ȣ���� �� ������ ��Ÿ����?
	/*
	  static int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);    
      }
	 */
}
