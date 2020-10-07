package brutforce.nandm;

import java.util.Scanner;

//1번이랑 다른 점은 고른 수열이 오름차순이여야 한다는 점 

public class B15650_N과M_2 {

	static boolean[] visit ; // 숫자에 방문 했는지 안했는지 확인하는 노드
	// 숫자가 중복 안되게 하려면 필요 , n의 크기만큼 필요한데  1부터 시작해서 n까지므로 배열크기는 n+1필요(인덱스 0부터이므로)
	static int[] output ; // 한 줄에 출력할 숫자들 (m의 크기만큼)
	
	static void dfs(int index, int n, int m)  // dfs함수에 static을 붙혀줘야 main함수에서 dfs함수 호출 가능
	{ 
		if (index == m) { // 한 줄에 m개를 다 채우면 (output을)
			for (int i = 0; i < m; i++) {  // m개 출력
				System.out.print(output[i]); 
				if (i != m - 1) //출력하는 수가 m번째 즉,마지막 수이면 공백 줄 필요없이 바로 줄바꿈 
					System.out.print(" "); 
				} 
			System.out.println(); 
			//return;  // return 해줘야 밑에 for문 실행 안시키고  dfs 빠져나감 ! 반환값은 void므로 return; 만 해주면 됨 --> 지우고 밑에 코드 else로 묶기 
		} 
		else {
			for (int i = 1; i <= n; i++) {
			
				if (visit[i]) { 
					continue; 
				}
			
				// 이 2줄을 밑에있는 if문 안에 넣으면 실행안됨
				// output을받아서 비교를 한뒤, 재귀함수를 돌릴지 결정해야하는데 if문 안에 넣으면 output[index] 값을 받지 못함 
				visit[i] = true;
				output[index] = i; 
			
				// N과M(1) 과 다른점 한 줄 ! 
				if(index == 0 || index > 0 && output[index-1]<output[index]) {
					dfs(index + 1, n, m); 
				}
				visit[i] = false;             
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
