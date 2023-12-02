package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.ads.AdRequest;
import com.google.android.gms.wearable.WearableStatusCodes;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class zzbzr {
    protected static final zzfpu zza = zzfpu.zzb(WearableStatusCodes.TARGET_NODE_NOT_CONNECTED);

    @VisibleForTesting
    static String zzd(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 4) {
            int lineNumber = stackTrace[3].getLineNumber();
            return str + " @" + lineNumber;
        }
        return str;
    }

    public static void zze(String str) {
        if (zzm(3) && str != null && str.length() > 4000) {
            for (String str2 : zza.zzd(str)) {
            }
        }
    }

    public static void zzf(String str, Throwable th) {
        zzm(3);
    }

    public static void zzg(String str) {
        if (zzm(6)) {
            if (str != null && str.length() > 4000) {
                boolean z3 = true;
                for (String str2 : zza.zzd(str)) {
                    if (z3) {
                        Log.e(AdRequest.LOGTAG, str2);
                    } else {
                        Log.e("Ads-cont", str2);
                    }
                    z3 = false;
                }
                return;
            }
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void zzh(String str, Throwable th) {
        if (zzm(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzi(String str) {
        if (zzm(4)) {
            if (str != null && str.length() > 4000) {
                boolean z3 = true;
                for (String str2 : zza.zzd(str)) {
                    if (z3) {
                        Log.i(AdRequest.LOGTAG, str2);
                    } else {
                        Log.i("Ads-cont", str2);
                    }
                    z3 = false;
                }
                return;
            }
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void zzj(String str) {
        if (zzm(5)) {
            if (str != null && str.length() > 4000) {
                boolean z3 = true;
                for (String str2 : zza.zzd(str)) {
                    if (z3) {
                        Log.w(AdRequest.LOGTAG, str2);
                    } else {
                        Log.w("Ads-cont", str2);
                    }
                    z3 = false;
                }
                return;
            }
            Log.w(AdRequest.LOGTAG, str);
        }
    }

    public static void zzk(String str, Throwable th) {
        if (zzm(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzl(String str, @Nullable Throwable th) {
        if (zzm(5)) {
            if (th != null) {
                zzk(zzd(str), th);
            } else {
                zzj(zzd(str));
            }
        }
    }

    public static boolean zzm(int i4) {
        if (i4 < 5 && !Log.isLoggable(AdRequest.LOGTAG, i4)) {
            return false;
        }
        return true;
    }
}
