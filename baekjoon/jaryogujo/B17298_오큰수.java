package jaryogujo;

import java.io.*;
import java.util.*;

//(내 생각) 직관적으로 이중for문 만들어서 일일히 비교해서 출력하면(전체탐색) 답은 나오나 시간초과뜸(BufferedReader 써도) --> Stack 활용해서 풀기

/* 솔루션 :값 자체가 아닌 인덱스를 활용해야 하는 문제 !!!!(배열) + 스택 

* 출력값이 길이가 변하는 값이 아닌 들어오는 num 값으로 정해져있고, 인덱스를 활용해서 문제를 풀어야 하므로 output을 stringbuilder가 아닌 배열로 선언
* 입력값을 배열로 받아서 첫번째 인덱스부터 stack에 넣어서 그 다음 값이랑 비교한 후, 크면 output으로 빼고(인덱스활용해서) output으로 나간 인덱스값 스택에서 pop
* 다음 값보다 작으면 스택에 해당하는 인덱스 그냥 냅두고 다음 번째 인덱스 값 비교 
* 마지막에 스택에 남아있는 인덱스의 output값 -1 로 바꾸면 출력
* ---> 인덱스 활용해서 푸는 게 solution   
*/

public class B17298_오큰수 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		int num = Integer.parseInt(br.readLine());
		int[] input = new int[num];
		int[] output = new int[num];

		/* split(" ") 이용해서 input 저장해도 됨
		 String temp[] = br.readLine().split(" "); 한 후에 input 구할 때
		 input[i] = Integer.parseInt(temp[i]); 로 하면 됨 
		 */
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < num ; i ++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> s = new Stack<Integer>();

		s.push(0); // 비교할 첫번째 인덱스 먼저 push

		for(int i = 1 ; i < num ; i ++) {

			//if(s.isEmpty()) s.push(i); --> 코드 생략해도 되는 이유 : for문을 들어올때 스택이 비어있을 경우가 존재 X

			// if가 아닌 while을 쓰는 이유는 바로 다음 숫자만 비교하는게 아니라 오른쪽에 있는 모든 수를 고려해야 하므로 while 쓰는 것 
			// 오큰수 : 오른쪽에 있으면서 자기보다 값이 큰 수 중!! 가장 왼쪽에 있는 수 
			// stack이 비었다는건 들어간 index는 다 output을 채웠다는 뜻이므로 while문 나가도 됨  
			while(!s.isEmpty() && input[s.peek()] < input[i]) { 

				output[s.pop()] = input[i];
			}

			s.push(i);

		}

		while(!s.isEmpty()){
			output[s.pop()] = -1;
		}

		for(int i = 0 ; i < num ; i++) {
			// 원래 bw는 string만 인식하므로 String.valueOf(output[i]+" ")로 하는게 정석(output이 int이기 때문) 
			bw.write(output[i] + " ");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}

/* 처음 내 코드(시간초과)
for(int i = 0 ; i < num ; i ++) {
			if(i == num-1) {
				output.append(-1);
				break;
			}
			for(int j = i+1 ; j < num  ; j ++) {

				if(input[i] < input[j]) {
					output.append(input[j]+ " ");
					break;
				}

				else if(input[i] >= input[j] && j == num-1) {
					output.append(-1 + " ");
				}

				else continue;
			}
		}
 */