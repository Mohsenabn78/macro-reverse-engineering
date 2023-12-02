package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzid implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21824a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzik f21825b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzid(zzik zzikVar, AtomicReference atomicReference) {
        this.f21825b = zzikVar;
        this.f21824a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f21824a) {
            this.f21824a.set(Double.valueOf(this.f21825b.f21734a.zzf().zza(this.f21825b.f21734a.zzh().zzl(), zzeg.zzO)));
            this.f21824a.notify();
        }
    }
}
