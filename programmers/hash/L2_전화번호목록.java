package hash;

public class L2_��ȭ��ȣ��� {
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
/* �ٸ����Ǯ��: startsWith�Լ� �Ǵ� indexOf �Լ� ���

// startsWith ���
static boolean solution(String[] phone_book) {
	for(int i = 0 ; i < phone_book.length -1; i ++) {
		for(int j = i+1 ; j < phone_book.length; j++) {
			if(phone_book[i].startsWith(phone_book[j]))  return false; 
			if(phone_book[j].startsWith(phone_book[i]))  return false; 
		}
	}
	return true;
}

// indexOf ��� 
static boolean solution(String[] phone_book) {
	for(int i = 0 ; i < phone_book.length; i ++) {
		for(int j = 0 ; j < phone_book.length; j++) {
			if(i == j) continue; // ���� ���ڴ� �� x 
			if(phone_book[i].indexOf(phone_book[j]) == 0){
				return false;
			}
		}	
	}
	return true;
}

 */


