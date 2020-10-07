package suhak;

import java.util.Scanner;

//��ȿ������ ��� ������? 
public class B17087_���ٲ���6 {
	
	public static void main(String[] args) {
		
		// ��� ��������� �������� �ִ� ������� ���ϸ� �� , 
		// �� 3���̸� 3�� ������ �ִ����� 4���̸� 4�������� �ִ�����...
		Scanner sc = new Scanner(System.in);
		
		int lowerNum = sc.nextInt(); // ���� ��
		int sLocat = sc.nextInt() ; // ���� ��ġ 
		int[] lLocat = new int[lowerNum]; // ������ ��ġ
		int[] distance = new int[lowerNum]; // ������� �������� �Ÿ�
		
		
		for(int i = 0 ; i < lowerNum ; i++) {
			lLocat[i] = sc.nextInt();
		}
		
		for(int i = 0  ; i <lowerNum ; i ++) {
			distance[i] = (lLocat[i]>sLocat ? lLocat[i]-sLocat : sLocat-lLocat[i]);
		}
		

		int GCD = distance[0]; // ó���� �ִ����� ��, �ȴ°Ÿ��� �����Ѹ���� ���̷� �ʱ�ȭ 
		for(int i = 0 ; i< distance.length ; i ++) {
			
			GCD = gcd(distance[i],GCD);
			
		}
		// ������ �������� ��ġ�� �ٸ���, �������� ��ġ�� ���� �����Ƿ� distance�� 0�ΰŴ� ���� ���ص� ��
		System.out.print(GCD);
		
		
		
	}
	
	static int gcd(int a, int b) {
		int r = a % b;
		if(r == 0) return b;
		else return gcd(b,r);
	}
}
