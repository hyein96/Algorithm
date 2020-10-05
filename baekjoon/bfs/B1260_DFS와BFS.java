package BFS;

import java.util.LinkedList;
import java.io.*;
import java.util.*;

// DFS�� ť�� ����, BFS�� ���� �Ǵ� ����Լ��� �����ϴµ� ����Լ��� ���� �������̰� ª�� �ۼ�����  (�Լ��α���)
public class B1260_DFS��BFS {

	// �ؿ� �������� bfs,dfs���� �� ���̹Ƿ� static���� �Լ��ۿ� ���� 
	private static int[][] map; //�������
	private static boolean[] visit; //�湮�ߴ��� ���ߴ���  
	private static int pointCount, lineCount,startPoint;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		pointCount = Integer.parseInt(st.nextToken());
		lineCount = Integer.parseInt(st.nextToken());
		startPoint = Integer.parseInt(st.nextToken());

		map = new int[pointCount+1][pointCount+1]; // ����� ���� Ȯ���Ϸ��� ����
		visit = new boolean[pointCount+1]; // ������ �湮�ߴ��� Ȯ���ؾ��ϹǷ� ����������

		for(int i = 0 ; i <lineCount ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1; // ����� ������� 1(������ִ�) 
		}


		dfs(startPoint,pointCount);		// �������̶� �������� �Ѿ
		
		System.out.println();
		visit = new boolean[pointCount+1]; // dfs�����ϸ� visit�迭 �ٲ�� �ֱ⋚����

		bfs(startPoint,pointCount);
		br.close();

	}

	//bfs �Լ�(ť�̿�)
	private static void bfs(int s, int n) {
		Queue<Integer> qu = new LinkedList<Integer>(); // BFS�� ť�� ����(LIFO)
		qu.offer(s);
		while(!qu.isEmpty()) {
			int out = qu.poll(); // �ϳ��� ���(����) ������
			visit[out] = true; 
			System.out.print(out + " ");

			for(int i = 1 ; i <= n ; i++) {
				if(map[out][i] == 1 && visit[i] == false){ // ������ map�� ����� �� 1�� �ʱ�ȭ �س����Ƿ� �Ѱ��� �ᵵ ����� Ȯ���ϴ� �� 
					qu.add(i);
					visit[i] = true;
				}
			}
		}
	}

	//dfs �Լ�(����Լ��̿�)
	private static void dfs(int s, int n) {
		if(visit[s]) { // �湮�ѰŸ� �ٷ� �Լ�����������(�ð�����X)
			return;
		}
		visit[s] = true; 
		System.out.print(s + " ");

		for(int i = 1; i <=n ; i++) {
			if(map[s][i] == 1 && visit[i] == false) 
				dfs(i,n);
		}
	}
}