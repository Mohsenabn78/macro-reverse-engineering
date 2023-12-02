package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class ExecutorSelector {

    /* renamed from: a  reason: collision with root package name */
    private final Provider f32959a;

    public ExecutorSelector(@NonNull Provider provider) {
        this.f32959a = provider;
    }

    @NonNull
    @KeepForSdk
    public Executor getExecutorToUse(@Nullable Executor executor) {
        if (executor != null) {
            return executor;
        }
        return (Executor) this.f32959a.get();
    }
}
