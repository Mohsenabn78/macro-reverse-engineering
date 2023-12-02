package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21802a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21803b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f21804c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzik f21805d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhv(zzik zzikVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f21805d = zzikVar;
        this.f21802a = atomicReference;
        this.f21803b = str2;
        this.f21804c = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21805d.f21734a.zzt().D(this.f21802a, null, this.f21803b, this.f21804c);
    }
}
