package com.luckycatlabs.sunrisesunset;

import com.luckycatlabs.sunrisesunset.calculator.SolarEventCalculator;
import com.luckycatlabs.sunrisesunset.dto.Location;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class SunriseSunsetCalculator {

    /* renamed from: a  reason: collision with root package name */
    private Location f36122a;

    /* renamed from: b  reason: collision with root package name */
    private SolarEventCalculator f36123b;

    public SunriseSunsetCalculator(Location location, String str) {
        this.f36122a = location;
        this.f36123b = new SolarEventCalculator(location, str);
    }

    public static Calendar getSunrise(double d4, double d5, TimeZone timeZone, Calendar calendar, double d6) {
        return new SolarEventCalculator(new Location(d4, d5), timeZone).computeSunriseCalendar(new Zenith(90.0d - d6), calendar);
    }

    public static Calendar getSunset(double d4, double d5, TimeZone timeZone, Calendar calendar, double d6) {
        return new SolarEventCalculator(new Location(d4, d5), timeZone).computeSunsetCalendar(new Zenith(90.0d - d6), calendar);
    }

    public Calendar getAstronomicalSunriseCalendarForDate(Calendar calendar) {
        return this.f36123b.computeSunriseCalendar(Zenith.ASTRONOMICAL, calendar);
    }

    public String getAstronomicalSunriseForDate(Calendar calendar) {
        return this.f36123b.computeSunriseTime(Zenith.ASTRONOMICAL, calendar);
    }

    public Calendar getAstronomicalSunsetCalendarForDate(Calendar calendar) {
        return this.f36123b.computeSunsetCalendar(Zenith.ASTRONOMICAL, calendar);
    }

    public String getAstronomicalSunsetForDate(Calendar calendar) {
        return this.f36123b.computeSunsetTime(Zenith.ASTRONOMICAL, calendar);
    }

    public Calendar getCivilSunriseCalendarForDate(Calendar calendar) {
        return this.f36123b.computeSunriseCalendar(Zenith.CIVIL, calendar);
    }

    public String getCivilSunriseForDate(Calendar calendar) {
        return this.f36123b.computeSunriseTime(Zenith.CIVIL, calendar);
    }

    public Calendar getCivilSunsetCalendarForDate(Calendar calendar) {
        return this.f36123b.computeSunsetCalendar(Zenith.CIVIL, calendar);
    }

    public String getCivilSunsetForDate(Calendar calendar) {
        return this.f36123b.computeSunsetTime(Zenith.CIVIL, calendar);
    }

    public Location getLocation() {
        return this.f36122a;
    }

    public Calendar getNauticalSunriseCalendarForDate(Calendar calendar) {
        return this.f36123b.computeSunriseCalendar(Zenith.NAUTICAL, calendar);
    }

    public String getNauticalSunriseForDate(Calendar calendar) {
        return this.f36123b.computeSunriseTime(Zenith.NAUTICAL, calendar);
    }

    public Calendar getNauticalSunsetCalendarForDate(Calendar calendar) {
        return this.f36123b.computeSunsetCalendar(Zenith.NAUTICAL, calendar);
    }

    public String getNauticalSunsetForDate(Calendar calendar) {
        return this.f36123b.computeSunsetTime(Zenith.NAUTICAL, calendar);
    }

    public Calendar getOfficialSunriseCalendarForDate(Calendar calendar) {
        return this.f36123b.computeSunriseCalendar(Zenith.OFFICIAL, calendar);
    }

    public String getOfficialSunriseForDate(Calendar calendar) {
        return this.f36123b.computeSunriseTime(Zenith.OFFICIAL, calendar);
    }

    public Calendar getOfficialSunsetCalendarForDate(Calendar calendar) {
        return this.f36123b.computeSunsetCalendar(Zenith.OFFICIAL, calendar);
    }

    public String getOfficialSunsetForDate(Calendar calendar) {
        return this.f36123b.computeSunsetTime(Zenith.OFFICIAL, calendar);
    }

    public SunriseSunsetCalculator(Location location, TimeZone timeZone) {
        this.f36122a = location;
        this.f36123b = new SolarEventCalculator(location, timeZone);
    }
}
