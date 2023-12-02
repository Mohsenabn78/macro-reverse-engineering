package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgso extends zzgsp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgso(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.ads.zzgsp
    public final byte zza(long j4) {
        return Memory.peekByte(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzgsp
    public final double zzb(Object obj, long j4) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j4));
    }

    @Override // com.google.android.gms.internal.ads.zzgsp
    public final float zzc(Object obj, long j4) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j4));
    }

    @Override // com.google.android.gms.internal.ads.zzgsp
    public final void zzd(long j4, byte[] bArr, long j5, long j6) {
        Memory.peekByteArray(j4, bArr, (int) j5, (int) j6);
    }

    @Override // com.google.android.gms.internal.ads.zzgsp
    public final void zze(Object obj, long j4, boolean z3) {
        if (zzgsq.zzb) {
            zzgsq.zzG(obj, j4, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzgsq.zzH(obj, j4, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgsp
    public final void zzf(Object obj, long j4, byte b4) {
        if (zzgsq.zzb) {
            zzgsq.zzG(obj, j4, b4);
        } else {
            zzgsq.zzH(obj, j4, b4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgsp
    public final void zzg(Object obj, long j4, double d4) {
        this.zza.putLong(obj, j4, Double.doubleToLongBits(d4));
    }

    @Override // com.google.android.gms.internal.ads.zzgsp
    public final void zzh(Object obj, long j4, float f4) {
        this.zza.putInt(obj, j4, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.gms.internal.ads.zzgsp
    public final boolean zzi(Object obj, long j4) {
        if (zzgsq.zzb) {
            return zzgsq.zzw(obj, j4);
        }
        return zzgsq.zzx(obj, j4);
    }
}
