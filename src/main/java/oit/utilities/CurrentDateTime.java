package oit.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CurrentDateTime {

    public String currentTime;

    public Date dateAndTime() {

        SimpleDateFormat formatter = new SimpleDateFormat(
                "MM/dd/yyyy h:mm:ss a");
        Date date = new Date(System.currentTimeMillis() - 2 * (60 * 60) * 1000);
        currentTime = formatter.format(date);
        return date;
    }

    public void calcDiffDate(Date d1, Date d2) {

        long diff = Math.abs(d1.getTime() - d2.getTime());
        long diffMinutes = diff / (60 * 1000) % 60;
        if (diffMinutes < 5) {
            System.out.println(diffMinutes);
        }
    }

    public Date convertStringToDate(String string) throws ParseException {
        Date dateFormat;
        dateFormat = new SimpleDateFormat("M/d/yyyy h:mm:ss a").parse(string);
        return dateFormat;
    }

    //Format [2017-01-23]
    public String currentDate() {
        String strDate;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        strDate = formatter.format(date);
        return strDate;
    }

    public String currentMonth() {
        LocalDate currentDate = LocalDate.now();
        String month;
        month = currentDate.getMonth().toString();
        return month;
    }

    public int currentMonthInNumber() {
        LocalDate currentDate = LocalDate.now();
        int month;
        month = currentDate.getMonthValue();
        return month;
    }
}
