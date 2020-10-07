package greedyalgorithm;

import java.util.*;
import java.io.*;

public class B1120_���ڿ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken(); // A �޾ƿ���
		String B = st.nextToken(); // B �޾ƿ���

		// (2�������) 2��for�� ��� 
		int output = A.length(); // �� ���� ���ڿ��� �ִ� �ȸ´� ���� A�� ���̸�ŭ ��, max�� A�� ����
		int diff = B.length()-A.length(); // ����
		int tmp = 0;

		for(int i = 0; i <= diff ; i++) {
			for(int j = 0 ; j < A.length() ; j++) {
				if(A.charAt(j) != B.charAt(i+j)) tmp++;
			}
			output = Math.min(output, tmp);
			tmp = 0;
		}
		System.out.print(output);
		return;
	}
}

/*
 * ����for���� �ƴ� while�� ����ϸ� �ð��� �پ� �� �� �־ ������ �ʹ� ���� �����ؾ� �ؼ� �ڵ尡 ����
// (2�������) substring���� �κй��ڿ��� ���ͼ� ���ϴ� ��� 
			int output = A.length(); // �� ���� ���ڿ��� �ִ� �ȸ´� ���� A�� ���̸�ŭ ��, max�� A�� ����
			int diff = B.length()-A.length(); // ����
			int tmp = 0;

			for(int i = 0; i <= diff ; i++) {
				String subB = B.substring(i,A.length()+i);
				for(int j = 0 ; j < A.length() ; j++) {
					if(A.charAt(j) != subB.charAt(j)) tmp++;
				}
				output = Math.min(output, tmp);
				tmp = 0;
			}
		}
 */
/* ó�� �� ���� : ���̶� �ڶ� ���� ������ �ΰ��� ��츦 ���� �� �ߴµ� ������ �о�� ���̶� �� ���ÿ� �߰� �� �� ������(�� ���ΰ� �ƴ�)  
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());

String A = st.nextToken(); // A �޾ƿ���
String B = st.nextToken(); // B �޾ƿ���

int frontMin = 0;  // �տ� ������
int backMin = 0; // �ڿ� ������
//int output = 0 ; //  ��

for(int i = 0 ; i < A.length() ; i++) { 
	if(A.charAt(i) != B.charAt(i)) {
		backMin++;
	}
}

if(A.length() == B.length()){
	System.out.print(backMin);
	return;
}
else {
	int diff = B.length()- A.length();
	for(int i = diff-1 ; i >= 0 ; i--) {
		A = B.charAt(i) + A;
	}
	for(int i = 0 ; i < A.length() ; i++) { 
		if(A.charAt(i) != B.charAt(i)) {
			frontMin ++;
		}
	}
	System.out.print(Math.min(frontMin, backMin));
	return;
}
 */