package BFS;

import java.util.LinkedList;
import java.io.*;
import java.util.*;

// DFS는 큐로 구현, BFS는 스택 또는 재귀함수로 구현하는데 재귀함수가 좀더 보편적이고 짧게 작성가능  (함수로구현)
public class B1260_DFS와BFS {

	// 밑에 변수들은 bfs,dfs에서 다 쓰이므로 static으로 함수밖에 선언 
	private static int[][] map; //연결상태
	private static boolean[] visit; //방문했는지 안했는지  
	private static int pointCount, lineCount,startPoint;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		pointCount = Integer.parseInt(st.nextToken());
		lineCount = Integer.parseInt(st.nextToken());
		startPoint = Integer.parseInt(st.nextToken());

		map = new int[pointCount+1][pointCount+1]; // 연결된 상태 확인하려고 만듬
		visit = new boolean[pointCount+1]; // 정점이 방문했는지 확인해야하므로 정점갯수로

		for(int i = 0 ; i <lineCount ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1; // 양방향 연결상태 1(연결되있다) 
		}


		dfs(startPoint,pointCount);		// 시작점이랑 정점갯수 넘어감
		
		System.out.println();
		visit = new boolean[pointCount+1]; // dfs실행하면 visit배열 바뀌어 있기떄문에

		bfs(startPoint,pointCount);
		br.close();

	}

	//bfs 함수(큐이용)
	private static void bfs(int s, int n) {
		Queue<Integer> qu = new LinkedList<Integer>(); // BFS는 큐로 구현(LIFO)
		qu.offer(s);
		while(!qu.isEmpty()) {
			int out = qu.poll(); // 하나의 노드(정점) 꺼내기
			visit[out] = true; 
			System.out.print(out + " ");

			for(int i = 1 ; i <= n ; i++) {
				if(map[out][i] == 1 && visit[i] == false){ // 위에서 map을 양방향 다 1로 초기화 해놨으므로 한개만 써도 양방향 확인하는 것 
					qu.add(i);
					visit[i] = true;
				}
			}
		}
	}

	//dfs 함수(재귀함수이용)
	private static void dfs(int s, int n) {
		if(visit[s]) { // 방문한거면 바로 함수빠져나오기(시간낭비X)
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