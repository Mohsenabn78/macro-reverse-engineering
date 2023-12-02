package com.google.android.recaptcha.internal;

import sun.misc.Unsafe;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzjm extends zzjo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjm(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.recaptcha.internal.zzjo
    public final double zza(Object obj, long j4) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j4));
    }

    @Override // com.google.android.recaptcha.internal.zzjo
    public final float zzb(Object obj, long j4) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j4));
    }

    @Override // com.google.android.recaptcha.internal.zzjo
    public final void zzc(Object obj, long j4, boolean z3) {
        if (zzjp.zzb) {
            zzjp.zzD(obj, j4, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzjp.zzE(obj, j4, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzjo
    public final void zzd(Object obj, long j4, byte b4) {
        if (zzjp.zzb) {
            zzjp.zzD(obj, j4, b4);
        } else {
            zzjp.zzE(obj, j4, b4);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzjo
    public final void zze(Object obj, long j4, double d4) {
        this.zza.putLong(obj, j4, Double.doubleToLongBits(d4));
    }

    @Override // com.google.android.recaptcha.internal.zzjo
    public final void zzf(Object obj, long j4, float f4) {
        this.zza.putInt(obj, j4, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.recaptcha.internal.zzjo
    public final boolean zzg(Object obj, long j4) {
        if (zzjp.zzb) {
            return zzjp.zzt(obj, j4);
        }
        return zzjp.zzu(obj, j4);
    }
}
