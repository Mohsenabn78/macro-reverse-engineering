package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbkc implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzcaj zza;
    final /* synthetic */ zzbke zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkc(zzbke zzbkeVar, zzcaj zzcajVar) {
        this.zzb = zzbkeVar;
        this.zza = zzcajVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        zzbjr zzbjrVar;
        try {
            zzcaj zzcajVar = this.zza;
            zzbjrVar = this.zzb.zza;
            zzcajVar.zzd(zzbjrVar.zzp());
        } catch (DeadObjectException e4) {
            this.zza.zze(e4);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i4) {
        zzcaj zzcajVar = this.zza;
        zzcajVar.zze(new RuntimeException("onConnectionSuspended: " + i4));
    }
}
