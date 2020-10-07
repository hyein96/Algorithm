package suhak;

import java.util.Scanner;

public class B1934_최소공배수 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder answer = new StringBuilder(); // 한꺼번에 출력 위해 
		int testcase = 0 ; // 테스트케이스
		int first ;
		int second;
		int LCM = 0 ; // 이 문제는 간신히 int로 가능 , int로 안될 땐 long으로 자료형선택
		// 아니면 ,최소공배수를 변수에 넣지말고 그냥 바로 출력 ! (자료형 선언 필요없음)
		
		testcase = sc.nextInt(); // next()는 문자열 받아오는 것 
		
		for(int i = 0 ; i < testcase ; i ++) {
			
			first = sc.nextInt();
			second = sc.nextInt();
			int GCD = 1;
			
			for(int j = 1 ; j <= ((first <= second)? first:second) ; j++) {
				if(first % j == 0 && second % j == 0)
						GCD = j;
			}
			
			LCM = GCD * (first/GCD) *(second/GCD);
			answer.append(LCM+"\n"); // StringBuffer에 안넣고 그냥 바로 출력 해도 됨 
		}
		
		System.out.print(answer.toString());
		
	}

}
/* 유클리드 호제법 이용 --> 시간 더 효율적 !!!!!!!!
 public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int gcd = gcd(a, b);
            System.out.println(a * (b / gcd));// 최소공배수는 각 수를 최대공약수로 나눈 값에 최대공약수 곱한값이므로
                                              // 정리하면, 한개 수 * 다른수/최대공약수 
        }
    }

   static int gcd (int a, int b) { // 최대공약수 구할때 ,유클리드 호제법 이용 
        int r = a % b;
        if (r == 0) return b;
        return gcd(b, r);
    }
}
 */
