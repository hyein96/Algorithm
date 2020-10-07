package jaryogujo;

import java.util.Scanner;
import java.util.Stack;



public class B9012_괄호 {
	
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		int testNum ;
		
		testNum = sc.nextInt();
		sc.nextLine(); // 앞에 int의 enter을 잡기위해 써줌! 이걸 안써주면  stack에 nextLine 처음 읽히는 값이 enter가 됨 
		
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
