package com.google.firebase.appindexing.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class zzae {
    @GuardedBy("itself")

    /* renamed from: a  reason: collision with root package name */
    private static final DateFormat f28806a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);

    public static String zza(Calendar calendar) {
        String format;
        DateFormat dateFormat = f28806a;
        synchronized (dateFormat) {
            dateFormat.setTimeZone(calendar.getTimeZone());
            format = dateFormat.format(calendar.getTime());
        }
        return format;
    }
}
