package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.UwbComplexChannel;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzrm extends zzpf {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzrv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrm(zzrv zzrvVar, TaskCompletionSource taskCompletionSource) {
        this.zzb = zzrvVar;
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzpg
    public final void zzd(zzqy zzqyVar) {
        UwbComplexChannel uwbComplexChannel;
        zzrv zzrvVar = this.zzb;
        UwbComplexChannel.Builder builder = new UwbComplexChannel.Builder();
        builder.setChannel(zzqyVar.zza());
        builder.setPreambleIndex(zzqyVar.zzb());
        zzrvVar.zzd = builder.build();
        TaskCompletionSource taskCompletionSource = this.zza;
        uwbComplexChannel = this.zzb.zzd;
        taskCompletionSource.setResult(uwbComplexChannel);
    }
}
