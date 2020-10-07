package bfs;

import java.util.*;
import java.io.*;

public class B2667_������ȣ���̱� { //bfs�� Ǯ �� ���ְ� dfs�ε� ���� 
	// BFS : ����for�� ������ map�� 1�� ĭ ã�Ƽ� (visit��������) bfs������ , ������ ��ŭ �迭 ���� ��, map�迭�� �� �������ְ� ������ ���� map�迭 �� ���� �� �ε����� �ֱ�    

	// ��������(static)�� private�� ���� 
	private static int[][] map ;
	private static int mapSize;
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	private static boolean [][] visit;
	private static int apart = 0; // ����(1����,2���� ��...) 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mapSize = Integer.parseInt(br.readLine()); //������ ũ�� 
		map = new int[mapSize][mapSize];
		visit = new boolean[mapSize][mapSize];

		//������ �Է� 
		for(int i = 0 ; i < mapSize ; i++) {
			String data = br.readLine();
			for(int j = 0 ; j < mapSize ; j++) {
				map[i][j] = data.charAt(j) - '0' ; //�ƽ�Ű�ڵ�� �޾ƿ��Ƿ� -'0'
			}
		} 

		for(int i = 0 ; i < mapSize; i++) {
			for(int j = 0 ; j < mapSize ; j++) {
				if(map[i][j] == 1 && visit[i][j] == false) { 
					++ apart ; //���� �� �Ѱ� �ø��� bfs���� map�迭�� �ش��ϴ� ���� �ֱ�
					//bfs(i,j);
					dfs(i,j);
				}
			}
		}
		
		int[] output = new int[apart]; // ���� �� �迭 (�� �ε����� ������ ���ϴ� �� �� ���� ��)
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
	private static void dfs(int x, int y) { //ť ���� �� �� ����� ����Լ��� ���� (bfs���� ���� ���� + �ð� �� �ɸ�)
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

//���� ��Ű�� �ȿ��� Ŭ���� �̸� �����ϰ� ���� x (BFS ��Ű�� �ȿ� XYŬ���� �����Ƿ� �ٸ��� �̸� ����) 
class XY2 { //Ŭ���� ����� ���
	int x;
	int y;

	XY2(int x, int y){ //������
		this.x = x;
		this.y = y;
	}
}
