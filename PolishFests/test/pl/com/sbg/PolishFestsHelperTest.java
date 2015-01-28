package pl.com.sbg;

import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author aaugustyniak
 */
public class PolishFestsHelperTest {

//    @Test(expected = IllegalArgumentException.class)
//    public void testFestsWithUnparsableString() {
//        PolishFestsHelper pfh = new PolishFestsHelper();
//        String rubbish = "ohamburgerfonsz";
//        pfh.isFest(rubbish);
//    }
//
//    @Test
//    public void testFestsWithString() {
//        String param = provenFests[0];
//        PolishFestsHelper pfh = new PolishFestsHelper();
//        assertTrue(pfh.isFest(param));
//    }
//
//    @Test
//    public void testFestsWithObject() {
//        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
//        DateTime dt = formatter.parseDateTime(provenFests[0]);
//        Date param = dt.toDate();
//        PolishFestsHelper pfh = new PolishFestsHelper();
//        assertTrue(pfh.isFest(param));
//    }
    @Test
    public void testLeapYearIndicator() {
        PolishFestsHelper pfh = new PolishFestsHelper();
        for (int year : leapYears) {
            assertTrue(pfh.isLeap(year));
        }
    }

    @Test
    public void testNonLeapYearIndicator() {
        PolishFestsHelper pfh = new PolishFestsHelper();
        for (int year : nonLeapYears) {
            assertFalse(pfh.isLeap(year));
        }
    }

//    @Test
//    public void testProvenFests() {
//        PolishFestsHelper pfh = new PolishFestsHelper();
//        for (String day : provenFests) {
//            assertTrue(pfh.isFest(day));
//        }
//    }
//
//    @Test
//    public void testProvenWorkingDays() {
//        PolishFestsHelper pfh = new PolishFestsHelper();
//        for (String day : provenWorkingDays) {
//            assertTrue(pfh.isWorkingDay(day));
//        }
//    }
    private int[] leapYears = {
        2008,
        2012
    };
    private int[] nonLeapYears = {
        2009,
        2010
    };

    private String[] provenWorkingDays = {
        "2011-06-13",
        "2011-06-14",
        "2011-06-15",
        "2011-06-16",
        "2011-06-17",
        "2011-06-18"
    };
    private String[] provenFests = {
        "2011-01-01",
        "2011-01-06",
        "2011-04-24",
        "2011-04-25",
        "2011-05-01",
        "2011-05-03",
        "2011-06-12",
        "2011-06-23",
        "2011-11-01",
        "2011-11-11",
        "2011-12-25",
        "2011-12-26",
        "2013-01-01",
        "2013-01-06",
        "2013-03-31",
        "2013-04-01",
        "2013-05-01",
        "2013-05-03",
        "2013-05-19",
        "2013-05-30",
        "2013-11-01",
        "2013-11-11",
        "2013-12-25",
        "2013-12-26"};

}
