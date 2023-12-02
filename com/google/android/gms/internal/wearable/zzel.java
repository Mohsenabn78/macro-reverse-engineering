package com.google.android.gms.internal.wearable;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzel extends zzen {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzel(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.wearable.zzen
    public final double zza(Object obj, long j4) {
        return Double.longBitsToDouble(zzk(obj, j4));
    }

    @Override // com.google.android.gms.internal.wearable.zzen
    public final float zzb(Object obj, long j4) {
        return Float.intBitsToFloat(zzj(obj, j4));
    }

    @Override // com.google.android.gms.internal.wearable.zzen
    public final void zzc(Object obj, long j4, boolean z3) {
        if (zzeo.zzb) {
            zzeo.zzD(obj, j4, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzeo.zzE(obj, j4, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzen
    public final void zzd(Object obj, long j4, byte b4) {
        if (zzeo.zzb) {
            zzeo.zzD(obj, j4, b4);
        } else {
            zzeo.zzE(obj, j4, b4);
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzen
    public final void zze(Object obj, long j4, double d4) {
        zzo(obj, j4, Double.doubleToLongBits(d4));
    }

    @Override // com.google.android.gms.internal.wearable.zzen
    public final void zzf(Object obj, long j4, float f4) {
        zzn(obj, j4, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.gms.internal.wearable.zzen
    public final boolean zzg(Object obj, long j4) {
        if (zzeo.zzb) {
            return zzeo.zzt(obj, j4);
        }
        return zzeo.zzu(obj, j4);
    }
}
