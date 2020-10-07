package jaryogujo;

import java.util.Scanner;
import java.util.Stack;

public class B9093_단어뒤집기 {
	public static void main(String[] args) {
		//StringBuffer 의 reverse함수 사용해서 풀어도되나 시간복잡도가 증가하므로 (비효율적)
		// 스택이용!!!!!!!!!!!!!!
		
		Scanner sc = new Scanner(System.in);
		int testnum ;
		testnum = sc.nextInt();
		sc.nextLine(); // 정수 이후에 받는 개행문자 제거 위한 코드 
		
		for(int i = 0 ; i < testnum ; i ++) {
			Stack<Character> stack = new Stack<Character>(); // 스텍이용
			String input = sc.nextLine(); // 문장 읽어오기 
			
			for(int j = 0 ; j < input.length(); j++) {
				char c = input.charAt(j); // 한 문자씩 나누기 
				if(c == ' ') { // 공백 만나면 
					while(!stack.empty()) { // 빼준 값 출력해주고
						System.out.print(stack.pop());
					}
					System.out.print(" "); // 공백 준 뒤에
				}else {
					stack.push(c); //공백만나기 전까진 스택에 하나씩 넣어주기
				}
			}
			while(!stack.empty()) { // 마지막 값 까지 넣고나면 공백이 없으므로 -> 스택이 안비어있기때문에 값 빼면서 출력!
				System.out.print(stack.pop());
			}
			System.out.println();
		}
		
		sc.close();
	}
}
