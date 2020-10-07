package brutforce.nandm;

// �ߺ��ؼ� ���ڴ� ���͵� �ǹǷ� visit�迭�� �ʿ������, output���� ��, �����ؼ� �־������ (2)��ó�� 
import java.io.*;
import java.util.*;
public class B15652_N��M_4 {

	
	static int[] output ;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void dfs(int index, int n, int m) throws IOException {
		
		if(index == m) {
			for(int i = 0 ; i < m ; i ++) {
				bw.write(String.valueOf(output[i]));
				if(i != m-1) bw.write(" ");
			}
			bw.newLine();	
		}
		else {
			for(int i = 1; i <=n ; i++) {
				output[index] = i;
				if(index == 0 || index > 0 && output[index-1] <= output[index])
					dfs(index+1 , n, m);
			}
		}				
	}
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		output = new int[m];
		
		dfs(0,n,m);
		
		br.close();
		bw.flush();
		bw.close();
		
		
	}
}
