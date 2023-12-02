package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfvy;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzx implements zzfvy {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzbsi f19569a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f19570b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzaa f19571c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(zzaa zzaaVar, zzbsi zzbsiVar, boolean z3) {
        this.f19571c = zzaaVar;
        this.f19569a = zzbsiVar;
        this.f19570b = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        try {
            zzbsi zzbsiVar = this.f19569a;
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
        ArrayList arrayList = (ArrayList) obj;
        try {
            this.f19569a.zzf(arrayList);
            z3 = this.f19571c.f19518o;
            if (z3 || this.f19570b) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (this.f19571c.o(uri)) {
                        str = this.f19571c.f19527x;
                        w3 = zzaa.w(uri, str, "1");
                        zzfgrVar = this.f19571c.f19517n;
                        zzfgrVar.zzc(w3.toString(), null);
                    } else {
                        if (((Boolean) zzba.zzc().zzb(zzbbm.zzhk)).booleanValue()) {
                            zzfgrVar2 = this.f19571c.f19517n;
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
