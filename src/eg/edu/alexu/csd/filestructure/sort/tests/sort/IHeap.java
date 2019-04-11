package eg.edu.alexu.csd.filestructure.sort.tests.sort;

import java.util.Collection;

public abstract interface IHeap<T extends Comparable<T>> extends Cloneable {
	public abstract INode<T> getRoot();

	public abstract int size();

	public abstract void heapify(INode<T> paramINode);

	public abstract T extract();

	public abstract void insert(T paramT);

	public abstract void build(Collection<T> paramCollection);

}
