package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzejw implements zzekb {
    final /* synthetic */ zzejx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzejw(zzejx zzejxVar) {
        this.zza = zzejxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekb
    public final void zza() {
        synchronized (this.zza) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekb
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzc = ((zzcrd) obj).zzl();
            ((zzcrd) obj).zzj();
        }
    }
}
