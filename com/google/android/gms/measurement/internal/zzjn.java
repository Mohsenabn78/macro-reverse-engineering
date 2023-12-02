package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21932a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjz f21933b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjn(zzjz zzjzVar, zzq zzqVar) {
        this.f21933b = zzjzVar;
        this.f21932a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzej zzejVar;
        zzjz zzjzVar = this.f21933b;
        zzejVar = zzjzVar.f21972d;
        if (zzejVar == null) {
            zzjzVar.f21734a.zzaA().zzd().zza("Failed to send consent settings to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.f21932a);
            zzejVar.zzp(this.f21932a);
            this.f21933b.q();
        } catch (RemoteException e4) {
            this.f21933b.f21734a.zzaA().zzd().zzb("Failed to send consent settings to the service", e4);
        }
    }
}
