package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdmh extends VideoController.VideoLifecycleCallbacks {
    private final zzdha zza;

    public zzdmh(zzdha zzdhaVar) {
        this.zza = zzdhaVar;
    }

    @Nullable
    private static com.google.android.gms.ads.internal.client.zzdt zza(zzdha zzdhaVar) {
        com.google.android.gms.ads.internal.client.zzdq zzj = zzdhaVar.zzj();
        if (zzj == null) {
            return null;
        }
        try {
            return zzj.zzi();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoEnd() {
        com.google.android.gms.ads.internal.client.zzdt zza = zza(this.zza);
        if (zza == null) {
            return;
        }
        try {
            zza.zze();
        } catch (RemoteException e4) {
            zzbzr.zzk("Unable to call onVideoEnd()", e4);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoPause() {
        com.google.android.gms.ads.internal.client.zzdt zza = zza(this.zza);
        if (zza == null) {
            return;
        }
        try {
            zza.zzg();
        } catch (RemoteException e4) {
            zzbzr.zzk("Unable to call onVideoEnd()", e4);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoStart() {
        com.google.android.gms.ads.internal.client.zzdt zza = zza(this.zza);
        if (zza == null) {
            return;
        }
        try {
            zza.zzi();
        } catch (RemoteException e4) {
            zzbzr.zzk("Unable to call onVideoEnd()", e4);
        }
    }
}
