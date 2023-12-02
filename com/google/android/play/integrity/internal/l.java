package com.google.android.play.integrity.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public abstract class l implements Runnable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final TaskCompletionSource f25338a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l() {
        this.f25338a = null;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f25338a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final TaskCompletionSource c() {
        return this.f25338a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b();
        } catch (Exception e4) {
            a(e4);
        }
    }

    public l(@Nullable TaskCompletionSource taskCompletionSource) {
        this.f25338a = taskCompletionSource;
    }
}
