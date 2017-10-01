package hw5.demo;
import java.util.Scanner;
import static org.junit.Assert.*;
import junit.framework.*;
import org.junit.Test;

public class TestLetterGradeTest extends TestCase {
	
	public int Input;
	public char Result;
	public char letterGrade;
	
		@Test
		public void test_1() {
			Input = 14;
			Result ='F';
			assertEquals(Result,letterGrade(Input));
			
		}

	
		@Test
		public void test_2() {
			Input = -3;
			Result ='X';
			assertEquals(Result,letterGrade(Input));
			
		}
		
		
		@Test
		public void test_3() {
			Input = 0;
			Result ='F';
			assertEquals(Result,letterGrade(Input));
			
		}
		
		@Test
		public void test_4() {
			Input = 66;
			Result ='D';
			assertEquals(Result,letterGrade(Input));
			
		}
		
		@Test
		public void test_5() {
			Input = 87;
			Result ='B';
			assertEquals(Result,letterGrade(Input));
			
		}
		
		@Test
		public void test_6() {
			Input = 99;
			Result ='A';
			assertEquals(Result,letterGrade(Input));
			
		}
		
		@Test
		public void test_7() {
			Input = 120;
			Result ='X';
			assertEquals(Result,letterGrade(Input));
			
		}
		
		
	private static char letterGrade(int score) {
		char grade ;
		if(score<0 || score>100) {
			grade='X';
		}else if (score>=90 && score<=100) {
			grade='A';
		}else if (score>=80 && score<=90) {
			grade='B';
		}else if (score>=70 && score<=80) {
			grade='C';
		}else if (score>=60 && score<=70) {
			grade='D';
		}else {
			grade='F';
		}
	return grade;

	}
}