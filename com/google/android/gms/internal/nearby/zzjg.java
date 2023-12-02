package com.google.android.gms.internal.nearby;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
abstract class zzjg extends zzjd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjg(GoogleApiClient googleApiClient, zzjf zzjfVar) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzje(this, status);
    }
}
