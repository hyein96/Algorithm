package hash;

import java.util.HashMap;
public class L2_���� {
	
	public static void main(String[] args) {
		System.out.println(solution(new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses","eyewear"},{"green_turban", "headgear"}}));
		System.out.println(solution(new String[][]{{"crow_mask", "face"},{"blue_sunglasses","face"},{"smoky_makeup", "face"}}));
		
	}
	static int solution(String[][] clothes) {
		  int answer = 1;
	         HashMap<String,Integer> hm = new HashMap<>();
	         for(int i = 0 ; i < clothes.length; i++){
	             String type = clothes[i][1]; //�ǻ� ���� 
	             hm.put(type, hm.getOrDefault(type, 0) + 1); //map�� �ǻ����� �� ���� �ֱ� 
	         }
	        
	        for(String key : hm.keySet()){
	            answer *= hm.get(key) + 1; // �ǻ� ���� ���� �Դ°�쵵 �ְ� ���Դ� ��쵵 �����Ƿ� �� ����� ���� ���� + 1 
	        }
	        answer -= 1; // ��� �ǻ� ���Դ� ��� ����(�Ϸο� �ּ� �� ���� �ǻ��� ����)
	        return answer;
	}
}