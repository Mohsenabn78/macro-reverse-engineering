package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzli f22020a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzlh f22021b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkx(zzlh zzlhVar, zzli zzliVar) {
        this.f22021b = zzlhVar;
        this.f22020a = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlh.S(this.f22021b, this.f22020a);
        this.f22021b.r();
    }
}
