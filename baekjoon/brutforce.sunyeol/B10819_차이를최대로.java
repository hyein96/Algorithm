package brutforce.sunyeol;
// 처음엔 오름 차순한 후, 제일큰수 제일작은수 그다음큰수 ... 로 나열해서 구하면 답 나올줄 알았으나 X
// 전체 탐색으로 모든 순열 구한후, 각자 더해서 비교 후 max 구하기 --> 모든 순열구하는 코드 2가지 있는데 그 2가지로 다 코드 짤수 있어야 함 
import java.io.*;
import java.util.*;

public class B10819_차이를최대로 {
	
	static int n;
	static int[] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[n];
		for(int i = 0 ; i < n; i ++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		int max = 0 ;
		do {
			int sum = 0;
			for(int i = 1 ; i < n ; i ++) {
				
				sum += Math.abs(input[i-1]-input[i]); // math.abs는 인자값에 대한 절대값 반환하는 함수
			}
			
			if(sum > max) // Math.max(sum,max) 해도 됨 
				max = sum;
			
		}while(nextPermutation());
	
		System.out.println(max);
	}
	
	static boolean nextPermutation() {
		boolean next = false;
		for(int i = n-1 ; i > 0 ; i --) {
			if(input[i-1] < input[i]) {
				next = true;
				for(int j = n-1 ; j > 0 ; j --) {
					if(input[i-1] < input[j]) {
						int temp = input[j];
						input[j] = input[i-1];
						input[i-1] = temp;
						break;
					}
				}
				int k = n-1;
				while(i < k) {
					int temp2 = input[k];
					input[k] = input[i] ;
					input[i] = temp2;
					i++;
					k--;
				}
				break;
			}
		}
		if(next) return true;
		else return false;
	}
}
// 다른 사람 솔루션 : 순열 알고리즘을 구현 후, 모든 순열에서 max 찾아서 반환 (순열알고리즘 이해 ★)

