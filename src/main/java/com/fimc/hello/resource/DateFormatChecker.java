package com.fimc.hello.resource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatChecker {

    public String checkDateFormat(String date) throws ParseException {
        // mm-dd-yyyy
        String result = "";
        if (date.length() != 10) {
            result = "invalid";
        } else {
            String month = date.substring(0, 2);
            String day = date.substring(3, 5);
            String year = date.substring(6, 10);

            if (month.contains("-")) {
                result = "invalid";
            } else {
                if (Integer.parseInt(month) > 12) {
                    System.out.println("not a month");
                    result = "invalid";
                }
            }

            if (day.contains("-")) {
                result = "invalid";
            } else {
                if (Integer.parseInt(day) > 31) {
                    System.out.println("not a day");
                    result = "invalid";
                }
            }

            if (year.contains("-")) {
                result = "invalid";
            } else {
                if (Integer.parseInt(year) > Calendar.getInstance().get(Calendar.YEAR)) {
                    System.out.println("inputed year is greater than today year");
                    result = "invalid";
                }
            }

            if (!result.equals("invalid")) {
                date = day + "-" + month + "-" + year;
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
                Date dateFormatted = formatter.parse(date);
                result = formatter.format(dateFormatted);
            }
        }

        return result;

    }

}
