package bfs_dfs;

public class L2_Ÿ�ٳѹ� {

	//DFS ���� 
	static int answer = 0;
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,1,1,1,1}, 3));
	}
	
	//�� �ε��� ���� +,- �ΰ�� ��� ����ؼ� �� ��� ��,target �̶� ������  answer++
    //�Ź� �� ������, +,-  �������� �ϹǷ� ����Լ��� ����(DFS) 
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
            // *= -1�� �����ϸ� +�� ��� ���� �� �����Ƿ� *= 1 ���� �ϱ� 
            numbers[index] *= -1;
            dfs(numbers, target, index+1);
        }
    }
}

/* �ٸ� ��� Ǯ��
// ���� �Ȱ��� �˰����ε� +,- ��� ��� ����ؼ� ���Ѱ� ���� ã�� ���&�ڵ�(��� ����� ���� ���� ã�� ���)
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