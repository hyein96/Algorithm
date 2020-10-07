package greedyalgorithm;

import java.util.*;
import java.io.*;


public class B5585_°Å½º¸§µ· {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int output = 0 ; // ÀÜµ·°³¼ö
		int change = 1000- input;

		while(change != 0) {
			if(change >= 500) {
				output += (change / 500);
				change = change % 500;
			}
			else if(100 <= change && change <500) {
				output += (change / 100);
				change = change % 100;
			}
			else if(50 <= change && change <100) {
				output += (change / 50);
				change = change % 50;
			}
			else if(10 <= change && change <50) {
				output += (change / 10);
				change = change % 10;
			}
			else if(5 <= change && change <10) {
				output += (change / 5);
				change = change % 5;
			}
			else if(1 <= change && change <5) {
				output += (change / 1);
				change = change % 1;
			}
		}
		
		System.out.print(output);
		br.close();

	}

}
