package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.Message;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzak implements zzbc {
    public final /* synthetic */ Message zza;

    public /* synthetic */ zzak(Message message) {
        this.zza = message;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbc
    public final void zza(zzai zzaiVar, ListenerHolder listenerHolder) {
        Message message = this.zza;
        int i4 = zzbh.zza;
        zzaiVar.m(listenerHolder, zzae.zza(message));
    }
}
