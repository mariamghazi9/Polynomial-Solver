package eg.edu.alexu.csd.datastructure.linkedList.cs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
class PolynomialSolverTest {

	PolynomialSolver solver=new PolynomialSolver();
	int test1[][]= {{1,2},{-1,2},{3,4},{6,5}};
	int test2[][]= {{3,2},{4,5},{0,2},{3,1}};
	int test3[][]= {{8,2},{-1,2},{6,4},{2,3},{0,0},{6,0},{-8,2}};
	int test4[][]= {{3,-2},{4,3},{0,2},{4,1},{9,-1}};
 
	@Test
	void testClearPolynomial() {
		solver.setPolynomial('A',test1);
		assertEquals(4,solver.A.size());
		solver.clearPolynomial('A');
		assertEquals(0,solver.A.size());
 
	}
	@Test
	void testChooseList()
	{
		assertNull(solver.chooseList('M'));
 
	}
 
 
	@Test
	void testEvaluatePolynomial() {
		solver.setPolynomial('B', test2);
 
		assertEquals(1008,solver.evaluatePolynomial('B', 3));
		float ans=solver.evaluatePolynomial('B', (float) 1.5);
		assertEquals(41.625,ans);
		assertEquals(-122,solver.evaluatePolynomial('B', -2));
 
	}
 
 
 
 
	@Test
	void testAdd() {
		solver.setPolynomial('A', test1);
		solver.setPolynomial('B',test2);
		int [][]expected1= {{10,5},{3,4},{3,2},{3,1}};
		assertArrayEquals(expected1,solver.add('A','B'));
	    solver.B.clear();
	    solver.R.clear();
		int [][] expected2= {{6,4},{6,3},{-1,2},{4,1},{6,0},{9,-1},{3,-2}};
		solver.setPolynomial('B', test3);
		solver.setPolynomial('C', test4);
		int [][] result=solver.add('B', 'C');
		assertArrayEquals(expected2,result);
 
 
 
	}
 
	@Test
	void testSubtract() {
 
		solver.setPolynomial('A', test1);
		solver.setPolynomial('B',test2);
		int [][]expected1= {{2,5},{3,4},{-3,2},{-3,1}};
		assertArrayEquals(expected1,solver.subtract('A','B'));
	    solver.B.clear();
	    solver.R.clear();
		int [][] expected2= {{6,4},{-2,3},{-1,2},{-4,1},{6,0},{-9,-1},{-3,-2}};
		solver.setPolynomial('B', test3);
		solver.setPolynomial('C', test4);
		assertArrayEquals(expected2,solver.subtract('B','C'));
	}
 
	@Test
	void testMultiply() {
 
		solver.setPolynomial('A', test1);
		solver.setPolynomial('B',test2);
		int [][]expected1= {{24,10},{12,9},{18,7},{27,6},{9,5}};
		assertArrayEquals(expected1,solver.multiply('A','B'));
	    solver.B.clear();
	    solver.R.clear();
		int [][] expected2= {{24,7},{8,6},{20,5},{8,4},{74,3},{36,2},{21,1},{-3,0},{54,-1},{18,-2}};
		solver.setPolynomial('B', test3);
		solver.setPolynomial('C', test4);
		assertArrayEquals(expected2,solver.multiply('B','C'));
	}

}
