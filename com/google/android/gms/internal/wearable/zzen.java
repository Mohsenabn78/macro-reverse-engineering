package com.google.android.gms.internal.wearable;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class zzen {
    final Unsafe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzen(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j4);

    public abstract float zzb(Object obj, long j4);

    public abstract void zzc(Object obj, long j4, boolean z3);

    public abstract void zzd(Object obj, long j4, byte b4);

    public abstract void zze(Object obj, long j4, double d4);

    public abstract void zzf(Object obj, long j4, float f4);

    public abstract boolean zzg(Object obj, long j4);

    public final int zzh(Class cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzi(Class cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzj(Object obj, long j4) {
        return this.zza.getInt(obj, j4);
    }

    public final long zzk(Object obj, long j4) {
        return this.zza.getLong(obj, j4);
    }

    public final long zzl(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final Object zzm(Object obj, long j4) {
        return this.zza.getObject(obj, j4);
    }

    public final void zzn(Object obj, long j4, int i4) {
        this.zza.putInt(obj, j4, i4);
    }

    public final void zzo(Object obj, long j4, long j5) {
        this.zza.putLong(obj, j4, j5);
    }

    public final void zzp(Object obj, long j4, Object obj2) {
        this.zza.putObject(obj, j4, obj2);
    }
}
