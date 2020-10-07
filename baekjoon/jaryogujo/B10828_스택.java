package jaryogujo;

import java.util.Scanner;
import java.util.*;

public class B10828_���� {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String stackInput ;
		ArrayList<Integer> answer = new ArrayList<>();
		
	
		
		int number = sc.nextInt() ; // ����� �� 
		
		for(int i = 0 ; i < number ; i ++) {
			
			stackInput = sc.next();
			
			if(stackInput.equals("push"))
			{
				int number2 = sc.nextInt();
				answer.add(number2);
			}
			else if(stackInput.equals("pop")) {
				if(answer.size()== 0) System.out.println(-1);
				else{
					System.out.println(answer.get(answer.size()-1));
					answer.remove(answer.size()-1);
				}
			}
			else if(stackInput.equals("size")) {
				System.out.println(answer.size());
			}
			else if(stackInput.equals("empty")) {
				if(answer.size() == 0) {
					System.out.println(1);
				}
				else System.out.println(0);
			}
			else if(stackInput.equals("top")) {
				if(answer.size()== 0) System.out.println(-1);
				else{	
					System.out.println(answer.get(answer.size()-1));
				}
			}
		}
	}
}


/* import java.util.Stack; ����ؼ� Ǭ �ڵ� --> �̹� �޼ҵ� �� ���� ���ִ°� �״�� ���
 // �ð��� �׷��� ���� �ڵ� ���� ȿ�����ΰ� ���� ����
  
import java.util.Scanner;
import java.util.Stack;

public class Main {

   public static void main(String[] args) {
    
      Stack<Integer> stack = new Stack<Integer>();
	 
	  Scanner sc = new Scanner(System.in);
      
      int cnt = sc.nextInt();
  
      for(int i=0; i<cnt; i++) {
    	  String input = sc.next();
    	  if(input.contains("push")) {
    		int input2 = sc.nextInt();
    		stack.push(input2);
    	  }else if(input.equals("pop")){
    		 System.out.println(stack.isEmpty()?-1:stack.pop());
    	  }else if(input.equals("size")) {
    		  System.out.println(stack.size());
    	  }else if(input.equals("empty")) {
    		 System.out.println(stack.isEmpty()?1:0);
    	  }else if(input.equals("top")) {
    		System.out.println(stack.isEmpty()?-1:stack.peek());
    	  }
      }
   }
}
 
 
 */
