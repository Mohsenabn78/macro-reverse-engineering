package com.google.android.gms.internal.icing;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzei<T> implements zzep<T> {
    private final zzee zza;
    private final zzfd<?, ?> zzb;
    private final boolean zzc;
    private final zzcq<?> zzd;

    private zzei(zzfd<?, ?> zzfdVar, zzcq<?> zzcqVar, zzee zzeeVar) {
        this.zzb = zzfdVar;
        this.zzc = zzcqVar.zza(zzeeVar);
        this.zzd = zzcqVar;
        this.zza = zzeeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzei<T> zzg(zzfd<?, ?> zzfdVar, zzcq<?> zzcqVar, zzee zzeeVar) {
        return new zzei<>(zzfdVar, zzcqVar, zzeeVar);
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final boolean zza(T t3, T t4) {
        if (!this.zzb.zzb(t3).equals(this.zzb.zzb(t4))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zzb(t3);
        this.zzd.zzb(t4);
        throw null;
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final int zzb(T t3) {
        int hashCode = this.zzb.zzb(t3).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zzb(t3);
        throw null;
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final void zzc(T t3, T t4) {
        zzer.zzF(this.zzb, t3, t4);
        if (this.zzc) {
            zzer.zzE(this.zzd, t3, t4);
        }
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final int zzd(T t3) {
        zzfd<?, ?> zzfdVar = this.zzb;
        int zze = zzfdVar.zze(zzfdVar.zzb(t3));
        if (!this.zzc) {
            return zze;
        }
        this.zzd.zzb(t3);
        throw null;
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final void zze(T t3) {
        this.zzb.zzc(t3);
        this.zzd.zzc(t3);
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final boolean zzf(T t3) {
        this.zzd.zzb(t3);
        throw null;
    }

    @Override // com.google.android.gms.internal.icing.zzep
    public final void zzi(T t3, zzcn zzcnVar) throws IOException {
        this.zzd.zzb(t3);
        throw null;
    }
}
