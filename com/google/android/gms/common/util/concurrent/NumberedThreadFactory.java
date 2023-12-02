package com.google.android.gms.common.util.concurrent;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class NumberedThreadFactory implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f20751a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f20752b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    private final ThreadFactory f20753c = Executors.defaultThreadFactory();

    @KeepForSdk
    public NumberedThreadFactory(@NonNull String str) {
        Preconditions.checkNotNull(str, "Name must not be null");
        this.f20751a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @NonNull
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread newThread = this.f20753c.newThread(new zza(runnable, 0));
        String str = this.f20751a;
        int andIncrement = this.f20752b.getAndIncrement();
        newThread.setName(str + "[" + andIncrement + "]");
        return newThread;
    }
}
