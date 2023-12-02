package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzia implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21818a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzik f21819b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzia(zzik zzikVar, AtomicReference atomicReference) {
        this.f21819b = zzikVar;
        this.f21818a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f21818a) {
            this.f21818a.set(this.f21819b.f21734a.zzf().zzo(this.f21819b.f21734a.zzh().zzl(), zzeg.zzL));
            this.f21818a.notify();
        }
    }
}
