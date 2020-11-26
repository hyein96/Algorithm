package greedyalgorithm;

import java.util.Arrays;
public class L2_����Ʈ {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{70,50,80,50}, 100));
		System.out.println(solution(new int[]{70,80,50}, 100));
	}
	
	private static int solution(int[] people, int limit) {
        //���� ����Ʈ�� �ٲ㼭 �� ���� ���� �ʿ���� min, max�� ��ġ�� �ٲ��ָ� limit�� ���ϸ� �� (������ �迭�� �� ������ �ȵ�, ����Ʈ�ٲٸ� ��ȿ����)
        //min�̶� max�� ��ġ�� ������ �� �ݺ��� ������!
        Arrays.sort(people);
        int cnt = 0;
        int min = 0; 
        for(int max = people.length -1; min <= max; max--){ 
            //1�� �������� cnt �����ϸ� �ǹǷ� if, else�� ���� ����(��, min�� max�� ���� ��)
            if(people[min] + people[max] <= limit) {
                min ++;
                cnt ++;
            }
            else cnt ++;
        }
        return cnt;
    }
}
