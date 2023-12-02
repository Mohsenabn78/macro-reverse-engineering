package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21808a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21809b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f21810c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f21811d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzik f21812e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhx(zzik zzikVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z3) {
        this.f21812e = zzikVar;
        this.f21808a = atomicReference;
        this.f21809b = str2;
        this.f21810c = str3;
        this.f21811d = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21812e.f21734a.zzt().G(this.f21808a, null, this.f21809b, this.f21810c, this.f21811d);
    }
}
