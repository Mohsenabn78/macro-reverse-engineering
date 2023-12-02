package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzbdi;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zze extends zzbzr {
    public static void zza(String str) {
        if (zzc() && str != null && str.length() > 4000) {
            for (String str2 : zzbzr.zza.zzd(str)) {
            }
        }
    }

    public static void zzb(String str, Throwable th) {
        zzc();
    }

    public static boolean zzc() {
        if (zzbzr.zzm(2) && ((Boolean) zzbdi.zza.zze()).booleanValue()) {
            return true;
        }
        return false;
    }
}
