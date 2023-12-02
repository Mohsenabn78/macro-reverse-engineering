package com.google.android.gms.ads;

import androidx.annotation.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzb {
    public static int zza(AdSize adSize) {
        return adSize.b();
    }

    public static int zzb(AdSize adSize) {
        return adSize.a();
    }

    public static AdSize zzc(int i4, int i5, String str) {
        return new AdSize(i4, i5, str);
    }

    public static AdSize zzd(int i4, int i5) {
        AdSize adSize = new AdSize(i4, i5);
        adSize.e(true);
        adSize.c(i5);
        return adSize;
    }

    public static AdSize zze(int i4, int i5) {
        AdSize adSize = new AdSize(i4, i5);
        adSize.f(true);
        adSize.d(i5);
        return adSize;
    }

    public static boolean zzf(AdSize adSize) {
        return adSize.g();
    }

    public static boolean zzg(AdSize adSize) {
        return adSize.h();
    }

    public static boolean zzh(AdSize adSize) {
        return adSize.i();
    }
}
