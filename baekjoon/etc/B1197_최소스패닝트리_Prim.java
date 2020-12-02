package etc;

import java.io.*;
import java.util.*;

//정점위주 MTS 알고리즘(정점 수 채우면 MTS 완성 된 것) 
public class B1197_최소스패닝트리_Prim {

	//내부클래스
	public static class Edge implements Comparable<Edge> {
		int node; //다음 선택 할 정점 
		long weight;

		Edge(int node, long weight){
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) { //가중치 순으로 재정렬 
			return (int)(this.weight - e.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); //정점
		int E = Integer.parseInt(st.nextToken()); //간선

		int cnt = 0; //정점 수
		int ans = 0; //가중치 합(답)
		PriorityQueue<Edge> pq = new PriorityQueue<>(); //정점을 가중치 순으로 넣을 큐 
		ArrayList<ArrayList<Edge>> info = new ArrayList<>(); //그래프 정보 담는 리스트(정점 별로 연결된 모든 간선 넣어야하므로): 정점위주 알고리즘이므로
		boolean[] visit = new boolean[V]; //정점 방문 여부

		for(int i = 0; i < V; i ++) info.add(new ArrayList<>()); //정점 수 만큼 만들기

		for(int i = 0; i < E; i++) { //info 정보 채워 넣기(양방향), 정점 1~n은 0~n-1로 
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) -1;
			int end = Integer.parseInt(st.nextToken()) -1;
			int weight = Integer.parseInt(st.nextToken());
			
			//가중치 순으로 리스트 들어간 것 아님 (순서대로 들어간 것)
			info.get(start).add(new Edge(end, weight));
			info.get(end).add(new Edge(start, weight));
		}

		//정점 1(인덱스 0)부터 시작
		pq.add(new Edge(0,0));
		while(!pq.isEmpty()) {
			Edge e = pq.poll(); //큐에 있는 정점 중 가중치 순으로 나옴 (우선순위 큐이므로 가능한 것)
			if(visit[e.node]) continue; //방문한 노드면 굳이 다시 방문 x(최소 구하므로) 
			visit[e.node]= true;
			ans += e.weight;
			
			/* for(Edge next: info.get(e.node)) {
				  if(!visit[next.node]) pq.add(next);
			   }
			*/
			for(int i = 0 ; i < info.get(e.node).size(); i++) {
				Edge next = info.get(e.node).get(i);
				if(!visit[next.node]) pq.add(next); //방문하지 않은경우에만 큐에 들어감(우선순위 큐이므로 가중치순으로 정렬 됨)
			}
			
			if(++cnt == V) break; //정점 수 다 채우면 스패닝트리 완성한 것
		}
		System.out.println(ans);
	}
}


















