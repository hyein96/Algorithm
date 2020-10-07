package jaryogujo;

import java.util.Scanner;
import java.util.Stack;

public class B1874_스택수열 {

// Scanner값으로 입력 받는 걸 BufferReader / Writer 사용해서 코드 짤 수 있어야 함 (더 효율적)
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack <Integer> stack = new Stack<Integer>();
		StringBuilder answer = new StringBuilder(""); // 출력 수(답) 저장할 StringBuilder
		
		int pushValue = 0 ; // push할 수 저장할 변수로 어떤 수는 한번 push되면 다시 push할 수 없음
							
		int inputNumber = sc.nextInt(); // 들어오는 숫자 갯수
		
		for(int i = 0 ; i < inputNumber ; i ++) {
			
			int inputValue = sc.nextInt(); // 들어온 숫자 
			
			if(inputValue > pushValue) { // 맨 처음엔 push한 수가 없으므로 당연히 들어온 수 가 큼
				
				int repeatCount = inputValue - pushValue; // 변수 선언해주지않으면 pushValue 값이 for문 들어갈때마다 바뀌므로 원하는 수만큼 반복되지 않는다!
				
				for(int j = 0 ; j < repeatCount ; j ++) {
					
					pushValue ++ ; 
					stack.push(pushValue); // 차이만큼 push하기
					answer.append("+\n");
					
				}
				// 다 push하고 수열 만들기위해  맨 마지막에 넣은 값 pop하고 - 
				stack.pop();
				answer.append("-\n");
			}
			
			else { // 들어온 수가 push 한 수 보다 작으면 
			// 스택이 비어있을 경우엔 들어온수가 push한 수보다 작을수 없으므로 비어있지않은경우에만 해당 
				if(stack.peek() == inputValue) { //들어온 수가 스택의 맨 윗 수랑 같으면
					stack.pop();
					answer.append("-\n");
				}
				else { // 들어온수가 스택의 맨 윗수 보다 작으면 바로 그 들어온 수를 빼낼 수없으므로
               		   // 그 윗수부터 차근차근 뺴내야 하므로 원하는 수열 만들 수 없음
					answer = new StringBuilder("");
					answer.append("No"); // 새로운 stringbuilder 만들어서 no만 넣기
					break ; 
				}
			}
		}
		
		System.out.print(answer.toString());
		
	}
}
