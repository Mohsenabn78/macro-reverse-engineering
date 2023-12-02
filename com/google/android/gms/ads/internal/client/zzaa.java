package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbrq;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzbrv;
import com.google.android.gms.internal.ads.zzbrw;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaa extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f19044b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzaw f19045c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(zzaw zzawVar, Activity activity) {
        this.f19045c = zzawVar;
        this.f19044b = activity;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.i(this.f19044b, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zzm(ObjectWrapper.wrap(this.f19044b));
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        zzbsy zzbsyVar;
        zzbrq zzbrqVar;
        zzbbm.zza(this.f19044b);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjo)).booleanValue()) {
            zzbrqVar = this.f19045c.f19097f;
            return zzbrqVar.zza(this.f19044b);
        }
        try {
            return zzbrs.zzH(((zzbrw) zzbzv.zzb(this.f19044b, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", new zzbzt() { // from class: com.google.android.gms.ads.internal.client.zzz
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzbzt
                public final Object zza(Object obj) {
                    return zzbrv.zzb(obj);
                }
            })).zze(ObjectWrapper.wrap(this.f19044b)));
        } catch (RemoteException | zzbzu | NullPointerException e4) {
            this.f19045c.f19099h = zzbsw.zza(this.f19044b.getApplicationContext());
            zzbsyVar = this.f19045c.f19099h;
            zzbsyVar.zzf(e4, "ClientApiBroker.createAdOverlay");
            return null;
        }
    }
}
