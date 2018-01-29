package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;
//import sun.util.calendar.Gregorian;

import static org.junit.Assert.*;

public class CalDayTest {

	@Test
	public void test01() throws Throwable { //testing the both constructors
		CalDay badday = new CalDay();
		GregorianCalendar cal= new GregorianCalendar(2017,05,2); //object to pass into constructor
		CalDay calday = new CalDay(cal);
		assertFalse(badday.isValid()); //since valid is auto set to false
		assertTrue(calday.isValid()); //since valid is auto set to true
	}

	@Test
	public void test02() throws Throwable { //testing the addAppt method
		GregorianCalendar cal= new GregorianCalendar();
		CalDay calday = new CalDay(cal);
		CalDay badday= new CalDay(); //valid=false

		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description); //creating a valid appt

		startHour = 22;
		startMinute = 31;
		startDay = 16;
		startMonth = 02;
		startYear = 2017;
		title = "Testing event";
		description = "This is my testing event.";

		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description); //another valid appt

		startHour = 04;
		startMinute = 31;
		startDay = 16;
		startMonth = 02;
		startYear = 2017;
		title = "Testing event2";
		description = "This is my other testing event.";

		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description); //another valid appt

		LinkedList<Appt> appts;

		//adding all three valid appts
		calday.addAppt(appt);
		calday.addAppt(appt1);
		calday.addAppt(appt2);

		assertEquals(4, calday.getAppts().get(0).getStartHour()); //based on the ordering in the linked list the first appt should start in hour 4
		assertEquals(30, calday.getAppts().get(1).getStartMinute());
		assertEquals(2018, calday.getAppts().get(1).getStartYear());
		assertEquals(3, calday.getSizeAppts()); //3 appts were added in total
	}

	@Test
	public void test03() throws Throwable { //testing the iterators and toString method
		CalDay badday= new CalDay();
		GregorianCalendar cal= new GregorianCalendar();
		CalDay calday= new CalDay(cal);
		StringBuilder sb = new StringBuilder();
		LinkedList<Appt> appts= new LinkedList<>();

		int startHour = 04;
		int startMinute = 31;
		int startDay = 16;
		int startMonth = 02;
		int startYear = 2017;
		String title = "Testing event";
		String description = "This is my testing event.";

		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		startHour= 06;
		Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		appts.add(appt2);
		appts.add(appt3);
		calday.addAppt(appt2);
		calday.addAppt(appt3);

		assertEquals(null,badday.iterator()); //should be null if valid was set to false
		assertNotEquals(null, calday.iterator()); //testing if valid=true for branch coverage

		calday.toString();

		assertNotEquals("", calday.toString()); //if valid=true, the correct string with the date should be built
		assertEquals("", badday.toString()); //testing if valid=false to make sure the string isn't built in this case
		assertNotEquals((" --- -------- Appointments ------------ --- \n"), calday.toString()); //shouldn't just be part of what is appended to the overall string
		assertNotEquals((" --- -------- Appointments ------------ --- \n"), badday.toString());
	}

	@Test
	public void test04() throws Throwable { //testing addAppt test with an invalid appt
		GregorianCalendar cal= new GregorianCalendar();
		CalDay calday = new CalDay(cal);

		int startHour = 28; //values are invalid
		int startMinute = 98;
		int startDay = 65;
		int startMonth = 12;
		int startYear = 2018;
		String title = "Bad Testing Event";
		String description = "This is a bad event.";

		LinkedList<Appt> appts;

		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		calday.addAppt(appt2); //for branch coverage

	}
	@Test
	public void test05() throws Throwable { //null linked list test
		LinkedList<Appt> appts= null;
		GregorianCalendar cal= new GregorianCalendar();
		CalDay calday = new CalDay(cal);

	}
}
