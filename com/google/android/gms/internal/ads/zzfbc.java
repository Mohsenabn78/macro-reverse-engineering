package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfbc {
    public static void zza(Context context, boolean z3) {
        if (z3) {
            zzbzr.zzi("This request is sent from a test device.");
            return;
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        String zzy = zzbzk.zzy(context);
        zzbzr.zzi("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"" + zzy + "\")) to get test ads on this device.");
    }

    public static void zzb(int i4, Throwable th, String str) {
        zzbzr.zzi("Ad failed to load : " + i4);
        com.google.android.gms.ads.internal.util.zze.zzb(str, th);
        if (i4 == 3) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzo().zzt(th, str);
    }
}
