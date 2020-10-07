package jaryogujo;

import java.util.Stack;
import java.io.*;

/* �����±� ')' �� ���� ��, �� �±װ� ������ ���� �ǹ��ϴ���,�������� �ǹ��ϴ��� �Ǵ��� ��  
 * '('�� ')�� �ƴ� �ε����� �Ǵ��ϴ� ������  ������ ���� �������� �����ϴ� ��찡 ����Ƿ� ! 
 * '(' ������ �ٷ� ������ ')'�� �������̹Ƿ� '('�Ŀ� ')'������ �ֵ� �� �ε��� ���̰� 1�� ')' �� �������� �Ǻ��ؾ� �� !!!
 * --->  ��ȣ ��ü�� �ƴ� �ε����� stack�� �ְ� ���°�  �ַ�� 
 * 
 * ')'�� �������� ��  : �ٷ� �� '('�� pop�ϰ� ������ ���ʿ� �ִ� ��� ���밡 ������ ������ ���� ���̹Ƿ� ���ʿ��ִ� ���� (stack.size)��ŭ ������ 
 * ')'�� ������ ���� �� : �ٷ� �� '('�� pop�ϰ� (���� �ش��ϴ� ���븦 ���� ��) ���� ������ �Ѱ�(�ش縷���� �� ������ �߸� ����)�� �þ  
 */

public class B10799_�踷��� {
	
	public static void main(String[] args) throws IOException {
		 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Integer> s = new Stack<Integer>(); // �ε����� �������̹Ƿ� int
        
        int answer = 0 ; // ������ �� ���� 
        String input = br.readLine();
        
        for(int i = 0 ; i < input.length() ; i++) {
        	
        	if(input.charAt(i) =='(') {
        		s.push(i); // �ش��ϴ� �ε����� stack�� push
        	} else { // ')'�϶�
        		
        		if(i - s.peek() == 1) {// ')'�̸鼭 ���� ��ȣ'('�� �ε��� ���̰� 1�̶�°� �������� �ǹ�  
        			s.pop(); // ������ ���ְ�
        		
        			// �ؿ� if�� ���ֵ� �ڵ�� ���� �۵��� -> stack�� ��������� ������ ������� 0 �̹Ƿ� answer������ ������ ���ֹǷ� 
        			// �׷���, ������ ������� ���� ������ ������ �߰��ϴ°� ���� �ȵǹǷ� �ַ�� ������ ���� �ؿ� if���� ���ִ°� ����   
        			if(!s.isEmpty()) { // stack.size() != 0 �� ���� ��  
        				answer += s.size();
        			}
        		}
        		
        		else { // ������ ���� ��
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
