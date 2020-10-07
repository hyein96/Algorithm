package jaryogujo;

import java.util.Scanner;

public class B10820_문자열분석 {
// 한꺼번에 입력을 받으랬으므로 그냥 그렇게 입력 받으면 됨 . 한줄로 각각 출력되는건 신경x
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			
			String s = sc.nextLine();
			int lower =0;
			int upper = 0;
			int number= 0;
			int space = 0 ;
			
			
			for(int i = 0 ; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c == ' ') 
					space++;
				else if('a' <= c && c <='z')
					lower++;
				else if('A' <= c && c <='Z')
					upper++;
				else
					number++;
				
			}
			
			System.out.println(lower + " "+ upper +" "+ number + " " + space);
		
		
		
		}
		
		
	}
}

