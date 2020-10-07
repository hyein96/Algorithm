package greedyalgorithm;

import java.io.*;
import java.util.*;

public class B1049_기타줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int need = Integer.parseInt(st.nextToken()); // 필요한 기타줄
		int brandNum = Integer.parseInt(st.nextToken()); // 브랜드 갯수

		int[][] price = new int[brandNum][2]; // 6개 패키지, 낱개 가격
		for(int i = 0 ; i < brandNum ; i++) {
			st = new StringTokenizer(br.readLine());
			price[i][0] = Integer.parseInt(st.nextToken()); // 각 브랜드에 6개의 패키지 가격
			price[i][1] = Integer.parseInt(st.nextToken()); // 낱개 가격
		} 
		
		// 일차원배열로 6개패키지가격 배열이랑 낱개가격 배열 따로 선언해서 받아와서 비교해도 됨
		// for문으로 일일히 작은 거 비교 안하고 sort로 재정렬 한 후, 0번째 인덱스 가져와도 됨 
		
		int sixMin = price[0][0]; // 6개의 패키지 중 가장 저렴한 가격
		int min =  price[0][1];// 낱개 중 가장 저렴한 가격

		if(brandNum != 1) { // 가장 적은 가격 지정 
			for(int i = 1 ; i < brandNum ; i ++) {
				sixMin = Math.min(sixMin, price[i][0]);
				min = Math.min(min, price[i][1]);
			}
		}

		// 나머지가 0일때랑 아닐 때랑 나눠서 할 필요가 없는게 나머지가 0이면 6개의 패키지와 낱개로 구매할 때 원하는 값을 얻을 수 있음

		// int output = Integer.Max_VALUE; 로 가장 큰 값으로 설정 해놔도 됨 
		int output = Math.min(min * need, sixMin * (need/6 +1));
		output = Math.min(output, sixMin*(need/6) + min*(need % 6));

		System.out.print(output);
		br.close();
	}
}
