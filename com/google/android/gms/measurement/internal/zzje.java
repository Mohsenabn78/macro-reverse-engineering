package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzje implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21911a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f21912b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzjz f21913c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzje(zzjz zzjzVar, AtomicReference atomicReference, zzq zzqVar) {
        this.f21913c = zzjzVar;
        this.f21911a = atomicReference;
        this.f21912b = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzej zzejVar;
        synchronized (this.f21911a) {
            try {
            } catch (RemoteException e4) {
                this.f21913c.f21734a.zzaA().zzd().zzb("Failed to get app instance id", e4);
                atomicReference = this.f21911a;
            }
            if (!this.f21913c.f21734a.zzm().f().zzj(zzha.ANALYTICS_STORAGE)) {
                this.f21913c.f21734a.zzaA().zzl().zza("Analytics storage consent denied; will not get app instance id");
                this.f21913c.f21734a.zzq().k(null);
                this.f21913c.f21734a.zzm().f21595g.zzb(null);
                this.f21911a.set(null);
                this.f21911a.notify();
                return;
            }
            zzjz zzjzVar = this.f21913c;
            zzejVar = zzjzVar.f21972d;
            if (zzejVar == null) {
                zzjzVar.f21734a.zzaA().zzd().zza("Failed to get app instance id");
                this.f21911a.notify();
                return;
            }
            Preconditions.checkNotNull(this.f21912b);
            this.f21911a.set(zzejVar.zzd(this.f21912b));
            String str = (String) this.f21911a.get();
            if (str != null) {
                this.f21913c.f21734a.zzq().k(str);
                this.f21913c.f21734a.zzm().f21595g.zzb(str);
            }
            this.f21913c.q();
            atomicReference = this.f21911a;
            atomicReference.notify();
        }
    }
}
