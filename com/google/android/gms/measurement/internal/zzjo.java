package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21934a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f21935b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzau f21936c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f21937d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzjz f21938e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjo(zzjz zzjzVar, boolean z3, zzq zzqVar, boolean z4, zzau zzauVar, String str) {
        this.f21938e = zzjzVar;
        this.f21934a = zzqVar;
        this.f21935b = z4;
        this.f21936c = zzauVar;
        this.f21937d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzej zzejVar;
        zzau zzauVar;
        zzjz zzjzVar = this.f21938e;
        zzejVar = zzjzVar.f21972d;
        if (zzejVar == null) {
            zzjzVar.f21734a.zzaA().zzd().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.f21934a);
        zzjz zzjzVar2 = this.f21938e;
        if (this.f21935b) {
            zzauVar = null;
        } else {
            zzauVar = this.f21936c;
        }
        zzjzVar2.f(zzejVar, zzauVar, this.f21934a);
        this.f21938e.q();
    }
}
