package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTaskInput;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public abstract class MLTask<T, S extends MLTaskInput> extends ModelResource {
    @NonNull
    @KeepForSdk
    @WorkerThread
    public abstract T run(@NonNull S s3) throws MlKitException;
}
