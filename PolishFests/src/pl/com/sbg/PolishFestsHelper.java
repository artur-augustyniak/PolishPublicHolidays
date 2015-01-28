package pl.com.sbg;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author aaugustyniak
 */
public class PolishFestsHelper {

    private final Map<Integer, String> festDays;

    public PolishFestsHelper() {
        festDays = new HashMap<>();
        festDays.put(1, "Nowy Rok");
        festDays.put(6, "Trzech Króli");
    }

    public boolean isWorkingDay(String day) {
        return !isFest(day);
    }

    public boolean isWorkingDay(Date day) {
        return !isFest(day);
    }

    public boolean isFest(Date day) {

        DateTime dt = new DateTime(day);
        initMovableFestsFor(dt.getYear());
        int dayOfYear = dt.getDayOfYear();
        
        if (festDays.containsKey(dayOfYear)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFest(String day) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime dt = formatter.parseDateTime(day);
        return isFest(dt.toDate());
    }

    public boolean isLeap(int year) {
        
        
        
        boolean isMod4 = (year % 4) != 0;
        boolean isMod100 = (year % 100) != 0;
        boolean isMod400 = (year % 400) != 0;
        return !(isMod4) && ((isMod100) || !(isMod400));
    }

    private void initMovableFestsFor(int year) {

        int leapYearStep = (isLeap(year)) ? 1 : 0;
        int easterFirstDay = findFirstEasterDayIn(year);
        festDays.put(easterFirstDay, "Niedziela Wielkanocna");
        festDays.put(1 + easterFirstDay, "Poniedziałek Wielkanocny");
        festDays.put(121 + leapYearStep, "święto Pracy");
        festDays.put(123 + leapYearStep, "Trzeciego Maja");
        festDays.put(49 + easterFirstDay, "Zesłanie Ducha Świętego");
        festDays.put(60 + easterFirstDay, "Boże Ciało");
        festDays.put(305 + leapYearStep, "Wszystkich Świętych");
        festDays.put(315 + leapYearStep, "Święto niepodległości");
        festDays.put(359 + leapYearStep, "Boże Narodzenie I");
        festDays.put(360 + leapYearStep, "Boże Narodzenie II");

    }

    private int findFirstEasterDayIn(int year) {
        int leapYearStep = (isLeap(year)) ? 1 : 0;
        int w1 = year % 19;
        int w2 = year / 100;
        int w3 = year % 100;
        int w4 = w2 / 4;
        int w5 = w2 % 4;
        int w6 = (w2 + 8) / 25;
        int w7 = (w2 - w6 + 1) / 3;
        int w8 = (19 * w1 + w2 - w4 - w7 + 15) % 30;
        int w9 = w3 / 4;
        int w10 = w3 % 4;
        int w11 = (32 + 2 * w5 + 2 * w9 - w8 - w10) % 7;
        int w12 = (w1 + 11 * w8 + 22 * w11) / 451;
        int w13 = (w8 + w11 - 7 * w12 + 114);
        int dayNymber = -33 + w13 + leapYearStep;
        return dayNymber;
    }

}
