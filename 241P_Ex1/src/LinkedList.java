/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/

//Java Implementation of Linked List was based on code written 
//during self-study which was in turn based on https://www.youtube.com/watch?v=BBpAmxU_NQo

/* Base Linked List Class */
public class LinkedList{
	/*private class that creates the linked list node
	 * Each node contains the String value and pointer to next node
	 */
	private class Node{
		private String word;
		private Node next;
		
		private Node(String str) {
			this.word = str;
			this.next = null;
		}
	}
	//Pointer to first node in the Linked List
	Node first;
	
	//adds new word at the beginning of existing list
	public void addFirst(String value) {
		Node newNode = new Node(value);
		if(first == null)
			first = newNode;
		else {
				newNode.next = first;
				first = newNode;
		}
	}
	
	public boolean contains(String value) {
		if(first == null)
			return false;
		
		Node current;
		
		current = first;
		while(current != null) {
			if(current.word.equals(value))
				return true;
			current = current.next;
		}
		return false;
	}
	
	public int length() {
		if(first==null)
			return -1;
		Node current = first;
		int index = 0;
		while(current != null) {
			index++;
			current = current.next;
		}
		return index;
	}
	
}