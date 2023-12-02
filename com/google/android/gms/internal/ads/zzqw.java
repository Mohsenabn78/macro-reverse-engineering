package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzqw {
    public static final boolean zza;

    static {
        boolean z3 = false;
        if ("Amazon".equals(zzfj.zzc)) {
            String str = zzfj.zzd;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z3 = true;
            }
        }
        zza = z3;
    }
}
