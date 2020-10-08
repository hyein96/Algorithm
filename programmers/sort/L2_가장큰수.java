package sort;

import java.util.Arrays;
import java.util.Comparator;

public class L2_����ū�� {
	
	//�ܼ� ��������, �������� ������ �ƴ϶� ���ο� ���� ���� ����������
    //�ڸ� �� �������, �� �� �ڸ����� ���Ͽ� �ڸ��� ���� ���ϴ� ���� ���� �����
    //������ ����: ���ϴ� �� ���ڸ� String�� ��ȯ ��, ��,�ڷ� ���ļ� ū ���ڰ� ������ ����(��������) ����� 

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

		//0�Ǵ� �������� ��� �迭�̹Ƿ� 00�̶� ����� ����: equals �ᵵ �ǰ� startsWith �ᵵ �� 
		if(s[0].equals("0")) { // 00000 ó�� 0�� �������� ���� �� 0���� ǥ�� 
			answer += "0";
		} else{
			for(int i = 0  ; i < s.length; i++){
				answer += s[i];
			}
		}
		return answer;
	}
}
