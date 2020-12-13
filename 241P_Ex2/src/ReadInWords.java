
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
import java.util.ArrayList;
import java.util.Scanner;

public class ReadInWords {

	public static void main(String[] args) {
		File text = new File("src/pride-and-prejudice.txt");
		// creating multiple Lists so that each sorting algorithm receives unsorted
		// input
		ArrayList<String> IwordList = new ArrayList<String>();
		ArrayList<String> SwordList = new ArrayList<String>();
		ArrayList<String> HwordList = new ArrayList<String>();
		ArrayList<String> MwordList = new ArrayList<String>();
		ArrayList<String> QwordList = new ArrayList<String>();
		try {
			FileInputStream inputStreamText = new FileInputStream(text);
			Scanner scText = new Scanner(inputStreamText, "UTF-8");

			FileWriter csvWriter = new FileWriter("sorting-stats.csv");
			csvWriter.append("INSERTION SORT");
			csvWriter.append(",");
			csvWriter.append("SELECTION SORT");
			csvWriter.append(",");
			csvWriter.append("MERGE SORT");
			csvWriter.append(",");
			csvWriter.append("HEAP SORT");
			csvWriter.append(",");
			csvWriter.append("QUICK SORT");
			csvWriter.append("\n");

			while (scText.hasNextLine()) {
				String line = scText.nextLine();
				if (line.equals(""))
					continue;
				line = line.replaceAll("[^a-zA-Z0-9]", " ");
				String[] wordsInLine = line.split("\\s+");
				for (String word : wordsInLine) {
					word = word.trim();
					if (!word.equals("")) {
						IwordList.add(word);
						SwordList.add(word);
						HwordList.add(word);
						MwordList.add(word);
						QwordList.add(word);
					}
				}
			} // end while
			scText.close();

			InsertionSort insertionObj = new InsertionSort();
			SelectionSort selectionObj = new SelectionSort();
			MergeSort mergeObj = new MergeSort();
			QuickSort quickObj = new QuickSort();
			HeapSort heapObj = new HeapSort();

			long insSort_start = System.nanoTime();
			insertionObj.doInsertSort(IwordList);
			long insSort_end = System.nanoTime();
			csvWriter.append(Long.toString(insSort_end - insSort_start));
			csvWriter.append(",");

			long selSort_start = System.nanoTime();
			selectionObj.doSelectionSort(SwordList);
			long selSort_end = System.nanoTime();
			csvWriter.append(Long.toString(selSort_end - selSort_start));
			csvWriter.append(",");

			long merSort_start = System.nanoTime();
			mergeObj.doMergeSort(MwordList);
			long merSort_end = System.nanoTime();
			csvWriter.append(Long.toString(merSort_end - merSort_start));
			csvWriter.append(",");

			long hpSort_start = System.nanoTime();
			heapObj.doHeapSort(HwordList);
			long hpSort_end = System.nanoTime();
			csvWriter.append(Long.toString(hpSort_end - hpSort_start));
			csvWriter.append(",");

			long qkSort_start = System.nanoTime();
			quickObj.doQuickSort(QwordList);
			long qkSort_end = System.nanoTime();
			csvWriter.append(Long.toString(qkSort_end - qkSort_start));
			csvWriter.append("\n");

			csvWriter.flush();
			csvWriter.close();

		} catch (Exception exception) {
			exception.printStackTrace();

		}
	}
}