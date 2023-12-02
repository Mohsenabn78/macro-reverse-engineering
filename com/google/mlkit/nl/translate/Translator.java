package com.google.mlkit.nl.translate;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.DownloadConditions;
import java.io.Closeable;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public interface Translator extends Closeable, LifecycleObserver {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void close();

    @NonNull
    Task<Void> downloadModelIfNeeded();

    @NonNull
    Task<Void> downloadModelIfNeeded(@NonNull DownloadConditions downloadConditions);

    @NonNull
    Task<String> translate(@NonNull String str);
}
