package com.google.android.gms.internal.nearby;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@VisibleForTesting
@Deprecated
/* loaded from: classes4.dex */
final class zzgo extends zzjs {
    private final Context zza;
    private final ListenerHolder zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgo(Context context, ListenerHolder listenerHolder) {
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzb = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzjt
    public final void zzc(zzlb zzlbVar) {
        this.zzb.notifyListener(new zzgn(this, zzlbVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzjt
    public final void zzd(zzlj zzljVar) {
        this.zzb.notifyListener(new zzgm(this, zzljVar));
    }
}
