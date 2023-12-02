package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdle implements zzbee {
    final /* synthetic */ String zza = "_videoMediaView";
    final /* synthetic */ zzdlf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdle(zzdlf zzdlfVar, String str) {
        this.zzb = zzdlfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    public final JSONObject zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    public final JSONObject zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    public final void zzc() {
        zzdgv zzdgvVar;
        zzdgv zzdgvVar2;
        zzdlf zzdlfVar = this.zzb;
        zzdgvVar = zzdlfVar.zzd;
        if (zzdgvVar != null) {
            zzdgvVar2 = zzdlfVar.zzd;
            zzdgvVar2.zzE(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    public final void zzd(MotionEvent motionEvent) {
    }
}
