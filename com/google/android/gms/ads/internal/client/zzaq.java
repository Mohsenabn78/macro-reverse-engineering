package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaq extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f19078b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzaw f19079c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaq(zzaw zzawVar, Context context) {
        this.f19079c = zzawVar;
        this.f19078b = context;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.i(this.f19078b, "mobile_ads_settings");
        return new zzey();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zzg(ObjectWrapper.wrap(this.f19078b), ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        zzeq zzeqVar;
        zzbsy zzbsyVar;
        Object zzcmVar;
        zzbbm.zza(this.f19078b);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjo)).booleanValue()) {
            zzeqVar = this.f19079c.f19094c;
            return zzeqVar.zza(this.f19078b);
        }
        try {
            IBinder zze = ((zzcp) zzbzv.zzb(this.f19078b, "com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl", new zzbzt() { // from class: com.google.android.gms.ads.internal.client.zzap
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzbzt
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface queryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
                    if (queryLocalInterface instanceof zzcp) {
                        return (zzcp) queryLocalInterface;
                    }
                    return new zzcp(obj);
                }
            })).zze(ObjectWrapper.wrap(this.f19078b), ModuleDescriptor.MODULE_VERSION);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzco) {
                zzcmVar = (zzco) queryLocalInterface;
            } else {
                zzcmVar = new zzcm(zze);
            }
            return zzcmVar;
        } catch (RemoteException | zzbzu | NullPointerException e4) {
            this.f19079c.f19099h = zzbsw.zza(this.f19078b);
            zzbsyVar = this.f19079c.f19099h;
            zzbsyVar.zzf(e4, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        }
    }
}
