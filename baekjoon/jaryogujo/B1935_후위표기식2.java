package jaryogujo;

import java.io.*;
import java.util.Stack;

public class B1935_����ǥ���2 {
// ���� 1918������ ����ǥ����� ����ǥ������� ��ȯ�ϴ� ����(�����̿�)
/* ����ǥ��Ŀ��� ����ǥ��� ��ȯ �� �ʿ� ����, ����ǥ����� ��� ��� ã�Ƽ� ����Ǯ�� ��
<����ǥ��� ��� �˰���>
1. �ǿ����ڴ� stack�� push
2. ������ ������ stack���� �ǿ����� �ΰ� ���� ��  �����ڶ� ����ؼ� �ٽ� stack�� push
3. 1��,2�� �ݺ��ϸ� �������� stack�� �ִ� ���� ����� �� --> stack�� �ִ� ���� char�� �ƴ� double�� �ؼ� Ǫ�°� ����   
*/

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Double> stack = new Stack<Double>(); // stack�� ���� �����ؼ� �����ǵ� ������� �Ҽ��� ��°�ڸ����� �̹Ƿ� stack�� double������ 
		

		int num = Integer.parseInt(br.readLine());  // BufferedReader�� ������ string������ �޾ƿ�
		String input = br.readLine();
		double pOper[] = new double[num]; // �ǿ����ڿ� �����ϴ� ���� 
		
		for(int i = 0 ; i < num ; i ++) {
			pOper[i] = Integer.parseInt(br.readLine()); // pOper[0]�� 'A'���̸�, ���ʴ�� B,C..���� �迭�� ����� 
		}
	

		for(int i = 0 ; i < input.length() ; i ++) {
			char ch = input.charAt(i);

			switch(ch) {
			// ����ؼ� �ٽ� stack�� �ִ� �Լ��� ���� ������ �ʰ� ,�� ������ case���� pop 2���ϰ� �����ؼ� push�ϴ� �� �ڵ�� ¥�� ��
			// �ڵ� ���Ἲ ���� '�Լ�(cal)' ����°� ȿ������ -> �Լ� Ȱ���ϸ� ��� ������ case �ϳ��� ���� �ڵ� ���� ��ų �� ���� 
			case '+':
			case '-':
			case '*':
			case '/':
				cal(stack,stack.pop(),stack.pop(),ch); //stack���� �ǿ����ڸ� �ι� ���鼭 cal�Լ��� �Ѱ��� �� 
				break;
			default:
				stack.push(pOper[ch-'A']); // pOper[0]�� 'A'�̹Ƿ�
				break;
			}
		}
		
		System.out.format("%.2f", stack.peek());
		br.close();
		
	}
	
	static void cal(Stack<Double> stack, double p1, double p2, char op) { // �ڷ��� ���� ��, stack�� �ڷ������� ���� ���� + char���� �ڷ��� char
		//main�Լ����� ������ case���� �����ؼ� push�ϴ� ���� �Լ� cal���� �ϴ� �� 
		switch(op) {
		//p1�� �ڿ� ���� ���̰�, p2�� ���� ���� �� (���� �� ����ؼ� �����ؾ� ��) 
		case '+':
			stack.push(p2 + p1);
			break;
		case '-':
			stack.push(p2 - p1);
			break;
		case '*':
			stack.push(p2 * p1);
			break;
		case '/':
			stack.push(p2 / p1);
			break;
		}
	}
}
