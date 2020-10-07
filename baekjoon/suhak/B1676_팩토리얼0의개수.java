package suhak;

import java.util.Scanner;
import java.io.*;

public class B1676_팩토리얼0의개수 {
	// 직관적으로 일일히 n!을 구해서 풀면 시간초과 (n이커질수록 n!값은 매우 커지므로)  
	// 10이 곱해져야 뒤에 0이 생김 즉 , 곱해지는 수 중 10의 갯수에따라 뒤에서부터 0의개수가 주어지는 것 ! 
	// 10은 2X5로 만들어지므로 n!에서 n이하의 숫자들을 2와 5로 최대한 끝까지 나눈 후(나뉘어지면) , 2랑 5중에 더 작은 갯수를 가진 숫자가 n!의 10의 갯수가 되며 답이  되는 것(둘 다 한개이상은 되야함) 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int twoNum = 0 ; // 2의갯수
		int fiveNum = 0; // 5의 갯수
		int output = 0 ;
		
		for(int i = 1 ; i <=input ; i ++) {
			int temp = i ; 
			while(temp % 2 == 0) {
				temp /= 2;
				twoNum ++;
			}
			
			while(temp % 5 == 0) {
				temp /= 5;
				fiveNum ++;
			}
		}
		
		if(twoNum >= 1 && fiveNum >=1) {
			output = Math.min(twoNum,fiveNum);
		}
		System.out.print(output);
		br.close();
	}
}
	


/* 틀린코드 -> 직관적으로 생각했으나, n의범위가 자료형 long도 감당못하는 큰값
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
int number = sc.nextInt();
int answer = 0 ;

long factorial = 1; // n이 100까지면 100!는 long도 감당못함 ! 다른방법 찾아야함  

if(number == 0)  factorial= 1;
else {
	for(int i = 1 ; i <= number ; i++) {
		factorial *= i;
	}
}

String factorial2 = String.valueOf(factorial); // factorial(int)를 String으로 ->0의 갯수 구하기 위해 
for(int i = factorial2.length()-1 ; i >= 0 ; i--) {
	if(factorial2.charAt(i) == '0' ) answer++;
	else break;
}

System.out.print(answer);
}
*/