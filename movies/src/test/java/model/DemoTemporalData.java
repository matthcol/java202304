package model;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DemoTemporalData {

    @Test
    void testDate() {
        // Year, Month, Day, Hour, Minute, Second, ms + TZ
        Date today = new Date();
        System.out.println(today); // Thu Apr 06 14:52:22 CEST 2023
    }

    @Test
    void testCalendar() {
        // since Java 1.1
        Calendar date = Calendar.getInstance();
        System.out.println(date);
        // java.util.GregorianCalendar[
        //      time=1680785801873,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
        //      zone=sun.util.calendar.ZoneInfo[id="Europe/Paris",offset=3600000,dstSavings=3600000,useDaylight=true,transitions=184,lastRule=java.util.SimpleTimeZone[id=Europe/Paris,offset=3600000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=2,startMonth=2,startDay=-1,startDayOfWeek=1,startTime=3600000,startTimeMode=2,endMode=2,endMonth=9,endDay=-1,endDayOfWeek=1,endTime=3600000,endTimeMode=2]],
        //      firstDayOfWeek=2,
        //      minimalDaysInFirstWeek=4,
        //      ERA=1,
        //      YEAR=2023,
        //      MONTH=3, !!!!!!
        //      WEEK_OF_YEAR=14,
        //      WEEK_OF_MONTH=1,
        //      DAY_OF_MONTH=6,
        //      DAY_OF_YEAR=96,
        //      DAY_OF_WEEK=5,
        //      DAY_OF_WEEK_IN_MONTH=1,
        //      AM_PM=1,
        //      HOUR=2,
        //      HOUR_OF_DAY=14,
        //      MINUTE=56,
        //      SECOND=41,
        //      MILLISECOND=873,
        //      ZONE_OFFSET=3600000,DST_OFFSET=3600000]
    }

    @Test
    void demoLocalDate() {
        var today = LocalDate.now();
        var formatFrSimple = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var formatFrExtended = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy");
        var formatUkExtended = DateTimeFormatter.ofPattern("EEEE MMMM dd yyyy",
                Locale.UK);
        System.out.println(today);  // 2023-04-06
        System.out.println(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(today.format(formatFrSimple));
        System.out.println(today.format(formatFrExtended));
        System.out.println(today.format(formatUkExtended));

        String dateIsoStr = "2000-02-29";
        LocalDate date2 = LocalDate.parse(dateIsoStr); // format ISO
        System.out.println(date2);

        String dateFrStr = "29/02/2000";
        LocalDate date3 = LocalDate.parse(dateFrStr, formatFrSimple);
        System.out.println(date3);

        LocalDate date4 = LocalDate.of(2020, 2, 29);
        System.out.println(date4);
    }

    @Test
    void demoLocalDateTime() {
        var now = LocalDateTime.now();
        System.out.println(now); // 2023-04-06T15:50:08.944944600
        var dt = LocalDateTime.of(2023, 4, 7, 17, 0);
        var dt2 = LocalDateTime.of(2023, 4, 7, 17, 20, 30);
        var dt3 = LocalDateTime.of(2023, 4, 7, 17, 20, 30, 500_000_000);
        System.out.println(dt);
        System.out.println(dt2);
        System.out.println(dt3);
        String timestampStr = "2023-04-07T09:00:00";
        var dt4 = LocalDateTime.parse(timestampStr);
        System.out.println(dt4);
    }

    @Test
    void demoZonedDateTime(){
        ZonedDateTime dtHere = ZonedDateTime.now();
        System.out.println(dtHere); // 2023-04-06T16:00:14.244630200+02:00[Europe/Paris]

//        ZoneId tzSidney = ZoneId.of("UTC+10");
        ZoneId tzSidney = ZoneId.of("Australia/Sydney");
        ZonedDateTime dtSidney = ZonedDateTime.now(tzSidney);
        System.out.println(dtSidney);
    }







}
