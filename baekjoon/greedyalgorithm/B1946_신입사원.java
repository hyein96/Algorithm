package greedyalgorithm;

import java.io.*;
import java.util.*;

public class B1946_���Ի�� { 
	// ���� �� ���� : ���� ���������ϰ�, �� ������� ���� ����� ���� �ֵ��� �� ���� ����� ������ ������ Ȯ�� (������ ���߰���)
	// �ַ�� : ��������� ������ �Ź� ������ �˻��������� ����� ���� ���� �ֺ���  �������� Ȯ��(max ������ ����) 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� ��

		while(testCase > 0) {
			int people = Integer.parseInt(br.readLine());
			int[][] score = new int[people][2];
			int pass = 0;

			for(int i = 0 ; i < people ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				score[i][0] = Integer.parseInt(st.nextToken()); // �����ɻ� ����
				score[i][1] = Integer.parseInt(st.nextToken()); // ��������
			}

			Arrays.sort(score, new Comparator<int[]>() { // ���� ������������ ������
				@Override
				public int compare(int[] start, int[] end) {
					return start[0]-end[0]; // �����ɻ� ���� �������� ��������(����� ���� ������ ����)
				}
			});

			pass ++; // ù��° ����� 1���� �����Ƿ� ������ �հ� ����
			int interviewMin = score[0][1]; // ��������� ���� ���� ��(���ڴ� ���� ����)�� �������
			for(int i = 1 ; i < people ; i++) {
				if(score[i][1] < interviewMin) pass++;
				interviewMin = Math.min(interviewMin, score[i][1]);
			}
			/*���� ������(�ð� �ʰ�)
			 * for(int i = people-1  ; i > 0 ; i--) { 
				pass = 0;
				for(int j = i-1 ; j >= 0 ; j-- ) {
					if(score[i][1] < score[j][1])  pass ++; // ����� ������ �̱��(��,���ڴ� �۾ƾ� �̱��)
					else break;
				}
				if(pass == i) output ++;
			}*/
			System.out.println(pass);
			testCase--;
		}
	}
}
