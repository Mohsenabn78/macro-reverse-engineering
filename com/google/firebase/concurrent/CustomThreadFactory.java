package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class CustomThreadFactory implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadFactory f29253e = Executors.defaultThreadFactory();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f29254a = new AtomicLong();

    /* renamed from: b  reason: collision with root package name */
    private final String f29255b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29256c;

    /* renamed from: d  reason: collision with root package name */
    private final StrictMode.ThreadPolicy f29257d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomThreadFactory(String str, int i4, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        this.f29255b = str;
        this.f29256c = i4;
        this.f29257d = threadPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        Process.setThreadPriority(this.f29256c);
        StrictMode.ThreadPolicy threadPolicy = this.f29257d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread newThread = f29253e.newThread(new Runnable() { // from class: com.google.firebase.concurrent.a
            @Override // java.lang.Runnable
            public final void run() {
                CustomThreadFactory.this.b(runnable);
            }
        });
        newThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f29255b, Long.valueOf(this.f29254a.getAndIncrement())));
        return newThread;
    }
}
