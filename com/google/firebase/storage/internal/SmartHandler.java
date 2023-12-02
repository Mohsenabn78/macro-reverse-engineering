package com.google.firebase.storage.internal;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.storage.StorageTaskScheduler;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class SmartHandler {

    /* renamed from: b  reason: collision with root package name */
    static boolean f32367b = false;

    /* renamed from: a  reason: collision with root package name */
    private final Executor f32368a;

    @SuppressLint({"ThreadPoolCreation"})
    public SmartHandler(@Nullable Executor executor) {
        if (executor == null) {
            if (!f32367b) {
                this.f32368a = StorageTaskScheduler.getInstance().getMainThreadExecutor();
                return;
            } else {
                this.f32368a = null;
                return;
            }
        }
        this.f32368a = executor;
    }

    public void callBack(@NonNull Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        Executor executor = this.f32368a;
        if (executor != null) {
            executor.execute(runnable);
        } else {
            StorageTaskScheduler.getInstance().scheduleCallback(runnable);
        }
    }
}
