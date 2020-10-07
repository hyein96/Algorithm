package brutforce.nandm;

import java.util.*;
import java.io.*;

public class B15655_N��M_6 {

	
	static int input[] ; // �Է� ������ ��
	static int output[]; // ��� �� ��
	static boolean visit[] ; // �ߺ����� ��� ���ϰ� true,false�� Ȯ��
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
				if(visit[i]) continue;
				
				visit[i] = true;
				output[index] = input[i];
				
				if(index == 0 || index > 0 && output[index-1] < output[index])
					dfs(index+1,n,m,input);
				
				visit[i] = false;
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
		visit = new boolean[n];
		
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
