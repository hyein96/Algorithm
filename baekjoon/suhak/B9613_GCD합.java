package suhak;

import java.util.Scanner;

public class B9613_GCD합 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i ++) {
			
			int inputNum = sc.nextInt();
			int[] input = new int[inputNum];
			long answer = 0 ; // n의범위가 크므로 더한값은 int형으로 못 담는 경우가 있음 -> long으로 !
			
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
	
	static int gcd(int a, int b) { // 다른 데에서 사용하려면 static 붙혀줘야 함 
		int r = a % b;
		if(r == 0) return b;
		else return gcd(b,r);
	}
	
	// 유클리드 호제법 더 간단히 나타내면?
	/*
	  static int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);    
      }
	 */
}
