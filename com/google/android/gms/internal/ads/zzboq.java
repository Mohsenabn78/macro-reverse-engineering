package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
final class zzboq implements InitializationCompleteCallback {
    final /* synthetic */ zzbkj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzboq(zzbow zzbowVar, zzbkj zzbkjVar) {
        this.zza = zzbkjVar;
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationFailed(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
        }
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationSucceeded() {
        try {
            this.zza.zzf();
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
        }
    }
}
