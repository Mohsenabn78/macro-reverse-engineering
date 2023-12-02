package com.google.android.gms.internal.p002firebaseauthapi;

import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajv  reason: invalid package */
/* loaded from: classes4.dex */
final class zzajv extends zzajx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajv(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajx
    public final double zza(Object obj, long j4) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j4));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajx
    public final float zzb(Object obj, long j4) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j4));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajx
    public final void zzc(Object obj, long j4, boolean z3) {
        if (zzajy.zzb) {
            zzajy.zzD(obj, j4, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzajy.zzE(obj, j4, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajx
    public final void zzd(Object obj, long j4, byte b4) {
        if (zzajy.zzb) {
            zzajy.zzD(obj, j4, b4);
        } else {
            zzajy.zzE(obj, j4, b4);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajx
    public final void zze(Object obj, long j4, double d4) {
        this.zza.putLong(obj, j4, Double.doubleToLongBits(d4));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajx
    public final void zzf(Object obj, long j4, float f4) {
        this.zza.putInt(obj, j4, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajx
    public final boolean zzg(Object obj, long j4) {
        if (zzajy.zzb) {
            return zzajy.zzt(obj, j4);
        }
        return zzajy.zzu(obj, j4);
    }
}
