package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeir implements zzekb {
    final /* synthetic */ zzeis zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeir(zzeis zzeisVar) {
        this.zza = zzeisVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekb
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekb
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpb zzcpbVar;
        zzcpb zzcpbVar2;
        zzcpb zzcpbVar3;
        zzcpb zzcpbVar4 = (zzcpb) obj;
        synchronized (this.zza) {
            zzeis zzeisVar = this.zza;
            zzcpbVar = zzeisVar.zzi;
            if (zzcpbVar != null) {
                zzcpbVar3 = zzeisVar.zzi;
                zzcpbVar3.zzb();
            }
            this.zza.zzi = zzcpbVar4;
            zzcpbVar2 = this.zza.zzi;
            zzcpbVar2.zzj();
        }
    }
}
