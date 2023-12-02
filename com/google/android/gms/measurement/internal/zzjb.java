package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21901a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f21902b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f21903c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzjz f21904d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjb(zzjz zzjzVar, AtomicReference atomicReference, zzq zzqVar, boolean z3) {
        this.f21904d = zzjzVar;
        this.f21901a = atomicReference;
        this.f21902b = zzqVar;
        this.f21903c = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzjz zzjzVar;
        zzej zzejVar;
        synchronized (this.f21901a) {
            try {
                zzjzVar = this.f21904d;
                zzejVar = zzjzVar.f21972d;
            } catch (RemoteException e4) {
                this.f21904d.f21734a.zzaA().zzd().zzb("Failed to get all user properties; remote exception", e4);
                atomicReference = this.f21901a;
            }
            if (zzejVar == null) {
                zzjzVar.f21734a.zzaA().zzd().zza("Failed to get all user properties; not connected to service");
                this.f21901a.notify();
                return;
            }
            Preconditions.checkNotNull(this.f21902b);
            this.f21901a.set(zzejVar.zze(this.f21902b, this.f21903c));
            this.f21904d.q();
            atomicReference = this.f21901a;
            atomicReference.notify();
        }
    }
}
