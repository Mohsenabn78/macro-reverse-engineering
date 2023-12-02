package com.google.android.gms.internal.icing;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public abstract class zzfm {
    final Unsafe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfm(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract void zza(Object obj, long j4, byte b4);

    public abstract boolean zzb(Object obj, long j4);

    public abstract void zzc(Object obj, long j4, boolean z3);

    public abstract float zzd(Object obj, long j4);

    public abstract void zze(Object obj, long j4, float f4);

    public abstract double zzf(Object obj, long j4);

    public abstract void zzg(Object obj, long j4, double d4);

    public final long zzh(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final int zzi(Class<?> cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzj(Class<?> cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzk(Object obj, long j4) {
        return this.zza.getInt(obj, j4);
    }

    public final void zzl(Object obj, long j4, int i4) {
        this.zza.putInt(obj, j4, i4);
    }

    public final long zzm(Object obj, long j4) {
        return this.zza.getLong(obj, j4);
    }

    public final void zzn(Object obj, long j4, long j5) {
        this.zza.putLong(obj, j4, j5);
    }

    public final Object zzo(Object obj, long j4) {
        return this.zza.getObject(obj, j4);
    }

    public final void zzp(Object obj, long j4, Object obj2) {
        this.zza.putObject(obj, j4, obj2);
    }
}
