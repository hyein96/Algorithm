package bfs;

import java.util.*;
import java.io.*;

public class B2667_단지번호붙이기 { //bfs로 풀 수 도있고 dfs로도 가능 
	// BFS : 이중for문 돌려서 map이 1인 칸 찾아서 (visit안했으면) bfs돌리기 , 단지수 만큼 배열 선언 후, map배열에 각 단지수넣고 단지수 가진 map배열 수 세서 각 인덱스에 넣기    

	// 정적변수(static)은 private로 선언 
	private static int[][] map ;
	private static int mapSize;
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	private static boolean [][] visit;
	private static int apart = 0; // 단지(1단지,2단지 등...) 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mapSize = Integer.parseInt(br.readLine()); //지도의 크기 
		map = new int[mapSize][mapSize];
		visit = new boolean[mapSize][mapSize];

		//데이터 입력 
		for(int i = 0 ; i < mapSize ; i++) {
			String data = br.readLine();
			for(int j = 0 ; j < mapSize ; j++) {
				map[i][j] = data.charAt(j) - '0' ; //아스키코드로 받아오므로 -'0'
			}
		} 

		for(int i = 0 ; i < mapSize; i++) {
			for(int j = 0 ; j < mapSize ; j++) {
				if(map[i][j] == 1 && visit[i][j] == false) { 
					++ apart ; //단지 수 한개 늘리고 bfs들어가서 map배열에 해당하는 단지 넣기
					//bfs(i,j);
					dfs(i,j);
				}
			}
		}
		
		int[] output = new int[apart]; // 단지 수 배열 (각 인덱스의 단지에 속하는 집 수 넣을 것)
		for(int i = 0 ; i < mapSize ; i++) {
			for(int j = 0 ; j <mapSize ; j++) {
				if(map[i][j] != 0) {
					output[map[i][j] -1] ++;
				}
			}
		}
		
		Arrays.sort(output);
		System.out.println(apart);
		for(int i = 0 ; i < apart ; i++) 
			System.out.println(output[i]);
		
	}

	/* private static void bfs(int x, int y) { //BFS
		Queue<XY2> qu = new LinkedList<>();
		visit[x][y] = true;
		map[x][y] = apart;
		qu.add(new XY2(x,y));

		while(!qu.isEmpty()) {
			XY2 xy = qu.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int nextX = xy.x + dx[i];
				int nextY = xy.y + dy[i];
				if(0 <= nextX && nextX < mapSize && 0 <= nextY && nextY < mapSize) {
					if(map[nextX][nextY] == 1 && visit[nextX][nextY] == false) {
						map[nextX][nextY] = apart; 
						visit[nextX][nextY] = true;
						qu.add(new XY2(nextX,nextY));
					}
				}
			}
		}
	} */
	private static void dfs(int x, int y) { //큐 선언 할 필 요없이 재귀함수로 구현 (bfs보다 좀더 간단 + 시간 덜 걸림)
		visit[x][y] = true; 
		map[x][y] = apart;
		
		for(int i = 0 ; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(0 <= nextX && nextX < mapSize && 0 <= nextY && nextY < mapSize) {
				if(map[nextX][nextY] == 1 && visit[nextX][nextY] == false) {
					map[nextX][nextY] = apart; 
					visit[nextX][nextY] = true;
					dfs(nextX,nextY);
				}
			}
		}
	}
	
}

//같은 패키지 안에서 클래스 이름 동일하게 선언 x (BFS 패키지 안에 XY클래스 있으므로 다르게 이름 지정) 
class XY2 { //클래스 선언법 기억
	int x;
	int y;

	XY2(int x, int y){ //생성자
		this.x = x;
		this.y = y;
	}
}
