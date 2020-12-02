package greedyalgorithm;

import java.util.*;

public class L3_섬연결하기 {

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
		public int compareTo(Edge e){ //가중치 순으로 재정렬(오름차순)
			return this.weight - e.weight;
		}
	}

	static int[] parent; //루트노드 담는 배열
	static PriorityQueue<Edge> pq; //그래프 정보(가중치 순으로) 담는 큐
	
	public static void main(String[] args) {
		System.out.println(solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
	}

	public static int solution(int n, int[][] costs) {
		//costs.length: 간선의 수, n: 정점의 수 
		//크루스칼(MTS: 간선위주알고리즘) 사용

 		pq = new PriorityQueue<>();
		parent = new int[n];
		int answer = 0;

		for(int i = 0; i < costs.length; i++){
			Edge edge = new Edge(costs[i][0],costs[i][1], costs[i][2]); 
			pq.add(edge); //바로 new 연산자 사용해서 넣어도 됨 
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

		if(rootA != rootB) parent[rootA] = rootB; //루트가 같으면 같은 집합으로 연결하면 사이클 생김 (rootA, rootB위치는 상관없음)
	}
}
