package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzao extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f19074b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f19075c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzbnw f19076d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzaw f19077e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(zzaw zzawVar, Context context, String str, zzbnw zzbnwVar) {
        this.f19077e = zzawVar;
        this.f19074b = context;
        this.f19075c = str;
        this.f19076d = zzbnwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.i(this.f19074b, "native_ad");
        return new zzeu();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zzb(ObjectWrapper.wrap(this.f19074b), this.f19075c, this.f19076d, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        zzi zziVar;
        zzbsy zzbsyVar;
        Object zzboVar;
        zzbbm.zza(this.f19074b);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjo)).booleanValue()) {
            zziVar = this.f19077e.f19093b;
            return zziVar.zza(this.f19074b, this.f19075c, this.f19076d);
        }
        try {
            IBinder zze = ((zzbr) zzbzv.zzb(this.f19074b, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", new zzbzt() { // from class: com.google.android.gms.ads.internal.client.zzan
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzbzt
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface queryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    if (queryLocalInterface instanceof zzbr) {
                        return (zzbr) queryLocalInterface;
                    }
                    return new zzbr(obj);
                }
            })).zze(ObjectWrapper.wrap(this.f19074b), this.f19075c, this.f19076d, ModuleDescriptor.MODULE_VERSION);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzbq) {
                zzboVar = (zzbq) queryLocalInterface;
            } else {
                zzboVar = new zzbo(zze);
            }
            return zzboVar;
        } catch (RemoteException | zzbzu | NullPointerException e4) {
            this.f19077e.f19099h = zzbsw.zza(this.f19074b);
            zzbsyVar = this.f19077e.f19099h;
            zzbsyVar.zzf(e4, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        }
    }
}
