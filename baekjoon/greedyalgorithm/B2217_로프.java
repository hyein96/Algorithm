package greedyalgorithm;

import java.io.*;
import java.util.Arrays;

public class B2217_로프 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());	
		int[] weight = new int[num];
		int maxWeight = 0; // 출력값
		
		for(int i = 0 ; i < num ; i ++) {
			weight[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(weight); // 오르차순으로 재정렬(버틸수있는 중랼이 작은것부터 큰것까지)
		
		for(int i = 0 ; i < num ; i++) {
			maxWeight = Math.max(maxWeight, weight[i] * (num-i));
		}
		System.out.print(maxWeight);
		br.close();
	}
}
