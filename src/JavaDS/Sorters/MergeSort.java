package JavaDS.Sorters;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Class implementing the Merge Sort algorithm. Can sort a provided collection
 * of <code>Comparable</code> extending data elements in O(n log(n)) time complexity.
 * 
 * @author Tom Esser
 *
 * @param <T> Type of data elements being sorted.
 */
public class MergeSort<T extends Comparable<T>> extends SuperSort<T> implements ISorter<T> {
	
	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>AbstractList</code>. 
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public MergeSort(AbstractList<T> unsortedData) {
		super(unsortedData);
	}
	

	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>Array</code>. 
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public MergeSort(T[] unsortedData) {
		super(unsortedData);
	}


	/**
	 * Method to sort the data collection stored within the class using the 
	 * Merge Sort sorting algorithm.
	 * 
	 * @param dir The direction in which to sort the data collection. 
	 */
	@Override
	public void Sort(SortDirection dir) {
		this.Sorter(dir, 0, this.GetData().size() - 1);		
	}
	
	/**
	 * Merges to subarrays into sorted array.
	 * 
	 * @param dir The direction the collection is being sorted in.
	 * @param l The effective lower bound of the first array.
	 * @param m The effective upper bound of the first array.
	 * @param r The effective upper bound of the second array.
	 */
	private void Merger(SortDirection dir, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		
		ArrayList<T> left = new ArrayList<T>();
		ArrayList<T> right = new ArrayList<T>();
		

		
		for (int i = 0; i < n1; ++i)
			left.add(this.GetData().get(l + i));
		for (int i = 0; i < n2; ++i)
			right.add(this.GetData().get(m + 1 + i));
		
		
		int i = 0, j = 0;
		
		int k = l;
		while (i < n1 && j < n2) {
			if (dir == SortDirection.ASC) { 
				if (left.get(i).compareTo(right.get(j)) <= 0) {
					this.GetData().set(k, left.get(i));
					i++;
				}
				else {
					this.GetData().set(k, right.get(j));
					j++;
				}
			}
			else {
				if (left.get(i).compareTo(right.get(j)) >= 0) {
					this.GetData().set(k, left.get(i));
					i++;
				}
				else {
					this.GetData().set(k, right.get(j));
					j++;
				}
			}
			k++;
		}
		
		while (i < n1) {
			this.GetData().set(k, left.get(i));
			i++;
			k++;
		}
		
		while (j < n2) {
			this.GetData().set(k, right.get(j));
			j++;
			k++;
		}

	}
	
	/**
	 * Method that sorts collection using merges recursively.
	 * 
	 * @param dir The direction the collection is being sorted in.
	 * @param l The effective lower bound of the first array.
	 * @param r The effective upper bound of the second array.
	 */
	private void Sorter(SortDirection dir, int l, int r) {
		
		if (l < r) {
			int m = l + (r - l) / 2;
			
			this.Sorter(dir, l, m);
			this.Sorter(dir, m + 1, r);
			
			this.Merger(dir, l, m, r);
		}
	}
}
