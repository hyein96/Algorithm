package jaryogujo;

import java.util.Scanner;

public class B10820_���ڿ��м� {
// �Ѳ����� �Է��� ���������Ƿ� �׳� �׷��� �Է� ������ �� . ���ٷ� ���� ��µǴ°� �Ű�x
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

