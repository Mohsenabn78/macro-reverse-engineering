package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.uwb.UwbStatusCodes;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzrn extends zzoz {
    final /* synthetic */ TaskCompletionSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrn(zzrv zzrvVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzpa
    public final void zzd(int i4) {
        if (i4 == 42004) {
            this.zza.setException(new SecurityException("Missing UWB_RANGING permission"));
        } else if (i4 != 0) {
            this.zza.setException(new ApiException(new Status(i4, UwbStatusCodes.zza(i4))));
        } else {
            this.zza.setResult(null);
        }
    }
}
