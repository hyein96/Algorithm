package jaryogujo;

import java.util.LinkedList;
import java.util.Scanner;

public class B10845_큐 {

// 향상된 if문 써주면 좋음 !!!!!!!!!!!!!!!!!!
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 큐는 linkedlist로 구현
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int inputNumber = sc.nextInt();
		
		for(int i = 0 ; i < inputNumber ; i ++) {
			
			String input = sc.next();
			if(input.equals("push")) { //equals 대신 contains 써도 됨 ! 
				int number = sc.nextInt();
				queue.add(number);
				
			}
			else if(input.equals("pop")) {
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(queue.poll());
				
			}
			else if(input.equals("size"))
					System.out.println(queue.size());
			else if(input.equals("front")) {
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(queue.peek());
			}
			else if(input.equals("back")) {
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(queue.peekLast());
			}
			else if(input.equals("empty")) {
				if(queue.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
		}
	}
}

// 향상된 if문 쓰고 , StringBuilder에 다 저장해서 한꺼번에 출력하는 방법 ! (equals 대신 contains사용)
/*
 public class Exam10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		while(N-- != 0) {
			String kind = br.readLine();
			if(kind.startsWith("push")) {
				queue.offer(Integer.parseInt(kind.split(" ")[1])); // @1
			} else if(kind.contains("pop")) {
				sb.append(queue.isEmpty() ? "-1\n" : queue.poll() + "\n"); // @2
			} else if(kind.contains("size")) {
				sb.append(queue.size() + "\n"); // @3
			} else if(kind.contains("empty")) {
				sb.append(queue.isEmpty() ? "1\n" : "0\n"); // @4
			} else if(kind.contains("front")) {
				sb.append(queue.isEmpty() ? "-1\n" : queue.peek() + "\n"); // @5
			} else if(kind.contains("back")) {
				sb.append(queue.isEmpty() ? "-1\n" : queue.peekLast() + "\n"); // @6
			} else {
				sb.append("error\n");
			}
		}
		System.out.println(sb.toString());
	}
}
 */
