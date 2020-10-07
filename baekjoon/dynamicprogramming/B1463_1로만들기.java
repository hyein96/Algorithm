package dynamicprogramming;
// 다이나믹프로그래밍 : 큰문제를 작은 여러개의 문제(작은문제)로 나누어서 해결
// 이전에 구해놓은값을 배열에 저장해 놓고 매번 재계산하지않고 문제를 푸는 방법 

import java.io.*;
import java.util.*;

//다이나믹프로그래밍 사용법으로 top-down(재귀이용) / bottom -up(반복문이용) 방식 두개 있음
// 둘다 공통적으로 배열만들어서 저장해놓고 사용하는 DP방식으로 품 
public class B1463_1로만들기 {
	
	public static void main(String[] args) throws IOException {

	// 1. Bottom-up방식(반복문이용) : 작은 수(1)부터 주어진 수 까지 아래에서 위로 올라가며 구하는 방식
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int input = Integer.parseInt(br.readLine());
	int dp[] = new int[input + 1]; // dp배열 (해당 수가 1이 될때까지 최소 연산값)
	dp[0] = 0 ; 
	dp[1] = 0 ; // 1이 되면 끝
	
	for(int i = 2 ; i < input + 1 ; i++) {
		dp[i] = dp[i-1] + 1; // 1을 빼는건 모든 수가 가능하므로 모든 수의 기본으로 적용해줌(뒤에서 더 작은 값이 그 수의 dp값 됨)
		if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
		if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
	}
	
	System.out.print(dp[input]);
	br.close();
		
	} 
	
	
	/* 2. Top-down방식(재귀이용) --> 시간 제일 오래 걸림 
	
	static int dp[] ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		dp = new int[input+1];
		dpCalculate(input);
		System.out.print(dp[input]);
		br.close();
	
	}
	
	static int dpCalculate(int num) { // 재귀함수 사용
		if(num == 1) return 0 ; // 1이면 끝
		if(dp[num] > 0) return dp[num] ; // 0보다 크다는 건 이미 계산 된 값 
		
		dp[num] = dpCalculate(num - 1) + 1; // 여기에 들어오면 num보다 작은 수들의 dp값은 다 계산이 되서 나옴 (재귀이므로)
		if(num % 2 == 0) {
			dp[num] = Math.min(dp[num], dp[num/2] +1);
		}
		if(num % 3 == 0) {
			dp[num] = Math.min(dp[num], dp[num/3] +1);
		}
		
		return dp[num];
	}
	*/
	
	

}

/* (다이나믹프로그래밍 사용 x) 
 * 내풀이 : 큐 선언해서, 방문했는지 안했는지 확인 하며 가능한 경우 다 큐에 넣으면서 1이 될때까지 횟수늘려가며  반복   
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int output = 0 ; 
		int[] visit = new int[input+1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(input);
		visit[input] = 1; // 방문함
		
		while(!q.isEmpty()) {
			
			int x = q.poll();
			if(x == 1) break;
			
			if(x % 2 == 0 && visit[x / 2] == 0) {
				q.offer(x / 2);
				visit[x/2]  =  visit[x] + 1 ;  
			}
			if(x % 3 == 0 && visit[x / 3] == 0) {
				q.offer(x / 3);
				visit[x/3]  =  visit[x] + 1 ;  
			}
			if(visit[x -1] == 0) {
				q.offer(x-1);
				visit[x-1]  =  visit[x] + 1 ;  
			}
		}
		
		output = visit[1] - 1 ;
		System.out.print(output);
		
		br.close();
*/
