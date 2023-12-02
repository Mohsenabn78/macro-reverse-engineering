package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class HandlerExecutor implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f20748a;

    @KeepForSdk
    public HandlerExecutor(@NonNull Looper looper) {
        this.f20748a = new zzi(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(@NonNull Runnable runnable) {
        this.f20748a.post(runnable);
    }
}
