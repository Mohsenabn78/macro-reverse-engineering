package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Nullable;
import org.threeten.bp.Year;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakh  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzakh {
    public static final zzajm zza;
    public static final zzajm zzb;
    public static final zzajm zzc;
    private static final ThreadLocal zzd;
    @Nullable
    private static final Method zze;
    @Nullable
    private static final Method zzf;
    @Nullable
    private static final Method zzg;

    static {
        zzajl zzc2 = zzajm.zzc();
        zzc2.zzb(-62135596800L);
        zzc2.zza(0);
        zza = (zzajm) zzc2.zzi();
        zzajl zzc3 = zzajm.zzc();
        zzc3.zzb(253402300799L);
        zzc3.zza(Year.MAX_VALUE);
        zzb = (zzajm) zzc3.zzi();
        zzajl zzc4 = zzajm.zzc();
        zzc4.zzb(0L);
        zzc4.zza(0);
        zzc = (zzajm) zzc4.zzi();
        zzd = new zzakg();
        zze = zzc("now");
        zzf = zzc("getEpochSecond");
        zzg = zzc("getNano");
    }

    public static zzajm zza(zzajm zzajmVar) {
        long zzb2 = zzajmVar.zzb();
        int i4 = (zzb2 > (-62135596800L) ? 1 : (zzb2 == (-62135596800L) ? 0 : -1));
        int zza2 = zzajmVar.zza();
        if (i4 >= 0 && zzb2 <= 253402300799L && zza2 >= 0 && zza2 < 1000000000) {
            return zzajmVar;
        }
        throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", Long.valueOf(zzb2), Integer.valueOf(zza2)));
    }

    public static zzajm zzb(String str) throws ParseException {
        String str2;
        int i4;
        int indexOf = str.indexOf(84);
        if (indexOf != -1) {
            int indexOf2 = str.indexOf(90, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(43, indexOf);
            }
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(45, indexOf);
            }
            if (indexOf2 != -1) {
                String substring = str.substring(0, indexOf2);
                int indexOf3 = substring.indexOf(46);
                if (indexOf3 != -1) {
                    String substring2 = substring.substring(0, indexOf3);
                    str2 = substring.substring(indexOf3 + 1);
                    substring = substring2;
                } else {
                    str2 = "";
                }
                long time = ((SimpleDateFormat) zzd.get()).parse(substring).getTime() / 1000;
                if (str2.isEmpty()) {
                    i4 = 0;
                } else {
                    i4 = 0;
                    for (int i5 = 0; i5 < 9; i5++) {
                        i4 *= 10;
                        if (i5 < str2.length()) {
                            if (str2.charAt(i5) >= '0' && str2.charAt(i5) <= '9') {
                                i4 += str2.charAt(i5) - '0';
                            } else {
                                throw new ParseException("Invalid nanoseconds.", 0);
                            }
                        }
                    }
                }
                if (str.charAt(indexOf2) == 'Z') {
                    if (str.length() != indexOf2 + 1) {
                        String substring3 = str.substring(indexOf2);
                        throw new ParseException("Failed to parse timestamp: invalid trailing data \"" + substring3 + "\"", 0);
                    }
                } else {
                    String substring4 = str.substring(indexOf2 + 1);
                    int indexOf4 = substring4.indexOf(58);
                    if (indexOf4 != -1) {
                        long parseLong = ((Long.parseLong(substring4.substring(0, indexOf4)) * 60) + Long.parseLong(substring4.substring(indexOf4 + 1))) * 60;
                        if (str.charAt(indexOf2) == '+') {
                            time -= parseLong;
                        } else {
                            time += parseLong;
                        }
                    } else {
                        throw new ParseException("Invalid offset value: ".concat(substring4), 0);
                    }
                }
                if (i4 <= -1000000000 || i4 >= 1000000000) {
                    try {
                        time = zzbb.zza(time, i4 / 1000000000);
                        i4 %= 1000000000;
                    } catch (IllegalArgumentException e4) {
                        ParseException parseException = new ParseException("Failed to parse timestamp " + str + " Timestamp is out of range.", 0);
                        parseException.initCause(e4);
                        throw parseException;
                    }
                }
                if (i4 < 0) {
                    i4 += 1000000000;
                    time = zzbb.zzb(time, 1L);
                }
                zzajl zzc2 = zzajm.zzc();
                zzc2.zzb(time);
                zzc2.zza(i4);
                zzajm zzajmVar = (zzajm) zzc2.zzi();
                zza(zzajmVar);
                return zzajmVar;
            }
            throw new ParseException("Failed to parse timestamp: missing valid timezone offset.", 0);
        }
        throw new ParseException("Failed to parse timestamp: invalid timestamp \"" + str + "\"", 0);
    }

    @Nullable
    private static Method zzc(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
