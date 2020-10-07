package suhak;

import java.util.Scanner;

public class B2609_최대공약수와최소공배수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int min = (a <= b)? a:b ;
		int GCD = 1 ; 
		int LCM = 0 ; // 들어오는 a와 b의 범위에 따라 자료형 잘 생각해야함 (int넘어가면 long으로)
		
		//공약수가 될 수있는 수 중 가장 큰 수는 두 수 중 작은수이므로 작은수 까지 나눠 보기 
		for(int i = 1 ; i <= min ; i++) { // 둘다 소수면 최대공약수 1일수도 있음 
			if(a % i == 0 && b % i == 0) 
				GCD = i;
		}
		
		LCM = GCD * (a / GCD) * (b / GCD); // for문을 안들어가면 GCD값은 정해지지 않으므로 처음 선언할 때 기본값으로 초기화 해줘야함 
		
		System.out.println(GCD);
		System.out.println(LCM);
		
		
		
	}
}
