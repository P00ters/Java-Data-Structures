package JavaDS.Validation;

import JavaDS.Sorters.*;
import JavaDS.Trees.*;

import java.util.AbstractList;
import java.util.Random;

public class Validator {

	public static void main(String[] args) {
		TreeTest();
	}
	
	public static void TreeTest () {
		int len = 25;
		Integer[] data = SampleData(len);
		System.out.println("Populating tree:");
		for (int i = 0; i < len; i++) {
			if (i != len - 1)
				System.out.print(data[i] + ", ");
			else
				System.out.print(data[i] + "\n");
		}
		
		ITree<Integer> tree = new BinarySearchTree<Integer>();
		
		for (int i = 0; i < len; i++)
			tree.AddNode(data[i]);
		
		AbstractList<INode<Integer>> list = tree.ToList(TraversalDirection.INORDER);
		System.out.println("Tree Inorder After Adds:");
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size() - 1)
				System.out.print(list.get(i).GetData() + ", ");
			else
				System.out.print(list.get(i).GetData() + "\n");
		}
		
		Random r = new Random();
		int[] toRemove = new int[3];
		toRemove[0] = r.nextInt(len);
		toRemove[1] = r.nextInt(len);
		while (toRemove[1] == toRemove[0])
			toRemove[1] = r.nextInt(len);
		toRemove[2] = r.nextInt(len);
		while (toRemove[2] == toRemove[1] || toRemove[2] == toRemove[0])
			toRemove[2] = r.nextInt(len);
		
		System.out.println("Removing:");
		for (int i = 0; i < toRemove.length; i++) {
			tree.RemoveNode(data[toRemove[i]]);
			if (i != toRemove.length - 1) 
				System.out.print(data[toRemove[i]] + ", ");
			else 
				System.out.print(data[toRemove[i]] + "\n");
		}
		
		list = tree.ToList(TraversalDirection.INORDER);
		System.out.println("Tree Inorder After Remvoes:");
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size() - 1)
				System.out.print(list.get(i).GetData() + ", ");
			else
				System.out.print(list.get(i).GetData() + "\n");
		}
	}
	
	public static void SortTest () {
		int len = 25;
		Integer[] data = SampleData(len);
		
		ISorter<Integer> sorter = new MergeSort<Integer>(data);
		SortDriver(sorter, SortDirection.ASC);
	}
	
	public static Integer[] SampleData (int len) {
		Integer[] data = new Integer[len];
		Random rand = new Random();
		
		for (int i = 0; i < len; i++) {
			data[i] = rand.nextInt(100);
		}
		
		return data;
	}
	
	public static void SortDriver (ISorter<Integer> sorter, SortDirection dir) {
		int len = sorter.GetData().size();
		
		System.out.println("Unsorted:");
		for (int i = 0; i < len; i++) {
			if (i == 0) System.out.print("{");
			if (i != len - 1) System.out.print(sorter.GetData().get(i).toString() + ",");
			else System.out.print(sorter.GetData().get(i).toString() + "}");
		}
		
		sorter.Sort(dir);
		
		System.out.print("\nSorted in ");
		if (dir == SortDirection.ASC) System.out.print("ASC:\n");
		else System.out.print("DEC\n");
		for (int i = 0; i < len; i++) {
			if (i == 0) System.out.print("{");
			if (i != len - 1) System.out.print(sorter.GetData().get(i).toString() + ",");
			else System.out.print(sorter.GetData().get(i).toString() + "}");
		}
	}

}
