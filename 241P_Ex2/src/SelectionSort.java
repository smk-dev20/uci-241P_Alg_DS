/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/
import java.util.ArrayList;
//Implementation references code in text book Steven Skiena - Page 42
public class SelectionSort{
	
	public void doSelectionSort(ArrayList<String>list) {
		if(list.size()==0)
			return;

		int min_index;
		
		for(int i=0;i<list.size();i++) {
			min_index = i;
			for(int j=i+1;j<list.size();j++) {
				if((list.get(j).compareTo(list.get(min_index)))<0) {
					min_index = j;
				}
			}
			String temp = list.get(i);
			list.set(i,list.get(min_index));
			list.set(min_index,temp);
		}
		System.out.print("Selection : ");
		for(String word : list)
			System.out.print(" "+word+" ");
	}
}