package etc;

import java.io.*;
import java.util.*;

//�������� MTS �˰���(���� �� ä��� MTS �ϼ� �� ��) 
public class B1197_�ּҽ��д�Ʈ��_Prim {

	//����Ŭ����
	public static class Edge implements Comparable<Edge> {
		int node; //���� ���� �� ���� 
		long weight;

		Edge(int node, long weight){
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) { //����ġ ������ ������ 
			return (int)(this.weight - e.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); //����
		int E = Integer.parseInt(st.nextToken()); //����

		int cnt = 0; //���� ��
		int ans = 0; //����ġ ��(��)
		PriorityQueue<Edge> pq = new PriorityQueue<>(); //������ ����ġ ������ ���� ť 
		ArrayList<ArrayList<Edge>> info = new ArrayList<>(); //�׷��� ���� ��� ����Ʈ(���� ���� ����� ��� ���� �־���ϹǷ�): �������� �˰����̹Ƿ�
		boolean[] visit = new boolean[V]; //���� �湮 ����

		for(int i = 0; i < V; i ++) info.add(new ArrayList<>()); //���� �� ��ŭ �����

		for(int i = 0; i < E; i++) { //info ���� ä�� �ֱ�(�����), ���� 1~n�� 0~n-1�� 
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) -1;
			int end = Integer.parseInt(st.nextToken()) -1;
			int weight = Integer.parseInt(st.nextToken());
			
			//����ġ ������ ����Ʈ �� �� �ƴ� (������� �� ��)
			info.get(start).add(new Edge(end, weight));
			info.get(end).add(new Edge(start, weight));
		}

		//���� 1(�ε��� 0)���� ����
		pq.add(new Edge(0,0));
		while(!pq.isEmpty()) {
			Edge e = pq.poll(); //ť�� �ִ� ���� �� ����ġ ������ ���� (�켱���� ť�̹Ƿ� ������ ��)
			if(visit[e.node]) continue; //�湮�� ���� ���� �ٽ� �湮 x(�ּ� ���ϹǷ�) 
			visit[e.node]= true;
			ans += e.weight;
			
			/* for(Edge next: info.get(e.node)) {
				  if(!visit[next.node]) pq.add(next);
			   }
			*/
			for(int i = 0 ; i < info.get(e.node).size(); i++) {
				Edge next = info.get(e.node).get(i);
				if(!visit[next.node]) pq.add(next); //�湮���� ������쿡�� ť�� ��(�켱���� ť�̹Ƿ� ����ġ������ ���� ��)
			}
			
			if(++cnt == V) break; //���� �� �� ä��� ���д�Ʈ�� �ϼ��� ��
		}
		System.out.println(ans);
	}
}


















