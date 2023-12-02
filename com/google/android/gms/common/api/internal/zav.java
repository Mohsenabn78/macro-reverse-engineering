package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zav implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zaaa f20335a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zav(zaaa zaaaVar) {
        this.f20335a = zaaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        lock = this.f20335a.f20125m;
        lock.lock();
        try {
            zaaa.p(this.f20335a);
        } finally {
            lock2 = this.f20335a.f20125m;
            lock2.unlock();
        }
    }
}
