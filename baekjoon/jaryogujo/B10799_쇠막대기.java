package jaryogujo;

import java.util.Stack;
import java.io.*;

/* 닫힘태그 ')' 가 나올 떄, 이 태그가 막대의 끝을 의미하는지,레이저를 의미하는지 판단할 때  
 * '('와 ')가 아닌 인덱스로 판단하는 이유는  막대의 끝을 레이저로 생각하는 경우가 생기므로 ! 
 * '(' 다음에 바로 나오는 ')'만 레이저이므로 '('후에 ')'나오는 애들 중 인덱스 차이가 1인 ')' 만 레이저로 판별해야 함 !!!
 * --->  괄호 자체가 아닌 인덱스를 stack에 넣고 뺴는게  솔루션 
 * 
 * ')'가 레이저일 때  : 바로 앞 '('를 pop하고 레이저 왼쪽에 있는 모든 막대가 반으로 나뉘어 지는 것이므로 왼쪽에있는 막대 (stack.size)만큼 더해줌 
 * ')'가 막대의 끝일 때 : 바로 앞 '('를 pop하고 (끝에 해당하는 막대를 없앤 것) 막대 갯수는 한개(해당막대의 맨 오른쪽 잘린 조각)만 늘어남  
 */

public class B10799_쇠막대기 {
	
	public static void main(String[] args) throws IOException {
		 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Integer> s = new Stack<Integer>(); // 인덱스를 넣을것이므로 int
        
        int answer = 0 ; // 조각의 총 개수 
        String input = br.readLine();
        
        for(int i = 0 ; i < input.length() ; i++) {
        	
        	if(input.charAt(i) =='(') {
        		s.push(i); // 해당하는 인덱스를 stack에 push
        	} else { // ')'일때
        		
        		if(i - s.peek() == 1) {// ')'이면서 앞의 괄호'('와 인덱스 차이가 1이라는건 레이저를 의미  
        			s.pop(); // 레이저 없애고
        		
        			// 밑에 if문 없애도 코드는 정상 작동됨 -> stack이 비어있으면 스택의 사이즈는 0 이므로 answer값에는 지장을 안주므로 
        			// 그러나, 스택이 비어있을 때는 막대의 갯수을 추가하는게 말이 안되므로 솔루션 생각할 때는 밑에 if문을 써주는게 맞음   
        			if(!s.isEmpty()) { // stack.size() != 0 와 같은 말  
        				answer += s.size();
        			}
        		}
        		
        		else { // 막대의 끝일 때
        			s.pop();
        			answer += 1;
        		}
        	}
        }
        
        bw.write(String.valueOf(answer));
        
        bw.flush();
        br.close();
        bw.close();
    }
}
