package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "S222225013";
		Assert.assertNotNull("Student ID is null", studentId);
		System.out.println(studentId);
		System.out.println();
	}

	@Test
	public void testStudentName() {
		String studentName = "AndreiAngeles";
		Assert.assertNotNull("Student name is null", studentName);

	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("testMinJanuary1ShouldIncrementToJanuary > " + date);
		date.increment();
		System.out.println(date);
		

	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil (1, 1, 2024);
		System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
		date.decrement();
		System.out.println(date);
	}
	
	/*
	 * Write tests for rest months of year 2024.
	 */
	
	@Test
	public void test1B_NextDate() {
	    DateUtil date = new DateUtil(1, 6, 1994);
	    date.increment();
	    System.out.println("1B Result: " + date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void test2B_NextDate() {
	    DateUtil date = new DateUtil(2, 6, 1994);
	    date.increment();
	    System.out.println("2B Result: " + date);
	    Assert.assertEquals(3, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void test3B_NextDate() {
	    DateUtil date = new DateUtil(15, 6, 1994);
	    date.increment();
	    System.out.println("3B Result: " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void test4B_NextDate() {
	    DateUtil date = new DateUtil(30, 6, 1994);
	    date.increment();
	    System.out.println("4B Result: " + date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test(expected = RuntimeException.class)
	public void test5B_InvalidDate() {
	    new DateUtil(31, 6, 1994);  // June has only 30 days < hence throw the expected runtime exception
	}

	@Test
	public void test6B_NextDate() {
	    DateUtil date = new DateUtil(15, 1, 1994);
	    date.increment();
	    System.out.println("6B Result: " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void test7B_NextDate() {
	    DateUtil date = new DateUtil(15, 2, 1994);
	    date.increment();
	    System.out.println("7B Result: " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void test8B_NextDate() {
	    DateUtil date = new DateUtil(15, 11, 1994);
	    date.increment();
	    System.out.println("8B Result: " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void test9B_NextDate() {
	    DateUtil date = new DateUtil(15, 12, 1994);
	    date.increment();
	    System.out.println("9B Result: " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void test10B_NextDate() {
	    DateUtil date = new DateUtil(15, 6, 1700);
	    date.increment();
	    System.out.println("10B Result: " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1700, date.getYear());
	}

	@Test
	public void test11B_NextDate() {
	    DateUtil date = new DateUtil(15, 6, 1701);
	    date.increment();
	    System.out.println("11B Result: " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1701, date.getYear());
	}

	@Test
	public void test12B_NextDate() {
	    DateUtil date = new DateUtil(15, 6, 2023);
	    date.increment();
	    System.out.println("12B Result: " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void test13B_NextDate() {
	    DateUtil date = new DateUtil(15, 6, 2024);
	    date.increment();
	    System.out.println("13B Result: " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}
	
}
