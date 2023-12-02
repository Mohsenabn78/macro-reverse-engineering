package com.google.firebase.storage;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public abstract class CancellableTask<StateT> extends Task<StateT> {
    @NonNull
    public abstract CancellableTask<StateT> addOnProgressListener(@NonNull Activity activity, @NonNull OnProgressListener<? super StateT> onProgressListener);

    @NonNull
    public abstract CancellableTask<StateT> addOnProgressListener(@NonNull OnProgressListener<? super StateT> onProgressListener);

    @NonNull
    public abstract CancellableTask<StateT> addOnProgressListener(@NonNull Executor executor, @NonNull OnProgressListener<? super StateT> onProgressListener);

    public abstract boolean cancel();

    @Override // com.google.android.gms.tasks.Task
    public abstract boolean isCanceled();

    public abstract boolean isInProgress();
}
