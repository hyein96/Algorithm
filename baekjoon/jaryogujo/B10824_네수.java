package jaryogujo;

import java.util.Scanner;

public class B10824_�׼� {

	// �� ������ �� �ڸ� �ڿ����� 1���� 1,000,000���� �̹Ƿ� ������ ���ϸ� 
	// int�� ǥ������ -2,147,483,648~2,147,483,648�� �Ѿ
	// ���� -9,223,372,036,854,775,808 ������ long������ �ڷ����� ���ؾ� �ϴ°� �ٽ� !
	
	// �ڿ��� ������ ������ �������� �ʰų�, �� �ٷ� �Է��� ���� ������ �� �ڵ�� ���� �ȵ�(�ؿ� �ڵ�� �ؾ���)
	public static void main(String[] args) {
		
		String input;
		String[] divString;
		long answer ; 
		
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextLine();
		
		divString = input.split(" ");
		
		
		answer = Long.parseLong(divString[0]+divString[1]) + Long.parseLong(divString[2]+ divString[3]);
		
		System.out.print(answer);
		
		
		
	}
}


/* �ٸ���� �ڵ�
// next()�޼ҵ�� ���� ���������� ���ڿ� �Է� �ް� nextLine()�� ���ڿ� ��ü(enter�� �������� �޼ҵ�����) �Է¹��� 
// next()�޼ҵ忡�� ����,�Ǽ� �Է¹޴°� next+�ڷ���()
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        String A = String.valueOf(a);
        String B = String.valueOf(b);
        String C = String.valueOf(c);
        String D = String.valueOf(d);
        A += B;
        C += D;
        long ans1 = Long.valueOf(A);
        long ans2 = Long.valueOf(C);
        System.out.println(ans1+ans2);
    }
}*/