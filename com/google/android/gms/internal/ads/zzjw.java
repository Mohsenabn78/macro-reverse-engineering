package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzjw implements zzkq {
    private final Object zza;
    private zzcw zzb;

    public zzjw(Object obj, zzcw zzcwVar) {
        this.zza = obj;
        this.zzb = zzcwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzc(zzjw zzjwVar, zzcw zzcwVar) {
        zzjwVar.zzb = zzcwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzkq
    public final zzcw zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzkq
    public final Object zzb() {
        return this.zza;
    }
}
