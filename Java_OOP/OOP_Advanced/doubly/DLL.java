package oop.lists.doubly;

public class DLL {
	public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    public void push(Node newNode) {
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
    public void printValuesForward() {
        Node current = this.head;

        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    public void printValuesBackward() {
    	Node current = this.tail;
    	
    	while(current != null) {
    		System.out.println(current.value);
    		current = current.previous;
    	}
    }
    public Node pop() {
    	Node lastNode = this.tail;
    	lastNode.previous.next = null;
    	lastNode.previous = null;
    	return lastNode;
    }
    public boolean contains(Integer value) {
    	Node runner = this.head;
    	while(runner != null) {
    		if(runner.value == value) {
    			return true;
    		}
    	}
    	return false;
    }
    public int size() {
    	int count = 0;
    	Node runner = this.head;
    	while(runner!= null) {
    		count++;
    		runner=runner.next;
    	}
    	return count;
    }
    
}
