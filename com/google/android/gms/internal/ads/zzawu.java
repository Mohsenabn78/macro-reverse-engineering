package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzawu implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzcaj zza;
    final /* synthetic */ zzawv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawu(zzawv zzawvVar, zzcaj zzcajVar) {
        this.zzb = zzawvVar;
        this.zza = zzcajVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Object obj;
        obj = this.zzb.zzd;
        synchronized (obj) {
            this.zza.zze(new RuntimeException("Connection failed."));
        }
    }
}
