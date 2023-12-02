package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f21796a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzik f21797b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhs(zzik zzikVar, long j4) {
        this.f21797b = zzikVar;
        this.f21796a = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21797b.h(this.f21796a, true);
        this.f21797b.f21734a.zzt().zzu(new AtomicReference());
    }
}
