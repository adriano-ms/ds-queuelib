package br.edu.fateczl.queue;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

	private Node<T> first;
	private Node<T> last;

	public Queue() {
		this.first = null;
		this.last = null;
	}

	public boolean isEmpty() {
		return first == null && last == null;
	}

	public void insert(T data) {
		Node<T> node = new Node<>(data, null);
		if (isEmpty()) {
			last = node;
			first = last;
		} else {
			last.setNext(node);
			last = node;
		}
	}

	public T remove() throws Exception {
		if (isEmpty())
			throw new Exception("Empty queue");

		T toReturn = first.getData();

		if (size() == 1) {
			first = null;
			last = null;
			return toReturn;
		}

		first = first.getNext();
		return toReturn;
	}

	public int size() {
		int count = 0;
		Node<T> aux = first;
		while (aux != null) {
			aux = aux.getNext();
			count++;
		}
		return count;
	}

	Node<T> getFirst() {
		return first;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for (T element : this)
			buffer.append(element + " -> ");

		return buffer.toString().replaceFirst("( -> )$", "").concat("]");
	}

	@Override
	public Iterator<T> iterator() {

		return new QueueIterator<T>(this);
	}
}

class QueueIterator<T> implements Iterator<T> {

	private Node<T> current;

	public QueueIterator(Queue<T> queue) {
		this.current = queue.getFirst();
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		T data = current.getData();
		current = current.getNext();
		return data;
	}

}
