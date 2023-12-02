package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21930a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjz f21931b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjm(zzjz zzjzVar, zzq zzqVar) {
        this.f21931b = zzjzVar;
        this.f21930a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzej zzejVar;
        zzjz zzjzVar = this.f21931b;
        zzejVar = zzjzVar.f21972d;
        if (zzejVar == null) {
            zzjzVar.f21734a.zzaA().zzd().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.f21930a);
            zzejVar.zzs(this.f21930a);
            this.f21931b.q();
        } catch (RemoteException e4) {
            this.f21931b.f21734a.zzaA().zzd().zzb("Failed to send measurementEnabled to the service", e4);
        }
    }
}
