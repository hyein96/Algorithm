package greedyalgorithm;

import java.util.Stack;

public class L2_큰수만들기 {

	public static void main(String[] args) {
		System.out.println(solution("1924",2));
		System.out.println(solution("1231234",3));
		System.out.println(solution("4177252841",4));
	}
	
	/* 1) 스택이용: char배열 사용하지 않고 k수로만 마지막까지 비교하면 시간 비효율적(초과날수도있음)
	   2) 스택이용: char배열 사용 한 후, new String(char배열) return하면 시간 효율적
	   3) StringBuilder 이용 -> 시간 효율적
	 */

	private static String solution(String number, int k) {
		//스택활용
		//가장 큰 숫자를 구하려면 앞에부터 큰 수가 놓이는 것이 중요 따라서, 전의 수보다 큰수가 나오는 경우가 생기면 계속 제거해줘야함(k개 제거하면 끝)
		//for문이 아닌 while 문필요(한 개 수만 제거하는게 아니므로)
		
		Stack<Character> st = new Stack<>();
		char[] answer = new char[number.length()-k];
		//String answer = "";

		for(int i = 0 ; i < number.length(); i++){
			char c = number.charAt(i);
			while(!st.isEmpty() && st.peek() < c && k > 0) {
				st.pop();
				k --;
			}
			st.push(c);
		}

		for(int i = 0 ; i < answer.length; i++){
			answer[i] = st.get(i);
		}
		return new String(answer);

		//		//위의 for문을 거치고 k가 남았다는 건 내림차순 순으로 정렬되있다는 뜻이므로 뒤에서 부터 k개 제거하면 됨 
		//		while(k > 0){ //k는 number자릿수미만이므로 stack이 empty경우는 없음
		//			st.pop();
		//			k--;
		//		}
		//		while(!st.isEmpty()){
		//			answer =  st.pop() + answer ; 
		//		}
		//		return answer;

	}
}


