package jaryogujo;

import java.util.Scanner;
import java.util.Stack;

public class B9093_�ܾ������ {
	public static void main(String[] args) {
		//StringBuffer �� reverse�Լ� ����ؼ� Ǯ��ǳ� �ð����⵵�� �����ϹǷ� (��ȿ����)
		// �����̿�!!!!!!!!!!!!!!
		
		Scanner sc = new Scanner(System.in);
		int testnum ;
		testnum = sc.nextInt();
		sc.nextLine(); // ���� ���Ŀ� �޴� ���๮�� ���� ���� �ڵ� 
		
		for(int i = 0 ; i < testnum ; i ++) {
			Stack<Character> stack = new Stack<Character>(); // �����̿�
			String input = sc.nextLine(); // ���� �о���� 
			
			for(int j = 0 ; j < input.length(); j++) {
				char c = input.charAt(j); // �� ���ھ� ������ 
				if(c == ' ') { // ���� ������ 
					while(!stack.empty()) { // ���� �� ������ְ�
						System.out.print(stack.pop());
					}
					System.out.print(" "); // ���� �� �ڿ�
				}else {
					stack.push(c); //���鸸���� ������ ���ÿ� �ϳ��� �־��ֱ�
				}
			}
			while(!stack.empty()) { // ������ �� ���� �ְ��� ������ �����Ƿ� -> ������ �Ⱥ���ֱ⶧���� �� ���鼭 ���!
				System.out.print(stack.pop());
			}
			System.out.println();
		}
		
		sc.close();
	}
}
