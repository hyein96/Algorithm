package suhak;

import java.util.Scanner;

public class B2609_�ִ��������ּҰ���� {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int min = (a <= b)? a:b ;
		int GCD = 1 ; 
		int LCM = 0 ; // ������ a�� b�� ������ ���� �ڷ��� �� �����ؾ��� (int�Ѿ�� long����)
		
		//������� �� ���ִ� �� �� ���� ū ���� �� �� �� �������̹Ƿ� ������ ���� ���� ���� 
		for(int i = 1 ; i <= min ; i++) { // �Ѵ� �Ҽ��� �ִ����� 1�ϼ��� ���� 
			if(a % i == 0 && b % i == 0) 
				GCD = i;
		}
		
		LCM = GCD * (a / GCD) * (b / GCD); // for���� �ȵ��� GCD���� �������� �����Ƿ� ó�� ������ �� �⺻������ �ʱ�ȭ ������� 
		
		System.out.println(GCD);
		System.out.println(LCM);
		
		
		
	}
}
