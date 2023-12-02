package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfe;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzau extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f19084b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ HashMap f19085c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ HashMap f19086d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzaw f19087e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzau(zzaw zzawVar, View view, HashMap hashMap, HashMap hashMap2) {
        this.f19087e = zzawVar;
        this.f19084b = view;
        this.f19085c = hashMap;
        this.f19086d = hashMap2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.i(this.f19084b.getContext(), "native_ad_view_holder_delegate");
        return new zzfa();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zzj(ObjectWrapper.wrap(this.f19084b), ObjectWrapper.wrap(this.f19085c), ObjectWrapper.wrap(this.f19086d));
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        zzbsy zzbsyVar;
        zzbgr zzbgrVar;
        zzbbm.zza(this.f19084b.getContext());
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjo)).booleanValue()) {
            zzbgrVar = this.f19087e.f19098g;
            return zzbgrVar.zza(this.f19084b, this.f19085c, this.f19086d);
        }
        try {
            return zzbfa.zze(((zzbfe) zzbzv.zzb(this.f19084b.getContext(), "com.google.android.gms.ads.ChimeraNativeAdViewHolderDelegateCreatorImpl", new zzbzt() { // from class: com.google.android.gms.ads.internal.client.zzat
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzbzt
                public final Object zza(Object obj) {
                    return zzbfd.zzb(obj);
                }
            })).zze(ObjectWrapper.wrap(this.f19084b), ObjectWrapper.wrap(this.f19085c), ObjectWrapper.wrap(this.f19086d)));
        } catch (RemoteException | zzbzu | NullPointerException e4) {
            this.f19087e.f19099h = zzbsw.zza(this.f19084b.getContext());
            zzbsyVar = this.f19087e.f19099h;
            zzbsyVar.zzf(e4, "ClientApiBroker.createNativeAdViewHolderDelegate");
            return null;
        }
    }
}
