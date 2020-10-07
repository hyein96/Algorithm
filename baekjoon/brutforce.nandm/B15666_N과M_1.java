package brutforce.nandm;

import java.util.Scanner;
// �ַ�� : BFS�˰��� Ȱ�� (�� ��� ������ ���� �켱���� �� ������ ����ϰ� ����Ұ� ������ ��Ʈ��ŷ���� ���� ���� �ٲ�)
// DFS�� ����Լ��� ¥�� ! 
public class B15666_N��M_1 {

	// main�̶� dfs�Լ����� �پ��� �������� static���� ��������� ��� ���� 
	
	static boolean[] visit ; // ���ڿ� �湮 �ߴ��� ���ߴ��� Ȯ���ϴ� ���
	// ���ڰ� �ߺ� �ȵǰ� �Ϸ��� �ʿ� , n�� ũ�⸸ŭ �ʿ��ѵ�  1���� �����ؼ� n�����Ƿ� �迭ũ��� n+1�ʿ�(�ε��� 0�����̹Ƿ�)
	static int[] output ; // �� �ٿ� ����� ���ڵ� (m�� ũ�⸸ŭ)
	
	static void dfs(int index, int n, int m) 
	{ 
		if (index == m) { // �� �ٿ� m���� �� ä��� (output��)
			for (int i = 0; i < m; i++) {  // m�� ���
				System.out.print(output[i]); 
				if (i != m - 1) //����ϴ� ���� m��° ��,������ ���̸� ���� �� �ʿ���� �ٷ� �ٹٲ� 
					System.out.print(" "); // ���� �ֱ�  
				} 
			System.out.println(); 
			} 
		else {	
			for (int i = 1; i <= n; i++) {
				// boolean �⺻���� false 
				if (visit[i]) { // �湮�� ����̸� (��, output�� �Էµ� �����)
					continue; 
				}
			
				visit[i] = true; // �湮�Ѱɷ� �ٲٰ�
				output[index] = i; // ��¿� �־��ֱ� 
				dfs(index + 1, n, m); // ���� ��� �� �־��ֱ� ���� ����Լ� ���
				visit[i] = false; // ����� �Ŀ��� output�� �A�� �̹Ƿ� �湮���� ���� ��尡 ��
			                  // �����ָ� ���� ��� �ٺ��ʹ� i��� ���ڸ� ��� ���� 
			} 
		}
	}
	public static void main(String[] args) { 
		
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int m = sc.nextInt();
		
		visit = new boolean[n+1];
		output = new int[m];
		
		dfs(0, n, m); 
	}

}
