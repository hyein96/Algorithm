package greedyalgorithm;

import java.io.*;
import java.util.*;


public class B11399_ATM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int personNum = Integer.parseInt(br.readLine());
		int[] input = new int[personNum];
		int output = 0 ; 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < personNum ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		for(int i = 0 ; i < personNum ; i ++) {
			output += input[i] * (personNum-i);
		}
		
		System.out.print(output);
		br.close();
	}
}
