package brutforce.sunyeol;

import java.io.*;

public class B10974_모든순열 {
	
	// 내 솔루션 : N과 M(1) 풀이 처럼 DFS사용해서 재귀함수로 구현 (방문하면 추가하지말고 입력값 만큼 받아서 중복없이 출력)
	// 다른 솔루션 : 다음순열 이용해서 품 (다음 순열이 있으면 계속 출력) 
	static boolean visit[];
	static int output[] ; 
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		visit = new boolean[input+1];
		output = new int[input];
		
		allPermutation(0,input);
		
		br.close();
		bw.flush();
		bw.close();
		
		
		
	}
	
	static void allPermutation(int index, int n) throws IOException {
		if(index == n) {
			for(int i = 0 ; i < n ; i ++) {
				bw.write(String.valueOf(output[i]));
				if(i != n-1) bw.write(" ");
			}
			bw.newLine();
		}
		else {
			for(int i = 1 ; i <= n ; i++) {
				if(visit[i]) continue;
				
				visit[i] = true; 
				output[index] = i;
				allPermutation(index+1,n);
				visit[i] = false;
				
			}
		}
		
	}
}
//내 솔루션(다른 풀이) : 다음순열 이용해서 품 (다음 순열이 있으면 계속 출력) --> 위랑 시간 차이 별로 안남 

/*private static int input;
private static int[] output;

public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	input = Integer.parseInt(br.readLine());
	output = new int[input];
	
	for(int i = 0 ; i < input ; i ++) {
		output[i] = i+1 ; 
	}
	
	do {
		for(int i = 0 ; i < input ; i ++) {
			bw.write(String.valueOf(output[i]));
			if( i != input - 1) bw.write(" ");
		}
		bw.newLine();
	}while(nextPermutation());
	
	br.close();
	bw.flush();
	bw.close();
}

public static boolean nextPermutation() {
	boolean next = false; // 다음 순열의 유무
	
	for(int i = input-1 ; i > 0 ; i--) { // n이 input.length ! 
		if(output[i-1] < output[i]) {
			next = true;
			for(int j = input-1 ; j >= 0 ; j--) {
				if(output[j] > output[i-1]) {
					//swap하는 방법 (변수 여러개 선언 필요없이,temp 한 개만있으면 swap가능 // swap법 암기)
					int temp = output[j];
					output[j] = output[i-1];
					output[i-1] = temp;
					break; // 두번째 for문 탈출 
				}
			}
			int k = input-1; // k는 맨 마지막수 --> i부터 맨마지막수까지 전부 뒤집는다 
			while(i < k) {
				int temp2 = output[k];
				output[k] = output[i];
				output[i] = temp2;
				i++;
				k--;
			}
			break; // 첫번째 for문 탈출
		}
	}
	
	if(next) return true;  // 다음 순열 있으면
	else return false; // 다음 순열 없으면 
	
}*/
 
// 다른 사람 솔루션 (다음 순열 있으면 계속 출력) --> 시간 제일 적게 걸림 
/*
 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	private static int N;
	private static int[] arr;
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		do {
			for (int i = 1; i <= N; i++) {
				sb.append(arr[i]).append(SPACE);
			}
			sb.append(NEW_LINE);
		} while(nextPermutation());// 다음 순열 있으면, 즉, true이면 위에 for문을 계속 실행하며 output만듬 
		System.out.print(sb); // 다음 순열 없으면, 출력 
	}
	
	public static boolean nextPermutation() { 
	// 다음 순열 있으면 구한 다음 , true 넘겨줘서 계속 다음 순열 찾게 만듬
	//  arr[i-1] < arr[i] 값 못찾고 결국 i가 1보다 같거나 작아지면 false 반환하며 다음 순열이 존재하지 않는 것
	  
		int i = N;
		while (i > 1 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i <= 1) return false;
		
		int j = N;
		while (arr[j] <= arr[i - 1]) {
			j--;
		}
		
		swap(i - 1, j);
		
		j = N;
		while (i < j) {
			swap(i, j);
			i++;
			j--;
		}
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
  */
