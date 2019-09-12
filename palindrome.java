
public class palindrome {
	public String reversed;
	//char reversed[];
	char exp[];
	
	
	public palindrome(String expression) {
		exp = expression.toCharArray();
		for (int i = expression.length()-1; i >= 0; i++) {
			reversed += exp[i];				
		}
		
		
	}

}
