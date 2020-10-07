package bfs;
// ���� ������ ���Ž��,�ȹ�Ž�� ���� ����!!!!!!!!!!!!!! dx,dy �̿��ؼ� 
// ����Ʈ ������ �� �ΰ��� �� ���ÿ� �ְ� ������ �ΰ��� �� ���� Ŭ���� �����ؼ� �ڷ��� �ڸ��� Ŭ������ ������ ��
// BFS�� ���� visit(�湮�迭), ���ڹ迭(map), ť(bfs) �ʿ�
import java.io.*;
import java.util.*;

public class B2178_�̷�Ž�� {

	static int[][] map ;
	static boolean[][] visit;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M]; //������ (1.1)����� (0,0)�� �ǹ� , �迭�̹Ƿ� 
		visit = new boolean[N][M]; //�湮�ߴ��� Ȯ��

		for(int i = 0 ; i < N ; i++ ) {
			String input = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = input.charAt(j) - '0';  //charAt�� ���������� �޾ƿ��Ƿ� �״�� ������ map�� �ƽ�Ű�ڵ� ���� ����Ǳ� ������ '0'�� ���� ���ڷ� ��������� ��
			}
		}

		visit[0][0] = true;
		bfs(0,0);
		System.out.print(map[N-1][M-1]);//�ε����� 0���� �����ϹǷ� ���ؾ� �� ����  map[N-1][M-1]
		br.close();
	}
	
	private static void bfs(int x, int y) { //bfs�� ť����ؼ� Ǯ�� 
		Queue<XY> qu = new LinkedList<XY>(); // �ڿ� XY�� �Ƚᵵ ����  
		//dx,dy���� ����� �� �˻� (������ , �Ʒ�, ����, �� ������ Ž��) 
		int[] dx = {0,1,0,-1}; 
		int[] dy = {1,0,-1,0};
		qu.add(new XY(x,y));

		while(!qu.isEmpty()) {
			XY xy = qu.poll(); //ť���� �ϳ� ����
			for(int i = 0 ; i < 4; i++) {
				int nextX = xy.x + dx[i];
				int nextY = xy.y + dy[i];

				if(0 <= nextX && nextX < N && 0 <= nextY && nextY < M) { //�ϴ� �����ȿ� ���� ��
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

class XY { //Ŭ���� ����� ���
	int x;
	int y;

	XY(int x, int y){ //������
		this.x = x;
		this.y = y;
	}
}
