package greedyalgorithm;

import java.io.*;

public class B1541_�Ҿ������ȣ {
	public static void main(String[] args) throws IOException {

		// - ������ ���� - ���� + �ϴ� �� �ݺ��ϸ� �� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine(); 
		// ���ڵ��� ���� ���� �޴°� �����ϱ� + �� - �������� split�޼ҵ�(StringŬ����) ��� 

		String[] minusDiv = input.split("\\-");
		int[] plusDiv = new int[minusDiv.length];
		int output = 0;
		
		for(int i = 0 ; i < minusDiv.length  ; i ++) {
			String[] tmp = minusDiv[i].split("\\+");
			for(int j = 0 ; j < tmp.length ; j++) {
				plusDiv[i] += Integer.parseInt(tmp[j]);
			}
			
			if(i == 0) output = plusDiv[i];
			else output -= plusDiv[i];
		}
		
		System.out.print(output);
		br.close();

	}
}
