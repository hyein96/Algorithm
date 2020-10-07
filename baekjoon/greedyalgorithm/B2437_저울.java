package greedyalgorithm;

import java.io.*;
import java.util.*;

public class B2437_저울 {
	static int[] weightInput;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); //저울 추 갯수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		weightInput = new int[num]; 
		
		for(int i = 0 ; i < num ; i++) {
			weightInput[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(weightInput); //저울 추의 무게를 오름차순으로 정렬 
		
		int i = 1;
		while(true) {
			if(check(i) == false) {
				break;
			}
			i++; 
		}
		
		System.out.println(i);
		br.close();
	}
	
	private static boolean check(int a) {
		for(int  i = weightInput.length-1 ; i >= 0 ; i--) {
			if(weightInput[i] <= a) {
				a -= weightInput[i];
				if(a == 0) {
					return true;
				}
				continue;
			}
		}
		return false;
	}
}

/* 다른사람 풀이
 public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] weight = new int[n];

        for (int i=0; i<n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        int sum = 0;
        for (int i=0; i<n; i++) {
            if (sum + 1 < weight[i]) {
                break;
            }

            sum += weight[i];
        }

        System.out.println(sum + 1);
    }
 * 
 */
