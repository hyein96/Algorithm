package suhak;

import java.util.Scanner;

public class B1934_�ּҰ���� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder answer = new StringBuilder(); // �Ѳ����� ��� ���� 
		int testcase = 0 ; // �׽�Ʈ���̽�
		int first ;
		int second;
		int LCM = 0 ; // �� ������ ������ int�� ���� , int�� �ȵ� �� long���� �ڷ�������
		// �ƴϸ� ,�ּҰ������ ������ �������� �׳� �ٷ� ��� ! (�ڷ��� ���� �ʿ����)
		
		testcase = sc.nextInt(); // next()�� ���ڿ� �޾ƿ��� �� 
		
		for(int i = 0 ; i < testcase ; i ++) {
			
			first = sc.nextInt();
			second = sc.nextInt();
			int GCD = 1;
			
			for(int j = 1 ; j <= ((first <= second)? first:second) ; j++) {
				if(first % j == 0 && second % j == 0)
						GCD = j;
			}
			
			LCM = GCD * (first/GCD) *(second/GCD);
			answer.append(LCM+"\n"); // StringBuffer�� �ȳְ� �׳� �ٷ� ��� �ص� �� 
		}
		
		System.out.print(answer.toString());
		
	}

}
/* ��Ŭ���� ȣ���� �̿� --> �ð� �� ȿ���� !!!!!!!!
 public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int gcd = gcd(a, b);
            System.out.println(a * (b / gcd));// �ּҰ������ �� ���� �ִ������� ���� ���� �ִ����� ���Ѱ��̹Ƿ�
                                              // �����ϸ�, �Ѱ� �� * �ٸ���/�ִ����� 
        }
    }

   static int gcd (int a, int b) { // �ִ����� ���Ҷ� ,��Ŭ���� ȣ���� �̿� 
        int r = a % b;
        if (r == 0) return b;
        return gcd(b, r);
    }
}
 */
