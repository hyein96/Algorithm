package jaryogujo;

import java.util.Arrays;
import java.util.Scanner;

public class B11656_접미사배열 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input ;
		String[] answer ; 
		
		input = sc.next();
		answer = new String[input.length()];
		
		for(int i = 0 ; i < input.length(); i++) {
			answer[i] = input.substring(i);
		}
		
		
		Arrays.sort(answer);
		
		for(int i = 0 ; i < input.length(); i++) {
			System.out.println(answer[i]);
		}
		
		
	}
}
