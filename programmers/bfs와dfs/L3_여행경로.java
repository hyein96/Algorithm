package bfs_dfs;

import java.util.Arrays;
import java.util.*;

public class L3_������ {
	//��� ���ø� �湮�� �� ���� ���� �־����� �����Ƿ� answer �迭�� ���� tickes�� �� + 1 �� ������ ���� 
	//�׻� ICN ���� ��� 
	//��� ������ ��츦 list�� ������ ��, �������� �����ϸ� ���ĺ������� ���� �ռ� ��� ���� �� ���� 
	//for������ ��� ��� �湮�ߴ���(visit����) Ȯ���������� ���� 1�� �� �༭ �Ǵ��ϴ°� ȿ����(for�� x)
	//��� ���� �湮�� �� ���� ���� �־����� x

	static ArrayList<String> answerList  = new ArrayList<>();
	static boolean[] visit ;
	static String route ="";
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] {{"ICN","JFK"}, {"HND","IAD"}, {"JFK","HND"}})));
		System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));

	}

	private static String[] solution(String[][] tickets) {

		visit = new boolean[tickets.length]; // �־��� �װ����� ��� ����ؾ� �ϹǷ� tickes�� ������ŭ visit�迭 ���� 
		for(int i = 0 ; i < tickets.length; i++){ // �׻� ICN���� ���� (ICN �϶��� dfs ����)
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
		String[] answer = answerList.get(0).split(","); //split�Լ��� �ش� ����(��)�� ������� �и����ִ� �Լ��� ��ȯ���� string �迭!!(string[])
		return answer;

	}
	
	private static void dfs(String end, String[][] tickets, int cnt){
		if(cnt == tickets.length){
			answerList.add(route);
			return;
		}

		for(int i = 0; i < tickets.length; i++) {
			if(!visit[i] && tickets[i][0].equals(end)){ // �湮���߾�� �� 
				String end2 = tickets[i][1];
				visit[i] = true;
				route += "," + end2;
				dfs(end2, tickets, cnt+1);
				visit[i] = false;
				route = route.substring(0, route.length() - 4); //�� ������ ���� ���ܽ�Ű�� bfs ������(�������� �빮��3���ڷ� �̷���������Ƿ� -4)
			}
		}
	}
}

