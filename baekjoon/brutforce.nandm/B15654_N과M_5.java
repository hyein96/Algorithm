package brutforce.nandm;
// 두번째 줄에 들어온 수를 오름차순으로 배열 해놓고 중복 없이 수열 출력 

import java.util.*;
import java.io.*;

public class B15654_N과M_5 {
	
	static int input[] ; // 둘째 줄에 들어온 수들 넣을 배열
	static int output[] ; // 출력 배열 
	static boolean visit[]; // 중복없이 처리 하기 위해 사용하는 배열 
	
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
		visit = new boolean[n]; // 앞의 N과M가 다른 점은 1부터 차례대로 넣는게 아니라 입력 받은 수를 넣는 것이므로 i=1부터 생각할 필요 없음 
		
		st = new StringTokenizer(br.readLine()); // 둘째 줄 읽어오기(새로운 객체 만들어서 읽어오면 됨) -> sc.nextLine()와 같은 것 
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken()); // 둘째 줄 수들 공백 기준으로 int배열에 넣기 
		}
		
		Arrays.sort(input); // 오름차순으로 정렬 후 , 이 배열을 수열로 출력할때 사용 할 것 
		
		dfs(0,n,m,input);
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
