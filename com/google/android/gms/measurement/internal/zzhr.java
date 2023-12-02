package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21793a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f21794b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzik f21795c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhr(zzik zzikVar, AtomicReference atomicReference, boolean z3) {
        this.f21795c = zzikVar;
        this.f21793a = atomicReference;
        this.f21794b = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21795c.f21734a.zzt().E(this.f21793a, this.f21794b);
    }
}
