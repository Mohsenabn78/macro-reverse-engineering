package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21909a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjz f21910b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjd(zzjz zzjzVar, zzq zzqVar) {
        this.f21910b = zzjzVar;
        this.f21909a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzej zzejVar;
        zzjz zzjzVar = this.f21910b;
        zzejVar = zzjzVar.f21972d;
        if (zzejVar == null) {
            zzjzVar.f21734a.zzaA().zzd().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.f21909a);
            zzejVar.zzm(this.f21909a);
        } catch (RemoteException e4) {
            this.f21910b.f21734a.zzaA().zzd().zzb("Failed to reset data on the service: remote exception", e4);
        }
        this.f21910b.q();
    }
}
