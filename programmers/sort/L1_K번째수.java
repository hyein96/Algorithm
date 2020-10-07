package sort_정렬;

import java.util.Arrays;

public class L1_K번째수 {

	public static void main(String[] args) {
		System.out.print(Arrays.toString(solution(new int[] {1,5,2,6,3,7,4}, 
				new int[][]{{2,5,3}, {4,4,1},{1,7,3}})));
	}
	
	//copyOfRange 메소드 사용 
	private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] newArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            /*
            int[] newArray = new int[commands[i][1]-commands[i][0]+1];
            int start = commands[i][0]-1;
            for(int j = 0; j < newArray.length; j++) {
                newArray[j] = array[start++];
            }                         
            */                            
            Arrays.sort(newArray);
            answer[i] = newArray[commands[i][2]-1] ;
        }
        return answer;
    }
}


