import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

	/**
	 * Read the file contents to a list
	 * @return a list with the names
	 */
	public List<String> readFileToArray(String file) {
		List<String> result = new ArrayList<>();

		File fileHandle = new File(file);

		if (!fileHandle.exists()) {
			System.err.println("Error finding the file. " +
					"Please check the command line arguments. Exiting");
			System.exit(0);
		}

		Scanner reader;
		try {
			reader = new Scanner(fileHandle);
			
			while (reader.hasNextLine()) {
				result.add(reader.nextLine());
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}