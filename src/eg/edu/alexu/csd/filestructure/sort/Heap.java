package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Heap<T extends Comparable<T>> implements IHeap<T> {

	private List<INode<T>> heap = new ArrayList<>();
	private int size = 0;

	private class Node<T extends Comparable<T>> implements INode<T> {

		int index;
		private T val;

		public Node(int index) {
			this.index = index;
		}

		@Override
		public INode<T> getLeftChild() {
			if (2 * index >= size) {
				return null;
			}
			return (INode<T>) heap.get(2 * index);
		}

		@Override
		public INode<T> getRightChild() {
			if (2 * index + 1 >= size) {
				return null;
			}
			return (INode<T>) heap.get(2 * index + 1);
		}

		@Override
		public INode<T> getParent() {
			if (index / 2 < 1) {
				return null;
			}
			return (INode<T>) heap.get(index / 2);
		}

		@Override
		public T getValue() {
			return val;
		}

		@Override
		public void setValue(T value) {
			val = value;

		}
	}

	@Override
	public INode<T> getRoot() {

		return heap.get(1);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void heapify(INode<T> node) {

		INode<T> left = node.getLeftChild();
		INode<T> right = node.getRightChild();
		INode<T> largest = node;

		if (left != null && left.getValue().compareTo(node.getValue()) > 0) {

			largest = left;
		} else {
			largest = node;
		}
		if (right != null && right.getValue().compareTo(largest.getValue()) > 0) {
			largest = right;
		}
		if (largest != node) {
			T temp = node.getValue();
			node.setValue(largest.getValue());
			largest.setValue(temp);
			heapify(largest);
		}

	}

	@Override
	public T extract() {
		T item = heap.get(1).getValue();
		heap.get(1).setValue(heap.get(size).getValue());
		heap.remove(size);
		size--;
		if (size != 0) {
			heapify(heap.get(1));
		}

		/*
		 * INode<T> item1 = heap.get(1); INode<T> temp = heap.get(size);
		 * item1.setValue(temp.getValue()); heap.remove(size); size--;
		 * heapify(heap.get(1));
		 */

		return item;
	}

	@Override
	public void insert(T element) {
		int i;
		if (size == 0) {
			heap.add(null);
		}
		Node<T> newnode = new Node<T>(size + 1);
		newnode.setValue(element);
		heap.add(size + 1, newnode);
		size++;
		i = size;

		INode<T> current = newnode;

		while (current != getRoot() && current.getValue().compareTo(current.getParent().getValue()) > 0) {
			T temp = current.getParent().getValue();
			current.getParent().setValue(current.getValue());
			current.setValue(temp);
			current = current.getParent();

		}
	}

	@Override
	public void build(Collection<T> unordered) {
		int length = unordered.size();
		heap = (List<INode<T>>) unordered;
		for (int i = length / 2; i > 0; i--) {
			heapify(heap.get(i));
		}

	}

}
