package greedyalgorithm;

import java.io.*;
import java.util.*;


//Comparator사용하여 알고리즘대로(끝나는시간 빠른순으로) 회의 재정렬 한 후, 코드 구현
public class B1931_회의실배정 { 

	// 시작시간,끝나는시간이 묶여서(즉,한개의 회의) 비교되야하므로 이차원배열로 받아오는게 좋을 것
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); // 회의 수
		int[][] time = new int[num][2]; // 회의 시작시간,끝시간
		int output = 0;

		for(int i = 0 ; i < num ; i++) { // 회의 시작시간,끝시간 받아오기 
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// Comparator 사용하여 2차원배열(time) 재정렬 하는 코드
		Arrays.sort(time, new Comparator<int[]>() { // <> 안에는 compare메소드의 파라미터와 같은 자료형으로 써주기
			@Override // compare메소드를 내가 정렬하고자 하는 방식으로 재정의
			public int compare(int[] start ,int[] end) {
				// start[0],end[0] 은 각각 첫번째 비교객체,두번째 비교객체의 시작시간
				// start[1],end[1] 은 각각 첫번째 비교객체,두번째 비교객체의 끝시간
				if(start[1] == end[1]) { // 비교하는 2개 회의에 끝시간이 같으면(시작시간 기준 오름차순정렬)
					return start[0]-end[0] ; // 시작시간 오름차순 정렬(두번째 시작시간이 작으면 연산값이 양수가 나오며 자리를 바꿈) 
				}
				else { 
					return start[1]-end[1] ; // 끝시간 오름차순 정렬 
				}
			}
		});
		
		int endTime = time[0][1];
		for(int i = 1 ; i < num ; i++) {
			if(time[i][0] >= endTime) { // 회의 끝시간보다 같거나 늦은 시작시간인 회의만 진행가능
				output ++; //회의시작 
				endTime = time[i][1]; //해당 회의에 끝시간으로 바꿈 
			}
		}
		System.out.print(output+1); // 첫 회의 +1 해주기
		br.close();
		
		/* 회의 갯수 출력할때 다른 코드  
		  int output = 0 ;
		  int endTime = -1;
		  for(int i = 0 ; i < num ; i++){
		  	if(time[i][0] >= endTime){
		  		endTime = time[i][1];
		  		output ++;
		   }
		  }
		 */
	}
}

/* 원래 내코드 : boolean변수 이용해서 회의 전체적으로 탐색 -> 시간초과
int endMin = time[0][1]; // 회의 중 가장 빨리 끝나는 시간
int start  = 0 ; 
boolean ox = true;
int finish = 0;

while(finish == 0) {
	for(int i = 0 ; i < num ; i++) {
		if(start <= time[i][0]) {
			if(ox == true) {
				ox = false; 
				endMin = time[i][1];
			}
			else if(endMin >= time[i][1]){
				endMin = time[i][1];
			}
		}
		if(i == num-1 && ox == true) { // while문 끝나는 조건(끝나는시간보다 큰 회의가 없을떄)
			finish = 1;
		}
	}
	
	if(finish == 0) {
		ox = true; 
		start = endMin;
		output++; // 회의 한개 끝
	}
}
System.out.print(output);
br.close(); */
