package com.google.android.gms.internal.nearby;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@VisibleForTesting
@Deprecated
/* loaded from: classes4.dex */
final class zzgb extends zzjy {
    private final ListenerHolder zza;

    public zzgb(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzjz
    public final void zzb(zzkx zzkxVar) {
        this.zza.notifyListener(new zzga(this, zzkxVar));
    }
}
