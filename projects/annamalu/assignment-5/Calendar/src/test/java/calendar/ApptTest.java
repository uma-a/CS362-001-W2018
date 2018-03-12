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
	public void test01() throws Throwable { //testing most of the getters and compareTo method with a valid appt
		int startHour = 1;
		int startMinute = 30;
		int startDay = 1;
		int startMonth = 1;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		assertEquals("	1/1/2018 at 1:30am ,Birthday Party, This is my birthday party.\n", appt.toString());
		assertTrue(appt.getValid());
		assertEquals(1, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(1, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());

		startHour = 17;
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		assertEquals("	1/1/2018 at 5:30pm ,Birthday Party, This is my birthday party.\n", appt1.toString());

		startHour = 11;
		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		assertEquals("	1/1/2018 at 11:30am ,Birthday Party, This is my birthday party.\n", appt2.toString());

		appt2.setStartMonth(1);
		assertTrue(appt.getValid());

		assertEquals(0, appt.compareTo(appt));
		assertEquals(16, appt1.compareTo(appt));
	}

	@Test
	public void test02() throws Throwable { //creating two invalid appts with values too high and too low
		int startHour = 28;
		int startMinute = 100;
		int startDay = 50;
		int startMonth = 12;
		int startYear = 2018;
		String title = null;
		String description = null;

		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description); //appt is invalid

		startHour = 17;
		Appt appt4 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description); //appt4 is valid
		assertEquals(null, appt4.toString());

		startHour = -2;
		startMinute = -9;
		startDay = -3;

		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description); //appt1 is invalid

		startHour = 4;
		startMinute = 45;
		startDay = 13;

		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description); //appt2 is valid

		int[] recurDaysArr1 = {2, 5};
		appt2.setRecurrence(recurDaysArr1, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);

		assertEquals(2, appt2.getRecurIncrement());
		assertTrue(appt2.isRecurring());
		assertEquals(Appt.RECUR_BY_MONTHLY, appt2.getRecurBy());
		assertEquals(Appt.RECUR_NUMBER_FOREVER, appt2.getRecurNumber());

		startHour = 7;
		Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		int recurDaysArr[] = new int[0];
		appt3.setRecurrence(recurDaysArr, 0, 0, Appt.RECUR_NUMBER_NEVER);

		assertEquals(0, appt3.getRecurIncrement());
		assertFalse(appt3.isRecurring());
		assertEquals(0, appt3.getRecurBy());
		assertEquals(Appt.RECUR_NUMBER_NEVER, appt3.getRecurNumber());

		assertFalse(appt.getValid());
		assertFalse(appt1.getValid());
	}

	@Test
	public void test03() throws Throwable { //testing all the setters with a valid appointment
		int startHour = 05;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		appt.setStartHour(25);
		assertFalse(appt.getValid());

		appt.setStartMinute(33);
		//assertTrue(appt.getValid());

		appt.setStartDay(23);
		//assertTrue(appt.getValid());

		appt.setStartYear(2018);
		//assertTrue(appt.getValid());

		appt.setDescription("Party");
		//assertTrue(appt.getValid());
		appt.setTitle("Birthday Party");

		appt.setStartHour(3);

		appt.setStartMinute(65);
		assertFalse(appt.getValid());

		appt.setStartMinute(36);

		appt.setStartDay(54);
		assertFalse(appt.getValid());

		appt.setStartDay(22);

		appt.setStartYear(-2018);
//		assertFalse(appt.getValid());

		appt.setStartYear(2018);


		/*assertEquals(3, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(4, appt.getStartDay());
		assertEquals(3, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Party", appt.getTitle());
		assertEquals("Party time", appt.getDescription());
		assertTrue(appt.getValid());*/
	}

	@Test
	public void test04() throws Throwable { //testing all the setters with a valid appointment
		int startHour = 0;
		int startMinute = 0;
		int startDay = 1;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		assertEquals(0, appt.getStartHour());
		assertEquals(0, appt.getStartMinute());
		assertEquals(1, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertTrue(appt.getValid());

		startHour = 23;
		startMinute = 59;
		startDay = 31;
		//startMonth=0;
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		assertEquals(23, appt1.getStartHour());
		assertEquals(59, appt1.getStartMinute());
		assertEquals(31, appt1.getStartDay());
		//assertEquals(0, appt1.getStartMonth());
		assertEquals(2018, appt1.getStartYear());
		assertTrue(appt1.getValid());

		startHour = 23;
		startMonth = 11;
		startDay = 31;

		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		assertEquals(23, appt2.getStartHour());
		assertEquals(59, appt2.getStartMinute());
		assertEquals(31, appt2.getStartDay());
		assertEquals(11, appt2.getStartMonth());
		assertEquals(2018, appt2.getStartYear());
		//assertTrue(appt2.getValid());

		startMonth = 12;
		Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		assertEquals(31, appt3.getStartDay());
		assertEquals(12, appt3.getStartMonth());
		assertTrue(appt3.getValid());

	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test05() throws Throwable { //testing all the setters with a valid appointment
		int startHour = 1;
		int startMinute = 13;
		int startDay = 1;
		int startMonth = 12;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		appt.setStartMonth(12);
		assertEquals(12, appt.getStartMonth());
		assertTrue(appt.getValid());

		appt.setStartMonth(1);
		assertEquals(1, appt.getStartMonth());
		assertTrue(appt.getValid());

		appt.setStartMonth(13);
		assertFalse(appt.getValid());
	}

	@Test
	public void test06() throws Throwable { //testing most of the getters and compareTo method with a valid appt
		int startHour = 16;
		int startMinute = 30;
		int startDay = 1;
		int startMonth = 1;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		startHour = 17;
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		assertEquals(0, appt.compareTo(appt));
		assertEquals(1, appt1.compareTo(appt));
	}
}