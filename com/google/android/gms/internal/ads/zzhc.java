package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzhc {
    private static final Pattern zza = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    private static final Pattern zzb = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static long zza(@Nullable String str, @Nullable String str2) {
        long j4 = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                j4 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                zzer.zzc("HttpUtil", "Unexpected Content-Length [" + str + "]");
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            Matcher matcher = zza.matcher(str2);
            if (matcher.matches()) {
                try {
                    String group = matcher.group(2);
                    group.getClass();
                    long parseLong = Long.parseLong(group);
                    String group2 = matcher.group(1);
                    group2.getClass();
                    int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
                    long parseLong2 = (parseLong - Long.parseLong(group2)) + 1;
                    if (i4 < 0) {
                        return parseLong2;
                    }
                    if (j4 != parseLong2) {
                        zzer.zzf("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
                        return Math.max(j4, parseLong2);
                    }
                    return j4;
                } catch (NumberFormatException unused2) {
                    zzer.zzc("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
                    return j4;
                }
            }
            return j4;
        }
        return j4;
    }

    public static long zzb(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = zzb.matcher(str);
        if (!matcher.matches()) {
            return -1L;
        }
        String group = matcher.group(1);
        group.getClass();
        return Long.parseLong(group);
    }
}
