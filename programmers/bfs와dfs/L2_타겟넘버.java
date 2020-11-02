package bfs_dfs;

public class L2_타겟넘버 {

	//DFS 문제 
	static int answer = 0;
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,1,1,1,1}, 3));
	}
	
	//각 인덱스 값이 +,- 인경우 모두 고려해서 값 계산 후,target 이랑 같으면  answer++
    //매번 들어갈 때마다, +,-  고려해줘야 하므로 재귀함수로 구현(DFS) 
	private static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0);
        return answer;
    }
	
    private static void dfs(int[] numbers, int target, int index) {
        if(index == numbers.length) {
            int sum = 0; 
            for(int i = 0 ; i < index; i++){
                sum += numbers[i];
            }
            if(sum == target) answer++;
        }
        else {
            numbers[index] *= 1; 
            dfs(numbers, target, index+1);
            // *= -1을 먼저하면 +인 경우 나올 수 없으므로 *= 1 먼저 하기 
            numbers[index] *= -1;
            dfs(numbers, target, index+1);
        }
    }
}

/* 다른 사람 풀이
// 나랑 똑같은 알고리즘인데 +,- 모든 경우 고려해서 더한걸 빨리 찾는 방법&코드(모든 경우의 수를 빨리 찾는 방법)
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}

*/