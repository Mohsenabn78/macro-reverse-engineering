package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgh implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21688a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21689b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f21690c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzgv f21691d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgh(zzgv zzgvVar, String str, String str2, String str3) {
        this.f21691d = zzgvVar;
        this.f21688a = str;
        this.f21689b = str2;
        this.f21690c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlhVar = this.f21691d.f21731a;
        zzlhVar.a();
        zzlhVar2 = this.f21691d.f21731a;
        return zzlhVar2.zzh().T(this.f21688a, this.f21689b, this.f21690c);
    }
}
