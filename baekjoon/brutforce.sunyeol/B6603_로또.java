package brutforce.sunyeol;

// �ߺ����� 6�� ���缭 ����ϴ� �ɷ� �ڵ� ¥���� ��(n��mó�� ) -> ���� ���� ���ϴ� �ɷ��ϸ� �ߺ��� ����
import java.io.*;
import java.util.*;

public class B6603_�ζ� {
	
	static int[] input;
	static boolean[] visit;
	static int[] output = new int[6] ; // �ζǴ� 6���� ���� �ϹǷ� output�� �׻� ũ�Ⱑ 6
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) { // ���� ù��°�� 0�̸� while���� ���������� ��(stringtokenizer ����ص��ǰ�, split����ص��ǰ�)
		
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
