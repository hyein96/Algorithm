package jaryogujo;

import java.util.*;
import java.io.*;

public class B17299_����ū�� {
// (�� ����) ������ Ƚ�� �迭 �ϳ� �� ���� ���� Ƚ�����ϴ� �ڵ� ���� ������ ��, 
//	�� ���Ŀ��� ��ū��ó�� �ε���Ȱ���� input���� �ƴ� ����Ƚ�� ������ ���ؼ� �ڵ� « --> �ð��ʰ�
	
/* �ַ�� : ������ Ƚ�� �迭�� ����°� ���� .
  but ��� ���� ���� ����Ƚ�� ���ϴ� �ڵ带 ¥�°� �ƴ϶� ������ ���ڰ� ��� ���Դ����� ���ϸ� �� (�� �ٸ� �߰�)
*/
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int[] input = new int[num];
		int[] cntNum = new int[1000001]; // ������ ��(������ ����)�� ũ��� 1���� 1000000�̹Ƿ� ũ�� 1000001�� ����  
		int[] output = new int[num];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < num ; i++) {
			input[i] = Integer.parseInt(st.nextToken()); // ������ �� 
			cntNum[input[i]] ++; // �������� ���� ���ڵ��� cntNum ���� 0��(�⺻�� : 0) --> �̰͸� �߰����ָ� �� 
		}
		
		
		// ��ū���� �����ϰ� ���ؼ� stack
		
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
			// ���� bw�� string�� �ν��ϹǷ� String.valueOf(output[i]+" ")�� �ϴ°� ����(output�� int�̱� ����) 
			bw.write(output[i] + " ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}

/* ó�� �ڵ�(����Ƚ�� ���ϴ� �ڵ�) -> �ð��ʰ� 
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
