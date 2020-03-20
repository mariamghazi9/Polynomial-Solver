package eg.edu.alexu.csd.datastructure.linkedList.cs;


public class SinglyLinkedList implements ILinkedList {
private class Node {
	     Object element;
	     Node next;
}
Node head,tail;
int size;
	@Override
	public void add(int index, Object element) {
		Node x=new Node();
		x.element=element;
		
		if (index>size || index<0)
			throw new RuntimeException();
		else {
			
				if(index==0 && size()==0) {
					head=new Node();
			    	head.element=element;
                    head=x;
				}
				else if(index==0 && size()>0) {
					x.next=null;
					tail.next=x;
				    tail=x;
				}
			
				else {
					int i=0;
					Node y=head;
					while(i<index-1) {
						if(y.next!=null) {

						i++;
						y=y.next;
					}
						}
					x.next=y.next;
					y.next=x;
				}

			size++;
		}
	}


	@Override
	public void add(Object element) {
		Node x=new Node();
		x.element=element;
		if(size()==0) {
			x.next=head.next;
			head.next=x;
			tail=x;
		}
		else {
			x.next=null;
			tail.next=x;
			tail=x;
		}
		size++;
	}
	

	@Override
	public Object get(int index) {
		if (index>size || index<0)
			throw new RuntimeException();
		Node x=new Node();
		x=head;
		int i=0;
		while(i< index)
		{
			i++;
			x=x.next;
		}
		return x.element;
	}

	@Override
	public void set(int index, Object element) {
		
		if (index>size() || index<0)
			throw new RuntimeException();
		else if(index==0 && size()==0) {
			head=new Node();
			head.element=element;
		}
		else {
		Node x=new Node();
		x=head;
		int i=0;
		while(i< index)
		{
			if(x.next!=null) {
			i++;
			x=x.next;
		}
			}
		x.element=element;
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
	  }	}
		size--;

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		SinglyLinkedList SubList=new SinglyLinkedList();
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
		int i=0;
		Node x=new Node();
		x=head;
		while(i<size)
		{
			if(o.equals(x.element))
				return true;
			x=x.next;
			i++;
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
