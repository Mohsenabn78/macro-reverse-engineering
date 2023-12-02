package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes5.dex */
class TimeSource {

    /* renamed from: c  reason: collision with root package name */
    private static final TimeSource f23571c = new TimeSource(null, null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Long f23572a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final TimeZone f23573b;

    private TimeSource(@Nullable Long l4, @Nullable TimeZone timeZone) {
        this.f23572a = l4;
        this.f23573b = timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TimeSource c() {
        return f23571c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f23573b);
    }

    Calendar b(@Nullable TimeZone timeZone) {
        Calendar calendar;
        if (timeZone == null) {
            calendar = Calendar.getInstance();
        } else {
            calendar = Calendar.getInstance(timeZone);
        }
        Long l4 = this.f23572a;
        if (l4 != null) {
            calendar.setTimeInMillis(l4.longValue());
        }
        return calendar;
    }
}
