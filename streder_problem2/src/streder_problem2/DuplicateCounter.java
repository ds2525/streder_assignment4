package streder_problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
	
	private Integer wordCounter;
	private Map<String, Integer> map;
	
	public DuplicateCounter()
	{
		this.wordCounter = 0;
		this.map = new HashMap<>();
	}
	
	//function that counts how many times the word is in the file
	public void count(String dataFile)
	{
		Scanner fileReader;
		
		try
		{
			fileReader = new Scanner(new File(dataFile));
			while(fileReader.hasNextLine())
			{
				String line = fileReader.nextLine().trim();
				String[] data = line.split("[\\W] + ");
				
				//for loop through all of the data that is in the file 
				//and counting up how many times the word is in the file
				for(String word : data)
				{
					this.wordCounter = map.get(word);
					this.wordCounter = (this.wordCounter == null) ? 1 : ++this.wordCounter;
					map.put(word, this.wordCounter);
				}
			}
			//closing the scanner
			fileReader.close();
		}
		catch(FileNotFoundException fnfe)	//catch if the file does not exists
		{
			System.out.println("File " + dataFile + " cannot be found!");
			System.exit(1);
		}
	}
	
	public void write(String outputFile)
	{
		FileWriter fw;
		PrintWriter pw;
		
		try
		{
			fw = new FileWriter(new File(outputFile));
			pw = new PrintWriter(fw);
			
			//for loop that goes through ever entry in the file and 
			//writes the many times each word was displayed in the file to another file
			for(Map.Entry<String, Integer> entry : map.entrySet())
			{
				pw.write(entry.getKey() + " occurs " + entry.getValue() + " times " + System.lineSeparator());
			}
			
			System.out.println("Map data written to file: " + outputFile);
			
			//closing the filewriter and the printwriter
			pw.flush();
			fw.close();
			pw.close();
		}
		catch(IOException ex)	//catch if the file was not able to be written to
		{
			System.out.println("Error in writing to " + outputFile + ": " + ex.getMessage());
			System.exit(1);
		}
	}
}
