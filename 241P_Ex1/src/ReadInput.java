/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/
/*
 * Reference URLs used for file read, write and parse
 * https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
 * https://www.roseindia.net/java/examples/io/writeToFileCsv.shtml
 * https://grokonez.com/java/java-read-write-csv-file-example
 * https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
 * https://stackoverflow.com/questions/1805518/replacing-all-non-alphanumeric-characters-with-empty-strings
 * https://www.java67.com/2012/11/how-to-read-file-in-java-using-scanner-example.html
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadInput{
	
	public static void main(String[] args) {
		File text = new File("src/pride-and-prejudice.txt");
		File searchWords = new File("src/words-shuffled.txt");
		try 
		{
			LLSet linkedListSet = new LLSet();
			HTSet hashTableSet = new HTSet();
			BTSet binaryTreeSet = new BTSet();
			FileInputStream inputStreamText = new FileInputStream(text);
			Scanner scText = new Scanner(inputStreamText, "UTF-8");
			
			FileWriter csvWriter = new FileWriter("insert-run-time-stats.csv");
			csvWriter.append("WORD TO INSERT");csvWriter.append(",");
			csvWriter.append("LINKED LIST SET TIME");csvWriter.append(",");
			csvWriter.append("HASH TABLE SET TIME");csvWriter.append(",");
			csvWriter.append("BINARY TREE SET TIME");
			csvWriter.append("\n");

			int words = 0;
			while(scText.hasNextLine()){
				String line = scText.nextLine();
				if(line.equals(""))
					continue;
				line = line.replaceAll("[^a-zA-Z0-9]"," ");
				String[] wordsInLine = line.split("\\s+");
				for(String word : wordsInLine) {
					word = word.trim();
					if(!word.equals("")) {
						csvWriter.append(word);csvWriter.append(",");
						
						long llS_start  = System.nanoTime();
						linkedListSet.add(word);
						long llS_end  = System.nanoTime();
						csvWriter.append(Long.toString(llS_end - llS_start));csvWriter.append(",");
                     
						long htS_start  = System.nanoTime();
						hashTableSet.add(word);
						long htS_end  = System.nanoTime();
						csvWriter.append(Long.toString(htS_end - llS_start));csvWriter.append(",");
						
						long btS_start  = System.nanoTime();
						binaryTreeSet.add(word);
						long btS_end  = System.nanoTime();
						csvWriter.append(Long.toString(btS_end - btS_start));csvWriter.append("\n");;

					words++;
					}
				}
			}//end while
			scText.close();

			
			System.out.println("Total Words in Text "+words);
		    System.out.println("Words in linked list set "+linkedListSet.size());
			System.out.println("Words in hash table set "+hashTableSet.size());
			System.out.println("Words in binary tree set "+binaryTreeSet.size());

			FileInputStream inputStreamWords = new FileInputStream(searchWords);
			Scanner scWords = new Scanner(inputStreamWords, "UTF-8");
			FileWriter csvW = new FileWriter("search-run-time-stats.csv");
			csvW.append("WORD TO SEARCH");csvW.append(",");
			csvW.append("LINKED LIST SET TIME");csvW.append(",");
			csvW.append("HASH TABLE SET TIME");csvW.append(",");
			csvW.append("BINARY TREE SET TIME");
			csvW.append("\n");
			int llcountNotFound = 0;
			int htcountNotFound = 0;
			int btcountNotFound = 0;

			while(scWords.hasNextLine()){
				String searchWord = scWords.nextLine();
				searchWord = searchWord.replaceAll("[^a-zA-Z0-9]"," ").trim();
				csvW.append(searchWord);csvW.append(",");
                
				long llSrh_start = System.nanoTime();  
				if(!(linkedListSet.contains(searchWord))) {
					llcountNotFound++;
				}
                long llSrh_end = System.nanoTime();  
				csvW.append(Long.toString(llSrh_end - llSrh_start));csvW.append(",");

                long htSrh_start = System.nanoTime();  
				if(!(hashTableSet.contains(searchWord))){		
					htcountNotFound++;
				}
                long htSrh_end = System.nanoTime();  
				csvW.append(Long.toString(htSrh_end - htSrh_start));csvW.append(",");

                long btSrh_start = System.nanoTime();  
				if(!(binaryTreeSet.contains(searchWord))){		
					btcountNotFound++;
				}
                long btSrh_end = System.nanoTime();  
				csvW.append(Long.toString(btSrh_end - btSrh_start));csvW.append("\n");;

			}
			scWords.close();
			csvWriter.flush();
			csvWriter.close();
			csvW.flush();
			csvW.close();
			System.out.println(llcountNotFound+ " words not found in Linked List Set");
			System.out.println(htcountNotFound+ " words not found in Hash Table Set");
			System.out.println(btcountNotFound+ " words not found in Binary Tree Set");

		}
		catch(Exception exception){
			exception.printStackTrace();

		}
	}
}