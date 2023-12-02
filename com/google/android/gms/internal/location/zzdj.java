package com.google.android.gms.internal.location;

import androidx.annotation.GuardedBy;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes4.dex */
public final class zzdj {
    private static final SimpleDateFormat zza;
    private static final SimpleDateFormat zzb;
    @GuardedBy("sharedStringBuilder")
    private static final StringBuilder zzc;

    static {
        Locale locale = Locale.ROOT;
        zza = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        zzb = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
        zzc = new StringBuilder(33);
    }

    public static String zza(long j4) {
        String sb;
        StringBuilder sb2 = zzc;
        synchronized (sb2) {
            sb2.setLength(0);
            zzb(j4, sb2);
            sb = sb2.toString();
        }
        return sb;
    }

    public static void zzb(long j4, StringBuilder sb) {
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 == 0) {
            sb.append("0s");
            return;
        }
        sb.ensureCapacity(sb.length() + 27);
        boolean z3 = false;
        if (i4 < 0) {
            sb.append("-");
            if (j4 != Long.MIN_VALUE) {
                j4 = -j4;
            } else {
                j4 = Long.MAX_VALUE;
                z3 = true;
            }
        }
        if (j4 >= 86400000) {
            sb.append(j4 / 86400000);
            sb.append("d");
            j4 %= 86400000;
        }
        if (true == z3) {
            j4 = 25975808;
        }
        if (j4 >= 3600000) {
            sb.append(j4 / 3600000);
            sb.append("h");
            j4 %= 3600000;
        }
        if (j4 >= ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS) {
            sb.append(j4 / ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
            sb.append("m");
            j4 %= ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;
        }
        if (j4 >= 1000) {
            sb.append(j4 / 1000);
            sb.append("s");
            j4 %= 1000;
        }
        if (j4 > 0) {
            sb.append(j4);
            sb.append(TranslateLanguage.MALAY);
        }
    }
}
