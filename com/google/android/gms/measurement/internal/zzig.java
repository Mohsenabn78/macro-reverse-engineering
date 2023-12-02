package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzqu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzig implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzhb f21834a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f21835b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f21836c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzhb f21837d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzik f21838e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzig(zzik zzikVar, zzhb zzhbVar, long j4, boolean z3, zzhb zzhbVar2) {
        this.f21838e = zzikVar;
        this.f21834a = zzhbVar;
        this.f21835b = j4;
        this.f21836c = z3;
        this.f21837d = zzhbVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21838e.l(this.f21834a);
        zzik.q(this.f21838e, this.f21834a, this.f21835b, false, this.f21836c);
        zzqu.zzc();
        if (this.f21838e.f21734a.zzf().zzs(null, zzeg.zzan)) {
            zzik.p(this.f21838e, this.f21834a, this.f21837d);
        }
    }
}
