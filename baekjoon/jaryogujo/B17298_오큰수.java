package jaryogujo;

import java.io.*;
import java.util.*;

//(�� ����) ���������� ����for�� ���� ������ ���ؼ� ����ϸ�(��üŽ��) ���� ������ �ð��ʰ���(BufferedReader �ᵵ) --> Stack Ȱ���ؼ� Ǯ��

/* �ַ�� :�� ��ü�� �ƴ� �ε����� Ȱ���ؾ� �ϴ� ���� !!!!(�迭) + ���� 

* ��°��� ���̰� ���ϴ� ���� �ƴ� ������ num ������ �������ְ�, �ε����� Ȱ���ؼ� ������ Ǯ��� �ϹǷ� output�� stringbuilder�� �ƴ� �迭�� ����
* �Է°��� �迭�� �޾Ƽ� ù��° �ε������� stack�� �־ �� ���� ���̶� ���� ��, ũ�� output���� ����(�ε���Ȱ���ؼ�) output���� ���� �ε����� ���ÿ��� pop
* ���� ������ ������ ���ÿ� �ش��ϴ� �ε��� �׳� ���ΰ� ���� ��° �ε��� �� �� 
* �������� ���ÿ� �����ִ� �ε����� output�� -1 �� �ٲٸ� ���
* ---> �ε��� Ȱ���ؼ� Ǫ�� �� solution   
*/

public class B17298_��ū�� {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		int num = Integer.parseInt(br.readLine());
		int[] input = new int[num];
		int[] output = new int[num];

		/* split(" ") �̿��ؼ� input �����ص� ��
		 String temp[] = br.readLine().split(" "); �� �Ŀ� input ���� ��
		 input[i] = Integer.parseInt(temp[i]); �� �ϸ� �� 
		 */
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < num ; i ++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> s = new Stack<Integer>();

		s.push(0); // ���� ù��° �ε��� ���� push

		for(int i = 1 ; i < num ; i ++) {

			//if(s.isEmpty()) s.push(i); --> �ڵ� �����ص� �Ǵ� ���� : for���� ���ö� ������ ������� ��찡 ���� X

			// if�� �ƴ� while�� ���� ������ �ٷ� ���� ���ڸ� ���ϴ°� �ƴ϶� �����ʿ� �ִ� ��� ���� ����ؾ� �ϹǷ� while ���� �� 
			// ��ū�� : �����ʿ� �����鼭 �ڱ⺸�� ���� ū �� ��!! ���� ���ʿ� �ִ� �� 
			// stack�� ����ٴ°� �� index�� �� output�� ä���ٴ� ���̹Ƿ� while�� ������ ��  
			while(!s.isEmpty() && input[s.peek()] < input[i]) { 

				output[s.pop()] = input[i];
			}

			s.push(i);

		}

		while(!s.isEmpty()){
			output[s.pop()] = -1;
		}

		for(int i = 0 ; i < num ; i++) {
			// ���� bw�� string�� �ν��ϹǷ� String.valueOf(output[i]+" ")�� �ϴ°� ����(output�� int�̱� ����) 
			bw.write(output[i] + " ");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}

/* ó�� �� �ڵ�(�ð��ʰ�)
for(int i = 0 ; i < num ; i ++) {
			if(i == num-1) {
				output.append(-1);
				break;
			}
			for(int j = i+1 ; j < num  ; j ++) {

				if(input[i] < input[j]) {
					output.append(input[j]+ " ");
					break;
				}

				else if(input[i] >= input[j] && j == num-1) {
					output.append(-1 + " ");
				}

				else continue;
			}
		}
 */