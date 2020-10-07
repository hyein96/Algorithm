package jaryogujo;

import java.util.Scanner;
import java.util.Stack;

public class B17413_�ܾ������2 {

	public static void main(String[] args) {
		
	// �ܾ������1 ó�� ���� Ȱ���ϸ� �Ǵµ� ������ �ٽ��� boolean������ �༭ (�±װ� �������Ƿ�)
	// < �϶��� true�� > ���� ���ÿ� �����ʰ� �״�� ���
	// > ������ false�� �� �ٲ��ָ� ������ �������� �ܾ� ������ �� !
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		
		boolean tag = false ; // �±׾� �϶��� true, ���϶��� false�� ���� (ó���� false)
		
		for(int i = 0 ; i< input.length(); i++) {
			char c = input.charAt(i);
			if(c == '<') { // ���ÿ� ���� �ʿ����! ������ �Ⱥ�������� �׳� ��¸����ְ� ��������� ��¸�
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
			else if(tag) { // tag�� true�� ���ÿ� �����ʰ� �ٷ� ���
				System.out.print(c);
			}
			else {
				if(c == ' ') { // ���� ������ 
					while(!stack.isEmpty()) { // ���� �� ������ְ�
						System.out.print(stack.pop());
					}
					System.out.print(" "); // ���� �� �ڿ�
				}else {
					stack.push(c); //���鸸���� ������ ���ÿ� �ϳ��� �־��ֱ�
				}
			}
		}
		//�������� ������ �Ⱥ�������� ����� 
		while(!stack.empty()) { // ���� �� ������ְ�
			System.out.print(stack.pop());
		}
	}
}


/* BufferedWriter�� BufferedReader Ȱ��
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
public class Main {
 
    private static void printStack(BufferedWriter bw, Stack<Character> stack) throws IOException {
        // ���ÿ� ���� �ܾ ��� ����ϴ� �Լ�. ������ �ʿ��ؼ� �Լ��� �и�
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        
        String s = br.readLine();
        // Line �Է� �ް� s �� ����
 
        boolean tag = false;
        // tag ������ ������ Ȯ���� flag ����
 
        Stack<Character> stack = new Stack<Character>();
        // �ܾ�� ������ Stack ����
 
        for (int i = 0; i < s.length(); i++) {
        // �ܾ ó������ ������ �˻�
 
            if (s.charAt(i) == '<') {
                // �±� ������ ��
                
                tag = true;
                // tag ������ Ȯ���ϴ� flag�� true�� �ٲٰ�
                
                printStack(bw,stack);
                // �׵��� stack�� ���� �ܾ���� ������ �� �� ���� ����ش�
 
                bw.write(s.charAt(i));
                // �±� ���
                
            } else if (s.charAt(i) == '>') {
                // �±� ������ ��
                
                tag = false;
                // tag ������ Ȯ���ϴ� flag�� false�� �ٲٰ�
 
                bw.write(s.charAt(i));
                // �� �ܾ� �״�� ���
 
            } else if (tag) {
                // �±� ���� ���
                bw.write(s.charAt(i));
                // �� �ܾ� �״�� ���
            } else {
                // �±� �ٱ��� ���
                if(s.charAt(i)==' ') {
                    //�����̸�
                    printStack(bw,stack);
                    // �׵��� stack�� ���� �ܾ���� ������ �� �� ���� ����ش�
                    bw.write(s.charAt(i));
                    // ���� ���
                }else {
                    //������ �ƴϸ�
                    stack.push(s.charAt(i));
                    // stack�� �־��ش� 
                }
 
            }
 
        }
        
        // �ݺ��� ������ �������� ���
        printStack(bw,stack);
        // �׵��� stack�� ���� �ܾ���� ������ �� �� ���� ����ش�
        
        // BufferedWriter ���
        bw.flush();
        // reader, writer ����
        bw.close();
        br.close();
 
    }
 
}
*/