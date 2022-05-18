package JavaDS.Sorters;

import java.util.AbstractList;

/**
 * Class implementing the Heap Sort algorithm. Can sort a provided collection
 * of <code>Comparable</code> extending data elements in O(n log(n)) time complexity.
 * 
 * @author Tom Esser
 *
 * @param <T> Type of data elements being sorted.
 */
public class HeapSort<T extends Comparable<T>> extends SuperSort<T> implements ISorter<T> {

	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>AbstractList</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public HeapSort(AbstractList<T> unsortedData) {
		super(unsortedData);
	}
	
	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>Array</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public HeapSort(T[] unsortedData) {
		super(unsortedData);
	}

	/**
	 * Method to sort the data collection stored within the class using the 
	 * Heap Sort sorting algorithm.
	 * 
	 * @param dir The direction in which to sort the data collection. 
	 */
	@Override
	public void Sort(SortDirection dir) {
		for (int i = this.GetData().size() / 2 - 1; i >= 0; i--)
			this.Heap(dir, this.GetData().size(), i);
		
		for (int i = this.GetData().size() - 1; i > 0; i--) {
			this.Swap(0, i);
			this.Heap(dir, i, 0);
		}
	}
	
	/**
	 * Private method used to generate the heap. 
	 * 
	 * @param dir The direction the collection is being sorted in.
	 * @param n The effective heap size.
	 * @param i The rooted node in the heap being operated on.
	 */
	private void Heap(SortDirection dir, int n, int i) {
		int max = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if (dir == SortDirection.ASC) {
			if (l < n && this.GetData().get(l).compareTo(this.GetData().get(max)) > 0)
				max = l;
			
			if (r < n && this.GetData().get(r).compareTo(this.GetData().get(max)) > 0)
				max = r;
		}
		else {
			if (l < n && this.GetData().get(l).compareTo(this.GetData().get(max)) < 0)
				max = l;
			
			if (r < n && this.GetData().get(r).compareTo(this.GetData().get(max)) < 0)
				max = r;
		}
		
		if (max != i) {
			this.Swap(i, max);
			this.Heap(dir, n, max);
		}
	}

}
