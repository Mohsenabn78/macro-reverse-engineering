package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzns extends com.google.android.gms.nearby.messages.internal.zzx {
    private final ListenerHolder zza;

    public zzns(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzy
    public final void zzd(boolean z3) {
        this.zza.notifyListener(new zznr(this, z3));
    }
}
