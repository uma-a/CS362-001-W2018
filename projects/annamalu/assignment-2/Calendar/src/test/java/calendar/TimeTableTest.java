package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	@Test
	public void test01() throws Throwable { //testing getApptRange
		TimeTable t = new TimeTable();
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calday = new CalDay(cal);

		LinkedList<CalDay> calDays = new LinkedList<>();

		GregorianCalendar firstday = new GregorianCalendar(2018, 03, 03); //date is before last day
		GregorianCalendar lastday = new GregorianCalendar(2018, 05, 03);

		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		int[] recurDaysArr = {2, 3, 4};
		appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

		startHour = 0;
		startMinute = 30;
		startDay = 15;
		startMonth = 01;
		startYear = 2018;
		title = "Brunch";
		description = "Brunch time";

		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt); //adding appts to linked list
		appts.add(appt1);

		//System.out.print(appts);
		//System.out.print(appts.size());

		t.getApptRange(appts, firstday, lastday);
		//assertEquals(2, calDays.size());
	}

	@Test
	public void test02() throws Throwable { //testing deleteAppt
		TimeTable t = new TimeTable();
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calday = new CalDay(cal);

		int startHour = 20;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		startHour = 22;
		startMinute = 31;
		startDay = 16;
		startMonth = 02;
		startYear = 2017;
		title = "Testing event";
		description = "This is my testing event.";

		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		startHour = 23;
		startMinute = 31;
		startDay = 16;
		startMonth = 01;
		startYear = 2019;
		title = "Testing event2";
		description = "This is my testing event2.";

		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		LinkedList<CalDay> calDays = new LinkedList<>();
		LinkedList<Appt> appts = calday.getAppts();

		t.deleteAppt(appts, appt);

		assertEquals(null, t.deleteAppt(appts, appt));

	}

	@Test
	public void test03() throws Throwable { //testing deleteAppt
		TimeTable t = new TimeTable();
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calday = new CalDay(cal);
		int startHour = 20;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		title = "Testing event";
		description = "This is my testing event.";

		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		title = "Testing event2";
		description = "This is another testing event.";

		Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		startMinute= 100; //invalid for branch testing
		Appt appt5= new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		LinkedList<Appt> appts = new LinkedList<>();
		appts.add(appt1);
		appts.add(appt2);
		appts.add(appt3);

		t.deleteAppt(appts, appt2);
		assertEquals(2, appts.size()); //size should be one less since we deleted an appt

		appts.add(appt5);

		t.deleteAppt(appts, appt5);
		assertEquals(3, appts.size());
	}

	@Test (expected = DateOutOfRangeException.class) //added this so I can test the exception
	public void test04() throws Throwable { //testing getApptRange with a first day after the last day
		TimeTable t = new TimeTable();
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calday = new CalDay(cal);

		LinkedList<CalDay> calDays = new LinkedList<>();
		LinkedList<Appt> appts = new LinkedList<>();

		GregorianCalendar firstday = new GregorianCalendar(2018, 07, 03);
		GregorianCalendar lastday = new GregorianCalendar(2018, 05, 03);

		t.getApptRange(appts, firstday, lastday);

		assertEquals(0, calDays.size()); //size should be 0 since exception was thrown
	}

	@Test
	public void test05() throws Throwable { //testing deleteAppts with a null linked list and null appt
		TimeTable t = new TimeTable();
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calday = new CalDay(cal);
		LinkedList<Appt> appts = null;
		LinkedList<Appt> appts1 = new LinkedList<>();

		int startHour = 23;
		int startMinute = 31;
		int startDay = 16;
		int startMonth = 01;
		int startYear = 2019;
		String title = "Testing event";
		String description = "This is my testing event.";

		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		startHour=50;
		Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		Appt appt4 = null;

		assertEquals(null, t.deleteAppt(appts, appt2)); //should be null since linked list is null
		assertEquals(null, t.deleteAppt(appts, appt3)); //invalid appt
		assertEquals(null, t.deleteAppt(appts1, appt4)); //null appt- getting branch coverage
	}

	@Test (expected = IllegalArgumentException.class) //this test should throw an IllegalArgumentException
	public void test06() throws Throwable { //testing the permute method with array and linked list of different sizes
		TimeTable t = new TimeTable();
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calday = new CalDay(cal);
		LinkedList<Appt> appts = new LinkedList<>();
		int startHour = 23;
		int startMinute = 31;
		int startDay = 16;
		int startMonth = 01;
		int startYear = 2019;
		String title = "Testing event";
		String description = "This is my testing event.";

		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		startDay= 12;
		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		appts.add(appt1);
		appts.add(appt2);

		int pv1[]= new int[3]; //should throw illegal argument exception because linked list and array are different sizes
		pv1[0]= 2;
		pv1[1]= 3;

		t.permute(appts, pv1);
	}

	@Test
	public void test07() throws Throwable { //testing the permute method with array and linked list of same size
	TimeTable t = new TimeTable();
	GregorianCalendar cal = new GregorianCalendar();
	CalDay calday = new CalDay(cal);
	LinkedList<Appt> appts = new LinkedList<>();
	int startHour = 23;
	int startMinute = 31;
	int startDay = 16;
	int startMonth = 01;
	int startYear = 2019;
	String title = "Testing event";
	String description = "This is my testing event.";

	Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

	startDay= 12;
	Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

	appts.add(appt1);
	appts.add(appt2);

	int pv2[]= new int[2];
	pv2[0]=0;
	pv2[1]=1;

	t.permute(appts, pv2);
}

}