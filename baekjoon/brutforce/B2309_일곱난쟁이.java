package brutforce;

import java.io.*;
import java.util.Arrays;

// ��üŽ���ؾ��� ! �迭�� ������������ ���� �� ��, 7���϶� ¥���� ,�� ��� �� ������ �� ���غ��� 100�� �Ǹ� ���
// ��üŽ���� dfs(���̿켱Ž��)���� �� �������鼭 Ž���ϱ� --> N��Mó��(����Լ� �̿�) : N��M�� ������ �ǹ� 
// ������ ������ ���������� ��쿡�� �ƹ��ų� �Ѱ� ��� �ϹǷ�, boolean���� �̿��ؼ� �Ѱ� ��� �� ������ �� �ڴ� ������ �ʰ� �Լ� return ����
public class B2309_�ϰ������� {
	
	static boolean[] visit = new boolean[9];
	static int[] input = new int[9] ; // �־����� ��ȩ�����̵��� Ű
	static int[] output = new int[7];
	
	static boolean isFirst = true ; // first�� true�̸� first�� �� �� ����ϰ� ������(�Լ�������) 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < 9 ; i ++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input); // �迭�� ������������ ����
		
		seven(0);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	static void seven(int index) throws IOException {
		
		if(!isFirst) return; 
		// !isFirst �� true�� �Ǹ�(��, isFirst�� false�� �Ǹ�) seven�Լ� return�Ǹ�  ���� ��� �� �� ����  
		
		if(index == 7) {
			int sum = 0;
			for(int i = 0 ; i < 7 ; i ++) {
				sum += output[i];
			}
			if(sum == 100) {
				for(int i = 0 ; i < 7 ; i ++) {
					bw.write(String.valueOf(output[i]));
					bw.newLine();
				}
				isFirst = false ; // �ѹ� ����ϰ� ���� isFirst�� false�� �ٲ�� ù��° ��� �� ����
			}
		}
		
		else {
			for(int i = 0 ; i < 9 ; i ++) {
				if(visit[i]) continue; // boolean�� �⺻ ���� false
				visit[i] = true; 
				output[index] = input[i] ; 
				if(index == 0 || index > 0 && output[index-1] < output[index]) {
					seven(index+1) ; 
				}
				visit[i] = false;
			}
		}
	}
}

