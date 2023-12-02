package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzezj implements OnAdMetadataChangedListener {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzby zza;
    final /* synthetic */ zzezk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzezj(zzezk zzezkVar, com.google.android.gms.ads.internal.client.zzby zzbyVar) {
        this.zzb = zzezkVar;
        this.zza = zzbyVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzdmm zzdmmVar;
        zzdmmVar = this.zzb.zzd;
        if (zzdmmVar != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e4) {
                zzbzr.zzl("#007 Could not call remote method.", e4);
            }
        }
    }
}
