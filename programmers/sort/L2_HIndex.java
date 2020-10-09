package sort;

import java.util.*;

public class L2_HIndex {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,0,4,1,5}));
	}
	private static int solution(int[] citations) {
		  //h가 될 수 있는 최대값은 배열의 길이 즉, 논문의 갯수 n (n 보다 h가 클 순 없으므로)

        int max = citations.length;
        int cnt = 0; //h번 이상 인용된 논문 갯수
        int answer = 0;

        while(max >= 0){ //최소값은 0 
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

//다른사람 풀이: Arrays.sort()이용해서 정렬 후,
//각각의 경우에서 나올수 있는 H-index의 최대값 구하고 그 중에 최대값 구함
