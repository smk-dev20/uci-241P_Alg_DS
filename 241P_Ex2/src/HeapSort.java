/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/
/*
 * Reference URL - https://www.baeldung.com/java-heap-sort
 */
import java.util.ArrayList;

public class HeapSort{
	
	int leftChild(int index) {
		return 2*index +1;
	}
	
	int rightChild(int index) {
		return 2*index+2;
	}
	
    int parent(int index) {
        return (index - 1) / 2;
    }
    
    boolean isRoot(int index) {
    	if(index==0)
    		return true;
    	return false;
    }
    
	boolean isValid(ArrayList<String>list,int index) {
		if(index<list.size())
			return true;
		return false;
	}
    
	public void swap(ArrayList<String>list, int index1, int index2) {
		String temp = list.get(index2);
		list.set(index2, list.get(index1));
		list.set(index1, temp);
	}
	
	public ArrayList<String> buildHeap(ArrayList<String>list){
		ArrayList<String> heap = new ArrayList<String>();
		
		for(int i=0;i<list.size();i++) {
			heap.add(list.get(i));
			int heap_index = heap.size()-1;
			while(!isRoot(heap_index)&& !isCorrectChild(heap,heap_index)) {
				int parentIndex = parent(heap_index);

				swap(heap,heap_index,parentIndex);
				heap_index = parentIndex;
			}
		}
		return heap;
	}
	
	boolean isCorrectChild(ArrayList<String>list, int index) {
		return isCorrect(list,parent(index),index);
	}
	public void doHeapSort(ArrayList<String> list) {
		
		if(list.size()==0)
			return;

		ArrayList<String> sortedList = new ArrayList<String>();
		ArrayList<String> heapList = buildHeap(list);	
		
		while(!heapList.isEmpty()) {
			sortedList.add(removeRoots(heapList));
		}
		
		System.out.print("Heap : ");
		for(String word : sortedList)
			System.out.print(" "+word+" ");
	}
	
	String removeRoots(ArrayList<String>heap) {
		if(heap.isEmpty())
			return "";
		
		String root = heap.get(0);
		
		int lastIndex = heap.size()-1;
		swap(heap,0,lastIndex);
		heap.remove(lastIndex);
		
		int item_index = 0;
		while(!(isLeaf(heap,item_index)) && !isParent(heap,item_index)) {
			int smallerChildIndex = smallerChild(heap,item_index);
			swap(heap,item_index,smallerChildIndex);
			item_index = smallerChildIndex;
		}
		return root;
	}
	
int smallerChild(ArrayList<String>list,int index) {
	int leftChildIndex = leftChild(index);
	int rightChildIndex = rightChild(index);
	
	if(!isValid(list,rightChildIndex))
		return leftChildIndex;
	if(list.get(leftChildIndex).compareTo(list.get(rightChildIndex))<0) {
		return leftChildIndex;
	}
		
	return rightChildIndex;	
}
	
	boolean isLeaf(ArrayList<String>list,int index) {
		return !(isValid(list,leftChild(index)));
	}
		
	boolean isCorrect(ArrayList<String>list,int parent_index,int child_index) {
		if(!isValid(list,parent_index) || !isValid(list,child_index))
				return true;
	    return((list.get(parent_index).compareTo(list.get(child_index))<0));
		
	}
	boolean isParent(ArrayList<String>list,int index) {
		return (isCorrect(list,index,leftChild(index)) && isCorrect(list, index,rightChild(index)));
	}
	
}