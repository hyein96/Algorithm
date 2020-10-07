package brutforce;

import java.io.*;
import java.util.Arrays;

// 전체탐색해야함 ! 배열을 오름차순으로 나열 한 후, 7개일때 짜르고 ,그 출력 한 값들을 다 더해보고 100이 되면 출력
// 전체탐색을 dfs(깊이우선탐색)으로 쭉 내려가면서 탐색하기 --> N과M처럼(재귀함수 이용) : N과M의 조합을 의미 
// 가능한 정답이 여러가지인 경우에는 아무거나 한개 출력 하므로, boolean변수 이용해서 한개 출력 값 나오면 그 뒤는 나오지 않게 함수 return 해줌
public class B2309_일곱난쟁이 {
	
	static boolean[] visit = new boolean[9];
	static int[] input = new int[9] ; // 주어지는 아홉난쟁이들의 키
	static int[] output = new int[7];
	
	static boolean isFirst = true ; // first면 true이며 first일 때 만 출력하고 끝내기(함수나가기) 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < 9 ; i ++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input); // 배열을 오름차순으로 정렬
		
		seven(0);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	static void seven(int index) throws IOException {
		
		if(!isFirst) return; 
		// !isFirst 가 true가 되면(즉, isFirst가 false가 되면) seven함수 return되며  뒤의 출력 값 안 구함  
		
		if(index == 7) {
			int sum = 0;
			for(int i = 0 ; i < 7 ; i ++) {
				sum += output[i];
			}
			if(sum == 100) {
				for(int i = 0 ; i < 7 ; i ++) {
					bw.write(String.valueOf(output[i]));
					bw.newLine();
				}
				isFirst = false ; // 한번 출력하고 나면 isFirst가 false로 바뀌면 첫번째 출력 값 끝남
			}
		}
		
		else {
			for(int i = 0 ; i < 9 ; i ++) {
				if(visit[i]) continue; // boolean의 기본 값을 false
				visit[i] = true; 
				output[index] = input[i] ; 
				if(index == 0 || index > 0 && output[index-1] < output[index]) {
					seven(index+1) ; 
				}
				visit[i] = false;
			}
		}
	}
}

