package jaryogujo;

import java.util.Scanner;

public class B10809_���ĺ�ã�� {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] alNumber = new int['z'-'a'+1] ; // [] �ڸ��� 26 �־ ��
		String input ;
		
		input = sc.next();
		 for(int i = 0 ; i< alNumber. length ; i ++){
		  	alNumber[i] = -1 ; // ��°��� �� -1 �� �ٲ����
		  }
		  
		  for(int i = 0 ; i < input.length() ; i ++){
		  		char c = input.charAt(i); // �Է¹��� ���ڿ��� �ѹ��� ������
		  		int index = input.indexOf(c) ; // ���ڿ����� �� �ѹ��ڰ� ���� ó���� ������ ��ġ�� �ε��� �� ������ �ֱ�
		  		alNumber[c-'a'] = index ; // ��� ���ڿ��� �ش� ���� ��ġ�� �ֱ� 	
		  		                       // ��� ���ڿ��� �ε����� 0���� �����ϹǷ� 'a'�� �ε����� 0 'b'�� �ε����� 1��
		  		                       // � ���� c�� �ε����� c-'a'(a�� �ƽ�Ű�ڵ尪) �̶��� �� �� �ִ�. 
		  
		  }
		  
	 	 for(int i = 0 ; i < alNumber.length ; i++) {
				System.out.print(alNumber[i]+" ");
			}
	 
	}
}
	

/* �ٽ� § �ڵ� (indexOf(), �ƽ�Ű�ڵ� Ȱ�� 
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int[] alNumber = new int['z'-'a'+1] ; // [] �ڸ��� 26 �־ ��
	String input ;
	
	input = sc.next();
	 for(int i = 0 ; i< alNumber. length ; i ++){
	  	alNumbe[i] = -1 ; // ��°��� �� -1 �� �ٲ����
	  }
	  
	  for(int i = 0 ; i < input.length() ; i ++){
	  		char c = input.charAt(i); // �Է¹��� ���ڿ��� �ѹ��� ������
	  		int index = input.indexOf(c) ; // ���ڿ����� �� �ѹ��ڰ� ���� ó���� ������ ��ġ�� �ε��� �� ������ �ֱ�
	  		alNum[c-'a'] = index ; // ��� ���ڿ��� �ش� ���� ��ġ�� �ֱ� 	
	  		                       // ��� ���ڿ��� �ε����� 0���� �����ϹǷ� 'a'�� �ε����� 0 'b'�� �ε����� 1��
	  		                       // � ���� c�� �ε����� c-'a'(a�� �ƽ�Ű�ڵ尪) �̶��� �� �� �ִ�. 
	  
	  }
	  
 	 for(int i = 0 ; i < alNumber.length ; i++) {
			System.out.print(alNumber[i]+" ");
		}
 
 
 
  */
/* �ٸ� ����ڵ� : �ſ� ���� (indexOf() ���)
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String input = sc.next();

	for (char c = 'a' ; c <= 'z' ; c++)
       System.out.print(input.indexOf(c) + " ");
}
*/