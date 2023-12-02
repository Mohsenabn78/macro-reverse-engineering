package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21706a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzgv f21707b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgm(zzgv zzgvVar, zzq zzqVar) {
        this.f21707b = zzgvVar;
        this.f21706a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlhVar = this.f21707b.f21731a;
        zzlhVar.a();
        zzlhVar2 = this.f21707b.f21731a;
        zzq zzqVar = this.f21706a;
        zzlhVar2.zzaB().zzg();
        zzlhVar2.b();
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzlhVar2.M(zzqVar);
    }
}
