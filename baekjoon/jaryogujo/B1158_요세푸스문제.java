package jaryogujo;

import java.util.LinkedList;
import java.util.Scanner;


public class B1158_요세푸스문제 {
	
	public static void main(String[] args) {
		// BufferedReader 사용해서 읽어오면 시간적으로 매우 효율적 !
		Scanner sc = new Scanner(System.in);
		LinkedList <Integer> queue = new LinkedList<Integer>();
		StringBuilder output = new StringBuilder("<");
		
		int allNum = sc.nextInt();
		int deleteNum = sc.nextInt();
		
		for(int i = 1 ; i <= allNum ; i ++) { // 주어진 n명의 사람을 queue에 넣음 
				queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			
			// poll을 remove로 써도 똑같음
			for(int i = 1 ; i < deleteNum ; i ++) { // 제거 할 사람의 이전 사람들은 제거 후, 큐 뒤에 붙히기
				queue.add(queue.poll());
			}
			
			output.append(queue.poll()+", "); // 제거 하는 사람은 output에 넣고 제거 
		
		}
		
		output.delete(output.length()-2, output.length()); // 인덱스 값으로 생각해서 앞에꺼는 포함 뒤에껀 포함x 로 요소 삭제
		output.append(">");
		System.out.println(output.toString());
		// 위의 3줄을 1줄로
		//System.out.print((output.toString()).substring(0,output.length()-2)+">");
	    
	}

}
/*  나머지 연산 이용해서 원형리스트로 생각푸고 인덱스 값 바꿔가며 해결
 public static void main(String[] args){
 
 	Scanner sc = new Scannner(System.in);
 	ArrayList<Integer> list = new ArrayList<Integer>(); // 리스트
 	StringBuilder sb = new StringBuilder("<") ;
 	int m = sc.nextInt(); // 사람 수
 	int n = sc.nextInt() ; // 제거 할 순서
 	
 	int index = 0 ; // 이 인덱스 값을 계속 변경하며 리스트 안에 있는 사람등 제거 할 것
 	 
 	for(int i= 1 ; i=<m ; i ++) { // 리스트에 사람수 만큼 채우기 
 		list.add(i) ;
 	}
 	
 	while(!list.isEmpty()){ // 리스트가  빌 때 까지 이 작업 반복 
 	
 		index = (index + n - 1) % list.size() ; 
 		//index는 0부터 시작하므로 첫번째 없앨 사람의 인덱스는 2가 되고(1부터 시작했을 때 3번째 사람이므로)
 		// 그 뒤로는 index값에 3명의 사람 더하지만, 앞에서 한명을 remove한 상태이므로 -1한 인덱스의 값이 없앨 인덱스가 된다.
 		// 인덱스의 크기가 리스크 사이즈 보다 커질 떈 , 원형리스트로 생각하면 되므로 인덱스 값을 리스트 사이즈로 나눈 나머지 값이 인덱스 값이 된다.  
 		sb.append(list.remove(index) + ", ");
 
 	}
 	sb.delete(sb.length()-2, sb.length());
 	sb.append(">");
 	System.out.println(sb.toString());
 */
/* BufferedReader 사용 !
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 공백단위로 구분하여 받아옴

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

