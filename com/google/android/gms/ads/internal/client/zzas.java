package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbey;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzas extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FrameLayout f19080b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FrameLayout f19081c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Context f19082d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzaw f19083e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzaw zzawVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.f19083e = zzawVar;
        this.f19080b = frameLayout;
        this.f19081c = frameLayout2;
        this.f19082d = context;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.i(this.f19082d, "native_ad_view_delegate");
        return new zzez();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zzi(ObjectWrapper.wrap(this.f19080b), ObjectWrapper.wrap(this.f19081c));
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        zzbsy zzbsyVar;
        zzbgq zzbgqVar;
        zzbbm.zza(this.f19082d);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjo)).booleanValue()) {
            zzbgqVar = this.f19083e.f19095d;
            return zzbgqVar.zza(this.f19082d, this.f19080b, this.f19081c);
        }
        try {
            return zzbeu.zzbx(((zzbey) zzbzv.zzb(this.f19082d, "com.google.android.gms.ads.ChimeraNativeAdViewDelegateCreatorImpl", new zzbzt() { // from class: com.google.android.gms.ads.internal.client.zzar
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzbzt
                public final Object zza(Object obj) {
                    return zzbex.zzb(obj);
                }
            })).zze(ObjectWrapper.wrap(this.f19082d), ObjectWrapper.wrap(this.f19080b), ObjectWrapper.wrap(this.f19081c), ModuleDescriptor.MODULE_VERSION));
        } catch (RemoteException | zzbzu | NullPointerException e4) {
            this.f19083e.f19099h = zzbsw.zza(this.f19082d);
            zzbsyVar = this.f19083e.f19099h;
            zzbsyVar.zzf(e4, "ClientApiBroker.createNativeAdViewDelegate");
            return null;
        }
    }
}
