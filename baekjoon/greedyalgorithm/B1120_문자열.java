package greedyalgorithm;

import java.util.*;
import java.io.*;

public class B1120_문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken(); // A 받아오기
		String B = st.nextToken(); // B 받아오기

		// (2가지방법) 2중for문 사용 
		int output = A.length(); // 두 개의 문자열이 최대 안맞는 경우는 A의 길이만큼 즉, max는 A의 길이
		int diff = B.length()-A.length(); // 차이
		int tmp = 0;

		for(int i = 0; i <= diff ; i++) {
			for(int j = 0 ; j < A.length() ; j++) {
				if(A.charAt(j) != B.charAt(i+j)) tmp++;
			}
			output = Math.min(output, tmp);
			tmp = 0;
		}
		System.out.print(output);
		return;
	}
}

/*
 * 이중for문이 아닌 while문 사용하면 시간이 줄어 들 순 있어도 변수를 너무 많이 선언해야 해서 코드가 복잡
// (2가지방법) substring으로 부분문자열을 얻어와서 비교하는 방법 
			int output = A.length(); // 두 개의 문자열이 최대 안맞는 경우는 A의 길이만큼 즉, max는 A의 길이
			int diff = B.length()-A.length(); // 차이
			int tmp = 0;

			for(int i = 0; i <= diff ; i++) {
				String subB = B.substring(i,A.length()+i);
				for(int j = 0 ; j < A.length() ; j++) {
					if(A.charAt(j) != subB.charAt(j)) tmp++;
				}
				output = Math.min(output, tmp);
				tmp = 0;
			}
		}
 */
/* 처음 내 생각 : 앞이랑 뒤랑 각각 붙혀서 두개의 경우를 따로 비교 했는데 문제를 읽어보면 앞이랑 뒤 동시에 추가 할 수 도있음(꼭 따로가 아님)  
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());

String A = st.nextToken(); // A 받아오기
String B = st.nextToken(); // B 받아오기

int frontMin = 0;  // 앞에 붙히기
int backMin = 0; // 뒤에 붙히기
//int output = 0 ; //  답

for(int i = 0 ; i < A.length() ; i++) { 
	if(A.charAt(i) != B.charAt(i)) {
		backMin++;
	}
}

if(A.length() == B.length()){
	System.out.print(backMin);
	return;
}
else {
	int diff = B.length()- A.length();
	for(int i = diff-1 ; i >= 0 ; i--) {
		A = B.charAt(i) + A;
	}
	for(int i = 0 ; i < A.length() ; i++) { 
		if(A.charAt(i) != B.charAt(i)) {
			frontMin ++;
		}
	}
	System.out.print(Math.min(frontMin, backMin));
	return;
}
 */