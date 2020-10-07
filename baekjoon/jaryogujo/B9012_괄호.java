package jaryogujo;

import java.util.Scanner;
import java.util.Stack;



public class B9012_��ȣ {
	
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		int testNum ;
		
		testNum = sc.nextInt();
		sc.nextLine(); // �տ� int�� enter�� ������� ����! �̰� �Ƚ��ָ�  stack�� nextLine ó�� ������ ���� enter�� �� 
		
		for(int i = 0 ; i < testNum ; i ++) {
			
			Stack<Character> stack = new Stack<Character>();
			String input = sc.nextLine();
			
			for(int j = 0 ; j < input.length() ; j ++) {
				
				char c = input.charAt(j);
			
				if(stack.empty()) stack.push(c);
				else {
					if(stack.peek() == '(') {
						if(c ==')') stack.pop();
						else stack.push(c);
					}
					
					else stack.push(c);
				}
			}
			if(stack.empty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
