package com.google.android.gms.internal.appset;

import androidx.annotation.Nullable;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
/* loaded from: classes4.dex */
final class zzo extends zze {
    final /* synthetic */ TaskCompletionSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzp zzpVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.appset.zzf
    public final void zzb(Status status, @Nullable com.google.android.gms.appset.zzc zzcVar) {
        AppSetIdInfo appSetIdInfo;
        if (zzcVar != null) {
            appSetIdInfo = new AppSetIdInfo(zzcVar.zzb(), zzcVar.zza());
        } else {
            appSetIdInfo = null;
        }
        TaskUtil.setResultOrApiException(status, appSetIdInfo, this.zza);
    }
}
