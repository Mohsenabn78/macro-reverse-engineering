package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21914a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf f21915b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzjz f21916c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjf(zzjz zzjzVar, zzq zzqVar, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.f21916c = zzjzVar;
        this.f21914a = zzqVar;
        this.f21915b = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgd zzgdVar;
        zzej zzejVar;
        String str = null;
        try {
            try {
                if (!this.f21916c.f21734a.zzm().f().zzj(zzha.ANALYTICS_STORAGE)) {
                    this.f21916c.f21734a.zzaA().zzl().zza("Analytics storage consent denied; will not get app instance id");
                    this.f21916c.f21734a.zzq().k(null);
                    this.f21916c.f21734a.zzm().f21595g.zzb(null);
                    zzgdVar = this.f21916c.f21734a;
                } else {
                    zzjz zzjzVar = this.f21916c;
                    zzejVar = zzjzVar.f21972d;
                    if (zzejVar == null) {
                        zzjzVar.f21734a.zzaA().zzd().zza("Failed to get app instance id");
                        zzgdVar = this.f21916c.f21734a;
                    } else {
                        Preconditions.checkNotNull(this.f21914a);
                        str = zzejVar.zzd(this.f21914a);
                        if (str != null) {
                            this.f21916c.f21734a.zzq().k(str);
                            this.f21916c.f21734a.zzm().f21595g.zzb(str);
                        }
                        this.f21916c.q();
                        zzgdVar = this.f21916c.f21734a;
                    }
                }
            } catch (RemoteException e4) {
                this.f21916c.f21734a.zzaA().zzd().zzb("Failed to get app instance id", e4);
                zzgdVar = this.f21916c.f21734a;
            }
            zzgdVar.zzv().zzW(this.f21915b, str);
        } catch (Throwable th) {
            this.f21916c.f21734a.zzv().zzW(this.f21915b, null);
            throw th;
        }
    }
}
