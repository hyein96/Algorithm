package greedyalgorithm;

import java.util.Arrays;
public class L2_구명보트 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{70,50,80,50}, 100));
		System.out.println(solution(new int[]{70,80,50}, 100));
	}
	
	private static int solution(int[] people, int limit) {
        //굳이 리스트로 바꿔서 값 제거 해줄 필요없이 min, max의 위치만 바꿔주며 limit랑 비교하면 됨 (어차피 배열은 값 삭제도 안됨, 리스트바꾸면 비효율적)
        //min이랑 max의 위치가 엇갈릴 때 반복문 마무리!
        Arrays.sort(people);
        int cnt = 0;
        int min = 0; 
        for(int max = people.length -1; min <= max; max--){ 
            //1명만 남을때는 cnt 증가하면 되므로 if, else문 어디든 가능(즉, min과 max가 같을 때)
            if(people[min] + people[max] <= limit) {
                min ++;
                cnt ++;
            }
            else cnt ++;
        }
        return cnt;
    }
}
