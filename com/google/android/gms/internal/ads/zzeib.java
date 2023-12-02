package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzeib implements com.google.android.gms.ads.internal.zzf {
    final /* synthetic */ zzddo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeib(zzeic zzeicVar, zzddo zzddoVar) {
        this.zza = zzddoVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzb() {
        this.zza.zzb().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzc() {
        this.zza.zzc().zza();
        this.zza.zzf().zza();
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zza(View view) {
    }
}
