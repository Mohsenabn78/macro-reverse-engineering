package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzgj extends zza {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f22784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgj(zzgl zzglVar, TaskCompletionSource taskCompletionSource) {
        this.f22784a = taskCompletionSource;
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzex
    public final void zzy(zzer zzerVar) {
        TaskUtil.setResultOrApiException(zzhf.zza(zzerVar.zza), zzerVar.zzb, this.f22784a);
    }
}
