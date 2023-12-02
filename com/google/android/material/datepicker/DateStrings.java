package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class DateStrings {
    private DateStrings() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<String, String> a(@Nullable Long l4, @Nullable Long l5) {
        return b(l4, l5, null);
    }

    static Pair<String, String> b(@Nullable Long l4, @Nullable Long l5, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l4 == null && l5 == null) {
            return Pair.create(null, null);
        }
        if (l4 == null) {
            return Pair.create(null, d(l5.longValue(), simpleDateFormat));
        }
        if (l5 == null) {
            return Pair.create(d(l4.longValue(), simpleDateFormat), null);
        }
        Calendar o4 = UtcDates.o();
        Calendar q4 = UtcDates.q();
        q4.setTimeInMillis(l4.longValue());
        Calendar q5 = UtcDates.q();
        q5.setTimeInMillis(l5.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l4.longValue())), simpleDateFormat.format(new Date(l5.longValue())));
        } else if (q4.get(1) == q5.get(1)) {
            if (q4.get(1) == o4.get(1)) {
                return Pair.create(f(l4.longValue(), Locale.getDefault()), f(l5.longValue(), Locale.getDefault()));
            }
            return Pair.create(f(l4.longValue(), Locale.getDefault()), k(l5.longValue(), Locale.getDefault()));
        } else {
            return Pair.create(k(l4.longValue(), Locale.getDefault()), k(l5.longValue(), Locale.getDefault()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(long j4) {
        return d(j4, null);
    }

    static String d(long j4, @Nullable SimpleDateFormat simpleDateFormat) {
        Calendar o4 = UtcDates.o();
        Calendar q4 = UtcDates.q();
        q4.setTimeInMillis(j4);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j4));
        }
        if (o4.get(1) == q4.get(1)) {
            return e(j4);
        }
        return j(j4);
    }

    static String e(long j4) {
        return f(j4, Locale.getDefault());
    }

    static String f(long j4, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = UtcDates.c(locale).format(new Date(j4));
            return format;
        }
        return UtcDates.j(locale).format(new Date(j4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(long j4) {
        return h(j4, Locale.getDefault());
    }

    static String h(long j4, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = UtcDates.d(locale).format(new Date(j4));
            return format;
        }
        return UtcDates.h(locale).format(new Date(j4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i(Context context, long j4) {
        return DateUtils.formatDateTime(context, j4 - TimeZone.getDefault().getOffset(j4), 36);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(long j4) {
        return k(j4, Locale.getDefault());
    }

    static String k(long j4, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = UtcDates.s(locale).format(new Date(j4));
            return format;
        }
        return UtcDates.i(locale).format(new Date(j4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(long j4) {
        return m(j4, Locale.getDefault());
    }

    static String m(long j4, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = UtcDates.t(locale).format(new Date(j4));
            return format;
        }
        return UtcDates.h(locale).format(new Date(j4));
    }
}
