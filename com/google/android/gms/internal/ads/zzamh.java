package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.common.Util;
import com.google.common.net.HttpHeaders;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzamh {
    public static long zza(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e4) {
            if (!"0".equals(str) && !Util.ANY_CONTACT_ID.equals(str)) {
                zzalw.zzc(e4, "Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            zzalw.zzd("Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    @Nullable
    public static zzakt zzb(zzalg zzalgVar) {
        long j4;
        boolean z3;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = zzalgVar.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        if (str != null) {
            j4 = zza(str);
        } else {
            j4 = 0;
        }
        String str2 = (String) map.get(HttpHeaders.CACHE_CONTROL);
        int i4 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z3 = false;
            j5 = 0;
            j6 = 0;
            while (i4 < split.length) {
                String trim = split[i4].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j6 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j5 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z3 = true;
                }
                i4++;
            }
            i4 = 1;
        } else {
            z3 = false;
            j5 = 0;
            j6 = 0;
        }
        String str3 = (String) map.get(HttpHeaders.EXPIRES);
        if (str3 != null) {
            j7 = zza(str3);
        } else {
            j7 = 0;
        }
        String str4 = (String) map.get(HttpHeaders.LAST_MODIFIED);
        if (str4 != null) {
            j8 = zza(str4);
        } else {
            j8 = 0;
        }
        String str5 = (String) map.get(HttpHeaders.ETAG);
        if (i4 != 0) {
            j10 = currentTimeMillis + (j6 * 1000);
            if (z3) {
                j11 = j10;
            } else {
                Long.signum(j5);
                j11 = (j5 * 1000) + j10;
            }
            j9 = j11;
        } else {
            j9 = 0;
            if (j4 > 0 && j7 >= j4) {
                j10 = currentTimeMillis + (j7 - j4);
                j9 = j10;
            } else {
                j10 = 0;
            }
        }
        zzakt zzaktVar = new zzakt();
        zzaktVar.zza = zzalgVar.zzb;
        zzaktVar.zzb = str5;
        zzaktVar.zzf = j10;
        zzaktVar.zze = j9;
        zzaktVar.zzc = j4;
        zzaktVar.zzd = j8;
        zzaktVar.zzg = map;
        zzaktVar.zzh = zzalgVar.zzd;
        return zzaktVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzc(long j4) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j4));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
