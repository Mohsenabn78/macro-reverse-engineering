package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfro extends zzfrr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfro() {
        super(null);
    }

    static final zzfrr zzf(int i4) {
        zzfrr zzfrrVar;
        zzfrr zzfrrVar2;
        zzfrr zzfrrVar3;
        if (i4 < 0) {
            zzfrrVar3 = zzfrr.zzb;
            return zzfrrVar3;
        } else if (i4 > 0) {
            zzfrrVar2 = zzfrr.zzc;
            return zzfrrVar2;
        } else {
            zzfrrVar = zzfrr.zza;
            return zzfrrVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfrr
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfrr
    public final zzfrr zzb(int i4, int i5) {
        int i6;
        if (i4 < i5) {
            i6 = -1;
        } else if (i4 > i5) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        return zzf(i6);
    }

    @Override // com.google.android.gms.internal.ads.zzfrr
    public final zzfrr zzc(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzfrr
    public final zzfrr zzd(boolean z3, boolean z4) {
        return zzf(zzfuj.zza(z3, z4));
    }

    @Override // com.google.android.gms.internal.ads.zzfrr
    public final zzfrr zze(boolean z3, boolean z4) {
        return zzf(zzfuj.zza(false, false));
    }
}
