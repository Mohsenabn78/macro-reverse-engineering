package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public abstract class zzy {

    /* renamed from: a  reason: collision with root package name */
    final String f22104a;

    /* renamed from: b  reason: collision with root package name */
    final int f22105b;

    /* renamed from: c  reason: collision with root package name */
    Boolean f22106c;

    /* renamed from: d  reason: collision with root package name */
    Boolean f22107d;

    /* renamed from: e  reason: collision with root package name */
    Long f22108e;

    /* renamed from: f  reason: collision with root package name */
    Long f22109f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(String str, int i4) {
        this.f22104a = str;
        this.f22105b = i4;
    }

    private static Boolean d(String str, int i4, boolean z3, String str2, List list, String str3, zzet zzetVar) {
        int i5;
        if (i4 == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z3 && i4 != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i4 - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                if (true != z3) {
                    i5 = 66;
                } else {
                    i5 = 0;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, i5).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzetVar != null) {
                        zzetVar.zzk().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    @VisibleForTesting
    static Boolean e(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.zzer zzerVar, double d4) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzerVar);
        if (zzerVar.zzg()) {
            boolean z3 = true;
            if (zzerVar.zzm() != 1) {
                if (zzerVar.zzm() == 5) {
                    if (!zzerVar.zzk() || !zzerVar.zzj()) {
                        return null;
                    }
                } else if (!zzerVar.zzh()) {
                    return null;
                }
                int zzm = zzerVar.zzm();
                if (zzerVar.zzm() == 5) {
                    if (zzlj.G(zzerVar.zze()) && zzlj.G(zzerVar.zzd())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzerVar.zze());
                            bigDecimal4 = new BigDecimal(zzerVar.zzd());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                } else if (!zzlj.G(zzerVar.zzc())) {
                    return null;
                } else {
                    try {
                        bigDecimal2 = new BigDecimal(zzerVar.zzc());
                        bigDecimal3 = null;
                        bigDecimal4 = null;
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (zzm == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i4 = zzm - 1;
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4 || bigDecimal3 == null) {
                                return null;
                            }
                            return Boolean.valueOf((bigDecimal.compareTo(bigDecimal3) < 0 || bigDecimal.compareTo(bigDecimal4) > 0) ? false : false);
                        } else if (bigDecimal2 == null) {
                            return null;
                        } else {
                            if (d4 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                return Boolean.valueOf((bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d4).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d4).multiply(new BigDecimal(2)))) >= 0) ? false : false);
                            }
                            if (bigDecimal.compareTo(bigDecimal2) != 0) {
                                z3 = false;
                            }
                            return Boolean.valueOf(z3);
                        }
                    } else if (bigDecimal2 == null) {
                        return null;
                    } else {
                        if (bigDecimal.compareTo(bigDecimal2) <= 0) {
                            z3 = false;
                        }
                        return Boolean.valueOf(z3);
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                } else {
                    if (bigDecimal.compareTo(bigDecimal2) >= 0) {
                        z3 = false;
                    }
                    return Boolean.valueOf(z3);
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static Boolean f(String str, com.google.android.gms.internal.measurement.zzey zzeyVar, zzet zzetVar) {
        String zzd;
        List list;
        String str2;
        Preconditions.checkNotNull(zzeyVar);
        if (str == null || !zzeyVar.zzi() || zzeyVar.zzj() == 1) {
            return null;
        }
        if (zzeyVar.zzj() == 7) {
            if (zzeyVar.zza() == 0) {
                return null;
            }
        } else if (!zzeyVar.zzh()) {
            return null;
        }
        int zzj = zzeyVar.zzj();
        boolean zzf = zzeyVar.zzf();
        if (!zzf && zzj != 2 && zzj != 7) {
            zzd = zzeyVar.zzd().toUpperCase(Locale.ENGLISH);
        } else {
            zzd = zzeyVar.zzd();
        }
        String str3 = zzd;
        if (zzeyVar.zza() == 0) {
            list = null;
        } else {
            List<String> zze = zzeyVar.zze();
            if (!zzf) {
                ArrayList arrayList = new ArrayList(zze.size());
                for (String str4 : zze) {
                    arrayList.add(str4.toUpperCase(Locale.ENGLISH));
                }
                zze = Collections.unmodifiableList(arrayList);
            }
            list = zze;
        }
        if (zzj == 2) {
            str2 = str3;
        } else {
            str2 = null;
        }
        return d(str, zzj, zzf, str3, list, str2, zzetVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean g(double d4, com.google.android.gms.internal.measurement.zzer zzerVar) {
        try {
            return e(new BigDecimal(d4), zzerVar, Math.ulp(d4));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean h(long j4, com.google.android.gms.internal.measurement.zzer zzerVar) {
        try {
            return e(new BigDecimal(j4), zzerVar, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean i(String str, com.google.android.gms.internal.measurement.zzer zzerVar) {
        if (!zzlj.G(str)) {
            return null;
        }
        try {
            return e(new BigDecimal(str), zzerVar, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static Boolean j(Boolean bool, boolean z3) {
        boolean z4;
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue() != z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        return Boolean.valueOf(z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean c();
}
