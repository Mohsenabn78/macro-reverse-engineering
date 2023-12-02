package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzawg implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzawh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawg(zzawh zzawhVar) {
        this.zza = zzawhVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Object obj;
        zzawk zzawkVar;
        Object obj2;
        obj = this.zza.zzc;
        synchronized (obj) {
            this.zza.zzf = null;
            zzawh zzawhVar = this.zza;
            zzawkVar = zzawhVar.zzd;
            if (zzawkVar != null) {
                zzawhVar.zzd = null;
            }
            obj2 = this.zza.zzc;
            obj2.notifyAll();
        }
    }
}
