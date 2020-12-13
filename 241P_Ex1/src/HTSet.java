/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/
public class HTSet extends HashTable{
	
	//calculates hash for each word	
	public int hashFunction(String word) {
		int hashCode = 0;
		for(int i=0;i<word.length();i++) {
			int charCode = word.charAt(i) - 48;
			hashCode = (hashCode * 62 + charCode) %arraySize;
		}
		return hashCode;
	}
	
	public boolean add(String word) {
		int hash = hashFunction(word);
		if(!contains(word)){
			super.addtoTable(hash,word);
			return true;
		}
		return false;
	}
	public boolean contains(String word) {
			int hash = hashFunction(word);
		return (super.contains(hash, word));
	}
	
	public int size() {	
		return(super.totalContents());
	}
}