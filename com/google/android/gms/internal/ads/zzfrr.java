package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfrr {
    private static final zzfrr zza = new zzfro();
    private static final zzfrr zzb = new zzfrp(-1);
    private static final zzfrr zzc = new zzfrp(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfrr(zzfrq zzfrqVar) {
    }

    public static zzfrr zzj() {
        return zza;
    }

    public abstract int zza();

    public abstract zzfrr zzb(int i4, int i5);

    public abstract zzfrr zzc(Object obj, Object obj2, Comparator comparator);

    public abstract zzfrr zzd(boolean z3, boolean z4);

    public abstract zzfrr zze(boolean z3, boolean z4);
}
