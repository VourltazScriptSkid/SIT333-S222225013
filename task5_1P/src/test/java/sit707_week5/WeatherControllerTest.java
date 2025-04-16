package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.*; // import annotations beforeclass & afterclass

public class WeatherControllerTest {
	
	// declare shared controller instance and temp data for tests
    private static WeatherController weathController;
    private static double[] hourlyTemps;
    private static int numHours;
    
    // runs before the tests, inits weathercontroller stores hourly temps in array, avoids the repeated slow calls in test.
    @BeforeClass
    public static void setUpBeforeClass() {
    	weathController = WeatherController.getInstance();
        numHours = weathController.getTotalHours();
        hourlyTemps = new double[numHours];
        for (int i = 0; i < numHours; i++) {
            hourlyTemps[i] = weathController.getTemperatureForHour(i + 1);
        }
    }
    
    // runs after all test finish, shutting controller clean, and clean up resources
    @AfterClass
    public static void tearDownAfterClass() {
    	weathController.close();
    }
    
   // student id
	@Test
	public void testStudentIdentity() {
		String studentId = "s222225013";
		Assert.assertNotNull("Student ID is null", studentId);
	}
	// student name
	@Test
	public void testStudentName() {
		String studentName = "Andrei";
		Assert.assertNotNull("Student name is null", studentName);
	}

	
    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Arrange - find min value in array
        double min = hourlyTemps[0];
        for (double temp : hourlyTemps) {
            if (temp < min) min = temp;
        }

        // Act - get cached min value from controller
        double cachedMin = weathController.getTemperatureMinFromCache();

        // Assert - compare calculated min with cached value
        Assert.assertEquals(min, cachedMin, 0.001);
    }
	
	@Test
	public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Arrange - manually calc max value from stored hourlytemp array
        double max = hourlyTemps[0];
        for (double temp : hourlyTemps) {
            if (temp > max) max = temp;
        }

        // Act - get cached max value from weather controller
        double cachedMax = weathController.getTemperatureMaxFromCache();

        // Assert - check calculated max matches cached
        Assert.assertEquals(max, cachedMax, 0.001);
    }

	@Test
	public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Arrange - sum all temps from stored array
        double sum = 0;
        for (double temp : hourlyTemps) {
            sum += temp;
        }
        double average = sum / numHours;

        // Act - get cached avg from controller
        double cachedAverage = weathController.getTemperatureAverageFromCache();

        // Assert - compare values
        Assert.assertEquals(average, cachedAverage, 0.001);
    }
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
