package brutforce.sunyeol;

import java.io.*;
import java.util.*;
// 솔루션 암기(다른 문제에서도 많이 쓰임)
public class B10972_다음순열 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] input; // 둘째 줄에 입력으로 들어오는 수열 
		int n = Integer.parseInt(br.readLine());
		input = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		// 다음 순열 구하는 솔루션
		boolean last = true; // 사전 순으로 마지막으로 오는 순열일 경우 true 
	 
		for(int i = n-1 ; i > 0 ; i--) { // n이 input.length ! 
			if(input[i-1] < input[i]) {
				last = false;
				for(int j = n-1 ; j >= 0 ; j--) {
					if(input[j] > input[i-1]) {
						//swap하는 방법 (변수 여러개 선언 필요없이,temp 한 개만있으면 swap가능 // swap법 암기)
						int temp = input[j];
						input[j] = input[i-1];
						input[i-1] = temp;
						break; // 두번째 for문 탈출 
					}
				}
				int k = n-1; // k는 맨 마지막수 --> i부터 맨마지막수까지 전부 뒤집는다 
				while(i < k) {
					int temp2 = input[k];
					input[k] = input[i];
					input[i] = temp2;
					i++;
					k--;
				}
				break; // 첫번째 for문 탈출
			}
		}
		
		if(last) 
			bw.write(String.valueOf(-1));
		else {
			for(int i = 0 ; i < n ; i++ ) {
				bw.write(String.valueOf(input[i]));
				if(i != n-1) bw.write(" ");
			}
		} 
		
		br.close();
		bw.flush();
		bw.close();
	}
}
/* 솔루션은 똑같은데 다른 사람 코드 
 * 이중for문 쓰고 break를 두번 하지않고, for문에 이름을 정한뒤(Loop1) break Loop1; 해서 이중for문 한꺼번에 나감
 * 코드가 길어지면 main함수는 짧게 쓰고, 주요함수는 새로운 함수로 선언해서 코드 짜는 것 익숙 해지기   
 public class Beak10972 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
 
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
 
        nextPermutation(arr);
 
        sc.close();
    }
 
    private static void nextPermutation(int[] arr) {
        int n = arr.length;
        boolean b = true;
        Loop1: for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                for (int j = n - 1; j >= i; j--) {
                    if (arr[j] > arr[i - 1]) {
                        int temp = arr[j];
                        arr[j] = arr[i - 1];
                        arr[i - 1] = temp;
                        int k = n - 1;
                        while (i < k) {
                            int temp2 = arr[i];
                            arr[i] = arr[k];
                            arr[k] = temp2;
                            i++;
                            k--;
                        }
                        b = false;
                        break Loop1;
                    }
                }
            }
        }
        if (b) {
            System.out.println(-1);
        } else {
            showArray(arr);
        }
    }
 
    private static void showArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
 
*/
