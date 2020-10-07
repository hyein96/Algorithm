package greedyalgorithm;

import java.io.*;
import java.util.*;

public class B2875_대회or인턴 {

	// 솔루션 : 먼저, 각각의 여학생과 남학생수로 만들 수 있는 팀의 갯수 중 작은 수가 총 팀의 갯수
	// 팀을 만들고 남은 여학생,남학생은 인턴으로 보냄 (인턴수 - 남은 사람 수) 
	// 뺏는데도 인턴 수가 남으면, 한 개의 팀을 해체하고(-3) 그만큼 또 인턴으로 보냄(인턴 수가 0이하가 될때까지 반복)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[3];

		for(int i = 0; i <3 ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int teamNum = Math.min(input[0] / 2 , input[1] / 1); 
		int intern = input[2] - ((input[0]- teamNum*2) + (input[1] - teamNum)); // 팀 구성하고 남은 애들 인턴으로

		while(intern > 0 ) {
			if(teamNum < 0) { // -인 팀은 없음(제외 해줘야 함)
				teamNum = 0;
				break;
			}
			teamNum --;
			intern -= 3;
		}
		System.out.print(teamNum);
		br.close();
	}
}
