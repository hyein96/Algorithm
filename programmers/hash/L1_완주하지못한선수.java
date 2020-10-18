package hash;

import java.util.*; // Arrays클래스

public class L1_완주하지못한선수 {

	//단 한명만!! 마라톤을 완주하지 못한 것(2명이상도 아니고 다 완주한 경우도 존재X) 
	//즉,completion의 길이는 participant-1 이다
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
		//for문 다 돌았는데 없다는건 마지막 인덱스의 선수가 완주하지 못했다는 의미
		return participant[i];
	}
}
/* 다른사람풀이: HashMap(해쉬)이용: 더 효율적(시간 빠름) 
 
 static String solution(String[] participant, String[] completion) {
 	String answer = "";
		HashMap<String,Integer> hm = new HashMap<String,Integer>();

		// 처음의 hm.get 값은 매핑 되있지않으므로 다 값이없음(null) 따라서, participant 요소들은 다 값이 1로 등어감
		// (hm.get(player) == null) ? 1: hm.get(player) + 1 와 동일한 의미 
		// hm.getOrDefault(player, 1) 을 하면 안되는 이유는 동명이인 처리가 안되므로!(3번째 경우일때, 값이 2가 되어야하는데 이렇게 짜면 1이 나오며 제대론 값 x)
		
		for(String player: participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
		
		// participant에 있는데 completion에 없는 player은 밑의 문장이 실행이 안되며 값이 0이 아닌 1로 남아있을 것 
		for(String player: completion) hm.put(player,hm.get(player) -1);

		for(String key : hm.keySet()) {
			if(hm.get(key) != 0) answer = key;
		}
		return answer;
 }
 */

