package com.example.project;

public class DLL<T> {
	private DLLNode<T> head;
	private DLLNode<T> current;

    public DLL() {
        head = current = null;
    }
    public boolean empty() {
        return head == null;
    }
    public boolean last() {
        return current.next == null;
    }
    public boolean first() {
        return current.previous == null;
    }
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public void findPrevious() {
        current = current.previous;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T val) {
        current.data = val;
    }
    public void insert(T val) {
        DLLNode<T> tmp = new DLLNode<T>(val);
        if(empty()) {
            current = head = tmp;
        }
        else {
            tmp.next = current.next;
            tmp.previous = current;
            if(current.next != null)
                current.next.previous = tmp;
            current.next = tmp;
            current = tmp;
        }
    }
    public void remove() {
        if(current == head) {
            head = head.next;
            if(head != null)
               head.previous = null;
        }
        else {
            current.previous.next = current.next;
            if(current.next != null)
               current.next.previous = current.previous;
        }
        if(current.next == null)
            current = head;
        else
            current = current.next;
    }
    public void removeBetween(T e1, T e2) {
    	
    	boolean ise1Found = false;
    	boolean ise2Found = false;
    	DLLNode<T> tmp = null;
    	
    	current = head;
    	
    	while(current.next != null) {
    		if(current.data == e1) {
    			System.out.println("found");
    			ise1Found = true;
    			 tmp = current;
    		}
    		else if(current.data == e2 && !ise2Found) {
    			System.out.println("found");
    			ise2Found = true;
    			current = tmp.next;
    		}
    		if(ise1Found && ise2Found && current.data != e2) {
    			System.out.println(current.data + " removed");
    			remove();
    		}
    		
    		if(!ise1Found || !ise2Found) 
    			current = current.next;
    		
    	}
    	
    	current = head;
    	
    }
}
