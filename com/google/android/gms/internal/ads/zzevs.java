package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzevs implements zzekb {
    final /* synthetic */ zzevt zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzevs(zzevt zzevtVar) {
        this.zza = zzevtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekb
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekb
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzevl zzevlVar;
        zzevl zzevlVar2;
        zzdqa zzdqaVar;
        zzcov zzcovVar = (zzcov) obj;
        synchronized (this.zza) {
            zzcov zzcovVar2 = this.zza.zza;
            if (zzcovVar2 != null) {
                zzcovVar2.zzb();
            }
            zzevt zzevtVar = this.zza;
            zzevtVar.zza = zzcovVar;
            zzcovVar.zzc(zzevtVar);
            zzevt zzevtVar2 = this.zza;
            zzevlVar = zzevtVar2.zzg;
            zzevlVar2 = zzevtVar2.zzg;
            zzdqaVar = zzevtVar2.zzi;
            zzevlVar.zzl(new zzcow(zzcovVar, zzevtVar2, zzevlVar2, zzdqaVar));
            zzcovVar.zzj();
        }
    }
}
