package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
abstract class zaav implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zaaw f20157a;

    @WorkerThread
    protected abstract void a();

    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        Lock lock;
        Lock lock2;
        zabi zabiVar;
        Lock lock3;
        lock = this.f20157a.f20159b;
        lock.lock();
        try {
            try {
                if (Thread.interrupted()) {
                    lock3 = this.f20157a.f20159b;
                } else {
                    a();
                    lock3 = this.f20157a.f20159b;
                }
            } catch (RuntimeException e4) {
                zabiVar = this.f20157a.f20158a;
                zabiVar.g(e4);
                lock3 = this.f20157a.f20159b;
            }
            lock3.unlock();
        } catch (Throwable th) {
            lock2 = this.f20157a.f20159b;
            lock2.unlock();
            throw th;
        }
    }
}
