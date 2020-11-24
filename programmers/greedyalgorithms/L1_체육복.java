package greedyalgorithm;

public class L1_ü���� {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[]{2,4}, new int[]{1,3,5}));
		System.out.println(solution(5, new int[]{2,4}, new int[]{3}));
		System.out.println(solution(3, new int[]{3}, new int[]{1}));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		//�ٸ� ����� �ƿ� ������ �� ���� �� �л��� ���� �ٲٱ� (-1)
		//��(return): ���������� ���� �л� + ������������ ���������� �л� + ������������ ���� �л�
		int answer = n - lost.length; //�������������� �л�

		for(int i = 0 ; i < lost.length; i++){
			for(int j = 0 ; j < reserve.length; j++){
				if(lost[i] == reserve[j]) {
					answer ++;
					//�ٸ��л������� ������ְ� �Ѵ� -1�� �ٲٱ�(���� �������� ���� ������ �л�)
					lost[i] = -1;
					reserve[j] = -1; 
					break;
				}
			}
		}
		for(int i = 0; i < lost.length; i++){
			for(int j = 0; j < reserve.length; j++){
				if(lost[i] == reserve[j]-1 || lost[i] == reserve[j] +1){
					//���� �������� �����л�
					answer ++;
					reserve[j] = -1; //������ ������ �� ����
					break;
				}
			}
		}
		return answer;
	}
}


