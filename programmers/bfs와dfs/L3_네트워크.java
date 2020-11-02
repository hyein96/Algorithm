package bfs_dfs;

public class L3_��Ʈ��ũ {
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
		System.out.println(solution(3, new int[][] {{1,1,0},{1,1,1},{0,1,1}}));
	}

	//dfs����: dfs��  �������  ���� ����� ��Ʈ��ũ 1�� �Ǵ� ���� 
	private static int solution(int n, int[][] computers) {
		//��ǻ���� ������ visit �����, true�� �Ǹ� ��Ʈ��ũ�� �����ִٴ� �ǹ�
		boolean[] visit = new boolean[n];
		int answer = 0;
		for(int i = 0 ; i < computers.length; i++){
			if(visit[i] == false) {
				//dfs �ѹ��� ������ ���� ��Ʈ��ũ�� ������ ���� �� 
				//���� ��, false�� ������ �ٸ� ��Ʈ��ũ�� �ǹ� 
				dfs(i, visit, computers);
				answer++;
			}
		}
		return answer;
	}

	private static void dfs(int node, boolean[] visit, int[][] computers){
		//���� node�� ������ִ� node�� ���� ��Ʈ��ũ(true�� �ٲٱ�)
		visit[node] = true;
		for(int i = 0 ; i < computers.length ; i++){
			if(computers[node][i] == 1 &&  visit[i] == false) {
				dfs(i, visit, computers); //dfs�� ������ִ� ��� ������ Ž��
			}    
		}
	}
}


