package suhak;

import java.util.Scanner;
import java.io.*;

public class B1676_���丮��0�ǰ��� {
	// ���������� ������ n!�� ���ؼ� Ǯ�� �ð��ʰ� (n��Ŀ������ n!���� �ſ� Ŀ���Ƿ�)  
	// 10�� �������� �ڿ� 0�� ���� �� , �������� �� �� 10�� ���������� �ڿ������� 0�ǰ����� �־����� �� ! 
	// 10�� 2X5�� ��������Ƿ� n!���� n������ ���ڵ��� 2�� 5�� �ִ��� ������ ���� ��(����������) , 2�� 5�߿� �� ���� ������ ���� ���ڰ� n!�� 10�� ������ �Ǹ� ����  �Ǵ� ��(�� �� �Ѱ��̻��� �Ǿ���) 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int twoNum = 0 ; // 2�ǰ���
		int fiveNum = 0; // 5�� ����
		int output = 0 ;
		
		for(int i = 1 ; i <=input ; i ++) {
			int temp = i ; 
			while(temp % 2 == 0) {
				temp /= 2;
				twoNum ++;
			}
			
			while(temp % 5 == 0) {
				temp /= 5;
				fiveNum ++;
			}
		}
		
		if(twoNum >= 1 && fiveNum >=1) {
			output = Math.min(twoNum,fiveNum);
		}
		System.out.print(output);
		br.close();
	}
}
	


/* Ʋ���ڵ� -> ���������� ����������, n�ǹ����� �ڷ��� long�� ������ϴ� ū��
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
int number = sc.nextInt();
int answer = 0 ;

long factorial = 1; // n�� 100������ 100!�� long�� ������� ! �ٸ���� ã�ƾ���  

if(number == 0)  factorial= 1;
else {
	for(int i = 1 ; i <= number ; i++) {
		factorial *= i;
	}
}

String factorial2 = String.valueOf(factorial); // factorial(int)�� String���� ->0�� ���� ���ϱ� ���� 
for(int i = factorial2.length()-1 ; i >= 0 ; i--) {
	if(factorial2.charAt(i) == '0' ) answer++;
	else break;
}

System.out.print(answer);
}
*/