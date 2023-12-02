package com.google.android.gms.common.api;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(@NonNull Status status);

    @Override // com.google.android.gms.common.api.ResultCallback
    @KeepForSdk
    public final void onResult(@NonNull R r4) {
        Status status = r4.getStatus();
        if (status.isSuccess()) {
            onSuccess(r4);
            return;
        }
        onFailure(status);
        if (r4 instanceof Releasable) {
            try {
                ((Releasable) r4).release();
            } catch (RuntimeException e4) {
                Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(r4)), e4);
            }
        }
    }

    public abstract void onSuccess(@NonNull R r4);
}
