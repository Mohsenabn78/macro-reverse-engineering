package com.hippo.quickjs.android;

import androidx.annotation.Nullable;
import java.io.Closeable;

/* loaded from: classes6.dex */
public class JSRuntime implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private long f34061a;

    /* renamed from: b  reason: collision with root package name */
    private final QuickJS f34062b;

    /* loaded from: classes6.dex */
    public interface InterruptHandler {
        boolean onInterrupt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSRuntime(long j4, QuickJS quickJS) {
        this.f34061a = j4;
        this.f34062b = quickJS;
    }

    private void b() {
        if (this.f34061a != 0) {
            return;
        }
        throw new IllegalStateException("The JSRuntime is closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        long j4 = this.f34061a;
        if (j4 != 0) {
            this.f34061a = 0L;
            QuickJS.destroyRuntime(j4);
        }
    }

    public synchronized JSContext createJSContext() {
        long createContext;
        b();
        createContext = QuickJS.createContext(this.f34061a);
        if (createContext != 0) {
        } else {
            throw new IllegalStateException("Cannot create JSContext instance");
        }
        return new JSContext(createContext, this.f34062b, this);
    }

    public synchronized void setInterruptHandler(@Nullable InterruptHandler interruptHandler) {
        b();
        QuickJS.setRuntimeInterruptHandler(this.f34061a, interruptHandler);
    }

    public synchronized void setMallocLimit(int i4) {
        b();
        if (i4 != 0 && i4 >= -1) {
            QuickJS.setRuntimeMallocLimit(this.f34061a, i4);
        } else {
            throw new IllegalArgumentException("Only positive number and -1 are accepted as malloc limit");
        }
    }
}
