package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes5.dex */
final class zzx implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskQueue f33051a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzx(TaskQueue taskQueue, zzw zzwVar) {
        AtomicReference atomicReference;
        boolean z3;
        this.f33051a = taskQueue;
        atomicReference = taskQueue.f32982d;
        if (((Thread) atomicReference.getAndSet(Thread.currentThread())) == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AtomicReference atomicReference;
        atomicReference = this.f33051a.f32982d;
        atomicReference.set(null);
        this.f33051a.c();
    }
}
