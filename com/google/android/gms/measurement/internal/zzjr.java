package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21949a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21950b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzq f21951c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf f21952d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzjz f21953e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjr(zzjz zzjzVar, String str, String str2, zzq zzqVar, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.f21953e = zzjzVar;
        this.f21949a = str;
        this.f21950b = str2;
        this.f21951c = zzqVar;
        this.f21952d = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgd zzgdVar;
        zzej zzejVar;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                zzjz zzjzVar = this.f21953e;
                zzejVar = zzjzVar.f21972d;
                if (zzejVar == null) {
                    zzjzVar.f21734a.zzaA().zzd().zzc("Failed to get conditional properties; not connected to service", this.f21949a, this.f21950b);
                    zzgdVar = this.f21953e.f21734a;
                } else {
                    Preconditions.checkNotNull(this.f21951c);
                    arrayList = zzlp.zzH(zzejVar.zzf(this.f21949a, this.f21950b, this.f21951c));
                    this.f21953e.q();
                    zzgdVar = this.f21953e.f21734a;
                }
            } catch (RemoteException e4) {
                this.f21953e.f21734a.zzaA().zzd().zzd("Failed to get conditional properties; remote exception", this.f21949a, this.f21950b, e4);
                zzgdVar = this.f21953e.f21734a;
            }
            zzgdVar.zzv().zzR(this.f21952d, arrayList);
        } catch (Throwable th) {
            this.f21953e.f21734a.zzv().zzR(this.f21952d, arrayList);
            throw th;
        }
    }
}
