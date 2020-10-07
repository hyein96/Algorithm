package jaryogujo;

import java.util.LinkedList;
import java.util.Scanner;


public class B1158_�似Ǫ������ {
	
	public static void main(String[] args) {
		// BufferedReader ����ؼ� �о���� �ð������� �ſ� ȿ���� !
		Scanner sc = new Scanner(System.in);
		LinkedList <Integer> queue = new LinkedList<Integer>();
		StringBuilder output = new StringBuilder("<");
		
		int allNum = sc.nextInt();
		int deleteNum = sc.nextInt();
		
		for(int i = 1 ; i <= allNum ; i ++) { // �־��� n���� ����� queue�� ���� 
				queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			
			// poll�� remove�� �ᵵ �Ȱ���
			for(int i = 1 ; i < deleteNum ; i ++) { // ���� �� ����� ���� ������� ���� ��, ť �ڿ� ������
				queue.add(queue.poll());
			}
			
			output.append(queue.poll()+", "); // ���� �ϴ� ����� output�� �ְ� ���� 
		
		}
		
		output.delete(output.length()-2, output.length()); // �ε��� ������ �����ؼ� �տ����� ���� �ڿ��� ����x �� ��� ����
		output.append(">");
		System.out.println(output.toString());
		// ���� 3���� 1�ٷ�
		//System.out.print((output.toString()).substring(0,output.length()-2)+">");
	    
	}

}
/*  ������ ���� �̿��ؼ� ��������Ʈ�� ����Ǫ�� �ε��� �� �ٲ㰡�� �ذ�
 public static void main(String[] args){
 
 	Scanner sc = new Scannner(System.in);
 	ArrayList<Integer> list = new ArrayList<Integer>(); // ����Ʈ
 	StringBuilder sb = new StringBuilder("<") ;
 	int m = sc.nextInt(); // ��� ��
 	int n = sc.nextInt() ; // ���� �� ����
 	
 	int index = 0 ; // �� �ε��� ���� ��� �����ϸ� ����Ʈ �ȿ� �ִ� ����� ���� �� ��
 	 
 	for(int i= 1 ; i=<m ; i ++) { // ����Ʈ�� ����� ��ŭ ä��� 
 		list.add(i) ;
 	}
 	
 	while(!list.isEmpty()){ // ����Ʈ��  �� �� ���� �� �۾� �ݺ� 
 	
 		index = (index + n - 1) % list.size() ; 
 		//index�� 0���� �����ϹǷ� ù��° ���� ����� �ε����� 2�� �ǰ�(1���� �������� �� 3��° ����̹Ƿ�)
 		// �� �ڷδ� index���� 3���� ��� ��������, �տ��� �Ѹ��� remove�� �����̹Ƿ� -1�� �ε����� ���� ���� �ε����� �ȴ�.
 		// �ε����� ũ�Ⱑ ����ũ ������ ���� Ŀ�� �� , ��������Ʈ�� �����ϸ� �ǹǷ� �ε��� ���� ����Ʈ ������� ���� ������ ���� �ε��� ���� �ȴ�.  
 		sb.append(list.remove(index) + ", ");
 
 	}
 	sb.delete(sb.length()-2, sb.length());
 	sb.append(">");
 	System.out.println(sb.toString());
 */
/* BufferedReader ��� !
 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main{
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Deque<Integer> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // ��������� �����Ͽ� �޾ƿ�

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++){
            deque.add(i);
        }

        while(!deque.isEmpty()){
            for (int i = 0; i < k-1; i++){
                deque.addLast(deque.removeFirst());
            }
            sb.append(deque.removeFirst() + ", ");
        }
        System.out.println(sb.toString().substring(0,sb.length()-2) + ">");
    }
}
 */

