package hash;

import java.util.*; // ArraysŬ����

public class L1_�����������Ѽ��� {

	//�� �Ѹ�!! �������� �������� ���� ��(2���̻� �ƴϰ� �� ������ ��쵵 ����X) 
	//��,completion�� ���̴� participant-1 �̴�
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"leo","kiki","eden"}, 
				new String[]{"eden","kiki"}));
		System.out.println(solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, 
				new String[]{"josipa", "filipa", "marina", "nikola"}));
		System.out.println(solution(new String[] {"mislav", "stanko", "mislav", "ana"}, 
				new String[] {"stanko", "ana", "mislav"}));


	}

	static String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);

		int i ; 
		for(i = 0 ; i<completion.length ; i++){
			if(!participant[i].equals(completion[i])){
				return participant[i];
			}
		}
		//for�� �� ���Ҵµ� ���ٴ°� ������ �ε����� ������ �������� ���ߴٴ� �ǹ�
		return participant[i];
	}
}
/* �ٸ����Ǯ��: HashMap(�ؽ�)�̿�: �� ȿ����(�ð� ����) 
 
 static String solution(String[] participant, String[] completion) {
 	String answer = "";
		HashMap<String,Integer> hm = new HashMap<String,Integer>();

		// ó���� hm.get ���� ���� �����������Ƿ� �� ���̾���(null) ����, participant ��ҵ��� �� ���� 1�� ��
		// (hm.get(player) == null) ? 1: hm.get(player) + 1 �� ������ �ǹ� 
		// hm.getOrDefault(player, 1) �� �ϸ� �ȵǴ� ������ �������� ó���� �ȵǹǷ�!(3��° ����϶�, ���� 2�� �Ǿ���ϴµ� �̷��� ¥�� 1�� ������ ����� �� x)
		
		for(String player: participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
		
		// participant�� �ִµ� completion�� ���� player�� ���� ������ ������ �ȵǸ� ���� 0�� �ƴ� 1�� �������� �� 
		for(String player: completion) hm.put(player,hm.get(player) -1);

		for(String key : hm.keySet()) {
			if(hm.get(key) != 0) answer = key;
		}
		return answer;
 }
 */

