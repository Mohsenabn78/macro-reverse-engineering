package com.arlosoft.macrodroid.common;

import androidx.annotation.NonNull;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Date;

/* loaded from: classes3.dex */
public class CalendarEvent implements Comparable<CalendarEvent> {

    /* renamed from: a  reason: collision with root package name */
    private String f9848a;

    /* renamed from: b  reason: collision with root package name */
    private String f9849b;

    /* renamed from: c  reason: collision with root package name */
    private String f9850c;

    /* renamed from: d  reason: collision with root package name */
    private Date f9851d;

    /* renamed from: e  reason: collision with root package name */
    private Date f9852e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9853f;

    /* renamed from: g  reason: collision with root package name */
    private int f9854g;

    /* renamed from: h  reason: collision with root package name */
    private String f9855h;

    public CalendarEvent(String str, String str2, Date date, Date date2, boolean z3, int i4, String str3, String str4) {
        g(str);
        e(str2);
        d(date);
        f(date2);
        b(z3);
        c(i4);
        setLocation(str3);
        setEventId(str4);
    }

    private boolean a(Date date, Date date2) {
        if (date != null) {
            if (date2 == null) {
                return false;
            }
            return date.equals(date2);
        } else if (date2 != null) {
            return false;
        } else {
            return true;
        }
    }

    private void b(boolean z3) {
        this.f9853f = z3;
    }

    private void c(int i4) {
        this.f9854g = i4;
    }

    private void d(Date date) {
        this.f9851d = date;
    }

    private void e(String str) {
        this.f9849b = str;
    }

    private void f(Date date) {
        this.f9852e = date;
    }

    private void g(String str) {
        this.f9848a = str;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == null || !(obj instanceof CalendarEvent)) {
            return false;
        }
        CalendarEvent calendarEvent = (CalendarEvent) obj;
        if (this.f9855h == calendarEvent.f9855h) {
            return true;
        }
        if ((this.f9848a == null && calendarEvent.getTitle() != null) || ((this.f9848a != null && calendarEvent.getTitle() == null) || ((str = this.f9848a) != null && !str.equals(calendarEvent.getTitle())))) {
            return false;
        }
        if (((this.f9849b != null || calendarEvent.getDetail() != null) && ((this.f9849b == null && calendarEvent.getDetail() != null) || ((this.f9849b != null && calendarEvent.getDetail() == null) || ((str2 = this.f9849b) != null && !str2.equals(calendarEvent.getDetail()))))) || !a(this.f9851d, calendarEvent.getBegin()) || !a(this.f9852e, calendarEvent.getEnd()) || this.f9853f != calendarEvent.isAllDay() || this.f9854g != calendarEvent.f9854g) {
            return false;
        }
        return true;
    }

    public int getAvailability() {
        return this.f9854g;
    }

    public Date getBegin() {
        return this.f9851d;
    }

    public String getDetail() {
        return this.f9849b;
    }

    public Date getEnd() {
        return this.f9852e;
    }

    public String getEventId() {
        return this.f9855h;
    }

    public String getLocation() {
        return this.f9850c;
    }

    public String getTitle() {
        return this.f9848a;
    }

    public boolean isAllDay() {
        return this.f9853f;
    }

    public void setEventId(String str) {
        this.f9855h = str;
    }

    public void setLocation(String str) {
        this.f9850c = str;
    }

    public String toString() {
        return getTitle() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getBegin() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getEnd() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + isAllDay();
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull CalendarEvent calendarEvent) {
        return getBegin().compareTo(calendarEvent.f9851d);
    }
}
