package greedyalgorithm;

import java.util.Stack;

public class L2_ū������� {

	public static void main(String[] args) {
		System.out.println(solution("1924",2));
		System.out.println(solution("1231234",3));
		System.out.println(solution("4177252841",4));
	}
	
	/* 1) �����̿�: char�迭 ������� �ʰ� k���θ� ���������� ���ϸ� �ð� ��ȿ����(�ʰ�����������)
	   2) �����̿�: char�迭 ��� �� ��, new String(char�迭) return�ϸ� �ð� ȿ����
	   3) StringBuilder �̿� -> �ð� ȿ����
	 */

	private static String solution(String number, int k) {
		//����Ȱ��
		//���� ū ���ڸ� ���Ϸ��� �տ����� ū ���� ���̴� ���� �߿� ����, ���� ������ ū���� ������ ��찡 ����� ��� �����������(k�� �����ϸ� ��)
		//for���� �ƴ� while ���ʿ�(�� �� ���� �����ϴ°� �ƴϹǷ�)
		
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

		//		//���� for���� ��ġ�� k�� ���Ҵٴ� �� �������� ������ ���ĵ��ִٴ� ���̹Ƿ� �ڿ��� ���� k�� �����ϸ� �� 
		//		while(k > 0){ //k�� number�ڸ����̸��̹Ƿ� stack�� empty���� ����
		//			st.pop();
		//			k--;
		//		}
		//		while(!st.isEmpty()){
		//			answer =  st.pop() + answer ; 
		//		}
		//		return answer;

	}
}


