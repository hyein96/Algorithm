package bfs_dfs;

import java.util.Arrays;
import java.util.*;

public class L3_여행경로 {
	//모든 도시를 방문할 수 없는 경우는 주어지지 않으므로 answer 배열의 수는 tickes의 수 + 1 로 정해져 있음 
	//항상 ICN 에서 출발 
	//모든 가능한 경우를 list에 저장한 후, 오름차순 정렬하면 알파벳순으로 가장 앞선 경로 구할 수 있음 
	//for문으로 모든 경우 방문했는지(visit변수) 확인하지말고 변수 1개 더 줘서 판단하는게 효율적(for문 x)
	//모든 도시 방문할 수 없는 경우는 주어지지 x

	static ArrayList<String> answerList  = new ArrayList<>();
	static boolean[] visit ;
	static String route ="";
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] {{"ICN","JFK"}, {"HND","IAD"}, {"JFK","HND"}})));
		System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));

	}

	private static String[] solution(String[][] tickets) {

		visit = new boolean[tickets.length]; // 주어진 항공권을 모두 사용해야 하므로 tickes의 갯수만큼 visit배열 선언 
		for(int i = 0 ; i < tickets.length; i++){ // 항상 ICN에서 시작 (ICN 일때만 dfs 들어가기)
			if(tickets[i][0].equals("ICN")){
				String start = tickets[i][0];
				String end = tickets[i][1];
				visit[i] = true;
				route = start + "," + end;
				//System.out.println(route);
				dfs(end, tickets, 1);
				visit[i] = false;
			}
		}

		Collections.sort(answerList);
		//System.out.print(answerList)  ;
		String[] answer = answerList.get(0).split(","); //split함수는 해당 문자(열)을 기분으로 분리해주는 함수로 반환형이 string 배열!!(string[])
		return answer;

	}
	
	private static void dfs(String end, String[][] tickets, int cnt){
		if(cnt == tickets.length){
			answerList.add(route);
			return;
		}

		for(int i = 0; i < tickets.length; i++) {
			if(!visit[i] && tickets[i][0].equals(end)){ // 방문안했어야 함 
				String end2 = tickets[i][1];
				visit[i] = true;
				route += "," + end2;
				dfs(end2, tickets, cnt+1);
				visit[i] = false;
				route = route.substring(0, route.length() - 4); //맨 마지막 공항 제외시키고 bfs 돌리기(모든공항은 대문자3글자로 이루어져있으므로 -4)
			}
		}
	}
}

