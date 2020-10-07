package jaryogujo;

import java.io.*;
import java.util.*;

/* ������ ���� stack + ����� output(stringbuilder) ���� 
 �� ������ �켱������ ���� ����
 1) �ǿ����� ������ output�� �ֱ�
 2) ������ ���Դµ� 
   2-1 ) stack�� ����ְų�, �����ִ� �����ں��� ���� �������� �켱������ ũ�� stack�� ������ �ֱ�
   2-2 ) �����ִ� �����ں��� ���� �������� �켱������ �۰ų� ������ �����ִ� ������ output���� ���� ���� ������ stack�� �ֱ�
 3) �������� stack�� �Ⱥ�������� stack �� �� ���� ���ʴ�� stack�� ���� output�� �ֱ�
 * ��ȣ'(' �� stack���� ���� ����ϸ� �ȵ� + ��ȣ�� �켱������ ���� ���� : ��ȣ'('�� ������ �� �ڿ��ִ� �����ڴ� ������ stack�� �־�� �ϹǷ�
 * ��ȣ ')' �� ������ '('���ö� ���� stack�� �ִ� �� output���� ���� + ')'�� ¦�̸´� �ش�'('�� output���� �������� stack���� pop    
 */

public class B1918_����ǥ��� {

	//�켱�������� �Լ�
	static int priority(char c) {

		// �켱���� : (,) < +,- < *,/
		if(c == '(' || c == ')') return 0;
		else if(c == '+' || c == '-') return 1;
		else if(c == '*'|| c =='/') return 2;
		else return -1;

	}

	public static void main(String[] args) throws IOException {

		StringBuilder output = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine(); // �Է°�

		for(int i = 0 ; i < input.length() ; i++) {
			char ch = input.charAt(i);
			int p = priority(ch); // ���� �������� �켱���� �޾ƿ���

			// �ڵ� ���� ���� �����ϰ� ¥�� ���� , if-else if�� ���� switch�� ���(switch���� �� case������ break ���ֱ�)
			switch (ch) {
			case '+':
			case '-':
			case '*':
			case '/':
				while(!stack.isEmpty() && priority(stack.peek()) >= p) {
					output.append(stack.pop());
				}
				stack.push(ch);
				break;
			case '(': // ��ȣ'('������ ')'���������� �� stack�� �ֱ�
				stack.push(ch);
				break;
			case ')': // ��ȣ'('�� �ƴ� �����ڵ� output���� ����, ��ȣ'('�� �׳� ����  
				while(!stack.isEmpty() && stack.peek() !='(') {
					output.append(stack.pop());
				}
				stack.pop(); // '(' stack���� ���� �ڵ�  ->  ')'������ ¦�̸´� �ش�'('�� pop�ϴ� ��
				break;
			default : // �ǿ������� ��� 
				output.append(ch);
				break;
			}
		}
		
		while(!stack.isEmpty()) { // ������ ���Ҵµ� stack �Ⱥ�������� ����ִ°� �� ����  
			output.append(stack.pop());
		}

		bw.write(output.toString()); // StringBuilder�� String���� �ٲ㼭 ���
		
		br.close();
		bw.flush();
		bw.close();
	}
}
