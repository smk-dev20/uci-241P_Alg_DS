/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/
//Java Implementation of Hash Table was based on code written 
//during self-study which was in turn based on https://www.youtube.com/watch?v=B4vqVDeERhI

/* Base HashTable class implemented as an array of LinkedLists with size
 * of array 100*/
public class HashTable extends LinkedList{
	LinkedList[] array;
	int arraySize = 100;	
	
	public HashTable() {
		array = new LinkedList[arraySize];
		for(int i=0;i<arraySize;i++) {
			array[i] = new LinkedList();
		}
	}
	public void addtoTable(int hash, String word) {
		array[hash].addFirst(word);
	}
	
	public boolean contains(int hash, String word){
		return(array[hash].contains(word));	
	}
	
	public int totalContents() {
		int count=0;
		for(int i=0;i<arraySize;i++){
			int listSize = array[i].length();
			if(listSize!=-1)
				count+=listSize;
		}
		return count;
	}
	
}