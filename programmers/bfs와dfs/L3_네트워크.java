package bfs_dfs;

public class L3_네트워크 {
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
		System.out.println(solution(3, new int[][] {{1,1,0},{1,1,1},{0,1,1}}));
	}

	//dfs문제: dfs로  뻗어나가다  연결 끊기면 네트워크 1개 되는 것임 
	private static int solution(int n, int[][] computers) {
		//컴퓨터의 개수로 visit 만들고, true가 되면 네트워크에 속해있다는 의미
		boolean[] visit = new boolean[n];
		int answer = 0;
		for(int i = 0 ; i < computers.length; i++){
			if(visit[i] == false) {
				//dfs 한번이 끝나면 같은 네트워크의 노드들이 결정 됨 
				//끝난 후, false인 노드들은 다른 네트워크를 의미 
				dfs(i, visit, computers);
				answer++;
			}
		}
		return answer;
	}

	private static void dfs(int node, boolean[] visit, int[][] computers){
		//들어온 node는 연결되있는 node와 같은 네트워크(true로 바꾸기)
		visit[node] = true;
		for(int i = 0 ; i < computers.length ; i++){
			if(computers[node][i] == 1 &&  visit[i] == false) {
				dfs(i, visit, computers); //dfs로 연결되있는 노드 끝까지 탐색
			}    
		}
	}
}


