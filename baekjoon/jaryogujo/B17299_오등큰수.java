package jaryogujo;

import java.util.*;
import java.io.*;

public class B17299_오등큰수 {
// (내 생각) 등장한 횟수 배열 하나 더 만들어서 등장 횟수구하는 코드 따로 구현한 뒤, 
//	그 이후에는 오큰수처럼 인덱스활용해 input값이 아닌 등장횟수 값으로 비교해서 코드 짬 --> 시간초과
	
/* 솔루션 : 등장한 횟수 배열을 만드는건 맞음 .
  but 모든 수에 대한 등장횟수 구하는 코드를 짜는게 아니라 등장한 숫자가 몇번 나왔는지만 구하면 됨 (한 줄만 추가)
*/
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int[] input = new int[num];
		int[] cntNum = new int[1000001]; // 등장한 수(수열의 원소)의 크기는 1부터 1000000이므로 크기 1000001로 선언  
		int[] output = new int[num];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < num ; i++) {
			input[i] = Integer.parseInt(st.nextToken()); // 등장한 수 
			cntNum[input[i]] ++; // 등장하지 않은 숫자들의 cntNum 값은 0임(기본값 : 0) --> 이것만 추가해주면 됨 
		}
		
		
		// 오큰수랑 동일하게 비교해서 stack
		
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(0);
		
		for(int i = 1 ; i < num ; i++) {
			
			while (!s.isEmpty() && cntNum[input[s.peek()]] < cntNum[input[i]]) {
				output[s.pop()] = input[i]; 
			}
			s.push(i) ; 
		}
		
		while(!s.isEmpty()) {
			output[s.pop()] = -1 ; 
		}
		
		for(int i = 0 ; i < num ; i ++) {
			// 원래 bw는 string만 인식하므로 String.valueOf(output[i]+" ")로 하는게 정석(output이 int이기 때문) 
			bw.write(output[i] + " ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}

/* 처음 코드(등장횟수 구하는 코드) -> 시간초과 
  for(int i = 0 ; i < num ; i++) { 
			int checkNum = input[i];
			int cnt = 0 ; 
			
			for(int j = 0 ; j < num ; j++) {
				if(checkNum == input[j]) {
					cnt ++ ; 
				}
			}
			inputNum[i] = cnt ; 
		}
 */
