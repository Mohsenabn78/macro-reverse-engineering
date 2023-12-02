package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzac extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f19046b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzbnw f19047c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(zzaw zzawVar, Context context, zzbnw zzbnwVar) {
        this.f19046b = context;
        this.f19047c = zzbnwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.i(this.f19046b, "out_of_context_tester");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        IObjectWrapper wrap = ObjectWrapper.wrap(this.f19046b);
        zzbbm.zza(this.f19046b);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziR)).booleanValue()) {
            return zzceVar.zzh(wrap, this.f19047c, ModuleDescriptor.MODULE_VERSION);
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        IObjectWrapper wrap = ObjectWrapper.wrap(this.f19046b);
        zzbbm.zza(this.f19046b);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zziR)).booleanValue()) {
            return null;
        }
        try {
            return ((zzdk) zzbzv.zzb(this.f19046b, "com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl", new zzbzt() { // from class: com.google.android.gms.ads.internal.client.zzab
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzbzt
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface queryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTesterCreator");
                    if (queryLocalInterface instanceof zzdk) {
                        return (zzdk) queryLocalInterface;
                    }
                    return new zzdk(obj);
                }
            })).zze(wrap, this.f19047c, ModuleDescriptor.MODULE_VERSION);
        } catch (RemoteException | zzbzu | NullPointerException e4) {
            zzbsw.zza(this.f19046b).zzf(e4, "ClientApiBroker.getOutOfContextTester");
            return null;
        }
    }
}
