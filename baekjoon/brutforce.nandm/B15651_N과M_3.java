package brutforce.nandm;

import java.io.*;
import java.util.*;
//솔루션) 앞에 N과M (1)과(2)는 같은 수를 여러번 고르면 안되기 떄문에 visit인 boolean배열을 이용해 false인 값들만 접근해 출력 할 수 있게 해줬으나
// 이 문제는 같은 수를 여러번 골라도 되므로 , 순서대로 한개씩 출력하면 됨 . 즉, visit배열 필요없음
// 하지만 , 시간초과 뜸 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// 해결법 : 일반적인 입출력(scanner , system.out.print) --> BufferedReader, BufferedWriter 로 바꿔서 코드짜기
public class B15651_N과M_3 {
	
	//static boolean visit[] ; 
	static int output[] ;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//dfs메소드와 main함수에서 bufferedwriter을 사용하므로 static선언  
	
	// 입력처리나 출력부가 함수 안에있으면 무조건, 입출력 예외처리(throws IOException) 해줘야 함 
	static void dfs(int index, int n , int m) throws IOException {
		
		if(index == m) {
			for(int i = 0 ; i < m ; i ++) {
				bw.write(String.valueOf(output[i])); // output[i]은 int형 
				if(i != m-1) 
					bw.write(" ");
			}
			bw.newLine();
		}
		else {
			for(int i =  1 ; i <= n ; i ++) {
				output[index] = i ; 
				dfs(index+1 ,n,m);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 공백을 기준으로 입력받으므로 공백 구분 위해 StringTokenizer 객체 사용 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		output = new int[m];
		
		dfs(0,n,m);
		
		br.close();
		bw.flush(); // BufferedWriter클래스는 프로그램 종료전에 flush() 해줘야 올바르게 출력 값 나옴 
		bw.close();
		
		
	}
}
