package brutforce.nandm;

import java.io.*;
import java.util.*;
//�ַ��) �տ� N��M (1)��(2)�� ���� ���� ������ ���� �ȵǱ� ������ visit�� boolean�迭�� �̿��� false�� ���鸸 ������ ��� �� �� �ְ� ��������
// �� ������ ���� ���� ������ ��� �ǹǷ� , ������� �Ѱ��� ����ϸ� �� . ��, visit�迭 �ʿ����
// ������ , �ð��ʰ� �� !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// �ذ�� : �Ϲ����� �����(scanner , system.out.print) --> BufferedReader, BufferedWriter �� �ٲ㼭 �ڵ�¥��
public class B15651_N��M_3 {
	
	//static boolean visit[] ; 
	static int output[] ;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//dfs�޼ҵ�� main�Լ����� bufferedwriter�� ����ϹǷ� static����  
	
	// �Է�ó���� ��ºΰ� �Լ� �ȿ������� ������, ����� ����ó��(throws IOException) ����� �� 
	static void dfs(int index, int n , int m) throws IOException {
		
		if(index == m) {
			for(int i = 0 ; i < m ; i ++) {
				bw.write(String.valueOf(output[i])); // output[i]�� int�� 
				if(i != m-1) 
					bw.write(" ");
			}
			bw.newLine();
		}
		else {
			for(int i =  1 ; i <= n ; i ++) {
				output[index] = i ; 
				dfs(index+1 ,n,m);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ������ �������� �Է¹����Ƿ� ���� ���� ���� StringTokenizer ��ü ��� 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		output = new int[m];
		
		dfs(0,n,m);
		
		br.close();
		bw.flush(); // BufferedWriterŬ������ ���α׷� �������� flush() ����� �ùٸ��� ��� �� ���� 
		bw.close();
		
		
	}
}
