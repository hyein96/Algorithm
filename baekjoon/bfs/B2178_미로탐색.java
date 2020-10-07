package bfs;
// 격자 나오면 사방탐색,팔방탐색 먼저 생각!!!!!!!!!!!!!! dx,dy 이용해서 
// 리스트 선언할 때 두개의 값 동시에 넣고 싶으면 두개의 값 가진 클래스 선언해서 자료형 자리에 클래스형 넣으면 됨
// BFS는 보통 visit(방문배열), 격자배열(map), 큐(bfs) 필요
import java.io.*;
import java.util.*;

public class B2178_미로탐색 {

	static int[][] map ;
	static boolean[][] visit;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M]; //문제의 (1.1)출발은 (0,0)을 의미 , 배열이므로 
		visit = new boolean[N][M]; //방문했는지 확인

		for(int i = 0 ; i < N ; i++ ) {
			String input = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = input.charAt(j) - '0';  //charAt은 문자형으로 받아오므로 그대로 넣으면 map에 아스키코드 값이 저장되기 떄문에 '0'을 빼서 숫자로 저장해줘야 함
			}
		}

		visit[0][0] = true;
		bfs(0,0);
		System.out.print(map[N-1][M-1]);//인덱스가 0부터 시작하므로 구해야 할 값도  map[N-1][M-1]
		br.close();
	}
	
	private static void bfs(int x, int y) { //bfs는 큐사용해서 풀기 
		Queue<XY> qu = new LinkedList<XY>(); // 뒤에 XY는 안써도 가능  
		//dx,dy통해 사방을 다 검색 (오른쪽 , 아래, 왼쪽, 위 순서로 탐색) 
		int[] dx = {0,1,0,-1}; 
		int[] dy = {1,0,-1,0};
		qu.add(new XY(x,y));

		while(!qu.isEmpty()) {
			XY xy = qu.poll(); //큐에서 하나 빼기
			for(int i = 0 ; i < 4; i++) {
				int nextX = xy.x + dx[i];
				int nextY = xy.y + dy[i];

				if(0 <= nextX && nextX < N && 0 <= nextY && nextY < M) { //일단 범위안에 들어야 함
					if(map[nextX][nextY] == 1 && visit[nextX][nextY] == false) {
						qu.add(new XY(nextX, nextY));
						visit[nextX][nextY] = true; 
						map[nextX][nextY] = map[xy.x][xy.y] + 1;
					}
				}
			}
		}
	}
}

class XY { //클래스 선언법 기억
	int x;
	int y;

	XY(int x, int y){ //생성자
		this.x = x;
		this.y = y;
	}
}
