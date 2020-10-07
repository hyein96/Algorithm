package greedyalgorithm;

import java.io.*;
import java.util.*;

public class B1049_��Ÿ�� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int need = Integer.parseInt(st.nextToken()); // �ʿ��� ��Ÿ��
		int brandNum = Integer.parseInt(st.nextToken()); // �귣�� ����

		int[][] price = new int[brandNum][2]; // 6�� ��Ű��, ���� ����
		for(int i = 0 ; i < brandNum ; i++) {
			st = new StringTokenizer(br.readLine());
			price[i][0] = Integer.parseInt(st.nextToken()); // �� �귣�忡 6���� ��Ű�� ����
			price[i][1] = Integer.parseInt(st.nextToken()); // ���� ����
		} 
		
		// �������迭�� 6����Ű������ �迭�̶� �������� �迭 ���� �����ؼ� �޾ƿͼ� ���ص� ��
		// for������ ������ ���� �� �� ���ϰ� sort�� ������ �� ��, 0��° �ε��� �����͵� �� 
		
		int sixMin = price[0][0]; // 6���� ��Ű�� �� ���� ������ ����
		int min =  price[0][1];// ���� �� ���� ������ ����

		if(brandNum != 1) { // ���� ���� ���� ���� 
			for(int i = 1 ; i < brandNum ; i ++) {
				sixMin = Math.min(sixMin, price[i][0]);
				min = Math.min(min, price[i][1]);
			}
		}

		// �������� 0�϶��� �ƴ� ���� ������ �� �ʿ䰡 ���°� �������� 0�̸� 6���� ��Ű���� ������ ������ �� ���ϴ� ���� ���� �� ����

		// int output = Integer.Max_VALUE; �� ���� ū ������ ���� �س��� �� 
		int output = Math.min(min * need, sixMin * (need/6 +1));
		output = Math.min(output, sixMin*(need/6) + min*(need % 6));

		System.out.print(output);
		br.close();
	}
}
