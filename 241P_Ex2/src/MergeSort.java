/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/
//Referenced : https://www.baeldung.com/java-merge-sort but implemented as list
import java.util.ArrayList;

public class MergeSort{
	
	public void doMergeSort(ArrayList<String>list) {
		if(list.size()==0)
			return;


		int low = 0;
		int high = list.size()-1;
		mergeSort(list,low,high);
		
		System.out.print("Merge : ");
		for(String word : list)
			System.out.print(" "+word+" ");
	}
	
	public void mergeSort(ArrayList<String>list,int low, int high) {
		int mid;
		if(low<high) {
			mid = (int)(low + high)/2;
			mergeSort(list,low,mid);
			mergeSort(list,mid+1,high);
			merge(list,low,mid,high);
		}
	}
	
	public void merge(ArrayList<String>list, int low, int mid, int high) {
		ArrayList<String> merged = new ArrayList<String>();

		
		int left=low;
		int right=mid+1;
		while(left <= mid && right <= high) {
			if((list.get(left).compareTo(list.get(right))<0)){
				merged.add(list.get(left));
				left++;
			}else {
				merged.add(list.get(right));
				right++;
			}
		}
		
		while(left<=mid) {
			merged.add(list.get(left));
			left++;
		}
		
		while(right<=high) {
			merged.add(list.get(right));
			right++;
		}
		
		int i=0;
		int j=low;
		while(i<merged.size()) {
			list.set(j, merged.get(i++));
			j++;
		}

	}
}