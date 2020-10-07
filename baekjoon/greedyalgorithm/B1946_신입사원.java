package greedyalgorithm;

import java.io.*;
import java.util.*;

public class B1946_신입사원 { 
	// 원래 내 생각 : 성적 오름차순하고, 각 사람마다 성적 등수가 낮은 애들이 다 면접 등수가 높은지 일일히 확인 (맞으면 선발가능)
	// 솔루션 : 면접등수가 높은지 매번 일일히 검사하지말고 등수가 가장 높은 애보다  높은지만 확인(max 저장해 놓고) 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		while(testCase > 0) {
			int people = Integer.parseInt(br.readLine());
			int[][] score = new int[people][2];
			int pass = 0;

			for(int i = 0 ; i < people ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				score[i][0] = Integer.parseInt(st.nextToken()); // 서류심사 성적
				score[i][1] = Integer.parseInt(st.nextToken()); // 면접성적
			}

			Arrays.sort(score, new Comparator<int[]>() { // 서류 성적기준으로 재정렬
				@Override
				public int compare(int[] start, int[] end) {
					return start[0]-end[0]; // 서류심사 성적 기준으로 오름차순(등수가 높은 순으로 정렬)
				}
			});

			pass ++; // 첫번째 사람은 1등이 있으므로 무조건 합격 가능
			int interviewMin = score[0][1]; // 서류등수가 가장 높은 애(숫자는 제일 작음)의 면접등수
			for(int i = 1 ; i < people ; i++) {
				if(score[i][1] < interviewMin) pass++;
				interviewMin = Math.min(interviewMin, score[i][1]);
			}
			/*원래 내생각(시간 초과)
			 * for(int i = people-1  ; i > 0 ; i--) { 
				pass = 0;
				for(int j = i-1 ; j >= 0 ; j-- ) {
					if(score[i][1] < score[j][1])  pass ++; // 등수가 높으면 이긴거(즉,숫자는 작아야 이긴거)
					else break;
				}
				if(pass == i) output ++;
			}*/
			System.out.println(pass);
			testCase--;
		}
	}
}
