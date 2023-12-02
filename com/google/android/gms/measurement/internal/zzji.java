package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzji implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21921a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Bundle f21922b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzjz f21923c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzji(zzjz zzjzVar, zzq zzqVar, Bundle bundle) {
        this.f21923c = zzjzVar;
        this.f21921a = zzqVar;
        this.f21922b = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzej zzejVar;
        zzjz zzjzVar = this.f21923c;
        zzejVar = zzjzVar.f21972d;
        if (zzejVar == null) {
            zzjzVar.f21734a.zzaA().zzd().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.f21921a);
            zzejVar.zzr(this.f21922b, this.f21921a);
        } catch (RemoteException e4) {
            this.f21923c.f21734a.zzaA().zzd().zzb("Failed to send default event parameters to service", e4);
        }
    }
}
