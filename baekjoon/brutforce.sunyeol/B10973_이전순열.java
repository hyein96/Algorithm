package brutforce.sunyeol;

import java.util.*;
import java.io.*;

public class B10973_�������� {
	public static void main(String[]args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input  = new int[n];
		// �Է� �ޱ� 
		for(int i = 0 ; i < n ; i ++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		// �������� �ַ�� 
		boolean first = true; // true�� ���� ������ ���� ó���� ���� ���� ��, ���� ���� ���� 
		for(int i = n-1 ; i > 0 ; i --) {
			if(input[i] < input[i-1]) {
				first = false; // ���� ó���� ���� ���� �ƴ�  
				for(int j = n-1 ; j >= 0 ; j--) {
					if(input[j] < input[i-1]) {
						//swap�ϱ� 
						int temp = input[j];
						input[j] = input[i-1];
						input[i-1] = temp;
						break;
					}
				}
				int k = n-1; // k�� �� ������ �� 
				while(i < k) {
					int temp2 = input[k];
					input[k]= input[i] ;
					input[i] = temp2;
					i++;
					k--;
				}
				break; // 2��° for�� ����
			}
		}
		
		if(first) bw.write(String.valueOf(-1));
		else {
			for(int i = 0 ; i < n ; i ++) {
				bw.write(String.valueOf(input[i]));
				if(i != n-1) bw.write(" ");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
