package calendar;

import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	/**
	 * Generate Random Tests that tests TimeTable Class.
	 */
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

	@Test
	public void del_appt() throws Throwable {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");
		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int apptNum = ValuesGenerator.getRandomIntBetween(random, 1, 10); //rand num of appts for linked list
				LinkedList<Appt> appts = new LinkedList<Appt>(); //declaring new linked list for appts

				for (int i = 0; i < apptNum; i++) { //adding a random amount of appts to linked list
					int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
					int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 60);
					int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
					int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int startYear = ValuesGenerator.getRandomIntBetween(random, 1990, 2020);
					String title = "Birthday Party";
					String description = "This is my birthday party.";

					Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

					appts.add(appt); //adding all appts to a linked list
				}

				TimeTable t = new TimeTable();
				int deleteNum = ValuesGenerator.getRandomIntBetween(random, 1, apptNum - 1); //number of appts to delete
				int count =0;
				// for(int i=0; i<deleteNum-2; i++) {
				int locNum = ValuesGenerator.getRandomIntBetween(random, 0, apptNum - 1); //index to delete from
				t.deleteAppt(appts, appts.get(locNum)); //deleting from random index

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			}
		} catch (NullPointerException e) {

		}

		System.out.println("Done testing... 1st del appt");

	}

	@Test
	public void del_appt_null() throws Throwable {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				int isNull= ValuesGenerator.getRandomIntBetween(random, 0, 10); //used to decide if we're using null or normal linked list
				TimeTable t= new TimeTable();
				if(isNull<5){ //we use a normal linked list with a null appt
					LinkedList<Appt> appts = new LinkedList<Appt>(); //declaring new linked list for appts
					Appt appt= null;
					t.deleteAppt(appts, appt);
				}
				else{
					LinkedList<Appt> appts = null; //declaring new linked list for appts
					int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
					int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 60);
					int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
					int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int startYear = ValuesGenerator.getRandomIntBetween(random, 1990, 2020);
					String title = "Birthday Party";
					String description = "This is my birthday party.";

					Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
					t.deleteAppt(appts, appt1);

				}
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			}
		} catch (NullPointerException e) {

		}

		System.out.println("Done testing... del appt null");
	}

	@Test
	public void testApptRange()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		GregorianCalendar cal= new GregorianCalendar();
		CalDay day= new CalDay(cal);
		TimeTable t= new TimeTable();
		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int randDay= ValuesGenerator.RandInt(random);
				int randMonth= ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int randYear= ValuesGenerator.RandInt(random);

				int randDay1= ValuesGenerator.RandInt(random);
				int randMonth1= ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int randYear1= ValuesGenerator.getRandomIntBetween(random, 10, 10000);

				GregorianCalendar firstday = new GregorianCalendar(randYear, randMonth, randDay); //date is before last day
				GregorianCalendar lastday = new GregorianCalendar(randYear1, randMonth1, randDay1);


				LinkedList<Appt> appts = new LinkedList<Appt>(); //declaring new linked list for appts
				t.getApptRange(appts, firstday, lastday);


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
			}
		} catch (NullPointerException e) {

		}

		System.out.println("Done testing... appt 0");
	}

	@Test (expected = DateOutOfRangeException.class)
	public void testApptRange1()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		GregorianCalendar cal= new GregorianCalendar();
		CalDay day= new CalDay(cal);
		TimeTable t= new TimeTable();
		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int randDay= ValuesGenerator.RandInt(random);
				int randMonth= ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int randYear= ValuesGenerator.RandInt(random);

				int randDay1= ValuesGenerator.RandInt(random);
				int randMonth1= ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int randYear1= ValuesGenerator.getRandomIntBetween(random, 11, 10000); //range for the later year

				GregorianCalendar firstday = new GregorianCalendar(randYear1, randMonth, randDay); //date is before last day so exception should be thrown
				GregorianCalendar lastday = new GregorianCalendar(randYear, randMonth1, randDay1);


				LinkedList<Appt> appts = new LinkedList<Appt>(); //declaring new linked list for appts
				t.getApptRange(appts, firstday, lastday);


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			}
		} catch (NullPointerException e) {

		}
		System.out.println("Done testing... appt range 1");

	}
@Test
	public void testApptRange2()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		GregorianCalendar cal= new GregorianCalendar();
		CalDay day= new CalDay(cal);
		TimeTable t= new TimeTable();
		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int randDay= ValuesGenerator.RandInt(random);
				int randMonth= ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int randYear= ValuesGenerator.RandInt(random);

				int randDay1= ValuesGenerator.RandInt(random);
				int randMonth1= ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int randYear1= ValuesGenerator.getRandomIntBetween(random, 11, 10000);

				GregorianCalendar firstday = new GregorianCalendar(randYear, randMonth, randDay); //date is before last day
				GregorianCalendar lastday = new GregorianCalendar(randYear1, randMonth1, randDay1);
				int apptNum = ValuesGenerator.getRandomIntBetween(random, 1, 10); //rand num of appts for linked list

				LinkedList<Appt> appts = new LinkedList<Appt>(); //declaring new linked list for appts
					for (int i = 0; i < apptNum; i++) { //adding a random amount of appts to linked list
						int startHour = ValuesGenerator.getRandomIntBetween(random, -50, -1);
						int startMinute = ValuesGenerator.getRandomIntBetween(random, -50, -1);
						int startDay = ValuesGenerator.getRandomIntBetween(random, -50, 0);
						int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
						int startYear = ValuesGenerator.RandInt(random);
						String title = "Birthday Party";
						String description = "This is my birthday party.";
						Appt bad_appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
						appts.add(bad_appt); //adding invalid appts to linked list
				}

				t.getApptRange(appts, firstday, lastday);


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			}
		} catch (NullPointerException e) {

		}
	System.out.println("Done testing... appt range 2");
	}
@Test
	public void testApptRange3()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		GregorianCalendar cal= new GregorianCalendar();
		CalDay day= new CalDay(cal);
		TimeTable t= new TimeTable();
		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int randDay= ValuesGenerator.RandInt(random);
				int randMonth= ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int randYear= ValuesGenerator.RandInt(random);

				int randDay1= ValuesGenerator.RandInt(random);
				int randMonth1= ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int randYear1= ValuesGenerator.getRandomIntBetween(random, 11, 10000);

				GregorianCalendar firstday = new GregorianCalendar(randYear, randMonth, randDay); //date is before last day
				GregorianCalendar lastday = new GregorianCalendar(randYear1, randMonth1, randDay1);
				int apptNum = ValuesGenerator.getRandomIntBetween(random, 1, 10); //rand num of appts for linked list

				LinkedList<Appt> appts = new LinkedList<Appt>(); //declaring new linked list for appts
				for (int i = 0; i < apptNum; i++) { //adding a random amount of appts to linked list
					int startHour = ValuesGenerator.RandInt(random);
					int startMinute = ValuesGenerator.RandInt(random);
					int startDay = ValuesGenerator.RandInt(random);
					int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int startYear = ValuesGenerator.RandInt(random);
					String title = "Birthday Party";
					String description = "This is my birthday party.";
					Appt bad_appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
					appts.add(bad_appt); //adding normal appts to linked list
				}

				t.getApptRange(appts, firstday, lastday);


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
			}
		} catch (NullPointerException e) {

		}
	System.out.println("Done testing... appt range 3");
	}
}