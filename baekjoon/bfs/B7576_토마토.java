package bfs;

import java.util.*;
import java.io.*;

// bfs문제(큐사용!!!!!!!!! + 사방탐색할지 팔방탐색할지 등... + visit배열(boolean)선언) + 토마토문제는 사방탐색 :
// dfs문제는 재귀함수
public class B7576_토마토 {

	static final int ripeTomato = 1;
	static final int notRipeTomato = 0;
	static int day;

	static class Node {
		// 토마토 위치 좌표 값 같이 넘기기 위해 생성자 사용해서 클래스 다시 선언
		int x, y;

		//생성자
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// Queue<Integer> queue = new LinkedList<Integer>() ; 이렇게 하면 큐에는 Integer 변수만 들어
		// 갈 수 있음

		int[][] tomatoInfo;
		day = 0 ;
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		tomatoInfo = new int[N][M];

		// 이차원 배열에 토마토 정보 넣기
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

		// 사방탐색
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		Queue<Node> queue = new LinkedList<Node>(); // 이 큐에는 Node형태만 들어갈 수 있음 --> 제너릭 공부하면 이해 됨

		// 익은 토마토 위치 큐에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomatoInfo[i][j] == ripeTomato) {
					queue.add(new Node(i, j)); // 객체 생성 후(클래스), 좌표 값 같이 넘겨줌
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
