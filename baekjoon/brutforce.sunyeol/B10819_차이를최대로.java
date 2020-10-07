package brutforce.sunyeol;
// ó���� ���� ������ ��, ����ū�� ���������� �״���ū�� ... �� �����ؼ� ���ϸ� �� ������ �˾����� X
// ��ü Ž������ ��� ���� ������, ���� ���ؼ� �� �� max ���ϱ� --> ��� �������ϴ� �ڵ� 2���� �ִµ� �� 2������ �� �ڵ� ©�� �־�� �� 
import java.io.*;
import java.util.*;

public class B10819_���̸��ִ�� {
	
	static int n;
	static int[] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[n];
		for(int i = 0 ; i < n; i ++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		int max = 0 ;
		do {
			int sum = 0;
			for(int i = 1 ; i < n ; i ++) {
				
				sum += Math.abs(input[i-1]-input[i]); // math.abs�� ���ڰ��� ���� ���밪 ��ȯ�ϴ� �Լ�
			}
			
			if(sum > max) // Math.max(sum,max) �ص� �� 
				max = sum;
			
		}while(nextPermutation());
	
		System.out.println(max);
	}
	
	static boolean nextPermutation() {
		boolean next = false;
		for(int i = n-1 ; i > 0 ; i --) {
			if(input[i-1] < input[i]) {
				next = true;
				for(int j = n-1 ; j > 0 ; j --) {
					if(input[i-1] < input[j]) {
						int temp = input[j];
						input[j] = input[i-1];
						input[i-1] = temp;
						break;
					}
				}
				int k = n-1;
				while(i < k) {
					int temp2 = input[k];
					input[k] = input[i] ;
					input[i] = temp2;
					i++;
					k--;
				}
				break;
			}
		}
		if(next) return true;
		else return false;
	}
}
// �ٸ� ��� �ַ�� : ���� �˰����� ���� ��, ��� �������� max ã�Ƽ� ��ȯ (�����˰��� ���� ��)

