package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzja implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21895a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21896b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzq f21897c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f21898d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf f21899e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzjz f21900f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzja(zzjz zzjzVar, String str, String str2, zzq zzqVar, boolean z3, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.f21900f = zzjzVar;
        this.f21895a = str;
        this.f21896b = str2;
        this.f21897c = zzqVar;
        this.f21898d = z3;
        this.f21899e = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        RemoteException e4;
        zzej zzejVar;
        Bundle bundle2 = new Bundle();
        try {
            zzjz zzjzVar = this.f21900f;
            zzejVar = zzjzVar.f21972d;
            if (zzejVar == null) {
                zzjzVar.f21734a.zzaA().zzd().zzc("Failed to get user properties; not connected to service", this.f21895a, this.f21896b);
                this.f21900f.f21734a.zzv().zzS(this.f21899e, bundle2);
                return;
            }
            Preconditions.checkNotNull(this.f21897c);
            List<zzlk> zzh = zzejVar.zzh(this.f21895a, this.f21896b, this.f21898d, this.f21897c);
            bundle = new Bundle();
            if (zzh != null) {
                for (zzlk zzlkVar : zzh) {
                    String str = zzlkVar.zze;
                    if (str != null) {
                        bundle.putString(zzlkVar.zzb, str);
                    } else {
                        Long l4 = zzlkVar.zzd;
                        if (l4 != null) {
                            bundle.putLong(zzlkVar.zzb, l4.longValue());
                        } else {
                            Double d4 = zzlkVar.zzg;
                            if (d4 != null) {
                                bundle.putDouble(zzlkVar.zzb, d4.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                try {
                    this.f21900f.q();
                    this.f21900f.f21734a.zzv().zzS(this.f21899e, bundle);
                } catch (Throwable th) {
                    th = th;
                    bundle2 = bundle;
                    this.f21900f.f21734a.zzv().zzS(this.f21899e, bundle2);
                    throw th;
                }
            } catch (RemoteException e5) {
                e4 = e5;
                this.f21900f.f21734a.zzaA().zzd().zzc("Failed to get user properties; remote exception", this.f21895a, e4);
                this.f21900f.f21734a.zzv().zzS(this.f21899e, bundle);
            }
        } catch (RemoteException e6) {
            bundle = bundle2;
            e4 = e6;
        } catch (Throwable th2) {
            th = th2;
            this.f21900f.f21734a.zzv().zzS(this.f21899e, bundle2);
            throw th;
        }
    }
}
