package greedyalgorithm;

import java.io.*;
import java.util.*;

public class B1080_��� {

	private static int N;
	private static int M;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int output ;

	public static void main(String[] args) throws IOException {
		// 3*3ũ���� �κ� ��ķθ� �ȿ� �ִ� ��� ���� �� ������ ���̹Ƿ� (0,0)���� �����ؼ� 3*3�� ��ȯ�ϸ�(������ ����) 
		// �ι�° ��İ� ������ �Ź� �˻�

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());


		//��� �޾ƿ���
		int[][] matrixA = getMatrix();
		int[][] matrixB = getMatrix();

		System.out.print(solve(matrixA, matrixB));
	}

	private static int solve(int[][] matrixA, int[][] matrixB) {
		output = 0;
		if(N < 3 || M <3) {
			return isSameMatrix(matrixA, matrixB);
		} else {
			for(int i = 0; i < N-2; i++) {
				for(int j = 0; j< M-2; j++) {
					if(matrixA[i][j] != matrixB[i][j]) {
						//A�� �κ���� ��ȯ
						matrixA = changeSubMatrix(matrixA, i, j);
						output ++;
					}
				}
			}
			return isSameMatrix(matrixA, matrixB);
		}
	}

	private static int isSameMatrix(int[][] matrixA, int [][] matrixB) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j< M; j++) {
				if(matrixA[i][j] != matrixB[i][j])
					return -1;
			}
		}
		return output;
	}

	private static int[][] changeSubMatrix(int[][] matrix, int n, int m) {
		for(int i = n ; i < n+3 ; i++) {
			for(int j = m ; j < m+3; j++) {
				if(matrix[i][j] == 1) matrix[i][j] = 0;
				else matrix[i][j] = 1;
			}
		}
		return matrix; 
	}

	private static int[][] getMatrix() throws IOException{
		int[][] matrix = new int[N][M];
		for(int i = 0 ; i < N; i ++) {
			String row = br.readLine();
			for(int j = 0 ; j < M; j++) 
				matrix[i][j] = row.charAt(j)-'0'; //char�� int�� ��ȯ 
		}
		return matrix;
	}
}

