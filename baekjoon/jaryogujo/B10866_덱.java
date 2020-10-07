package jaryogujo;

import java.util.Scanner;
import java.util.LinkedList;

public class B10866_덱 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder answer = new StringBuilder();
		LinkedList<Integer> deque = new LinkedList<Integer>();
		// Deque<자료형> deque = new ArrayDeque<>(); ArrayDeque이용해도 밑에 있는 함수 다 사용가능 
		int inputNumber = sc.nextInt();
		int number;
		
		for(int i = 0 ; i < inputNumber ; i ++) {
			
			String input = sc.next();
			
			if(input.equals("push_front")) {
				number = sc.nextInt();
				deque.addFirst(number);
			} else if(input.equals("push_back")) {
				number = sc.nextInt();
				deque.addLast(number);
			} else if(input.equals("pop_front")) {
				answer.append(deque.isEmpty()? "-1\n" : deque.pollFirst()+"\n");
			} else if(input.equals("pop_back")) {
				answer.append(deque.isEmpty()? "-1\n" : deque.pollLast()+"\n");
			} else if(input.equals("front")) {
				answer.append(deque.isEmpty()? "-1\n" : deque.peekFirst()+"\n");
			} else if(input.equals("back")) {
				answer.append(deque.isEmpty()? "-1\n" : deque.peekLast()+"\n");
			} else if(input.equals("empty")) {
				answer.append(deque.isEmpty()?"-1\n" :"0\n");
			} else if(input.equals("size")) {
				answer.append(deque.size() +"\n");
			}
		}
		System.out.println(answer.toString());
		
	}

}

// 내코드는 백준에서 오류나는 코드
/* 내 코드랑 비교해서 내 코드 오류안나게 바꾸기 ! 
	public class Exam10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// @1
		String kind = "";
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deQ = new ArrayDeque<Integer>();
		
		while(n-- != 0) {
			kind = br.readLine();
			
			if(kind.startsWith("push_front")) { // @2
				deQ.addFirst(Integer.parseInt(kind.split(" ")[1]));
			} else if(kind.startsWith("push_back")) { // @3
				deQ.addLast(Integer.parseInt(kind.split(" ")[1]));
			} else if(kind.startsWith("pop_front")) { // @4
				sb.append(deQ.isEmpty() ? "-1\n" : deQ.pollFirst() + "\n");
			} else if(kind.startsWith("pop_back")) { // @5
				sb.append(deQ.isEmpty() ? "-1\n" : deQ.pollLast()+ "\n");
			} else if(kind.equals("size")) { // @6
				sb.append(deQ.size() + "\n");
			} else if(kind.equals("empty")) { // @7
				sb.append(deQ.isEmpty() ? "1\n" : "0\n");
			} else if(kind.equals("front")) { // @8
				sb.append(deQ.isEmpty() ? "-1\n" : deQ.getFirst() + "\n");
			} else if(kind.equals("back")) { // @9
				sb.append(deQ.isEmpty() ? "-1\n" : deQ.getLast() + "\n");
			} else {
				sb.append("error\n");
			}
		}
		System.out.println(sb.toString());
	}
}

 */


