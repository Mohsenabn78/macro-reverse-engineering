package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzir f21919a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjz f21920b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjh(zzjz zzjzVar, zzir zzirVar) {
        this.f21920b = zzjzVar;
        this.f21919a = zzirVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzej zzejVar;
        zzjz zzjzVar = this.f21920b;
        zzejVar = zzjzVar.f21972d;
        if (zzejVar == null) {
            zzjzVar.f21734a.zzaA().zzd().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzir zzirVar = this.f21919a;
            if (zzirVar == null) {
                zzejVar.zzq(0L, null, null, zzjzVar.f21734a.zzaw().getPackageName());
            } else {
                zzejVar.zzq(zzirVar.zzc, zzirVar.zza, zzirVar.zzb, zzjzVar.f21734a.zzaw().getPackageName());
            }
            this.f21920b.q();
        } catch (RemoteException e4) {
            this.f21920b.f21734a.zzaA().zzd().zzb("Failed to send current screen to the service", e4);
        }
    }
}
