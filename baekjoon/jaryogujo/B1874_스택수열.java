package jaryogujo;

import java.util.Scanner;
import java.util.Stack;

public class B1874_���ü��� {

// Scanner������ �Է� �޴� �� BufferReader / Writer ����ؼ� �ڵ� © �� �־�� �� (�� ȿ����)
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack <Integer> stack = new Stack<Integer>();
		StringBuilder answer = new StringBuilder(""); // ��� ��(��) ������ StringBuilder
		
		int pushValue = 0 ; // push�� �� ������ ������ � ���� �ѹ� push�Ǹ� �ٽ� push�� �� ����
							
		int inputNumber = sc.nextInt(); // ������ ���� ����
		
		for(int i = 0 ; i < inputNumber ; i ++) {
			
			int inputValue = sc.nextInt(); // ���� ���� 
			
			if(inputValue > pushValue) { // �� ó���� push�� ���� �����Ƿ� �翬�� ���� �� �� ŭ
				
				int repeatCount = inputValue - pushValue; // ���� ���������������� pushValue ���� for�� �������� �ٲ�Ƿ� ���ϴ� ����ŭ �ݺ����� �ʴ´�!
				
				for(int j = 0 ; j < repeatCount ; j ++) {
					
					pushValue ++ ; 
					stack.push(pushValue); // ���̸�ŭ push�ϱ�
					answer.append("+\n");
					
				}
				// �� push�ϰ� ���� ���������  �� �������� ���� �� pop�ϰ� - 
				stack.pop();
				answer.append("-\n");
			}
			
			else { // ���� ���� push �� �� ���� ������ 
			// ������ ������� ��쿣 ���¼��� push�� ������ ������ �����Ƿ� �������������쿡�� �ش� 
				if(stack.peek() == inputValue) { //���� ���� ������ �� �� ���� ������
					stack.pop();
					answer.append("-\n");
				}
				else { // ���¼��� ������ �� ���� ���� ������ �ٷ� �� ���� ���� ���� �������Ƿ�
               		   // �� �������� �������� ������ �ϹǷ� ���ϴ� ���� ���� �� ����
					answer = new StringBuilder("");
					answer.append("No"); // ���ο� stringbuilder ���� no�� �ֱ�
					break ; 
				}
			}
		}
		
		System.out.print(answer.toString());
		
	}
}
