public class Run {

	/**
	 * Runs the program
	 * @param args, the filename of the file that contains the names.
	 */
	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.err.println("No arguments were found, please give the filename as a parameter");
		}

		FileReader fileReader = new FileReader();

		MatchCalculator matchCalculator = new MatchCalculator();
		matchCalculator.findMatchesForPeople(fileReader.readFileToArray(args[0]));
	}	
}
