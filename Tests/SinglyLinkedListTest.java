package eg.edu.alexu.csd.datastructure.linkedList.cs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {
	SinglyLinkedList list=new SinglyLinkedList();
    SinglyLinkedListTest(){
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);
    list.add(3, 4);
    list.add(4, 5);
	}
	@Test
	void testGet() {
		assertEquals(1,list.get(0));
		assertEquals(2,list.get(1));
		assertEquals(3,list.get(2));
		assertEquals(4,list.get(3));
		assertEquals(5,list.get(4));
        assertThrows(RuntimeException.class,()->{list.get(-1);});
        assertThrows(RuntimeException.class,()->{list.get(7);});
        list.add(3,9);
		assertEquals(9,list.get(3));
        list.set(2,6);
		assertEquals(6,list.get(2));
	}

	@Test
	void testClear() {
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	void testRemove() {
		list.remove(3);
		assertEquals(4,list.size());
		assertEquals(5,list.get(3));
	}

	@Test
	void testSublist() {
		SinglyLinkedList list2=new SinglyLinkedList();
		list2=(SinglyLinkedList) list.sublist(1,3);
		assertEquals(3,list2.size());
		assertEquals(list.get(1),list2.get(0));
		assertEquals(list.get(2),list2.get(1));
		assertEquals(list.get(3),list2.get(2));
	}

	@Test
	void testContains() {
		assertTrue(list.contains(4));
		assertFalse(list.contains(7));
	}

}
