/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/
public class LLSet extends LinkedList{
	
	public boolean add(String word) {
		if(!contains(word)) {
			super.addFirst(word);
			return true;
		}	
		return false;
	}
	public boolean contains(String word) {
		return(super.contains(word));
	}
	
	public int size() {
		return(super.length());
}
}