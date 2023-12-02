package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzib implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21820a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzik f21821b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzib(zzik zzikVar, AtomicReference atomicReference) {
        this.f21821b = zzikVar;
        this.f21820a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f21820a) {
            this.f21820a.set(Long.valueOf(this.f21821b.f21734a.zzf().zzi(this.f21821b.f21734a.zzh().zzl(), zzeg.zzM)));
            this.f21820a.notify();
        }
    }
}
