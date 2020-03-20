package eg.edu.alexu.csd.datastructure.linkedList.cs;

import java.awt.Point;

public class PolynomialSolver implements IPolynomialSolver {
	SinglyLinkedList A = new SinglyLinkedList();
	SinglyLinkedList B = new SinglyLinkedList();
	SinglyLinkedList C = new SinglyLinkedList();
	SinglyLinkedList R = new SinglyLinkedList();
 
	public SinglyLinkedList fromArrToList(SinglyLinkedList list, int[][] array) {
 
		for (int i = 0; i<array.length; i++) {
			Point point = new Point();
			for (int j = 0; j<2; j++) {
				if (j == 0) {
					point.x = array[i][j];
 
				} else {
					point.y = array[i][j];
				}
 
			}
 
			list.add(i, point);
		}
		return list;
 
	}
	public int[][] fromListToArray(SinglyLinkedList list, int[][] array) {
		for (int i = 0; i<list.size(); i++) {
			Point temp = new Point();
			temp = (Point) list.get(i);
			array[i][0] = (int) temp.getX();
			array[i][1] = (int) temp.getY();
		}
 
		return array;
	}
 
	public Object addDuplicates(Object o1, Object o2, char op) {
		{
			Point A = new Point();
			Point B = new Point();
			A = (Point) o1;
			B = (Point) o2;
			Point result = new Point();
			switch (op) {
				case '+':
 
					result.x = (A.x + B.x);
					result.y = A.y;
					break;
				case '*':
					result.x = A.x * B.x;
					result.y = A.y + B.y;
					break;
			}
			return result;
 
		}
	}
 
	public SinglyLinkedList toNegative(SinglyLinkedList list) {
		for (int i = 0; i<list.size; i++) {
			Point temp = new Point();
			temp = (Point) list.get(i);
			temp.x = -temp.x;
			list.set(i, temp);
		}
		return list;
	}
 
	public int compare(Object o1, Object o2) {
		Point A = new Point();
		Point B = new Point();
		A = (Point) o1;
		B = (Point) o2;
 
		if (A.getY()<B.getY())
			return 1;
		else if (A.getY() == B.getY())
			return 2;
		else return 0;
	}
 
	public SinglyLinkedList removeZero(SinglyLinkedList list) {
		for (int i = 0; i<list.size; i++) {
			Point point = new Point();
			point = (Point) list.get(i);
			if (point.x == 0)
				list.remove(i);
		}
		return list;
	}
 
	@Override
	public void setPolynomial(char poly, int[][] terms) {
 
		switch (poly) {
			case 'A':
				fromArrToList(A, terms);
				break;
			case 'B':
				fromArrToList(B, terms);
				break;
			case 'C':
				fromArrToList(C, terms);
				break;
			case 'R':
				fromArrToList(R, terms);
 
		}
	}
 
	@Override
	public String print(char poly) {
		String s = new String();
		StringBuffer sb = new StringBuffer();
		SinglyLinkedList temp = new SinglyLinkedList();
		temp = chooseList(poly);
		if(temp.isEmpty())
			return null;
		boolean first = true;
		sort(temp);
		for (int i = 0; i<temp.size(); i++) {
			Point point = (Point) temp.get(i);
			if (point.x == 0)
				continue;
			else {
				if (first == false) {
					if (point.x > 0)
						sb.append('+');
					else
						sb.append("");
				}
 
				if (point.y == 1) {
					if (point.x == 1) {
						first = false;
 
						sb.append('x');
					} else if (point.x == -1) {
						sb.append("-x");
					} else {
						sb.append(point.x);
						sb.append('x');
						first = false;
					}
 
				} else if (point.y == 0 && point.x != 0) { //sb.append('+');
					sb.append(point.x);
					first = false;
 
				} else if (point.x == 1) {
					sb.append("x^");
					sb.append(point.y);
					first = false;
				} else if (point.x == -1) {
					sb.append("-x^");
					sb.append(point.y);
					first = false;
				} else {
					sb.append(point.x);
					sb.append("x^");
					sb.append(point.y);
					first = false;
 
				}
			}
		}
		s = sb.toString();
		return s;
	}
 
	@Override
	public void clearPolynomial(char poly) {
 
		switch (poly) {
			case 'A':
				A.head = null;
				A.size = 0;
 
				break;
			case 'B':
				B.head = null;
				B.size = 0;
				B = null;
				break;
			case 'C':
				C.head = null;
				C.size = 0;
				C = null;
				break;
			case 'R':
				R.head = null;
				R.size = 0;
				R = null;
				break;
		}
 
	}
	public SinglyLinkedList chooseList(char poly) {
		switch (poly) {
			case 'A':
				return A;
 
			case 'B':
				return B;
			case 'C':
				return C;
			case 'R':
				return R;
 
		}
		return null;
	}
 
	public void sort(SinglyLinkedList list) {
		int i = 0, j = 0;
		for (i = 0; i<list.size(); i++) {
 
			Object temp = new Object();
			Object temp2 = new Object();
 
			for (j = 1; j<list.size() - i; j++) {
 
				if (compare(list.get(j - 1), list.get(j)) == 1) {
					temp = list.get(j - 1);
					list.set(j - 1, list.get(j));
					list.set(j, temp);
				} else if (compare(list.get(j - 1), list.get(j)) == 2) {
					temp2 = addDuplicates(list.get(j - 1), list.get(j), '+');
					if (temp2.equals(0)) {
						list.remove(j-1);
						list.remove(j-1);
					} else {
						list.set(j - 1, addDuplicates(list.get(j - 1), list.get(j), '+'));
						list.remove(j);
					}
				}
			}
		}
	}
 
	@Override
	public float evaluatePolynomial(char poly, float value) {
		float sum = 0;
		SinglyLinkedList temp = new SinglyLinkedList();
		temp = chooseList(poly);
		for (int i = 0; i<temp.size; i++) {
			Point point = (Point) temp.get(i);
			sum += (point.getX()) * Math.pow(value, point.getY());
 
		}
		return sum;
	}
 
	@Override
	public int[][] add(char poly1, char poly2) {
		SinglyLinkedList list1 = new SinglyLinkedList();
		SinglyLinkedList list2 = new SinglyLinkedList();
		list1 = chooseList(poly1);
		list2 = chooseList(poly2);
		sort(list1);
		sort(list2);
 
		int i = 0, j = 0, k = 0;
 
		while (i<list1.size() && j<list2.size()) {
 
			if (compare(list1.get(i), list2.get(j)) == 1) {
				R.add(k, list2.get(j));
				j++;
				k++;
			} else if (compare(list1.get(i), list2.get(j)) == 2) {
				R.add(k, addDuplicates(list1.get(i), list2.get(j), '+'));
				k++;
				i++;
				j++;
 
			} else {
				R.add(k, list1.get(i));
				i++;
				k++;
			}
		}
 
		while (i<list1.size()) {
			R.add(k, list1.get(i));
			i++;
			k++;
 
		}
		while (j<list2.size()) {
			R.add(k, list2.get(j));
			j++;
			k++;
		}
		sort(R);
		removeZero(R);
		int[][] result = new int[R.size][2];
		return fromListToArray(R, result);
	}
 
	@Override
	public int[][] subtract(char poly1, char poly2) {
		SinglyLinkedList list = new SinglyLinkedList();
		list = chooseList(poly2);
		toNegative(list);
		return add(poly1, poly2);
	}
 
	@Override
	public int[][] multiply(char poly1, char poly2) {
		SinglyLinkedList list1 = new SinglyLinkedList();
		SinglyLinkedList list2 = new SinglyLinkedList();
		list1 = chooseList(poly1);
		list2 = chooseList(poly2);
		sort(list1);
		sort(list2);
		removeZero(list1);
		removeZero(list2);
		int k = 0;
		for (int i = 0; i<list1.size; i++) {
			for (int j = 0; j<list2.size; j++) {
				R.add(k, addDuplicates(list1.get(i), list2.get(j), '*'));
				k++;
			}
		}
 
		sort(R);
		removeZero(R);
		int[][] result = new int[R.size][2];
		return fromListToArray(R, result);
	}
 
}
