import java.util.List;

public class MatchCalculator {

	private static final String CODEWORD = "pairs";

	/**
	 * Goes through the list of names. If a perfect match is found, then prints the
	 * names of those people out.
	 * @param names, list of names
	 */
	public void findMatchesForPeople(List<String> names) {

		int result;
		//go over the list of names. Stop at the second to last name, since it
		//has already been compared with every other name.
		for (int i = 0; i < names.size() - 1; i++) {

			result = checkPercentage(names.get(i), names.get(i + 1));

			if (result == 99) {
				System.out.println("Found a perfect match: "+ names.get(i) + " ja " + names.get(i + 1));
			}
		}
	}

	/**
	 * Compare two names and calculate their compatibility score.
	 * @param name1, String
	 * @param name2, String
	 * @return two digit compatibility score 
	 */
	private int checkPercentage(String name1, String name2) {
		int[] numbers = countCharacters(CODEWORD, name1, name2);

		while (numbers.length > 2) {
			numbers = sumArrayValues(numbers);
		}

		int firstDigit = numbers[0] * 10;
		int secondDigit = numbers[1];
		
		return firstDigit + secondDigit;	
	}

	/**
	 * Counts up how many times the codewords characters appear in the names
	 * @param word, the codeword that we comparing the names against
	 * @param name1, String
	 * @param name2, String
	 * @return an int array where int[0] contains the number of times the
	 * first character of the codeword appeared in the names. The same applies for
	 * the other indexes. 
	 */
	private int[] countCharacters(String word, String name1, String name2) {
		String concatenated = (name1 + name2).toLowerCase().trim();

		int[] result = new int[word.length()];

		for (int i = 0; i < result.length; i++) {

			char character = word.charAt(i);
			int characterCount = 0;
			
			for (int j = 0; j < concatenated.length(); j++) {
				if (concatenated.charAt(j) == character) {
					characterCount++;
				}
			}
			result[i] = characterCount;
		}

		return result;
	}

	/**
	 * Add up every value with the following value, which generates an array that contains
	 * one value less than before. For example int[3] turns into int[2].
	 * @param numbers, int array
	 * @return int array with one value less than before.
	 */
	private int[] sumArrayValues(int[] numbers) {

		int[] result = new int[numbers.length - 1];

		for (int i = 0; i < numbers.length - 1; i++) {
			result[i] = sumValues(numbers[i], numbers[i + 1]);
		}
		
		return result;
	}

	/**
	 * Add up the two values given as parameters. If the sum is less than 10, then
	 * the value is returned. Otherwise the process is repeated with newly created value.
	 * For example, if 9 + 3 = 12, which means this method will be called again with values 1 and 2.
	 * @param value1, int
	 * @param value2, int
	 * @return one digit value.
	 */
	private int sumValues(int value1, int value2) {
		int sum = value1 + value2;
		if (sum >= 10) {
			return sumValues(sum / 10, sum % 10); //
		}
		else {
			return sum;
		}
	}
}