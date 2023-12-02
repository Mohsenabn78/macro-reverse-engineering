package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzit implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f21864a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzir f21865b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzir f21866c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f21867d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zziz f21868e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzit(zziz zzizVar, Bundle bundle, zzir zzirVar, zzir zzirVar2, long j4) {
        this.f21868e = zzizVar;
        this.f21864a = bundle;
        this.f21865b = zzirVar;
        this.f21866c = zzirVar2;
        this.f21867d = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zziz.j(this.f21868e, this.f21864a, this.f21865b, this.f21866c, this.f21867d);
    }
}
