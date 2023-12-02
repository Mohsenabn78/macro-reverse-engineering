package com.google.firebase.storage;

import android.app.Activity;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public abstract class ControllableTask<StateT> extends CancellableTask<StateT> {
    @NonNull
    public abstract ControllableTask<StateT> addOnPausedListener(@NonNull Activity activity, @NonNull OnPausedListener<? super StateT> onPausedListener);

    @NonNull
    public abstract ControllableTask<StateT> addOnPausedListener(@NonNull OnPausedListener<? super StateT> onPausedListener);

    @NonNull
    public abstract ControllableTask<StateT> addOnPausedListener(@NonNull Executor executor, @NonNull OnPausedListener<? super StateT> onPausedListener);

    public abstract boolean isPaused();

    public abstract boolean pause();

    public abstract boolean resume();
}
