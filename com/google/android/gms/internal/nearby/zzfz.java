package com.google.android.gms.internal.nearby;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@VisibleForTesting
@Deprecated
/* loaded from: classes4.dex */
final class zzfz extends zzjp {
    private final ListenerHolder zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfz(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzjq
    public final void zzb(zzkv zzkvVar) {
        this.zza.notifyListener(new zzfy(this, zzkvVar));
    }
}
