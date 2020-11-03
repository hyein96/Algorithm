package graph;

import java.util.*;

public class L3_가장먼노드 {

	public static void main(String[] args) {
		System.out.println(solution(6, new int[][] {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}}));
	}

	private static int solution(int n, int[][] edge) {
		Queue<Integer> qu = new LinkedList<>(); 
		int[] smallDis = new int[n+1]; //각 숫자까지의 최단거리 입력배열 
		boolean[][] visit = new boolean[n+1][n+1];
		for(int i = 0; i < edge.length; i++) {
			visit[edge[i][0]][edge[i][1]] = true;
			visit[edge[i][1]][edge[i][0]] = true;
		}

		qu.add(1); //1부터 시작
		while(!qu.isEmpty()){
			int num = qu.poll();
			for(int i = 2; i < n+1; i++){
				if(smallDis[i] == 0 && visit[num][i] == true){ //smallDis가 0이 아니면 이미 최단경로 찾아진 상태이므로 바꾸면 안됨
					smallDis[i] = smallDis[num] + 1;
					qu.add(i);
				}
			}
		}
		int max = 0; //최단경로 중 가장 긴 경로
		for(int i = 2 ; i < n+1; i++){
			max = Math.max(smallDis[i], max);
		}

		int answer = 0;
		for(int i = 2 ; i <  n+1; i++){
			if(max == smallDis[i]) answer ++;
		}
		return answer;
	}
}
