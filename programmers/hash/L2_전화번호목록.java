package hash;

public class L2_전화번호목록 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"119","97674223","1195524421"}));
		System.out.println(solution(new String[] {"123", "456", "789"}));
		System.out.println(solution(new String[] {"12", "123", "1235", "567","88"}));
	}

	static boolean solution(String[] phone_book) {

		//Loop1:
		for(int i = 0 ; i < phone_book.length - 1; i++){
			for(int j = i + 1; j < phone_book.length; j++){
				String first = phone_book[i];
				String second = phone_book[j];

				if(first.length() < second.length() || first.length() == second.length()){
					second = second.substring(0, first.length());
					if(first.equals(second)) { return false;}
				}
				else {
					first = first.substring(0, second.length());
					if(first.equals(second)) { return false;}
				}            
			}

		}
		return true;
	}
}
/* 다른사람풀이: startsWith함수 또는 indexOf 함수 사용

// startsWith 사용
static boolean solution(String[] phone_book) {
	for(int i = 0 ; i < phone_book.length -1; i ++) {
		for(int j = i+1 ; j < phone_book.length; j++) {
			if(phone_book[i].startsWith(phone_book[j]))  return false; 
			if(phone_book[j].startsWith(phone_book[i]))  return false; 
		}
	}
	return true;
}

// indexOf 사용 
static boolean solution(String[] phone_book) {
	for(int i = 0 ; i < phone_book.length; i ++) {
		for(int j = 0 ; j < phone_book.length; j++) {
			if(i == j) continue; // 같은 문자는 비교 x 
			if(phone_book[i].indexOf(phone_book[j]) == 0){
				return false;
			}
		}	
	}
	return true;
}

 */


