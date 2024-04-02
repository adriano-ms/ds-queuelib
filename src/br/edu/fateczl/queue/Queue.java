package br.edu.fateczl.queue;

public class Queue<T> {
	
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
		Node<T> node = new Node<T>();
		node.setData(data);
		node.setNext(null);
		if(isEmpty()) {
			last = node;
			first = last;
		} else {
			last.setNext(node);
			last = node;
		}
	}
	
	public T remove() throws Exception {
		if(isEmpty())
			throw new Exception("Empty queue");
		
		if(size() == 1) {
			first = null;
			last = null;
		}
		T toReturn = first.getData();
		first = first.getNext();
		return toReturn;
	}
	
	public int size() {
		int count = 0;
		Node<T> aux = first;
		while(aux != null) {
			aux = aux.getNext();
			count++;
		}
		
		return count;
	}

}
