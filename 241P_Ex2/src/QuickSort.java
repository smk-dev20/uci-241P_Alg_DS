/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/
//Referenced pseudocode in text book - Steven Skiena Page 124
import java.util.ArrayList;

public class QuickSort{
	
	public void doQuickSort(ArrayList<String> list) {
		if(list.size()==0)
			return;

		int low=0;
		int high=list.size()-1;
		
		quicksort(list, low,high);
			
		System.out.print("Quick : ");
		for(String word : list)
			System.out.print(" "+word+" ");
	}
	
	public void quicksort(ArrayList<String> list, int low, int high) {
		int partition_index;
		
		if((high - low)>0) {
			partition_index = partition(list,low,high);
			quicksort(list, low,partition_index-1);
			quicksort(list, partition_index+1,high);
		}
	}
	
	public int partition(ArrayList<String>list, int low, int high) {
		int pivot_index;
		int final_pivot;
		
		pivot_index = high;
		final_pivot = low;
		for(int i= low;i<high;i++) {
			if((list.get(i).compareTo(list.get(pivot_index))<0)){
				String temp = list.get(final_pivot);
				list.set(final_pivot, list.get(i));
				list.set(i, temp);
				final_pivot++;			
			}
		}
		String temp = list.get(final_pivot);
		list.set(final_pivot, list.get(pivot_index));
		list.set(pivot_index, temp);
		
		return final_pivot;
		
	}
}