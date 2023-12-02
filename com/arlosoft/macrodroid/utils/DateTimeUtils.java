package com.arlosoft.macrodroid.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class DateTimeUtils {
    public static String getFullDayName(int i4) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 7, 1, 0, 0, 0);
        calendar.add(5, i4);
        return String.format("%tA", calendar);
    }

    public static String[] getMonthNames() {
        String[] strArr = new String[12];
        for (int i4 = 0; i4 < 12; i4++) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
            calendar.set(2, i4);
            calendar.set(5, 1);
            strArr[i4] = simpleDateFormat.format(calendar.getTime());
        }
        return strArr;
    }

    public static String getShortDayName(int i4) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 7, 1, 0, 0, 0);
        calendar.add(5, i4);
        return String.format("%ta", calendar);
    }
}
