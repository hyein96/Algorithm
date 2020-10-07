package suhak;

import java.util.Scanner;

//더효율적인 방법 없을까? 
public class B17087_숨바꼭질6 {
	
	public static void main(String[] args) {
		
		// 모든 동생들과의 차끼리의 최대 공약수를 구하면 됨 , 
		// 즉 3명이면 3개 숫자의 최대공약수 4명이면 4개숫자의 최대공약수...
		Scanner sc = new Scanner(System.in);
		
		int lowerNum = sc.nextInt(); // 동생 수
		int sLocat = sc.nextInt() ; // 수빈 위치 
		int[] lLocat = new int[lowerNum]; // 동생들 위치
		int[] distance = new int[lowerNum]; // 동생들과 수빈이의 거리
		
		
		for(int i = 0 ; i < lowerNum ; i++) {
			lLocat[i] = sc.nextInt();
		}
		
		for(int i = 0  ; i <lowerNum ; i ++) {
			distance[i] = (lLocat[i]>sLocat ? lLocat[i]-sLocat : sLocat-lLocat[i]);
		}
		

		int GCD = distance[0]; // 처음의 최대공약수 즉, 걷는거리는 동생한명과의 차이로 초기화 
		for(int i = 0 ; i< distance.length ; i ++) {
			
			GCD = gcd(distance[i],GCD);
			
		}
		// 조건이 동생들의 위치는 다르며, 수빈이의 위치와 같지 않으므로 distance가 0인거는 생각 안해도 됨
		System.out.print(GCD);
		
		
		
	}
	
	static int gcd(int a, int b) {
		int r = a % b;
		if(r == 0) return b;
		else return gcd(b,r);
	}
}
