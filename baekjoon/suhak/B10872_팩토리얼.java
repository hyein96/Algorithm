package suhak;

import java.util.Scanner;

public class B10872_���丮�� {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int answer = 1; // ������ ������ 0���� 12�� int�� �����Ѱ�,�� ũ�� long���� �ٲ�� �� 
		
		if(number == 0) System.out.print(1);
		else {
			for(int i = 1 ; i <= number ; i++) {
				answer *= i;
			}
			System.out.print(answer);
		}
	}
////////////////////////// ��ͷ� Ǯ��� //////////////////////////
}
