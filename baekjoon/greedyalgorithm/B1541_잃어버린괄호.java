package greedyalgorithm;

import java.io.*;

public class B1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {

		// - 만나면 다음 - 까지 + 하는 거 반복하면 답 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine(); 
		// 숫자따로 문자 따로 받는게 어려우니까 + 랑 - 기준으로 split메소드(String클래스) 사용 

		String[] minusDiv = input.split("\\-");
		int[] plusDiv = new int[minusDiv.length];
		int output = 0;
		
		for(int i = 0 ; i < minusDiv.length  ; i ++) {
			String[] tmp = minusDiv[i].split("\\+");
			for(int j = 0 ; j < tmp.length ; j++) {
				plusDiv[i] += Integer.parseInt(tmp[j]);
			}
			
			if(i == 0) output = plusDiv[i];
			else output -= plusDiv[i];
		}
		
		System.out.print(output);
		br.close();

	}
}
