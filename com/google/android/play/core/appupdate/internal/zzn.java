package com.google.android.play.core.appupdate.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public abstract class zzn implements Runnable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final TaskCompletionSource f25187a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn() {
        this.f25187a = null;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final TaskCompletionSource b() {
        return this.f25187a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e4) {
            zzc(e4);
        }
    }

    public final void zzc(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f25187a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    public zzn(@Nullable TaskCompletionSource taskCompletionSource) {
        this.f25187a = taskCompletionSource;
    }
}
