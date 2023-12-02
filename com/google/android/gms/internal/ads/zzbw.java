package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzbw {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbw(zzbw zzbwVar) {
        this.zza = zzbwVar.zza;
        this.zzb = zzbwVar.zzb;
        this.zzc = zzbwVar.zzc;
        this.zzd = zzbwVar.zzd;
        this.zze = zzbwVar.zze;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbw)) {
            return false;
        }
        zzbw zzbwVar = (zzbw) obj;
        if (this.zza.equals(zzbwVar.zza) && this.zzb == zzbwVar.zzb && this.zzc == zzbwVar.zzc && this.zzd == zzbwVar.zzd && this.zze == zzbwVar.zze) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzbw zza(Object obj) {
        if (this.zza.equals(obj)) {
            return this;
        }
        return new zzbw(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        if (this.zzb != -1) {
            return true;
        }
        return false;
    }

    private zzbw(Object obj, int i4, int i5, long j4, int i6) {
        this.zza = obj;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = j4;
        this.zze = i6;
    }

    public zzbw(Object obj, int i4, int i5, long j4) {
        this(obj, i4, i5, j4, -1);
    }

    public zzbw(Object obj, long j4) {
        this(obj, -1, -1, j4, -1);
    }

    public zzbw(Object obj, long j4, int i4) {
        this(obj, -1, -1, j4, i4);
    }
}
