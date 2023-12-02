package com.google.android.gms.internal.ads;

import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzgsp {
    final Unsafe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgsp(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract byte zza(long j4);

    public abstract double zzb(Object obj, long j4);

    public abstract float zzc(Object obj, long j4);

    public abstract void zzd(long j4, byte[] bArr, long j5, long j6);

    public abstract void zze(Object obj, long j4, boolean z3);

    public abstract void zzf(Object obj, long j4, byte b4);

    public abstract void zzg(Object obj, long j4, double d4);

    public abstract void zzh(Object obj, long j4, float f4);

    public abstract boolean zzi(Object obj, long j4);
}
