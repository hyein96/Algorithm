package brutforce.sunyeol;

// 중복없이 6개 맞춰서 출력하는 걸로 코드 짜야할 것(n과m처럼 ) -> 다음 순열 구하는 걸로하면 중복이 생김
import java.io.*;
import java.util.*;

public class B6603_로또 {
	
	static int[] input;
	static boolean[] visit;
	static int[] output = new int[6] ; // 로또는 6개를 골라야 하므로 output은 항상 크기가 6
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) { // 줄의 첫번째가 0이면 while문을 빠져나가면 됨(stringtokenizer 사용해도되고, split사용해도되고)
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			else {
				input = new int[n];
				visit = new boolean[n];
				for(int i = 0 ; i < n ; i++) {
					input[i] = Integer.parseInt(st.nextToken());
				}
			
				lotto(0,n);
				bw.newLine();
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void lotto(int index, int n) throws IOException {
		if(index == 6) {
			for(int i = 0 ; i< 6 ; i++) {
				bw.write(String.valueOf(output[i]));
				if(i != 5) bw.write(" ");
			}
			bw.newLine();
		}
		else {
			for(int i = 0 ; i < n; i++) {
				if(visit[i]) continue;
				else {
					visit[i] = true;
					output[index] = input[i];
					if(index == 0 || index > 0 && output[index-1]<output[index]) {
						lotto(index+1, n);
					}
					visit[i] = false;
				}
			}
		}
	}
	
	
}
