package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgk implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21700a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21701b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f21702c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzgv f21703d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgk(zzgv zzgvVar, String str, String str2, String str3) {
        this.f21703d = zzgvVar;
        this.f21700a = str;
        this.f21701b = str2;
        this.f21702c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlhVar = this.f21703d.f21731a;
        zzlhVar.a();
        zzlhVar2 = this.f21703d.f21731a;
        return zzlhVar2.zzh().Q(this.f21700a, this.f21701b, this.f21702c);
    }
}
