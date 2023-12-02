package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzas extends IStatusCallback.Stub {
    final /* synthetic */ List zza;
    final /* synthetic */ TaskCompletionSource zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzax zzaxVar, List list, TaskCompletionSource taskCompletionSource) {
        this.zza = list;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        for (ParcelFileDescriptor parcelFileDescriptor : this.zza) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e4) {
                Log.w("ExposureNotification", "Failed to close file", e4);
            }
        }
        TaskUtil.trySetResultOrApiException(status, null, this.zzb);
    }
}
