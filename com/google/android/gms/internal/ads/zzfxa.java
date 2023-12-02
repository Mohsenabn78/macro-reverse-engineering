package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfxa extends zzfwl {
    final /* synthetic */ zzfxc zza;
    private final zzfvi zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfxa(zzfxc zzfxcVar, zzfvi zzfviVar) {
        this.zza = zzfxcVar;
        this.zzb = zzfviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzfwm zza = this.zzb.zza();
        zzfph.zzd(zza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzb);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    final void zzd(Throwable th) {
        this.zza.zze(th);
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    final /* synthetic */ void zze(Object obj) {
        this.zza.zzt((zzfwm) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    final boolean zzg() {
        return this.zza.isDone();
    }
}
