package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzie implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Boolean f21826a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzik f21827b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzie(zzik zzikVar, Boolean bool) {
        this.f21827b = zzikVar;
        this.f21826a = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21827b.n(this.f21826a, true);
    }
}
