package calendar;

import java.util.*;

import org.junit.Test;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

	 @Test
	  public void testaddAppt()  throws Throwable {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 GregorianCalendar cal = new GregorianCalendar();
		 CalDay day = new CalDay(cal);

		 System.out.println("Start testing...");

		 try {
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed = System.currentTimeMillis(); //10
				 //			System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);

				 int apptNum = ValuesGenerator.getRandomIntBetween(random, 1, 10); //rand num of appts for linked list
				 LinkedList<Appt> appts = new LinkedList<Appt>(); //declaring new linked list for appts
				 int validity = ValuesGenerator.getRandomIntBetween(random, 1, 10);
				 int test_val = ValuesGenerator.getRandomIntBetween(random, 1, 10);
				 if (validity < 5) { //add invalid appts
					 for (int i = 0; i < apptNum; i++) { //adding a random amount of appts to linked list
						 int startHour = ValuesGenerator.getRandomIntBetween(random, -50, -1);
						 int startMinute = ValuesGenerator.getRandomIntBetween(random, -50, -1);
						 int startDay = ValuesGenerator.getRandomIntBetween(random, -50, 0);
						 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
						 int startYear = ValuesGenerator.RandInt(random);
						 String title = "Birthday Party";
						 String description = "This is my birthday party.";
						 Appt bad_appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

						 day.addAppt(bad_appt);
					 }
				 } else {
					 for (int i = 0; i < apptNum; i++) { //adding a random amount of appts to linked list
						 int startHour = ValuesGenerator.RandInt(random);
						 int startMinute = ValuesGenerator.RandInt(random);
						 int startDay = ValuesGenerator.RandInt(random);
						 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
						 int startYear = ValuesGenerator.RandInt(random);
						 String title = "Birthday Party";
						 String description = "This is my birthday party.";
						 Appt good_appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

						 day.addAppt(good_appt);
					 }
				 }

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if ((iteration % 10000) == 0 && iteration != 0)
					 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			 }
		 } catch (NullPointerException e) {

		 }

	 }

}
