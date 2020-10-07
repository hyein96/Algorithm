package suhak;

import java.util.Scanner;

public class B1929_�Ҽ����ϱ� {

	public static void main(String[] args) {
		//�����佺�׳׽��� ü �̿� 
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int prime[] = new int[n+1]; // �ε����� 0���� �����ϹǷ�(�Ҽ� �迭)

		
		
		//1���� n������ �Ҽ������� �����佺�׳׽��� ü�� �̿��ؼ� ���ϰ�, m���� n������ �Ҽ����� ���� ���
		prime[0] = prime[1] = 0 ; // 0�� 1�� �Ҽ��� �ƴϹǷ� -> �Ҽ��� �ƴ� ���� �� 0���� ��ȯ 
		for(int i = 2 ; i <= n ; i ++) { // �Ҽ��迭�� ����, ������ ���� ���� 
			prime[i] = i ;
		}
		
		//�����佺�׳׽��� ü 
		for(int i = 2 ; i <= n ; i ++) {
			if(prime[i] == 0) continue;
			for(int j = i * 2 ; j <= n ; j += i) { // n *2 ���� �����ؼ� n�� ��� ���� 
				prime[j] = 0 ;
			}
		}
		
		for(int i = m ; i <= n ; i++) {
			if(prime[i] != 0) 
				System.out.println(i);
		}
		
	}
}

/* �ð��ʰ����� �ڵ�
Scanner sc = new Scanner(System.in);

int m = sc.nextInt();
int n = sc.nextInt();

for(int i = m ; i <= n ; i ++) {
	int count = 0 ; 
	for(int j = 1 ; j <= i ; j ++) {
		if(i % j == 0 ) count ++;
		
	}
	if(count == 2) System.out.println(i);
}
*/