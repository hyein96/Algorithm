package dynamicprogramming;

import java.io.*;

public class B9095_123더하기 {
	// 다이나믹프로그래밍으로 배열 선언해놓고 큰 수의 값을 작은 수들 이용해서 구하기 --> 점화식 구하면 됨 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		// n의 범위가 1부터 10까지 인데, 모든 경우를 다 구하는건 비효율적(n이 클수록 효율 떨어짐) --> 각각의 수에 대해 계산
		for(int i = 0 ; i < testNum ; i ++) {
			int input = Integer.parseInt(br.readLine());
			int[] dp = new int[input + 1];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for(int j = 4; j <= input ; j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			}
			System.out.println(dp[input]);
		}
	
		br.close();
	}

}
// 이클립스에서는 실행되나, 백준에선 정적으로 배열선언해줘야 런타임 에러 안남(dp배열을 맨위에 정적으로 선언해줘야함)
// 동적으로 매번 dp배열 선언하면 런타임 에러남 