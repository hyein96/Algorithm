package etc;

import java.io.*;
import java.util.*;

//ũ�罺Į �˰����� union-find �˰������� ����Ŭ �������� �˻� 
public class B1197_�ּҽ��д�Ʈ��_Kruskal {
	
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
		public int compareTo(Edge e) { //���� ����ġ ������ ������
			return (int)(this.weight-e.weight);
		}
	}
	
	static PriorityQueue<Edge> pq; //���� ����ġ ���� �׷��� ���� ���� ť (list�� �����ϸ� �� �ְ� ��������� ��)
	static int[] parent; //�ش� ������ ��Ʈ��� ��
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); //����
		int E = Integer.parseInt(st.nextToken()); //����
		int ans = 0; //����ġ �� 
		
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
			if(find(next.start) == find(next.end)) continue; //��Ʈ��� ������ union�ϸ� ����Ŭ ������
			else {
				union(next.start, next.end);
				ans += next.weight;
			}
		}
		System.out.println(ans);
	}
	
	public static int find(int n) { //��Ʈ ��� ã�� �Լ�
		if(parent[n] == n) return n;
		return parent[n] = find(parent[n]); //�θ��尡 �ƴ϶� �ش� ������ ��Ʈ ������ �ö󰡴� �ڵ�
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		//�� ���� ��Ʈ�� ������ �̹� ���� Ʈ���̹Ƿ� �����ϸ� ����Ŭ �����ϱ� ������ ��ġ�� ����
		if(rootA != rootB) parent[rootA] = rootB; //rootA�� rootB��ġ�� ��� ���� 
	}
}
