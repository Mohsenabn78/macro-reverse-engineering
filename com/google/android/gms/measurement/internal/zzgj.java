package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgj implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21696a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21697b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f21698c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzgv f21699d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgj(zzgv zzgvVar, String str, String str2, String str3) {
        this.f21699d = zzgvVar;
        this.f21696a = str;
        this.f21697b = str2;
        this.f21698c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlhVar = this.f21699d.f21731a;
        zzlhVar.a();
        zzlhVar2 = this.f21699d.f21731a;
        return zzlhVar2.zzh().Q(this.f21696a, this.f21697b, this.f21698c);
    }
}
