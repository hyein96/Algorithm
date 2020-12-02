package greedyalgorithm;

import java.util.*;

public class L3_�������ϱ� {

	static class Edge implements Comparable<Edge> {
		int start;
		int end; 
		int weight;

		Edge(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e){ //����ġ ������ ������(��������)
			return this.weight - e.weight;
		}
	}

	static int[] parent; //��Ʈ��� ��� �迭
	static PriorityQueue<Edge> pq; //�׷��� ����(����ġ ������) ��� ť
	
	public static void main(String[] args) {
		System.out.println(solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
	}

	public static int solution(int n, int[][] costs) {
		//costs.length: ������ ��, n: ������ �� 
		//ũ�罺Į(MTS: �������־˰���) ���

 		pq = new PriorityQueue<>();
		parent = new int[n];
		int answer = 0;

		for(int i = 0; i < costs.length; i++){
			Edge edge = new Edge(costs[i][0],costs[i][1], costs[i][2]); 
			pq.add(edge); //�ٷ� new ������ ����ؼ� �־ �� 
		}
		for(int i = 0; i < n; i ++) parent[i] = i;

		while(!pq.isEmpty()){
			Edge next = pq.poll();
			if(find(next.start) == find(next.end)) continue;
			else {
				union(next.start, next.end);
				answer += next.weight; 
			}
		}
		return answer;
	}

	static public int find(int n){
		if(n == parent[n]) return n;
		else return parent[n] = find(parent[n]);
	}

	static public void union(int a, int b){
		int rootA = find(a);
		int rootB = find(b); 

		if(rootA != rootB) parent[rootA] = rootB; //��Ʈ�� ������ ���� �������� �����ϸ� ����Ŭ ���� (rootA, rootB��ġ�� �������)
	}
}
