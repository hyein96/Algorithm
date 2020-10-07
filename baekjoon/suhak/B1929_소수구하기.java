package suhak;

import java.util.Scanner;

public class B1929_소수구하기 {

	public static void main(String[] args) {
		//에라토스테네스의 체 이용 
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int prime[] = new int[n+1]; // 인덱스는 0부터 시작하므로(소수 배열)

		
		
		//1부터 n까지의 소수갯수을 에라토스테네스의 체를 이용해서 구하고, m부터 n까지의 소수갯수 빼서 출력
		prime[0] = prime[1] = 0 ; // 0과 1은 소수가 아니므로 -> 소수가 아닌 값은 다 0으로 변환 
		for(int i = 2 ; i <= n ; i ++) { // 소수배열에 먼저, 각각의 수를 대입 
			prime[i] = i ;
		}
		
		//에라토스테네스의 체 
		for(int i = 2 ; i <= n ; i ++) {
			if(prime[i] == 0) continue;
			for(int j = i * 2 ; j <= n ; j += i) { // n *2 부터 시작해서 n의 배수 지움 
				prime[j] = 0 ;
			}
		}
		
		for(int i = m ; i <= n ; i++) {
			if(prime[i] != 0) 
				System.out.println(i);
		}
		
	}
}

/* 시간초과나는 코드
Scanner sc = new Scanner(System.in);

int m = sc.nextInt();
int n = sc.nextInt();

for(int i = m ; i <= n ; i ++) {
	int count = 0 ; 
	for(int j = 1 ; j <= i ; j ++) {
		if(i % j == 0 ) count ++;
		
	}
	if(count == 2) System.out.println(i);
}
*/