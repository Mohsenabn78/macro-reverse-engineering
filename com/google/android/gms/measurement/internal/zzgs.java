package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgs implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21722a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzgv f21723b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgs(zzgv zzgvVar, String str) {
        this.f21723b = zzgvVar;
        this.f21722a = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlhVar = this.f21723b.f21731a;
        zzlhVar.a();
        zzlhVar2 = this.f21723b.f21731a;
        return zzlhVar2.zzh().S(this.f21722a);
    }
}
