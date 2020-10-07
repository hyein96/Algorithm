package brutforce.sunyeol;

import java.io.*;

public class B10974_������ {
	
	// �� �ַ�� : N�� M(1) Ǯ�� ó�� DFS����ؼ� ����Լ��� ���� (�湮�ϸ� �߰��������� �Է°� ��ŭ �޾Ƽ� �ߺ����� ���)
	// �ٸ� �ַ�� : �������� �̿��ؼ� ǰ (���� ������ ������ ��� ���) 
	static boolean visit[];
	static int output[] ; 
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		visit = new boolean[input+1];
		output = new int[input];
		
		allPermutation(0,input);
		
		br.close();
		bw.flush();
		bw.close();
		
		
		
	}
	
	static void allPermutation(int index, int n) throws IOException {
		if(index == n) {
			for(int i = 0 ; i < n ; i ++) {
				bw.write(String.valueOf(output[i]));
				if(i != n-1) bw.write(" ");
			}
			bw.newLine();
		}
		else {
			for(int i = 1 ; i <= n ; i++) {
				if(visit[i]) continue;
				
				visit[i] = true; 
				output[index] = i;
				allPermutation(index+1,n);
				visit[i] = false;
				
			}
		}
		
	}
}
//�� �ַ��(�ٸ� Ǯ��) : �������� �̿��ؼ� ǰ (���� ������ ������ ��� ���) --> ���� �ð� ���� ���� �ȳ� 

/*private static int input;
private static int[] output;

public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	input = Integer.parseInt(br.readLine());
	output = new int[input];
	
	for(int i = 0 ; i < input ; i ++) {
		output[i] = i+1 ; 
	}
	
	do {
		for(int i = 0 ; i < input ; i ++) {
			bw.write(String.valueOf(output[i]));
			if( i != input - 1) bw.write(" ");
		}
		bw.newLine();
	}while(nextPermutation());
	
	br.close();
	bw.flush();
	bw.close();
}

public static boolean nextPermutation() {
	boolean next = false; // ���� ������ ����
	
	for(int i = input-1 ; i > 0 ; i--) { // n�� input.length ! 
		if(output[i-1] < output[i]) {
			next = true;
			for(int j = input-1 ; j >= 0 ; j--) {
				if(output[j] > output[i-1]) {
					//swap�ϴ� ��� (���� ������ ���� �ʿ����,temp �� ���������� swap���� // swap�� �ϱ�)
					int temp = output[j];
					output[j] = output[i-1];
					output[i-1] = temp;
					break; // �ι�° for�� Ż�� 
				}
			}
			int k = input-1; // k�� �� �������� --> i���� �Ǹ����������� ���� �����´� 
			while(i < k) {
				int temp2 = output[k];
				output[k] = output[i];
				output[i] = temp2;
				i++;
				k--;
			}
			break; // ù��° for�� Ż��
		}
	}
	
	if(next) return true;  // ���� ���� ������
	else return false; // ���� ���� ������ 
	
}*/
 
// �ٸ� ��� �ַ�� (���� ���� ������ ��� ���) --> �ð� ���� ���� �ɸ� 
/*
 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	private static int N;
	private static int[] arr;
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		do {
			for (int i = 1; i <= N; i++) {
				sb.append(arr[i]).append(SPACE);
			}
			sb.append(NEW_LINE);
		} while(nextPermutation());// ���� ���� ������, ��, true�̸� ���� for���� ��� �����ϸ� output���� 
		System.out.print(sb); // ���� ���� ������, ��� 
	}
	
	public static boolean nextPermutation() { 
	// ���� ���� ������ ���� ���� , true �Ѱ��༭ ��� ���� ���� ã�� ����
	//  arr[i-1] < arr[i] �� ��ã�� �ᱹ i�� 1���� ���ų� �۾����� false ��ȯ�ϸ� ���� ������ �������� �ʴ� ��
	  
		int i = N;
		while (i > 1 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i <= 1) return false;
		
		int j = N;
		while (arr[j] <= arr[i - 1]) {
			j--;
		}
		
		swap(i - 1, j);
		
		j = N;
		while (i < j) {
			swap(i, j);
			i++;
			j--;
		}
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
  */
