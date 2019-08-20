package com.kpmg.technical.assessment.utils;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String getFutureDateBy(int plusDays) {
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, plusDays);
        Date currentDatePlusOne = c.getTime();
        return dateFormat.format(currentDatePlusOne);
    }

    public String getFormattedDate(String date ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate.getDayOfWeek() + " " + localDate.getDayOfMonth() + " " + localDate.getMonth();
    }
}
