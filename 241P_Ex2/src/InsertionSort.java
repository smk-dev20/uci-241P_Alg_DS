/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/
import java.util.ArrayList;
//References Insertion Sort code presented in Text Book Steven Skiena-Page 4
public class InsertionSort{
	
	public void doInsertSort(ArrayList<String> list) {
		if(list.size() == 0)
			return;

		for(int i=0;i<list.size();i++) {
			int j=i;
			while((j>0) && ((list.get(j).compareTo(list.get(j-1))<0))) {
				String temp = list.get(j-1);
				list.set(j-1,list.get(j));
				list.set(j,temp);	
				j=j-1;
			}
		}
		System.out.print("Insertion : ");
		for(String word : list)
			System.out.print(" "+word+" ");
	}
}