package jaryogujo;

import java.util.Scanner;

public class B10808_���ĺ����� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input ; 
		int alNumber[] = new int ['z'-'a'+1];
		
		// ��°� �ϴ� 0 ���� �� ����� 
		for(int i = 0 ; i< alNumber.length ; i++) {
			alNumber[i] = 0 ; 
		}
		
		input = sc.next();
		
		for(int i = 0 ; i < input.length() ; i ++) {
			char c = input.charAt(i); // �ѱ��� ������
			alNumber[c-'a'] ++ ;  // ��¹��ڿ����� a�� �ε����� 0 b�� �ε����� 1... �̹Ƿ� 
			                      // ���� ���ڿ��� 'a'�� �ƽ�Ű�ڵ� �� ���� ��¹��ڿ��� �ش� ���ڿ� �ε����� �� 
		}
		
		for(int i = 0 ; i< alNumber.length ; i ++) {
			System.out.print(alNumber[i]+ " ");
		}
	}

}
