package streder_problem1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

	public static void main(String[] args) throws IOException{
		DuplicateRemover r = new DuplicateRemover();
		Path path = Paths.get("problem1.txt");
		r.remove("problem1.txt");
		r.write("unique_words.txt");
	}
}
