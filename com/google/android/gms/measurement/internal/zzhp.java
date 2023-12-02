package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21779a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21780b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f21781c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Bundle f21782d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f21783e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ boolean f21784f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ boolean f21785g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ String f21786h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ zzik f21787i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhp(zzik zzikVar, String str, String str2, long j4, Bundle bundle, boolean z3, boolean z4, boolean z5, String str3) {
        this.f21787i = zzikVar;
        this.f21779a = str;
        this.f21780b = str2;
        this.f21781c = j4;
        this.f21782d = bundle;
        this.f21783e = z3;
        this.f21784f = z4;
        this.f21785g = z5;
        this.f21786h = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21787i.g(this.f21779a, this.f21780b, this.f21781c, this.f21782d, this.f21783e, this.f21784f, this.f21785g, this.f21786h);
    }
}
