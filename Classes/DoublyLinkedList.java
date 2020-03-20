package eg.edu.alexu.csd.datastructure.linkedList.cs;

public class DoublyLinkedList implements ILinkedList {
 class Node {
	     Object element; 
	     Node next;
	     Node prev;
}
Node head,tail;
int size=0;
@Override
public void add(int index, Object element) {
	Node x=new Node();
    x.element=element;
    
	if (index>size || index<0)
		throw new RuntimeException();
	else{
		
	    if(size()==0 && index==0) {
	    	
	    	head=new Node();
	    	head.element=element;
	    	tail=head;
	    	size++;
	    }
	    else if(index==0 && size()>0) {
	    	x.next=head;
	    	head.prev=x;
	    	head=x;
	    }
	   
	    else {
	    	
	    	Node v=head;
			int i=0;
			while(i<index-1) {
				if(v.next!=null) {
				i++;
				v=v.next;
			}
				}
			x.next=v.next;
			v.next=x;
			x.prev=v;
			(v.next).prev=x;
			size++;
		
	}}
}
@Override
public void add(Object element) {
	Node x=new Node();
    x.element=element;
    tail.next=x;
    x.prev=tail;
    size++;
}
@Override
public Object get(int index) {
	if (index>size || index<0)
		throw new RuntimeException();
	else{
	Node x=new Node();
	x=head;
	int i=0; 
	while(i<index) {
		if(x.next!=null) {
		i++;
		x=x.next;
	}
		}
	return x.element;
}
}
@Override
public void set(int index, Object element) {
	Node x=new Node();
	int i=0;
	if (index>size || index<0)
		throw new RuntimeException();
	else if(index==0){
		head.element=element;
	}
	else{
		x=head;

		while(i<index) {
			if(x.next!=null) {
			i++;
			x=x.next;
		}
			x.element=element;
	}	
  }
}
@Override
public void clear() {
head=null;
size=0;
}
@Override
public boolean isEmpty() {
	if (size==0)
		return true;
	else
	return false;
}
@Override
public void remove(int index) {
	if (index>size || index<0 || size()==0)
		throw new RuntimeException();
	else if(index==0 && size()==1)
		head=null;
	else if(index==0 && size()>1)
		head=head.next;
	else{
	Node x=new Node();
	x=head;
	int i=0;
	while(i< index-1)
	{
		i++;
		x=x.next;
	}
	if(i+1==size()-1)
		x.next=null;
	else {
	Node v=new Node();
	v=x.next;
	x.next=v.next;
	(x.next).prev=x;
  }	}
	size--;

}

@Override
public int size() {
	return size;
}
@Override
public ILinkedList sublist(int fromIndex, int toIndex) {
	DoublyLinkedList SubList=new DoublyLinkedList();
	Node temp=head;
	int i;
	int j;
	SubList.size=0;
	
	if(isEmpty()==true)
	{
		return null;
	}
	else {
		for(i=0;i<fromIndex;i++)
		{  
			if(temp.next!=null)
				temp=temp.next;
		}
		Node headSubList=new Node();
		headSubList.element=temp.element;
		SubList.head=headSubList;
		SubList.size++;
		
		for(j=i;j<toIndex;j++)
		{
			if(temp.next!=null)
			{   temp=temp.next;
			    
				SubList.add(j,temp.element);
			}
		}
	}
	
	return SubList;
}
@Override
public boolean contains(Object o) {
	Node x=new Node();
	x=head;
	while(x!= null)
	{
		if(o.equals(x.element))
			return true;
		x=x.next;
	}
	return false;
}
public void show(){
	Node current=head;
	while(current!=null)
	{
		System.out.println(current.element);
		current=current.next;
	}
}
}
