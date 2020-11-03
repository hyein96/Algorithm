package graph;

import java.util.*;

public class L3_����ճ�� {

	public static void main(String[] args) {
		System.out.println(solution(6, new int[][] {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}}));
	}

	private static int solution(int n, int[][] edge) {
		Queue<Integer> qu = new LinkedList<>(); 
		int[] smallDis = new int[n+1]; //�� ���ڱ����� �ִܰŸ� �Է¹迭 
		boolean[][] visit = new boolean[n+1][n+1];
		for(int i = 0; i < edge.length; i++) {
			visit[edge[i][0]][edge[i][1]] = true;
			visit[edge[i][1]][edge[i][0]] = true;
		}

		qu.add(1); //1���� ����
		while(!qu.isEmpty()){
			int num = qu.poll();
			for(int i = 2; i < n+1; i++){
				if(smallDis[i] == 0 && visit[num][i] == true){ //smallDis�� 0�� �ƴϸ� �̹� �ִܰ�� ã���� �����̹Ƿ� �ٲٸ� �ȵ�
					smallDis[i] = smallDis[num] + 1;
					qu.add(i);
				}
			}
		}
		int max = 0; //�ִܰ�� �� ���� �� ���
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
