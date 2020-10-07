package dynamicprogramming;

import java.io.*;

public class B9095_123���ϱ� {
	// ���̳������α׷������� �迭 �����س��� ū ���� ���� ���� ���� �̿��ؼ� ���ϱ� --> ��ȭ�� ���ϸ� �� 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		// n�� ������ 1���� 10���� �ε�, ��� ��츦 �� ���ϴ°� ��ȿ����(n�� Ŭ���� ȿ�� ������) --> ������ ���� ���� ���
		for(int i = 0 ; i < testNum ; i ++) {
			int input = Integer.parseInt(br.readLine());
			int[] dp = new int[input + 1];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for(int j = 4; j <= input ; j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			}
			System.out.println(dp[input]);
		}
	
		br.close();
	}

}
// ��Ŭ���������� ����ǳ�, ���ؿ��� �������� �迭��������� ��Ÿ�� ���� �ȳ�(dp�迭�� ������ �������� �����������)
// �������� �Ź� dp�迭 �����ϸ� ��Ÿ�� ������ 