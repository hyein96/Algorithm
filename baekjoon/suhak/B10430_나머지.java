package suhak;

import java.util.Scanner;

public class B10430_������ {
	
	public static void main(String[] args) {
	//���� �����ص�, ������ �� �������ִ°��� ����ϴ� �� ����(���� ���������ؼ� ���� �� ,����� �ʿ����)
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // nextInt�� ���� �������� ����
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println((A+B)%C);
		System.out.println( (A%C + B%C)%C);
		System.out.println((A*B)%C);
		System.out.println((A%C * B%C)%C);
			
	}
	

}
