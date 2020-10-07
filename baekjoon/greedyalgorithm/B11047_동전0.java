package greedyalgorithm;

import java.io.*;
import java.util.*;

public class B11047_����0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int coinNum = Integer.parseInt(st.nextToken());
		int coinSum = Integer.parseInt(st.nextToken());
		int[] coinValue = new int[coinNum];
		int output = 0 ;

		for(int i = 0 ; i < coinNum ; i++) {
			coinValue[i] = Integer.parseInt(br.readLine());
		}
		
		// while �κ��� �Լ��� ���� �� �� �� ���� 
		while(coinSum != 0) {
			for(int i = 0 ; i < coinNum ; i++) {
				if(i == coinNum -1) {
					output += (coinSum / coinValue[i]);
					coinSum -= coinValue[i] * (coinSum / coinValue[i]);
					break;
				}
				else {
					// �� �κп��� coinSum�� ���� ���� ó�� ����� �ϹǷ� <= �� ����� (�ȱ׷��� �ð��ʰ� ��)
					if(coinValue[i] <= coinSum && coinSum < coinValue[i+1]) { 
						output += (coinSum / coinValue[i]);
						coinSum -= coinValue[i] * (coinSum / coinValue[i]);
						break;
					}
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		System.out.print(output);
		br.close();
	}
}
