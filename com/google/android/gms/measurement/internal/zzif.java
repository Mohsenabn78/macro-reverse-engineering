package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzqu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzif implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzhb f21828a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f21829b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f21830c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f21831d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzhb f21832e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzik f21833f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzif(zzik zzikVar, zzhb zzhbVar, long j4, long j5, boolean z3, zzhb zzhbVar2) {
        this.f21833f = zzikVar;
        this.f21828a = zzhbVar;
        this.f21829b = j4;
        this.f21830c = j5;
        this.f21831d = z3;
        this.f21832e = zzhbVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21833f.l(this.f21828a);
        this.f21833f.h(this.f21829b, false);
        zzik.q(this.f21833f, this.f21828a, this.f21830c, true, this.f21831d);
        zzqu.zzc();
        if (this.f21833f.f21734a.zzf().zzs(null, zzeg.zzan)) {
            zzik.p(this.f21833f, this.f21828a, this.f21832e);
        }
    }
}
