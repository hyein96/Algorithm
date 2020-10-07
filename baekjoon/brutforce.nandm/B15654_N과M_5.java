package brutforce.nandm;
// �ι�° �ٿ� ���� ���� ������������ �迭 �س��� �ߺ� ���� ���� ��� 

import java.util.*;
import java.io.*;

public class B15654_N��M_5 {
	
	static int input[] ; // ��° �ٿ� ���� ���� ���� �迭
	static int output[] ; // ��� �迭 
	static boolean visit[]; // �ߺ����� ó�� �ϱ� ���� ����ϴ� �迭 
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void dfs(int index, int n, int m, int input[]) throws IOException {
		if(index == m) {
			for(int i = 0 ; i < m ; i ++) {
				bw.write(String.valueOf(output[i]));
				if(i != m-1) bw.write(" ");
			}
			bw.newLine();
		}
		
		else {
			for(int i = 0; i < n ; i++) {
				
				if(visit[i]) continue;
				
				visit[i] = true;
				output[index] = input[i];
				
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
		output = new int[m];
		visit = new boolean[n]; // ���� N��M�� �ٸ� ���� 1���� ���ʴ�� �ִ°� �ƴ϶� �Է� ���� ���� �ִ� ���̹Ƿ� i=1���� ������ �ʿ� ���� 
		
		st = new StringTokenizer(br.readLine()); // ��° �� �о����(���ο� ��ü ���� �о���� ��) -> sc.nextLine()�� ���� �� 
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken()); // ��° �� ���� ���� �������� int�迭�� �ֱ� 
		}
		
		Arrays.sort(input); // ������������ ���� �� , �� �迭�� ������ ����Ҷ� ��� �� �� 
		
		dfs(0,n,m,input);
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
