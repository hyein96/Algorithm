package brutforce.sunyeol;

import java.util.*;
import java.io.*;

public class B10973_이전순열 {
	public static void main(String[]args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input  = new int[n];
		// 입력 받기 
		for(int i = 0 ; i < n ; i ++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이전순열 솔루션 
		boolean first = true; // true면 사전 순으로 가장 처음에 오는 순열 즉, 이전 순열 없음 
		for(int i = n-1 ; i > 0 ; i --) {
			if(input[i] < input[i-1]) {
				first = false; // 가장 처음에 오는 순열 아님  
				for(int j = n-1 ; j >= 0 ; j--) {
					if(input[j] < input[i-1]) {
						//swap하기 
						int temp = input[j];
						input[j] = input[i-1];
						input[i-1] = temp;
						break;
					}
				}
				int k = n-1; // k는 맨 마지막 수 
				while(i < k) {
					int temp2 = input[k];
					input[k]= input[i] ;
					input[i] = temp2;
					i++;
					k--;
				}
				break; // 2번째 for문 나감
			}
		}
		
		if(first) bw.write(String.valueOf(-1));
		else {
			for(int i = 0 ; i < n ; i ++) {
				bw.write(String.valueOf(input[i]));
				if(i != n-1) bw.write(" ");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
