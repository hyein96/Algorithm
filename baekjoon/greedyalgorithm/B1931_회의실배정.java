package greedyalgorithm;

import java.io.*;
import java.util.*;


//Comparator����Ͽ� �˰�����(�����½ð� ����������) ȸ�� ������ �� ��, �ڵ� ����
public class B1931_ȸ�ǽǹ��� { 

	// ���۽ð�,�����½ð��� ������(��,�Ѱ��� ȸ��) �񱳵Ǿ��ϹǷ� �������迭�� �޾ƿ��°� ���� ��
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); // ȸ�� ��
		int[][] time = new int[num][2]; // ȸ�� ���۽ð�,���ð�
		int output = 0;

		for(int i = 0 ; i < num ; i++) { // ȸ�� ���۽ð�,���ð� �޾ƿ��� 
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// Comparator ����Ͽ� 2�����迭(time) ������ �ϴ� �ڵ�
		Arrays.sort(time, new Comparator<int[]>() { // <> �ȿ��� compare�޼ҵ��� �Ķ���Ϳ� ���� �ڷ������� ���ֱ�
			@Override // compare�޼ҵ带 ���� �����ϰ��� �ϴ� ������� ������
			public int compare(int[] start ,int[] end) {
				// start[0],end[0] �� ���� ù��° �񱳰�ü,�ι�° �񱳰�ü�� ���۽ð�
				// start[1],end[1] �� ���� ù��° �񱳰�ü,�ι�° �񱳰�ü�� ���ð�
				if(start[1] == end[1]) { // ���ϴ� 2�� ȸ�ǿ� ���ð��� ������(���۽ð� ���� ������������)
					return start[0]-end[0] ; // ���۽ð� �������� ����(�ι�° ���۽ð��� ������ ���갪�� ����� ������ �ڸ��� �ٲ�) 
				}
				else { 
					return start[1]-end[1] ; // ���ð� �������� ���� 
				}
			}
		});
		
		int endTime = time[0][1];
		for(int i = 1 ; i < num ; i++) {
			if(time[i][0] >= endTime) { // ȸ�� ���ð����� ���ų� ���� ���۽ð��� ȸ�Ǹ� ���డ��
				output ++; //ȸ�ǽ��� 
				endTime = time[i][1]; //�ش� ȸ�ǿ� ���ð����� �ٲ� 
			}
		}
		System.out.print(output+1); // ù ȸ�� +1 ���ֱ�
		br.close();
		
		/* ȸ�� ���� ����Ҷ� �ٸ� �ڵ�  
		  int output = 0 ;
		  int endTime = -1;
		  for(int i = 0 ; i < num ; i++){
		  	if(time[i][0] >= endTime){
		  		endTime = time[i][1];
		  		output ++;
		   }
		  }
		 */
	}
}

/* ���� ���ڵ� : boolean���� �̿��ؼ� ȸ�� ��ü������ Ž�� -> �ð��ʰ�
int endMin = time[0][1]; // ȸ�� �� ���� ���� ������ �ð�
int start  = 0 ; 
boolean ox = true;
int finish = 0;

while(finish == 0) {
	for(int i = 0 ; i < num ; i++) {
		if(start <= time[i][0]) {
			if(ox == true) {
				ox = false; 
				endMin = time[i][1];
			}
			else if(endMin >= time[i][1]){
				endMin = time[i][1];
			}
		}
		if(i == num-1 && ox == true) { // while�� ������ ����(�����½ð����� ū ȸ�ǰ� ������)
			finish = 1;
		}
	}
	
	if(finish == 0) {
		ox = true; 
		start = endMin;
		output++; // ȸ�� �Ѱ� ��
	}
}
System.out.print(output);
br.close(); */
