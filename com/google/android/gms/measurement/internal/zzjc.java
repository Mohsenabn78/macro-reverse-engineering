package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21905a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f21906b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzlk f21907c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzjz f21908d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjc(zzjz zzjzVar, zzq zzqVar, boolean z3, zzlk zzlkVar) {
        this.f21908d = zzjzVar;
        this.f21905a = zzqVar;
        this.f21906b = z3;
        this.f21907c = zzlkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzej zzejVar;
        zzlk zzlkVar;
        zzjz zzjzVar = this.f21908d;
        zzejVar = zzjzVar.f21972d;
        if (zzejVar == null) {
            zzjzVar.f21734a.zzaA().zzd().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.f21905a);
        zzjz zzjzVar2 = this.f21908d;
        if (this.f21906b) {
            zzlkVar = null;
        } else {
            zzlkVar = this.f21907c;
        }
        zzjzVar2.f(zzejVar, zzlkVar, this.f21905a);
        this.f21908d.q();
    }
}
