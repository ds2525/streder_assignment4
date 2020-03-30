package streder_problem2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
	
	public static void main(String[] args)
	{
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		Path path = Paths.get("problem2.txt");
		duplicateCounter.count("problem2.txt");
		duplicateCounter.write("unique_word_counts.txt");
	}
}
