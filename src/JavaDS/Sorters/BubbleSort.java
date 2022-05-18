package JavaDS.Sorters;

import java.util.AbstractList;

/**
 * Class implementing the Bubble Sort algorithm. Can sort a provided collection
 * of <code>Comparable</code> extending data elements in average O(n^2) time complexity.
 * 
 * @author Tom Esser
 *
 * @param <T> Type of data elements being sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends SuperSort<T> implements ISorter<T> {

	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>AbstractList</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public BubbleSort(AbstractList<T> unsortedData) {
		super(unsortedData);
	}
	
	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>Array</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public BubbleSort(T[] unsortedData) {
		super(unsortedData);
	}

	/**
	 * Method to sort the data collection stored within the class using the 
	 * Bubble Sort sorting algorithm.
	 * 
	 * @param dir The direction in which to sort the data collection. 
	 */
	@Override
	public void Sort(SortDirection dir) {
		for (int i = 0; i < this.GetData().size() - 1; i++) {
			for (int j = 0; j < this.GetData().size() - i - 1; j++) {
				if (dir == SortDirection.ASC) {
					if (this.GetData().get(j).compareTo(this.GetData().get(j+1)) > 0)
						this.Swap(j, j+1);
				}
				else {
					if (this.GetData().get(j).compareTo(this.GetData().get(j+1)) < 0)
						this.Swap(j, j+1);
				}
				
			}
		}
		
	}
	
}
