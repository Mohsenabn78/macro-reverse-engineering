package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21939a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f21940b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzac f21941c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzac f21942d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzjz f21943e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjp(zzjz zzjzVar, boolean z3, zzq zzqVar, boolean z4, zzac zzacVar, zzac zzacVar2) {
        this.f21943e = zzjzVar;
        this.f21939a = zzqVar;
        this.f21940b = z4;
        this.f21941c = zzacVar;
        this.f21942d = zzacVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzej zzejVar;
        zzac zzacVar;
        zzjz zzjzVar = this.f21943e;
        zzejVar = zzjzVar.f21972d;
        if (zzejVar == null) {
            zzjzVar.f21734a.zzaA().zzd().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Preconditions.checkNotNull(this.f21939a);
        zzjz zzjzVar2 = this.f21943e;
        if (this.f21940b) {
            zzacVar = null;
        } else {
            zzacVar = this.f21941c;
        }
        zzjzVar2.f(zzejVar, zzacVar, this.f21939a);
        this.f21943e.q();
    }
}
