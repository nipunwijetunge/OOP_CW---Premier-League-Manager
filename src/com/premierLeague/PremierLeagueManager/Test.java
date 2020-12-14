package com.premierLeague.PremierLeagueManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Test{
    public static void main(String[] args) throws ParseException {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate today = LocalDate.now();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = Date.from(today.atStartOfDay(defaultZoneId).toInstant());
        String date2 = dateFormat.format(date1);

        System.out.println(date2);
    }


}
