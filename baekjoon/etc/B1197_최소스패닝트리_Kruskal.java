package etc;

import java.io.*;
import java.util.*;

//크루스칼 알고리즘은 union-find 알고리즘으로 사이클 형성여부 검사 
public class B1197_최소스패닝트리_Kruskal {
	
	public static class Edge implements Comparable<Edge> {
		int start;
		int end;
		long weight;
		
		Edge(int start, int end, long weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) { //간선 가중치 순으로 재정렬
			return (int)(this.weight-e.weight);
		}
	}
	
	static PriorityQueue<Edge> pq; //간선 가중치 별로 그래프 정보 저장 큐 (list로 저장하면 값 넣고 정렬해줘야 함)
	static int[] parent; //해당 정점의 루트노드 값
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); //정점
		int E = Integer.parseInt(st.nextToken()); //간선
		int ans = 0; //가중치 합 
		
		pq = new PriorityQueue<Edge>();  
		parent = new int[V+1];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(start, end, weight)); 
		}
			
		for(int i = 1; i <= V; i++) parent[i] = i;
		
		while(!pq.isEmpty()) {
			Edge next = pq.poll();
			if(find(next.start) == find(next.end)) continue; //루트노드 같은데 union하면 사이클 형성됨
			else {
				union(next.start, next.end);
				ans += next.weight;
			}
		}
		System.out.println(ans);
	}
	
	public static int find(int n) { //루트 노드 찾는 함수
		if(parent[n] == n) return n;
		return parent[n] = find(parent[n]); //부모노드가 아니라 해당 정점의 루트 노드까지 올라가는 코드
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		//두 값의 루트가 같으면 이미 같은 트리이므로 연결하면 사이클 형성하기 때문에 합치지 않음
		if(rootA != rootB) parent[rootA] = rootB; //rootA와 rootB위치는 상관 없음 
	}
}
