package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzawf implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzawh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawf(zzawh zzawhVar) {
        this.zza = zzawhVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        Object obj;
        Object obj2;
        zzawk zzawkVar;
        zzawk zzawkVar2;
        obj = this.zza.zzc;
        synchronized (obj) {
            try {
                zzawh zzawhVar = this.zza;
                zzawkVar = zzawhVar.zzd;
                if (zzawkVar != null) {
                    zzawkVar2 = zzawhVar.zzd;
                    zzawhVar.zzf = zzawkVar2.zzq();
                }
            } catch (DeadObjectException e4) {
                zzbzr.zzh("Unable to obtain a cache service instance.", e4);
                zzawh.zzh(this.zza);
            }
            obj2 = this.zza.zzc;
            obj2.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i4) {
        Object obj;
        Object obj2;
        obj = this.zza.zzc;
        synchronized (obj) {
            this.zza.zzf = null;
            obj2 = this.zza.zzc;
            obj2.notifyAll();
        }
    }
}
