package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzehs implements com.google.android.gms.ads.internal.zzf {
    final /* synthetic */ zzcaj zza;
    final /* synthetic */ zzezz zzb;
    final /* synthetic */ zzezn zzc;
    final /* synthetic */ zzehy zzd;
    final /* synthetic */ zzeht zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzehs(zzeht zzehtVar, zzcaj zzcajVar, zzezz zzezzVar, zzezn zzeznVar, zzehy zzehyVar) {
        this.zze = zzehtVar;
        this.zza = zzcajVar;
        this.zzb = zzezzVar;
        this.zzc = zzeznVar;
        this.zzd = zzehyVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zza(View view) {
        zzeic zzeicVar;
        zzcaj zzcajVar = this.zza;
        zzeicVar = this.zze.zzd;
        zzcajVar.zzd(zzeicVar.zza(this.zzb, this.zzc, view, this.zzd));
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzb() {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzc() {
    }
}
