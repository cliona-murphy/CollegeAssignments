import java.util.Arrays;

public class assignment2 {
	public static int numOps1; //int to hold number of Operations for method 1
	public static int numOps2;	//int to hold number of Operations for method 2
	public static int numOps3; //int to hold number of Operations for method 3
	public static String reversed; //String to hold reversed String of the expression, created in method 1
	public static char reversedArray[]; //Character Array to hold reversed String as a char array
	public static char exp[]; //character array to hold expression string as a char array
	public static int bothPalindrome = 0; //int to hold number of times decimal and binary equivalent are palindromes
	public static int decimalPalindrome = 0; //int to hold number of times the decimal number is a palindrome
	public static int binaryPalindrome = 0; //int to hold number of time binary number is a palindrome
	 
	
	
	public static void main (String[] args)
	{
		//counting through number of ops for each method
		for (int i = 0; i < 10000; i+=500) {
			numOps1 = 0;
			numOps2 = 0;
			numOps2 = 0;
		
		
		for (int j = 0; j < i; j++) {
			reverse(Integer.toString(j));
			compareStartAndEnd(Integer.toString(j));
			stackQueue(Integer.toString(j));
		}
		System.out.println(numOps1 + " " + numOps2 + " " + numOps3);
		}
		//Test for method 1
				
				String expr = "1001";
				
				boolean ans = reverse(expr);
				if (ans) System.out.println("test1 true");
				else System.out.println("test1 false");
				
				//Test for method 2
				/*
				boolean ans2 = compareStartAndEnd(expr);
				if (ans2) System.out.println("test2 true");
				else System.out.println("test2 false");
				
				//Test for method 3
				boolean ans3 = stackQueue(expr);
				if (ans3) System.out.println("test3 true");
				else System.out.println("test3 false");
				
				//Test for converting
				String number = "565";
				String boo = DecimalToBinary(number);
				System.out.println("Decimal: " + number + ", binary: " +boo);*/
					
		double timeBefore = System.currentTimeMillis(); //records the time before the test begins
		for (int i = 1; i <= 1000; i++) { //loops through first 1 million numbers
		String decimal = Integer.toString(i); //converts each integer to a string
		String binaryStr = DecimalToBinary(decimal); //converts each string holding decimal number into its binary equivalent
		if (reverse(binaryStr)) { //checking if reverse returns true for the binary String
			binaryPalindrome++; //if so, the number of binary palindromes is incremented
		}
		else if(reverse(decimal)) { //checking if reverse returns true for the decimal String
			decimalPalindrome++; //if so, number of decimal palindromes incremented
		}
		else if (reverse(decimal) && reverse(binaryStr)) { //if both decimal and its binary equivalent are palindromes
			bothPalindrome++;								// bothPalindrome is incremented
		}
		
	}
		double timeAfter = System.currentTimeMillis(); //records the time after the test has completed
		double time1 = timeAfter - timeBefore; //stores the difference in the 2 times recorded, this value is the length of time the test took to complete
		System.out.println("Reverse time = " +time1 + ", numOps = "+numOps1); //prints out time taken for test to be completed and the number of operations
		
		
		double timeBefore2 = System.currentTimeMillis();  //records the time before the test begins
		for (int i=1; i <= 1000; i++) {
			String decimal = Integer.toString(i); //converting decimal to string
			String binaryStr = DecimalToBinary(decimal); //converting decimal string to binary string
			if (compareStartAndEnd(binaryStr)) { //checking if compareStartAndEnd returns true for the binary String
				binaryPalindrome++;
			}
			else if(compareStartAndEnd(decimal)) { //checking if compareStartAndEnd returns true for the decimal String
				decimalPalindrome++;				
			}
			else if (compareStartAndEnd(decimal) && compareStartAndEnd(binaryStr)) { //if both decimal and its binary equivalent are palindromes
				bothPalindrome++;													// bothPalindrome is incremented
			}
		}
		 double timeAfter2 = System.currentTimeMillis(); //records the time after the test has completed
		double time2 = timeAfter2 - timeBefore2; //stores the different in the 2 times recorded, this value is the length of time the test took to complete
		System.out.println("compareStartAndEnd time = " +time2+ ", numOps = "+numOps2);  //prints out time taken for test to be completed and the number of operations
		
		
		double timeBefore3 = System.currentTimeMillis();
		for (int i=1; i <= 1000; i++) {
			String decimal = Integer.toString(i); //converting decimal to string
			String binaryStr = DecimalToBinary(decimal); //converting decimal string to binary string
			if (stackQueue(binaryStr)) { //checking if binary string is palindrome using StackQueue method
				binaryPalindrome++; //if so, binaryPalindrome incremented
			}
			else if(stackQueue(decimal)) {  //checking if decimal string is palindrome using StackQueue method
				decimalPalindrome++; //if so, decimalPalindrome is incremented
			}
			else if (stackQueue(decimal) && stackQueue(binaryStr)) {  //checking if binary string and decimal string are both palindrome using StackQueue method
				bothPalindrome++; //if so, bothPalindrome is incremented
			}
		}
		 double timeAfter3 = System.currentTimeMillis(); //records time after test has been completed
		double time3 = timeAfter3 - timeBefore3; //subtracts time before from time after and stores it in time3
		System.out.println("stackQueue time = " + time3 + ", numOps = "+ numOps3); //prints out time taken for test to be completed and the number of operations
	}
		
	/*public static boolean reverse(String expression) { //works!
		//expression = expression.toLowerCase();
		exp = expression.toCharArray();
		for (int i = expression.length()-1; i >= 0; i--) { // sorting thru array is out of bounds.
			//numOps1++;
			reversed += exp[i];				
		}
		reversed = reversed.toLowerCase();
		
		reversedArray = reversed.toCharArray();
		//numOps1++;
		
		boolean retVal = Arrays.equals(exp, reversedArray);
		//numOps1++;
		
		return retVal;
		
	}*/
	public static boolean reverse(String expression) { //reverses the input string and compares them to each other letter by letter to see if they match
	//expression = expression.toLowerCase();
		exp = expression.toCharArray(); //converts expression to char array
		for (int i = expression.length()-1; i >= 0; i--) { //loops through expression, starting at the last letter and ending at the first, adding it to the "reversed" string as it goes
			reversed += exp[i];	//adds it to reversed string
			numOps1++; //increments number of operations
		}
		//reversed = reversed.toLowerCase(); 
		
		reversedArray = reversed.toCharArray(); //converting reversed string to char array
		numOps1++;//increments number of operations
		
		boolean retVal = Arrays.equals(exp, reversedArray); //Arrays.equals compares original string to reversed string to determine if they are palindromes
		numOps1++;
		
		return retVal; //returns the boolean value
		
	}
	public static boolean compareStartAndEnd(String expression) { 
		//expression = expression.toLowerCase(); 
		exp = expression.toCharArray(); //converts expression to char array
		numOps2++;//increments number of operations
		for (int i = 0; i < expression.length(); i++) { //loops through expression
			
			if (exp[i] != exp[expression.length() -1 -i]) //if first letter != last letter, and so on until expression length is reached, they are not palindromes
				//numOps2++; this line makes the time taken to be completed = 0 so I took it out
				return false; //false is returned
		}
		 
		/*for (int i = 0; i < expression.length(); i++) { 
		numOps2++;*/
		
		//numOps2++;
	
		return true;
		
		
	}
	
	public static boolean stackQueue(String expression) { //works!!
		//add each char to a stack and a queue as it is read
		exp = expression.toCharArray(); 
		numOps3++;
		ArrayStack stack = new ArrayStack();
		numOps3++;
		ArrayQueue queue = new ArrayQueue();
		numOps3++;
		
		for (int i = 0; i < expression.length(); i++) {
			stack.push(exp[i]);
			numOps3++;
			queue.enqueue(exp[i]);
			numOps3++;
			
		}
		//After all characters have been put onto both the stack and the queue, start removing
		//characters from both the stack and the queue, and comparing them
		while(!stack.isEmpty() && !queue.isEmpty()) {
			if (!(stack.pop().equals(queue.dequeue()))) {
				
					return false;
		}
			numOps3++;
		}
		return true;
	}
	
	
	public static String DecimalToBinary(String string) { 
		int binary[] = new int[40];
		String result = "";
		int decimal = Integer.parseInt(string);
		     int j = 0;
		     
		     while(decimal > 0){
		       binary[j++] = decimal%2;
			
		       decimal = decimal/2;
			

		     }
		     for(int i = j-1;i >= 0;i--){
		       result += binary[i];

		     }
		     return result;
		    
		     
		  }

}
