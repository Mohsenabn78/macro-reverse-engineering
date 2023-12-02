package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21806a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzik f21807b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhw(zzik zzikVar, AtomicReference atomicReference) {
        this.f21807b = zzikVar;
        this.f21806a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f21806a) {
            this.f21806a.set(Boolean.valueOf(this.f21807b.f21734a.zzf().zzs(this.f21807b.f21734a.zzh().zzl(), zzeg.zzK)));
            this.f21806a.notify();
        }
    }
}
