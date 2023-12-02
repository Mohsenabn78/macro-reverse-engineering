package com.google.android.gms.internal.nearby;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
final class zzgk extends zzkc {
    private final ListenerHolder zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgk(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzkd
    public final synchronized void zzb(zzld zzldVar) {
    }

    @Override // com.google.android.gms.internal.nearby.zzkd
    public final void zzc(zzlf zzlfVar) {
        this.zza.notifyListener(new zzgi(this, zzlfVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzkd
    public final void zzd(zzlh zzlhVar) {
        this.zza.notifyListener(new zzgj(this, zzlhVar));
    }
}
