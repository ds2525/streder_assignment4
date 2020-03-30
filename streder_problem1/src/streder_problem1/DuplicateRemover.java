package streder_problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class DuplicateRemover {
	private Set<String> uniqueWords;
	
	//function that removes the words that are duplicated in the file
	public void remove(String dataFile) throws FileNotFoundException
	{
		String word;
		uniqueWords = new HashSet<String>();
		Scanner sc = new Scanner(new File(dataFile));
		
		//while loop that continues till there is no more data in the file
		while (sc.hasNext())
		{
			word = sc.next();
			String lowerCaseWord = word.toLowerCase();
			uniqueWords.add(lowerCaseWord);
		}
		
		sc.close();
	}
	
	//function that writes the unique words to the file
	public void write(String outputFile) throws IOException
	{
		File file;
		FileWriter fileWrite = null;
		
		file = new File(outputFile);
		
		// if statement to see if the file exists
		if(file.exists())
		{
			file.delete();
			fileWrite = new FileWriter(file, true);
			Iterator itr = uniqueWords.iterator();
			
			while (itr.hasNext())
			{
				String string = (String)itr.next();
				fileWrite.write(string + "\n");
			}
			
			fileWrite.close();
			System.out.println("Data Written to File");
		}
		else	//else statement if the file does not exist then create the file
		{
			file.createNewFile();
			fileWrite = new FileWriter(file);
			Iterator itr = uniqueWords.iterator();
			
			while(itr.hasNext())
			{
				String string = (String)itr.next();
				fileWrite.write(string + "\n");
			}
			
			fileWrite.close();
			System.out.println("Data Written to File");
		}
	}

}
