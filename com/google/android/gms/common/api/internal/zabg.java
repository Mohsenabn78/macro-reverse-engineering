package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
abstract class zabg {

    /* renamed from: a  reason: collision with root package name */
    private final zabf f20216a;

    /* JADX INFO: Access modifiers changed from: protected */
    public zabg(zabf zabfVar) {
        this.f20216a = zabfVar;
    }

    protected abstract void a();

    public final void b(zabi zabiVar) {
        Lock lock;
        Lock lock2;
        zabf zabfVar;
        Lock lock3;
        lock = zabiVar.f20218a;
        lock.lock();
        try {
            zabfVar = zabiVar.f20228k;
            if (zabfVar != this.f20216a) {
                lock3 = zabiVar.f20218a;
            } else {
                a();
                lock3 = zabiVar.f20218a;
            }
            lock3.unlock();
        } catch (Throwable th) {
            lock2 = zabiVar.f20218a;
            lock2.unlock();
            throw th;
        }
    }
}
