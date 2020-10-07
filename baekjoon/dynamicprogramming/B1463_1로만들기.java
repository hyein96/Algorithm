package dynamicprogramming;
// ���̳������α׷��� : ū������ ���� �������� ����(��������)�� ����� �ذ�
// ������ ���س������� �迭�� ������ ���� �Ź� ���������ʰ� ������ Ǫ�� ��� 

import java.io.*;
import java.util.*;

//���̳������α׷��� �������� top-down(����̿�) / bottom -up(�ݺ����̿�) ��� �ΰ� ����
// �Ѵ� ���������� �迭���� �����س��� ����ϴ� DP������� ǰ 
public class B1463_1�θ���� {
	
	public static void main(String[] args) throws IOException {

	// 1. Bottom-up���(�ݺ����̿�) : ���� ��(1)���� �־��� �� ���� �Ʒ����� ���� �ö󰡸� ���ϴ� ���
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int input = Integer.parseInt(br.readLine());
	int dp[] = new int[input + 1]; // dp�迭 (�ش� ���� 1�� �ɶ����� �ּ� ���갪)
	dp[0] = 0 ; 
	dp[1] = 0 ; // 1�� �Ǹ� ��
	
	for(int i = 2 ; i < input + 1 ; i++) {
		dp[i] = dp[i-1] + 1; // 1�� ���°� ��� ���� �����ϹǷ� ��� ���� �⺻���� ��������(�ڿ��� �� ���� ���� �� ���� dp�� ��)
		if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
		if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
	}
	
	System.out.print(dp[input]);
	br.close();
		
	} 
	
	
	/* 2. Top-down���(����̿�) --> �ð� ���� ���� �ɸ� 
	
	static int dp[] ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		dp = new int[input+1];
		dpCalculate(input);
		System.out.print(dp[input]);
		br.close();
	
	}
	
	static int dpCalculate(int num) { // ����Լ� ���
		if(num == 1) return 0 ; // 1�̸� ��
		if(dp[num] > 0) return dp[num] ; // 0���� ũ�ٴ� �� �̹� ��� �� �� 
		
		dp[num] = dpCalculate(num - 1) + 1; // ���⿡ ������ num���� ���� ������ dp���� �� ����� �Ǽ� ���� (����̹Ƿ�)
		if(num % 2 == 0) {
			dp[num] = Math.min(dp[num], dp[num/2] +1);
		}
		if(num % 3 == 0) {
			dp[num] = Math.min(dp[num], dp[num/3] +1);
		}
		
		return dp[num];
	}
	*/
	
	

}

/* (���̳������α׷��� ��� x) 
 * ��Ǯ�� : ť �����ؼ�, �湮�ߴ��� ���ߴ��� Ȯ�� �ϸ� ������ ��� �� ť�� �����鼭 1�� �ɶ����� Ƚ���÷�����  �ݺ�   
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int output = 0 ; 
		int[] visit = new int[input+1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(input);
		visit[input] = 1; // �湮��
		
		while(!q.isEmpty()) {
			
			int x = q.poll();
			if(x == 1) break;
			
			if(x % 2 == 0 && visit[x / 2] == 0) {
				q.offer(x / 2);
				visit[x/2]  =  visit[x] + 1 ;  
			}
			if(x % 3 == 0 && visit[x / 3] == 0) {
				q.offer(x / 3);
				visit[x/3]  =  visit[x] + 1 ;  
			}
			if(visit[x -1] == 0) {
				q.offer(x-1);
				visit[x-1]  =  visit[x] + 1 ;  
			}
		}
		
		output = visit[1] - 1 ;
		System.out.print(output);
		
		br.close();
*/
