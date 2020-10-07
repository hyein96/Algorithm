package jaryogujo;

import java.util.Scanner;
import java.util.Stack;

public class B17413_단어뒤집기2 {

	public static void main(String[] args) {
		
	// 단어뒤집기1 처럼 스택 활용하면 되는데 문제의 핵심은 boolean변수를 줘서 (태그가 들어가있으므로)
	// < 일때는 true로 > 까지 스택에 넣지않고 그대로 출력
	// > 나오면 false가 로 바꿔주며 공백을 기준으로 단어 뒤집어 줌 !
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		
		boolean tag = false ; // 태그안 일때는 true, 밖일때는 false로 유지 (처음엔 false)
		
		for(int i = 0 ; i< input.length(); i++) {
			char c = input.charAt(i);
			if(c == '<') { // 스택에 넣을 필요없음! 그전이 안비어있으면 그냥 출력만해주고 비어있으면 출력만
				tag = true ;
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(c);
			}		
			else if(c=='>') {
				tag = false;
				System.out.print(c);
			}
			else if(tag) { // tag가 true면 스택에 넣지않고 바로 출력
				System.out.print(c);
			}
			else {
				if(c == ' ') { // 공백 만나면 
					while(!stack.isEmpty()) { // 빼준 값 출력해주고
						System.out.print(stack.pop());
					}
					System.out.print(" "); // 공백 준 뒤에
				}else {
					stack.push(c); //공백만나기 전까진 스택에 하나씩 넣어주기
				}
			}
		}
		//마지막에 스택이 안비어있으면 비워줌 
		while(!stack.empty()) { // 빼준 값 출력해주고
			System.out.print(stack.pop());
		}
	}
}


/* BufferedWriter와 BufferedReader 활용
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
public class Main {
 
    private static void printStack(BufferedWriter bw, Stack<Character> stack) throws IOException {
        // 스택에 쌓인 단어를 모두 출력하는 함수. 여러번 필요해서 함수로 분리
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        
        String s = br.readLine();
        // Line 입력 받고 s 에 저장
 
        boolean tag = false;
        // tag 안인지 밖인지 확인할 flag 생성
 
        Stack<Character> stack = new Stack<Character>();
        // 단어들 뒤집을 Stack 생성
 
        for (int i = 0; i < s.length(); i++) {
        // 단어를 처음부터 끝까지 검사
 
            if (s.charAt(i) == '<') {
                // 태그 시작일 때
                
                tag = true;
                // tag 안인지 확인하는 flag를 true로 바꾸고
                
                printStack(bw,stack);
                // 그동안 stack에 쌓인 단어들을 스택이 빌 때 까지 비워준다
 
                bw.write(s.charAt(i));
                // 태그 출력
                
            } else if (s.charAt(i) == '>') {
                // 태그 종료일 때
                
                tag = false;
                // tag 안인지 확인하는 flag를 false로 바꾸고
 
                bw.write(s.charAt(i));
                // 그 단어 그대로 출력
 
            } else if (tag) {
                // 태그 안일 경우
                bw.write(s.charAt(i));
                // 그 단어 그대로 출력
            } else {
                // 태그 바깥일 경우
                if(s.charAt(i)==' ') {
                    //공백이면
                    printStack(bw,stack);
                    // 그동안 stack에 쌓인 단어들을 스택이 빌 때 까지 비워준다
                    bw.write(s.charAt(i));
                    // 공백 출력
                }else {
                    //공백이 아니면
                    stack.push(s.charAt(i));
                    // stack에 넣어준다 
                }
 
            }
 
        }
        
        // 반복이 끝나고 마지막일 경우
        printStack(bw,stack);
        // 그동안 stack에 쌓인 단어들을 스택이 빌 때 까지 비워준다
        
        // BufferedWriter 비움
        bw.flush();
        // reader, writer 종료
        bw.close();
        br.close();
 
    }
 
}
*/