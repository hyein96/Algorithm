package brutforce.nandm;

import java.util.*;
import java.io.*;

// 같은 수를 여러번 골라도 되므로 visit배열이 필요 없음 
public class B15657_N과M_8 {

	static int input[] ; // 입력 들어오는 값
	static int output[]; // 출력 할 값
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void dfs(int index, int n , int m, int[] input) throws IOException {
		
		if(index == m) {
			for(int i = 0 ; i < m ; i ++) {
				bw.write(String.valueOf(output[i]));
				if(i != m-1) bw.write(" ");
			}
			bw.newLine();
		}
		
		else {
			for(int i = 0 ; i < n ; i ++) {
				output[index] = input[i];
				if(index == 0 || index > 0 && output[index-1] <= output[index])
						dfs(index+1,n,m,input);
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		input = new int[n];
		output= new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		dfs(0,n,m,input);
		
		br.close();
		bw.flush();
		bw.close();	
	}
}
