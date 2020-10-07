package jaryogujo;

import java.io.*;
import java.util.Stack;

public class B1935_후위표기식2 {
// 앞의 1918문제는 중위표기식을 후위표기식으로 변환하는 문제(스택이용)
/* 후위표기식에서 중위표기식 변환 할 필요 없이, 후위표기식의 계산 방법 찾아서 문제풀면 됨
<후위표기식 계산 알고리즘>
1. 피연산자는 stack에 push
2. 연산자 나오면 stack에서 피연산자 두개 꺼낸 후  연산자랑 계산해서 다시 stack에 push
3. 1번,2번 반복하면 마지막에 stack에 있는 값이 계산한 값 --> stack에 있는 값을 char가 아닌 double로 해서 푸는게 좋음   
*/

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Double> stack = new Stack<Double>(); // stack에 값을 저장해서 넣을건데 계산결과는 소수점 둘째자리까지 이므로 stack은 double형으로 
		

		int num = Integer.parseInt(br.readLine());  // BufferedReader는 무조건 string형으로 받아옴
		String input = br.readLine();
		double pOper[] = new double[num]; // 피연산자에 대응하는 값들 
		
		for(int i = 0 ; i < num ; i ++) {
			pOper[i] = Integer.parseInt(br.readLine()); // pOper[0]이 'A'값이며, 차례대로 B,C..값이 배열에 저장됨 
		}
	

		for(int i = 0 ; i < input.length() ; i ++) {
			char ch = input.charAt(i);

			switch(ch) {
			// 계산해서 다시 stack에 넣는 함수를 따로 만들지 않고 ,각 연산자 case별로 pop 2번하고 연산해서 push하는 걸 코드로 짜도 됨
			// 코드 간결성 위해 '함수(cal)' 만드는게 효율적임 -> 함수 활용하면 모든 연산자 case 하나로 묶고 코드 통일 시킬 수 있음 
			case '+':
			case '-':
			case '*':
			case '/':
				cal(stack,stack.pop(),stack.pop(),ch); //stack에서 피연산자를 두번 빼면서 cal함수로 넘겨준 것 
				break;
			default:
				stack.push(pOper[ch-'A']); // pOper[0]이 'A'이므로
				break;
			}
		}
		
		System.out.format("%.2f", stack.peek());
		br.close();
		
	}
	
	static void cal(Stack<Double> stack, double p1, double p2, char op) { // 자료형 선언 시, stack은 자료형까지 같이 기입 + char형은 자료형 char
		//main함수에서 일일히 case별로 연산해서 push하는 것을 함수 cal에서 하는 것 
		switch(op) {
		//p1이 뒤에 들어온 값이고, p2가 먼저 들어온 값 (순서 잘 고려해서 연산해야 함) 
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
