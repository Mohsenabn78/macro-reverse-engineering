package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfvy;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzy implements zzfvy {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzbsi f19572a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f19573b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzaa f19574c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(zzaa zzaaVar, zzbsi zzbsiVar, boolean z3) {
        this.f19574c = zzaaVar;
        this.f19572a = zzbsiVar;
        this.f19573b = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        try {
            zzbsi zzbsiVar = this.f19572a;
            String message = th.getMessage();
            zzbsiVar.zze("Internal error: " + message);
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        boolean z3;
        String str;
        Uri w3;
        zzfgr zzfgrVar;
        zzfgr zzfgrVar2;
        List<Uri> list = (List) obj;
        try {
            zzaa.f(this.f19574c, list);
            this.f19572a.zzf(list);
            z3 = this.f19574c.f19519p;
            if (z3 || this.f19573b) {
                for (Uri uri : list) {
                    if (this.f19574c.n(uri)) {
                        str = this.f19574c.f19527x;
                        w3 = zzaa.w(uri, str, "1");
                        zzfgrVar = this.f19574c.f19517n;
                        zzfgrVar.zzc(w3.toString(), null);
                    } else {
                        if (((Boolean) zzba.zzc().zzb(zzbbm.zzhk)).booleanValue()) {
                            zzfgrVar2 = this.f19574c.f19517n;
                            zzfgrVar2.zzc(uri.toString(), null);
                        }
                    }
                }
            }
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
        }
    }
}
