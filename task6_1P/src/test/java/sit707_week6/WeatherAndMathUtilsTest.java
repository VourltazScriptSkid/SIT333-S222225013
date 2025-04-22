package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
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
	public void testFalseNumIsEvenNum() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(7));

	}
	
    @Test
    public void testCancelWeatAdvice() {
    	Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }
    
    @Test
    public void testWeatAdviceCancel_Rain() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(10.0, 6.1));
    }

    @Test
    public void testWeatAdviceCancel_Both() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 4.1));
    }

    @Test
    public void testWeatAdviceWarn_Wind() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 1.0));
    }

    @Test
    public void testWeatAdviceWarn_Rain() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(10.0, 5.0));
    }

    @Test
    public void testWeatAdviceAllClear() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(10.0, 1.0));
    }

    @Test
    public void testWeatAdviceNegativeInputs() {
        try {
            WeatherAndMathUtils.weatherAdvice(-1.0, 0.0);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Passed
        }
    }

    @Test
    public void testIsEven_TrueNum() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(400));
    }

    @Test
    public void testIsEven_FalseNum() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(101));
    }

    @Test
    public void testIsEven_ZeroNum() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(0));
    }

    @Test
    public void testIsPrime_TrueNum() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(43));
    }

    @Test
    public void testIsPrime_FalseNum() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(-7));
    }

    @Test
    public void testIsPrime_ZeroNum() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(0));
    }

    @Test
    public void testIsPrime_NegativeNum() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(-97));
    }

    
}
