package jaryogujo;

import java.util.Scanner;

public class B10824_네수 {

	// 이 문제는 네 자리 자연수가 1에서 1,000,000까지 이므록 붙혀서 더하면 
	// int의 표현범위 -2,147,483,648~2,147,483,648를 넘어감
	// 따라서 -9,223,372,036,854,775,808 범위인 long형으로 자료형을 정해야 하는게 핵심 !
	
	// 자연수 사이의 공백이 일정하지 않거나, 한 줄로 입력이 오지 않으면 내 코드는 실행 안됨(밑에 코드로 해야함)
	public static void main(String[] args) {
		
		String input;
		String[] divString;
		long answer ; 
		
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextLine();
		
		divString = input.split(" ");
		
		
		answer = Long.parseLong(divString[0]+divString[1]) + Long.parseLong(divString[2]+ divString[3]);
		
		System.out.print(answer);
		
		
		
	}
}


/* 다른사람 코드
// next()메소드는 공백 이전까지의 문자열 입력 받고 nextLine()는 문자열 전체(enter값 기준으로 메소드종료) 입력받음 
// next()메소드에서 정수,실수 입력받는게 next+자료형()
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        String A = String.valueOf(a);
        String B = String.valueOf(b);
        String C = String.valueOf(c);
        String D = String.valueOf(d);
        A += B;
        C += D;
        long ans1 = Long.valueOf(A);
        long ans2 = Long.valueOf(C);
        System.out.println(ans1+ans2);
    }
}*/