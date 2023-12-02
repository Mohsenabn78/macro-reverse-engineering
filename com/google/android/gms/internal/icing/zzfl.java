package com.google.android.gms.internal.icing;

import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzfl extends zzfm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfl(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.icing.zzfm
    public final void zza(Object obj, long j4, byte b4) {
        if (zzfn.zzb) {
            zzfn.zzD(obj, j4, b4);
        } else {
            zzfn.zzE(obj, j4, b4);
        }
    }

    @Override // com.google.android.gms.internal.icing.zzfm
    public final boolean zzb(Object obj, long j4) {
        if (zzfn.zzb) {
            return zzfn.zzv(obj, j4);
        }
        return zzfn.zzw(obj, j4);
    }

    @Override // com.google.android.gms.internal.icing.zzfm
    public final void zzc(Object obj, long j4, boolean z3) {
        if (zzfn.zzb) {
            zzfn.zzD(obj, j4, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzfn.zzE(obj, j4, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.icing.zzfm
    public final float zzd(Object obj, long j4) {
        return Float.intBitsToFloat(zzk(obj, j4));
    }

    @Override // com.google.android.gms.internal.icing.zzfm
    public final void zze(Object obj, long j4, float f4) {
        zzl(obj, j4, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.gms.internal.icing.zzfm
    public final double zzf(Object obj, long j4) {
        return Double.longBitsToDouble(zzm(obj, j4));
    }

    @Override // com.google.android.gms.internal.icing.zzfm
    public final void zzg(Object obj, long j4, double d4) {
        zzn(obj, j4, Double.doubleToLongBits(d4));
    }
}
