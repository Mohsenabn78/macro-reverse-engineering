package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.UwbAddress;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzrl extends zzpc {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzrv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrl(zzrv zzrvVar, TaskCompletionSource taskCompletionSource) {
        this.zzb = zzrvVar;
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzpd
    public final void zzd(zzqt zzqtVar) {
        UwbAddress uwbAddress;
        this.zzb.zzc = new UwbAddress(zzqtVar.zzb());
        TaskCompletionSource taskCompletionSource = this.zza;
        uwbAddress = this.zzb.zzc;
        taskCompletionSource.setResult(uwbAddress);
    }
}
