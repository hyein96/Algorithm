package greedyalgorithm;

import java.io.*;
import java.util.*;

public class B11047_동전0 {
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
		
		// while 부분을 함수로 구현 할 수 도 있음 
		while(coinSum != 0) {
			for(int i = 0 ; i < coinNum ; i++) {
				if(i == coinNum -1) {
					output += (coinSum / coinValue[i]);
					coinSum -= coinValue[i] * (coinSum / coinValue[i]);
					break;
				}
				else {
					// 이 부분에서 coinSum고 같은 값도 처리 해줘야 하므로 <= 로 써야함 (안그러면 시간초과 뜸)
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
