package bfs;

import java.util.*;
import java.io.*;

// bfs����(ť���!!!!!!!!! + ���Ž������ �ȹ�Ž������ ��... + visit�迭(boolean)����) + �丶�乮���� ���Ž�� :
// dfs������ ����Լ�
public class B7576_�丶�� {

	static final int ripeTomato = 1;
	static final int notRipeTomato = 0;
	static int day;

	static class Node {
		// �丶�� ��ġ ��ǥ �� ���� �ѱ�� ���� ������ ����ؼ� Ŭ���� �ٽ� ����
		int x, y;

		//������
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// Queue<Integer> queue = new LinkedList<Integer>() ; �̷��� �ϸ� ť���� Integer ������ ���
		// �� �� ����

		int[][] tomatoInfo;
		day = 0 ;
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		tomatoInfo = new int[N][M];

		// ������ �迭�� �丶�� ���� �ֱ�
		for (int i = 0; i<  N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomatoInfo[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		bfs(tomatoInfo, N, M);
		
		for (int i = 0; i<  N; i++) {
			for (int j = 0; j < M; j++) {
				if(tomatoInfo[i][j]== 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(day-1);
	}

	static void bfs(int[][] tomatoInfo, int N, int M) {

		// ���Ž��
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		Queue<Node> queue = new LinkedList<Node>(); // �� ť���� Node���¸� �� �� ���� --> ���ʸ� �����ϸ� ���� ��

		// ���� �丶�� ��ġ ť�� �ֱ�
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomatoInfo[i][j] == ripeTomato) {
					queue.add(new Node(i, j)); // ��ü ���� ��(Ŭ����), ��ǥ �� ���� �Ѱ���
				}
			}
		}

		while (!queue.isEmpty()) {

			int size = queue.size();
			day++;
			for (int j = 0; j < size; j++) {
				Node node = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];

					if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
						continue;
					}

					if (tomatoInfo[nx][ny] == notRipeTomato) {
						tomatoInfo[nx][ny] = ripeTomato ;
						queue.add(new Node(nx, ny));
					}

				}
			}

		}
	}
}
