package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzezc implements OnAdMetadataChangedListener {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzdd zza;
    final /* synthetic */ zzeze zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzezc(zzeze zzezeVar, com.google.android.gms.ads.internal.client.zzdd zzddVar) {
        this.zzb = zzezeVar;
        this.zza = zzddVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzdmm zzdmmVar;
        zzdmmVar = this.zzb.zzi;
        if (zzdmmVar != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e4) {
                zzbzr.zzl("#007 Could not call remote method.", e4);
            }
        }
    }
}
