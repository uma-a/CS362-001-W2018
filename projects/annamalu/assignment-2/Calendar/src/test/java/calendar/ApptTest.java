package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  { //testing most of the getters and compareTo method with a valid appt
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party."; //this should fail because of my assignment 1 bug

		 Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());

		appt.compareTo(appt);
	 }

	 @Test
	  public void test02()  throws Throwable  { //creating two invalid appts with values too high and too low
		 int startHour=28;
		 int startMinute=100;
		 int startDay=50;
		 int startMonth=12;
		 int startYear=2018;
		 String title=null;
		 String description=null;

		 Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		 int[] recurDaysArr = null;
		 appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

		 startHour= -2;
		 startMinute= -9;
		 startDay= -3;

		 Appt appt1= new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		 startHour= 0;
		 Appt appt2= new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		 assertFalse(appt.getValid());
		 assertFalse(appt1.getValid());
		 appt.toString();
	 }

	@Test
	public void test03()  throws Throwable { //testing all the setters with a valid appointment
		int startHour=05;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";

		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		appt.setStartHour(05);
		appt.setStartMinute(30);
		appt.setStartDay(15);
		appt.setStartMonth(01);
		appt.setStartYear(2018);
	}
	
}
