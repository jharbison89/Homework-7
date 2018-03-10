
public class Exercise_7 {
	
	/* Created by James Harbison
	 * this program displays a table of all the prime numbers that are also palendromes between 1 and 
	 * 100,000.  it does this by sending each number through two methods. the isPrime method returns 
	 * true if the number is prime and false otherwise, and the isPalendrome method returns true if 
	 * the number is a palindrome and false otherwise
	 */
	
	public static boolean isPrime(int num) {
		
		if(num > 1) {	// checks if the number is greater than 1 since all prime numbers are greater than 1
			int factorCount = 0;	// initialize counter variable for the number of factors
					
			for(int i = 2; i < num; i++) {	// checks all numbers between 2 and num - 1
				if(num % i == 0) {			// if the value of num/i has no remainder, i is a factor of num 
					factorCount++;			// increases factorCount if i is a factor
				}
			}
		
			if(factorCount == 0) {		// if there are no factors other than 1 and num returns true
				return true;
			}
			else {						// all other results return false
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean isPalendrome(int num) {
		int numSize = (int)(Math.log10(num) + 1);	// determines the number of digits in num
		
		int digits[] = new int[numSize];	// initialize array with size of the number of digits in num
		int i;
		
		for(i = 0; i < numSize; i++) {		// loops to fill the array with each digit in num in order
			digits[i] = (num / (int)(Math.pow(10, (numSize - 1 - i)))) % 10;
		}
		
		int noMatch = 0;	// initialize a variable to count the number of non-matching digit pairs
		
		for(i = 0; i < numSize; i++) {		
			if(digits[i] != digits[(numSize - 1 -i)]){	// compares the digits in order and reverse order 
				noMatch++;								// increase noMatch count if the numbers don't match
			}
		}
		
		if(noMatch == 0) {		// if there are no non-matching pairs returns true
			return true;
		}
		else {					// returns false if there are any non-matching pairs
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		
		int tableCount = 0;		// initialize a counter variable to create a table of digits instead of a long string
		
		System.out.println("Palendromic primes");		// display table title
		
		for(int number = 1; number <= 100000; number++) {	// for each number between 1 and 100,000 checks both isPrime and 
			if(isPrime(number) && isPalendrome(number)) {	// isPalendreome and displays the number if it returns true from both
				System.out.print(number + "\t");
				tableCount++;
				if(tableCount % 4 == 0) {	// after every 4 numbers creates a newline character to better format the output
					System.out.println();
				}
			}
		}
	}
}
