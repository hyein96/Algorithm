package sort;

import java.util.*;

public class L2_HIndex {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,0,4,1,5}));
	}
	private static int solution(int[] citations) {
		  //h�� �� �� �ִ� �ִ밪�� �迭�� ���� ��, ���� ���� n (n ���� h�� Ŭ �� �����Ƿ�)

        int max = citations.length;
        int cnt = 0; //h�� �̻� �ο�� �� ����
        int answer = 0;

        while(max >= 0){ //�ּҰ��� 0 
            cnt = 0;
            for(int i = 0 ; i < citations.length; i++){
                if(citations[i] >= max) cnt ++;
            }
            if(cnt >= max) {
                answer = max;
                break;
            }
            max --; 
        }
        return answer;
    }
}

//�ٸ���� Ǯ��: Arrays.sort()�̿��ؼ� ���� ��,
//������ ��쿡�� ���ü� �ִ� H-index�� �ִ밪 ���ϰ� �� �߿� �ִ밪 ����
