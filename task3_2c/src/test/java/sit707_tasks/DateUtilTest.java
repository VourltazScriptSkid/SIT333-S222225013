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
		String studentId = "s222225013";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Andrei";
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
	public void testIncrement_May15_NonLeapYear() {
	    DateUtil date = new DateUtil(15, 5, 2023); // May 15, 2023
        System.out.println("testIncrement_May15_NonLeapYear > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}
	
	
	@Test
	public void testIncrement_Feb29_LeapYear() {
	    DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("testIncrement_Feb29_LeapYearr > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	
	@Test(expected = RuntimeException.class)
	public void testInvalid_Feb29_NonLeapYear() {
	    new DateUtil(29, 2, 2023);
	}

		


	
	
	@Test
	public void testIncrement_April30() {
	    DateUtil date = new DateUtil(30, 4, 2024);
        System.out.println("testIncrement_April30 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}
	
	
	@Test
	public void testIncrement_Dec31_ToNewYear() {
	    DateUtil date = new DateUtil(31, 12, 2023);
        System.out.println("testIncrement_Dec31_ToNewYear > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}


	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
	    DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
	    DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}

}
