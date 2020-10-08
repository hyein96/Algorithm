package sort;

import java.util.Arrays;
import java.util.Comparator;

public class L2_가장큰수 {
	
	//단순 오름차순, 내림차순 정렬이 아니라 새로운 정렬 조건 만들어줘야함
    //자릿 수 상관없이, 맨 앞 자리부터 비교하여 자릿수 별로 비교하는 정렬 조건 만들기
    //도입한 생각: 비교하는 두 숫자를 String을 변환 후, 앞,뒤로 합쳐서 큰 숫자가 앞으로 가게(내림차순) 만들기 

	public static void main(String[] args) {
		System.out.println(solution(new int[]{6,10,2}));
		System.out.println(solution(new int[]{3,30,34,5,9}));
	}

	private static String solution(int[] numbers) {
		String[] s = new String[numbers.length];
		String answer = "";

		for(int i = 0; i < s.length; i++){
			s[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(s, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2){
				return (s2+s1).compareTo(s1+s2);
			}
		});

		//0또는 양의정수 담긴 배열이므로 00이란 담기지 않음: equals 써도 되고 startsWith 써도 됨 
		if(s[0].equals("0")) { // 00000 처럼 0이 여러개인 경우는 다 0으로 표현 
			answer += "0";
		} else{
			for(int i = 0  ; i < s.length; i++){
				answer += s[i];
			}
		}
		return answer;
	}
}
