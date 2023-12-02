package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzau f21925a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21926b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf f21927c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzjz f21928d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjk(zzjz zzjzVar, zzau zzauVar, String str, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.f21928d = zzjzVar;
        this.f21925a = zzauVar;
        this.f21926b = str;
        this.f21927c = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgd zzgdVar;
        zzej zzejVar;
        byte[] bArr = null;
        try {
            try {
                zzjz zzjzVar = this.f21928d;
                zzejVar = zzjzVar.f21972d;
                if (zzejVar == null) {
                    zzjzVar.f21734a.zzaA().zzd().zza("Discarding data. Failed to send event to service to bundle");
                    zzgdVar = this.f21928d.f21734a;
                } else {
                    bArr = zzejVar.zzu(this.f21925a, this.f21926b);
                    this.f21928d.q();
                    zzgdVar = this.f21928d.f21734a;
                }
            } catch (RemoteException e4) {
                this.f21928d.f21734a.zzaA().zzd().zzb("Failed to send event to the service to bundle", e4);
                zzgdVar = this.f21928d.f21734a;
            }
            zzgdVar.zzv().zzT(this.f21927c, bArr);
        } catch (Throwable th) {
            this.f21928d.f21734a.zzv().zzT(this.f21927c, bArr);
            throw th;
        }
    }
}
