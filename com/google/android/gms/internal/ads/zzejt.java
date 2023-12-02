package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzejt implements zzekb {
    final /* synthetic */ zzeju zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzejt(zzeju zzejuVar) {
        this.zza = zzejuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekb
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzj = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekb
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzddn zzddnVar;
        zzddn zzddnVar2 = (zzddn) obj;
        synchronized (this.zza) {
            this.zza.zzj = zzddnVar2;
            zzddnVar = this.zza.zzj;
            zzddnVar.zzj();
        }
    }
}
