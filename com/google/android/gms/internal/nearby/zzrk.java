package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingCapabilities;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzrk extends zzot {
    final /* synthetic */ TaskCompletionSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrk(zzrv zzrvVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzou
    public final void zzd(zzpv zzpvVar) {
        this.zza.setResult(new RangingCapabilities(zzpvVar.zzd(), zzpvVar.zzc(), zzpvVar.zze(), zzpvVar.zzb(), zztp.zzb(zzpvVar.zzf()), zztp.zzb(zzpvVar.zzh()), zztp.zzb(zzpvVar.zzg()), zzpvVar.zza()));
    }
}
