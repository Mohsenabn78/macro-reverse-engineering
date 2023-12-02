package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzr implements RemoteCall {
    public final /* synthetic */ zzax zza;

    public /* synthetic */ zzr(zzax zzaxVar) {
        this.zza = zzaxVar;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzai zzaiVar = new zzai(this.zza, (TaskCompletionSource) obj2);
        zzci zzciVar = new zzci();
        zzciVar.zza(zzaiVar);
        ((zzdr) ((zzn) obj).getService()).zzm(zzciVar.zzb());
    }
}
