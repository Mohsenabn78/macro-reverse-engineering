package com.google.android.gms.internal.wearable;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzdg implements zzdn {
    private final zzdc zza;
    private final zzee zzb;
    private final boolean zzc;
    private final zzbk zzd;

    private zzdg(zzee zzeeVar, zzbk zzbkVar, zzdc zzdcVar) {
        this.zzb = zzeeVar;
        this.zzc = zzbkVar.zzc(zzdcVar);
        this.zzd = zzbkVar;
        this.zza = zzdcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdg zzc(zzee zzeeVar, zzbk zzbkVar, zzdc zzdcVar) {
        return new zzdg(zzeeVar, zzbkVar, zzdcVar);
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final int zza(Object obj) {
        zzee zzeeVar = this.zzb;
        int zzb = zzeeVar.zzb(zzeeVar.zzc(obj));
        if (!this.zzc) {
            return zzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzc(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final Object zze() {
        return this.zza.zzV().zzv();
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final void zzg(Object obj, Object obj2) {
        zzdp.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzdp.zzE(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final void zzh(Object obj, byte[] bArr, int i4, int i5, zzaj zzajVar) throws IOException {
        zzbv zzbvVar = (zzbv) obj;
        if (zzbvVar.zzc == zzef.zzc()) {
            zzbvVar.zzc = zzef.zze();
        }
        zzbt zzbtVar = (zzbt) obj;
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final void zzi(Object obj, zzew zzewVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzc(obj).equals(this.zzb.zzc(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
