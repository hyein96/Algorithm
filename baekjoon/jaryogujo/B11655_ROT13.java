package jaryogujo;

import java.util.Scanner;

public class B11655_ROT13 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		char[] c ; // ���� ���ڿ� �� ���ھ� ������ �����ϴ� ���� 
		String answer = "";
		String s ;

		s = sc.nextLine();
		
		c = s.toCharArray();
		
		for(int i = 0 ; i < c.length ; i++) {
			// �����̰ų� �����϶�
			if(c[i] == ' ' || ('0' <= c[i] && c[i]<= '9') ) continue;
			
			// �ҹ���,�빮���϶��� 13 �����ְ�, z�� �Ѿ�� a�� ���ư��� �ϹǷ� ���ĺ� �� ��ŭ ���ֱ�
			else if('a'<= c[i] && c[i] <= 'z') {
				c[i] = (char) (c[i]+13);
				if(c[i]> 'z') {
					c[i] = (char)(c[i] -('z'-'a'+1));
				}
			}
			else if('A'<= c[i] && c[i] <= 'Z') {
				c[i] = (char) (c[i]+13);
				if(c[i]> 'Z') {
					c[i] = (char)(c[i] -('Z'-'A'+1));
				}
			}	
		}
		
		for(int i = 0 ; i< c.length ; i ++) {
			answer += c[i];
		}
		
		// �ڹٿ��� ����Ʈ�ÿ� ū ����ǥ�� ���� ���� ��� ���������� �ν� (ū ����ǥ�� ������ ���ڿ��̶� �����ϰ� �״�� ���)
		// ���ڿ��� ������ ���� �� + �� ���� 
		// ""�� + �� �������� int�� ���� �Ǵ� ���ڵ� ���ڿ��� �ν� �ѵ� �ܼ��� ���ڿ� ��ġ�⸦ �ϹǷ� �� �����ؼ� �ڵ� ¥�� 
		System.out.print(answer);
		
	}
}

