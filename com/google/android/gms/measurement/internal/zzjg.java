package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21917a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjz f21918b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjg(zzjz zzjzVar, zzq zzqVar) {
        this.f21918b = zzjzVar;
        this.f21917a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzej zzejVar;
        zzjz zzjzVar = this.f21918b;
        zzejVar = zzjzVar.f21972d;
        if (zzejVar == null) {
            zzjzVar.f21734a.zzaA().zzd().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.f21917a);
            zzejVar.zzj(this.f21917a);
            this.f21918b.f21734a.zzi().zzm();
            this.f21918b.f(zzejVar, null, this.f21917a);
            this.f21918b.q();
        } catch (RemoteException e4) {
            this.f21918b.f21734a.zzaA().zzd().zzb("Failed to send app launch to the service", e4);
        }
    }
}
