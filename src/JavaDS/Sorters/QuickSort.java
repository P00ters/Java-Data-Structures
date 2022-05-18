package JavaDS.Sorters;

import java.util.AbstractList;
import java.util.Random;

/**
 * Class implementing the Quick Sort algorithm. Can sort a provided collection
 * of <code>Comparable</code> extending data elements in average O(n log(n)) time complexity.
 * 
 * @author Tom Esser
 *
 * @param <T> Type of data elements being sorted.
 */
public class QuickSort<T extends Comparable<T>> extends SuperSort<T> implements ISorter<T> {
	
	private SortPivot pivotOption;
	
	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>AbstractList</code>. Uses the median as 
	 * pivot location in partitioning, unless specified in constructor.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public QuickSort(AbstractList<T> unsortedData) {
		super(unsortedData);
		this.pivotOption = SortPivot.MEDIAN;
	}
	

	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>Array</code>. Uses the median as 
	 * pivot location in partitioning, unless specified in constructor.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 */
	public QuickSort(T[] unsortedData) {
		super(unsortedData);
		this.pivotOption = SortPivot.MEDIAN;
	}
	
	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>AbstractList</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 * @param pivotOption Where to pick for pivot location in partitioning in 
	 * Quick Sort algorithm. If no value is provided, the median element is used.
	 */
	public QuickSort(AbstractList<T> unsortedData, SortPivot pivotOption) {
		super(unsortedData);
		this.pivotOption = pivotOption;
	}
	
	/**
	 * Constructor accepting an initial collection of data elements to be 
	 * sorted formatted as an <code>Array</code>.
	 * 
	 * @param unsortedData The collection of data elements to be stored for
	 * sorting. 
	 * @param pivotOption Where to pick for pivot location in partitioning in 
	 * Quick Sort algorithm. If no value is provided, the median element is used.
	 */
	public QuickSort(T[] unsortedData, SortPivot pivotOption) {
		super(unsortedData);
		this.pivotOption = pivotOption;
	}

	/**
	 * Method to sort the data collection stored within the class using the 
	 * Quick Sort sorting algorithm.
	 * 
	 * @param dir The direction in which to sort the data collection. 
	 */
	@Override
	public void Sort(SortDirection dir) {
		this.DoSort(dir, 0, this.GetData().size() - 1);		
	}
	
	/**
	 * Method that sorts using the Quick Sort algorithm with recursive 
	 * partitioning. 
	 * 
	 * @param dir The direction the collection is being sorted in.
	 * @param low The effective low element in the collection.
	 * @param high The effective high element in the collection.
	 */
	private void DoSort(SortDirection dir, int low, int high) {
		if (low < high) {
			int pivot = this.Partition(dir, low, high);
			
			this.DoSort(dir, low, pivot - 1);
			this.DoSort(dir, pivot + 1, high);
		}
	}
	
	/**
	 * Method to choose pivot and place in correct location. 
	 * 
	 * @param dir The direction the collection is being sorted in.
	 * @param low The effective low element in the collection.
	 * @param high The effective high element in the collection.
	 * @return The next pivot. 
	 */
	private int Partition (SortDirection dir, int low, int high) {
		T pivot;
		int i = low - 1;
		
		if (this.pivotOption == SortPivot.FIRST) {
			this.Swap(low, high);
			pivot = this.GetData().get(high);
		}
		else if (this.pivotOption == SortPivot.LAST) {
			pivot = this.GetData().get(high);
		}
		else if (this.pivotOption == SortPivot.RANDOM) {
			Random r = new Random();
			int index = r.nextInt((high - low) + 1) + low;
			this.Swap(index, high);
			pivot = this.GetData().get(high);
		}
		else {
			int index = (high + low) / 2;
			this.Swap(index, high);
			pivot = this.GetData().get(high);
		}
		
		
		for (int j = low; j < high; j++) {
			if (dir == SortDirection.ASC) { 
				if (this.GetData().get(j).compareTo(pivot) < 0) {
					i++;
					this.Swap(i, j);
				}
			}
			else {
				if (this.GetData().get(j).compareTo(pivot) > 0) {
					i++;
					this.Swap(i, j);
				}
			}
		}
		
		this.Swap(i+1, high);
		return (i+1);
	}
	
}
