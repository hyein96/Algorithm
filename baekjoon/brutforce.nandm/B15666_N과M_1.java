package brutforce.nandm;

import java.util.Scanner;
// 솔루션 : BFS알고리즘 활용 (한 노드 잡으면 깊이 우선으로 다 뒤져서 출력하고 출력할거 없으면 백트래킹으로 다음 노드로 바꿈)
// DFS는 재귀함수로 짜기 ! 
public class B15666_N과M_1 {

	// main이랑 dfs함수에서 다쓰는 변수들은 static으로 선언해줘야 사용 가능 
	
	static boolean[] visit ; // 숫자에 방문 했는지 안했는지 확인하는 노드
	// 숫자가 중복 안되게 하려면 필요 , n의 크기만큼 필요한데  1부터 시작해서 n까지므로 배열크기는 n+1필요(인덱스 0부터이므로)
	static int[] output ; // 한 줄에 출력할 숫자들 (m의 크기만큼)
	
	static void dfs(int index, int n, int m) 
	{ 
		if (index == m) { // 한 줄에 m개를 다 채우면 (output을)
			for (int i = 0; i < m; i++) {  // m개 출력
				System.out.print(output[i]); 
				if (i != m - 1) //출력하는 수가 m번째 즉,마지막 수이면 공백 줄 필요없이 바로 줄바꿈 
					System.out.print(" "); // 공백 주기  
				} 
			System.out.println(); 
			} 
		else {	
			for (int i = 1; i <= n; i++) {
				// boolean 기본값은 false 
				if (visit[i]) { // 방문한 노드이면 (즉, output에 입력된 노드라면)
					continue; 
				}
			
				visit[i] = true; // 방문한걸로 바꾸고
				output[index] = i; // 출력에 넣어주기 
				dfs(index + 1, n, m); // 다음 출력 값 넣어주기 위해 재귀함수 사용
				visit[i] = false; // 출력한 후에는 output에 뺸거 이므로 방문하지 않은 노드가 됨
			                  // 안해주면 다음 출력 줄부터는 i라는 숫자를 출력 못함 
			} 
		}
	}
	public static void main(String[] args) { 
		
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int m = sc.nextInt();
		
		visit = new boolean[n+1];
		output = new int[m];
		
		dfs(0, n, m); 
	}

}
