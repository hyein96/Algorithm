package hash;

import java.util.HashMap;
public class L2_위장 {
	
	public static void main(String[] args) {
		System.out.println(solution(new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses","eyewear"},{"green_turban", "headgear"}}));
		System.out.println(solution(new String[][]{{"crow_mask", "face"},{"blue_sunglasses","face"},{"smoky_makeup", "face"}}));
		
	}
	static int solution(String[][] clothes) {
		  int answer = 1;
	         HashMap<String,Integer> hm = new HashMap<>();
	         for(int i = 0 ; i < clothes.length; i++){
	             String type = clothes[i][1]; //의상 종류 
	             hm.put(type, hm.getOrDefault(type, 0) + 1); //map에 의상종류 별 갯수 넣기 
	         }
	        
	        for(String key : hm.keySet()){
	            answer *= hm.get(key) + 1; // 의상 종류 별로 입는경우도 있고 안입는 경우도 있으므로 각 경우의 수는 갯수 + 1 
	        }
	        answer -= 1; // 모든 의상 안입는 경우 뺴기(하로에 최소 한 개의 의상은 입음)
	        return answer;
	}
}