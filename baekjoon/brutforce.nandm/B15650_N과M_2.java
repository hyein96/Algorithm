package brutforce.nandm;

import java.util.Scanner;

//1���̶� �ٸ� ���� �� ������ ���������̿��� �Ѵٴ� �� 

public class B15650_N��M_2 {

	static boolean[] visit ; // ���ڿ� �湮 �ߴ��� ���ߴ��� Ȯ���ϴ� ���
	// ���ڰ� �ߺ� �ȵǰ� �Ϸ��� �ʿ� , n�� ũ�⸸ŭ �ʿ��ѵ�  1���� �����ؼ� n�����Ƿ� �迭ũ��� n+1�ʿ�(�ε��� 0�����̹Ƿ�)
	static int[] output ; // �� �ٿ� ����� ���ڵ� (m�� ũ�⸸ŭ)
	
	static void dfs(int index, int n, int m)  // dfs�Լ��� static�� ������� main�Լ����� dfs�Լ� ȣ�� ����
	{ 
		if (index == m) { // �� �ٿ� m���� �� ä��� (output��)
			for (int i = 0; i < m; i++) {  // m�� ���
				System.out.print(output[i]); 
				if (i != m - 1) //����ϴ� ���� m��° ��,������ ���̸� ���� �� �ʿ���� �ٷ� �ٹٲ� 
					System.out.print(" "); 
				} 
			System.out.println(); 
			//return;  // return ����� �ؿ� for�� ���� �Ƚ�Ű��  dfs �������� ! ��ȯ���� void�Ƿ� return; �� ���ָ� �� --> ����� �ؿ� �ڵ� else�� ���� 
		} 
		else {
			for (int i = 1; i <= n; i++) {
			
				if (visit[i]) { 
					continue; 
				}
			
				// �� 2���� �ؿ��ִ� if�� �ȿ� ������ ����ȵ�
				// output���޾Ƽ� �񱳸� �ѵ�, ����Լ��� ������ �����ؾ��ϴµ� if�� �ȿ� ������ output[index] ���� ���� ���� 
				visit[i] = true;
				output[index] = i; 
			
				// N��M(1) �� �ٸ��� �� �� ! 
				if(index == 0 || index > 0 && output[index-1]<output[index]) {
					dfs(index + 1, n, m); 
				}
				visit[i] = false;             
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
