package jaryogujo;

import java.io.*;
import java.util.*;

/* 연산자 넣을 stack + 출력할 output(stringbuilder) 생성 
 ★ 연산자 우선순위를 정해 놓기
 1) 피연산자 들어오면 output에 넣기
 2) 연산자 들어왔는데 
   2-1 ) stack이 비어있거나, 원래있던 연산자보다 들어온 연산자의 우선순위가 크면 stack에 연산자 넣기
   2-2 ) 원래있던 연산자보다 들어온 연산자의 우선순위가 작거나 같으면 원래있던 연산자 output으로 뺴고 들어온 연산자 stack에 넣기
 3) 마지막에 stack이 안비어있으면 stack 빌 때 까지 차례대로 stack의 값들 output에 넣기
 * 괄호'(' 는 stack에서 뺄때 출력하면 안됨 + 괄호의 우선순위를 제일 낮게 : 괄호'('를 만나면 그 뒤에있는 연산자는 무조건 stack에 넣어야 하므로
 * 괄호 ')' 를 만나면 '('나올때 까지 stack에 있는 값 output으로 빼기 + ')'와 짝이맞는 해당'('만 output으로 넣지말고 stack에서 pop    
 */

public class B1918_후위표기식 {

	//우선순위지정 함수
	static int priority(char c) {

		// 우선순위 : (,) < +,- < *,/
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

		String input = br.readLine(); // 입력값

		for(int i = 0 ; i < input.length() ; i++) {
			char ch = input.charAt(i);
			int p = priority(ch); // 들어온 연산자의 우선순위 받아오기

			// 코드 보기 쉽고 간결하게 짜기 위해 , if-else if문 말고 switch문 사용(switch문은 각 case끝나면 break 써주기)
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
			case '(': // 괄호'('들어오면 ')'만날때까지 다 stack에 넣기
				stack.push(ch);
				break;
			case ')': // 괄호'('가 아닌 연산자들 output으로 빼고, 괄호'('는 그냥 빼기  
				while(!stack.isEmpty() && stack.peek() !='(') {
					output.append(stack.pop());
				}
				stack.pop(); // '(' stack에서 빼는 코드  ->  ')'나오면 짝이맞는 해당'('만 pop하는 것
				break;
			default : // 피연산자일 경우 
				output.append(ch);
				break;
			}
		}
		
		while(!stack.isEmpty()) { // 끝까지 돌았는데 stack 안비어있으면 들어있는거 다 뺴기  
			output.append(stack.pop());
		}

		bw.write(output.toString()); // StringBuilder를 String으로 바꿔서 출력
		
		br.close();
		bw.flush();
		bw.close();
	}
}
