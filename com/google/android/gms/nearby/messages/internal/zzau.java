package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzau implements zzbc {
    public final /* synthetic */ zzbh zza;
    public final /* synthetic */ Message zzb;
    public final /* synthetic */ zzbe zzc;
    public final /* synthetic */ PublishOptions zzd;

    public /* synthetic */ zzau(zzbh zzbhVar, Message message, zzbe zzbeVar, PublishOptions publishOptions) {
        this.zza = zzbhVar;
        this.zzb = message;
        this.zzc = zzbeVar;
        this.zzd = publishOptions;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbc
    public final void zza(zzai zzaiVar, ListenerHolder listenerHolder) {
        this.zza.b(this.zzb, this.zzc, this.zzd, zzaiVar, listenerHolder);
    }
}
