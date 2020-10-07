package greedyalgorithm;

import java.io.*;

public class B10610_30 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int num = 0 ;
		int sum = 0 ;
		boolean checkZero = false ;  
		int[] numCountArr = new int[10]; // 0���� 9�����Ƿ� 

		for(int i = 0 ; i < input.length() ; i++) {
			num = input.charAt(i) -'0'; // char������ ������ �ƽ�Ű�ڵ尪�� �����ϹǷ� '0'�������
			//num = Integer.parseInt(input.substring(i,i+1));
			numCountArr[num] ++;
			if(num == 0) checkZero = true;
			sum += num;
		}

		if(checkZero == false || sum % 3 != 0) {
			System.out.print(-1);
			//return;
		}
		else {
			StringBuilder output = new StringBuilder();
			for(int i = 9 ; i >= 0; i--) {
				while(numCountArr[i] > 0) {
					output.append(i);
					numCountArr[i]--;
				}
			}
			System.out.print(output); // output.toString() �ص� ��
		}
	}
}

// �ٸ���� Ǯ��
/* public class Main {
    public static final int MAX = 100000;
    
    public static String str;
    public static int[] numCountArr;
    public static long strLen;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str= sc.nextLine();
        
        strLen = str.length();
        numCountArr = new int[10];
        long total = 0;
        for(int i=0; i < strLen; i++) {
            int tNum = Integer.parseInt(str.substring(i, i+1));
            numCountArr[tNum] += 1;
            total+=tNum;
        }
        
        // 0�� �������� ������ 30 ��� ������ �� �� ����.
        // �� �ڸ����� �� ���� 3�� ����� �ƴϸ� �����ؾ��Ѵ�.
        if(!str.contains("0") || total % 3 != 0) {
            System.out.println("-1");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            while(numCountArr[i] > 0) {
                sb.append(i);
                numCountArr[i]--;
            }
        }
        System.out.println(sb.toString());
    }
}
*/
