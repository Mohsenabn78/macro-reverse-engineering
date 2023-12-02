package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzic implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21822a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzik f21823b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzic(zzik zzikVar, AtomicReference atomicReference) {
        this.f21823b = zzikVar;
        this.f21822a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f21822a) {
            this.f21822a.set(Integer.valueOf(this.f21823b.f21734a.zzf().zze(this.f21823b.f21734a.zzh().zzl(), zzeg.zzN)));
            this.f21822a.notify();
        }
    }
}
