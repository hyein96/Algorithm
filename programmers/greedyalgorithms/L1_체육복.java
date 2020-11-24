package greedyalgorithm;

public class L1_체육복 {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[]{2,4}, new int[]{1,3,5}));
		System.out.println(solution(5, new int[]{2,4}, new int[]{3}));
		System.out.println(solution(3, new int[]{3}, new int[]{1}));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		//다른 사람을 아예 빌려줄 수 없게 그 학생의 값을 바꾸기 (-1)
		//답(return): 도난당하지 않은 학생 + 도난당했지만 여벌가져온 학생 + 도난당했지만 빌린 학생
		int answer = n - lost.length; //도난당하지않은 학생

		for(int i = 0 ; i < lost.length; i++){
			for(int j = 0 ; j < reserve.length; j++){
				if(lost[i] == reserve[j]) {
					answer ++;
					//다른학생들한테 지장안주게 둘다 -1로 바꾸기(도난 당했지만 여벌 가져온 학생)
					lost[i] = -1;
					reserve[j] = -1; 
					break;
				}
			}
		}
		for(int i = 0; i < lost.length; i++){
			for(int j = 0; j < reserve.length; j++){
				if(lost[i] == reserve[j]-1 || lost[i] == reserve[j] +1){
					//도난 당했지만 빌린학생
					answer ++;
					reserve[j] = -1; //나머지 빌려줄 수 없게
					break;
				}
			}
		}
		return answer;
	}
}


