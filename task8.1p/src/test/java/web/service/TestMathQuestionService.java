package web.service;

import org.junit.Assert;
import org.junit.Test;

import web.service.MathQuestionService;

public class TestMathQuestionService {

	@Test
	public void testTrueAdd() {
		Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
	}

	@Test
	public void testAddNumber1Empty() {
		Assert.assertNull(MathQuestionService.q1Addition("", "2"));
	}	
	
	 @Test
	    public void testAdditionValid() {
	        Assert.assertEquals(5.0, MathQuestionService.q1Addition("2", "3"), 0.01);
	    }

	    @Test
	    public void testAdditionInvalidInput() {
	        Assert.assertNull(MathQuestionService.q1Addition("a", "3"));
	    }

	    @Test
	    public void testSubtractionValid() {
	        Assert.assertEquals(1.0, MathQuestionService.q2Subtraction("5", "4"), 0.01);
	    }

	    @Test
	    public void testSubtractionInvalid() {
	        Assert.assertNull(MathQuestionService.q2Subtraction("x", "2"));
	    }

	    @Test
	    public void testMultiplicationValid() {
	        Assert.assertEquals(9.0, MathQuestionService.q3Multiplication("3", "3"), 0.01);
	    }

	    @Test
	    public void testMultiplicationInvalid() {
	        Assert.assertNull(MathQuestionService.q3Multiplication("", "3"));
	    }
	
}
