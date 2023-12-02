package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.firebase.appindexing.internal.zzae;
import java.util.Calendar;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class TimerBuilder extends IndexableBuilder<TimerBuilder> {
    @NonNull
    public static final String EXPIRED = "Expired";
    @NonNull
    public static final String MISSED = "Missed";
    @NonNull
    public static final String PAUSED = "Paused";
    @NonNull
    public static final String RESET = "Reset";
    @NonNull
    public static final String STARTED = "Started";
    @NonNull
    public static final String UNKNOWN = "Unknown";

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimerBuilder() {
        super("Timer");
    }

    @NonNull
    public TimerBuilder setExpireTime(@NonNull Calendar calendar) {
        put("expireTime", zzae.zza(calendar));
        return this;
    }

    @NonNull
    public TimerBuilder setIdentifier(@NonNull String str) {
        put("identifier", str);
        return this;
    }

    @NonNull
    public TimerBuilder setLength(long j4) {
        put("length", j4);
        return this;
    }

    @NonNull
    public TimerBuilder setMessage(@NonNull String str) {
        put("message", str);
        return this;
    }

    @NonNull
    public TimerBuilder setRemainingTime(long j4) {
        put("remainingTime", j4);
        return this;
    }

    @NonNull
    public TimerBuilder setRingtone(@NonNull String str) {
        put("ringtone", str);
        return this;
    }

    @NonNull
    public TimerBuilder setTimerStatus(@NonNull String str) {
        String str2;
        if (!"Started".equals(str) && !"Paused".equals(str) && !EXPIRED.equals(str) && !"Missed".equals(str) && !RESET.equals(str) && !"Unknown".equals(str)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Invalid timer status ".concat(valueOf);
            } else {
                str2 = new String("Invalid timer status ");
            }
            throw new IllegalArgumentException(str2);
        }
        put("timerStatus", str);
        return this;
    }

    @NonNull
    public TimerBuilder setVibrate(boolean z3) {
        put("vibrate", z3);
        return this;
    }
}
