package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgi implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21692a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21693b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f21694c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzgv f21695d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgi(zzgv zzgvVar, String str, String str2, String str3) {
        this.f21695d = zzgvVar;
        this.f21692a = str;
        this.f21693b = str2;
        this.f21694c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlhVar = this.f21695d.f21731a;
        zzlhVar.a();
        zzlhVar2 = this.f21695d.f21731a;
        return zzlhVar2.zzh().T(this.f21692a, this.f21693b, this.f21694c);
    }
}
