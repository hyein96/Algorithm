package greedyalgorithm;

import java.io.*;
import java.util.*;

public class B2875_��ȸor���� {

	// �ַ�� : ����, ������ ���л��� ���л����� ���� �� �ִ� ���� ���� �� ���� ���� �� ���� ����
	// ���� ����� ���� ���л�,���л��� �������� ���� (���ϼ� - ���� ��� ��) 
	// ���µ��� ���� ���� ������, �� ���� ���� ��ü�ϰ�(-3) �׸�ŭ �� �������� ����(���� ���� 0���ϰ� �ɶ����� �ݺ�)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[3];

		for(int i = 0; i <3 ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int teamNum = Math.min(input[0] / 2 , input[1] / 1); 
		int intern = input[2] - ((input[0]- teamNum*2) + (input[1] - teamNum)); // �� �����ϰ� ���� �ֵ� ��������

		while(intern > 0 ) {
			if(teamNum < 0) { // -�� ���� ����(���� ����� ��)
				teamNum = 0;
				break;
			}
			teamNum --;
			intern -= 3;
		}
		System.out.print(teamNum);
		br.close();
	}
}
