import java.util.*;

public class StackWithMin<T extends Comparable<T>>{	
	private class Node{
		T value;
		T min;
		Node next;
		public Node(T value){
			this.value = value;
		}
	}
	private Node last = null;

	public void push(T value) throws EmptyStackException{
		Node node = new Node(value);
		if(isEmpty() || node.value.compareTo(last.min) < 0){
			node.min = node.value;
		}
		else{
			node.min = last.min;
		}
		node.next = last;
		last = node;
	}

	public T pop(){
		if(isEmpty()) throw new EmptyStackException();
		else{
			Node n = last;
			last = last.next;
			return n.value;
		}
	}
	public boolean isEmpty(){
		if(last == null) return true;
		else return false;
	}
	public T min() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException();
		else return last.min;
	}
	public static void main(String[] args){
		StackWithMin<Integer> stack= new StackWithMin<Integer>();
		try{
			stack.push(6);
			System.out.println(stack.min());
			stack.push(5);
			System.out.println(stack.min());
			stack.push(4);
			System.out.println(stack.min());
			stack.pop();
			System.out.println(stack.min());
			stack.pop();
			System.out.println(stack.min());
		}
		catch(Exception e){}
	}
}