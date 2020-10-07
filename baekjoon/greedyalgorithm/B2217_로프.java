package greedyalgorithm;

import java.io.*;
import java.util.Arrays;

public class B2217_���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());	
		int[] weight = new int[num];
		int maxWeight = 0; // ��°�
		
		for(int i = 0 ; i < num ; i ++) {
			weight[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(weight); // ������������ ������(��ƿ���ִ� �ߎU�� �����ͺ��� ū�ͱ���)
		
		for(int i = 0 ; i < num ; i++) {
			maxWeight = Math.max(maxWeight, weight[i] * (num-i));
		}
		System.out.print(maxWeight);
		br.close();
	}
}
