package brutforce.sunyeol;

import java.io.*;
import java.util.*;
// �ַ�� �ϱ�(�ٸ� ���������� ���� ����)
public class B10972_�������� {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] input; // ��° �ٿ� �Է����� ������ ���� 
		int n = Integer.parseInt(br.readLine());
		input = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		// ���� ���� ���ϴ� �ַ��
		boolean last = true; // ���� ������ ���������� ���� ������ ��� true 
	 
		for(int i = n-1 ; i > 0 ; i--) { // n�� input.length ! 
			if(input[i-1] < input[i]) {
				last = false;
				for(int j = n-1 ; j >= 0 ; j--) {
					if(input[j] > input[i-1]) {
						//swap�ϴ� ��� (���� ������ ���� �ʿ����,temp �� ���������� swap���� // swap�� �ϱ�)
						int temp = input[j];
						input[j] = input[i-1];
						input[i-1] = temp;
						break; // �ι�° for�� Ż�� 
					}
				}
				int k = n-1; // k�� �� �������� --> i���� �Ǹ����������� ���� �����´� 
				while(i < k) {
					int temp2 = input[k];
					input[k] = input[i];
					input[i] = temp2;
					i++;
					k--;
				}
				break; // ù��° for�� Ż��
			}
		}
		
		if(last) 
			bw.write(String.valueOf(-1));
		else {
			for(int i = 0 ; i < n ; i++ ) {
				bw.write(String.valueOf(input[i]));
				if(i != n-1) bw.write(" ");
			}
		} 
		
		br.close();
		bw.flush();
		bw.close();
	}
}
/* �ַ���� �Ȱ����� �ٸ� ��� �ڵ� 
 * ����for�� ���� break�� �ι� �����ʰ�, for���� �̸��� ���ѵ�(Loop1) break Loop1; �ؼ� ����for�� �Ѳ����� ����
 * �ڵ尡 ������� main�Լ��� ª�� ����, �ֿ��Լ��� ���ο� �Լ��� �����ؼ� �ڵ� ¥�� �� �ͼ� ������   
 public class Beak10972 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
 
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
 
        nextPermutation(arr);
 
        sc.close();
    }
 
    private static void nextPermutation(int[] arr) {
        int n = arr.length;
        boolean b = true;
        Loop1: for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                for (int j = n - 1; j >= i; j--) {
                    if (arr[j] > arr[i - 1]) {
                        int temp = arr[j];
                        arr[j] = arr[i - 1];
                        arr[i - 1] = temp;
                        int k = n - 1;
                        while (i < k) {
                            int temp2 = arr[i];
                            arr[i] = arr[k];
                            arr[k] = temp2;
                            i++;
                            k--;
                        }
                        b = false;
                        break Loop1;
                    }
                }
            }
        }
        if (b) {
            System.out.println(-1);
        } else {
            showArray(arr);
        }
    }
 
    private static void showArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
 
*/
