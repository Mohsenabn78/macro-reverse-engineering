package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbro;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzag extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f19050b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzbnw f19051c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(zzaw zzawVar, Context context, zzbnw zzbnwVar) {
        this.f19050b = context;
        this.f19051c = zzbnwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    protected final /* bridge */ /* synthetic */ Object a() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zzl(ObjectWrapper.wrap(this.f19050b), this.f19051c, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        try {
            return ((zzbrp) zzbzv.zzb(this.f19050b, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", new zzbzt() { // from class: com.google.android.gms.ads.internal.client.zzaf
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzbzt
                public final Object zza(Object obj) {
                    return zzbro.zzb(obj);
                }
            })).zze(ObjectWrapper.wrap(this.f19050b), this.f19051c, ModuleDescriptor.MODULE_VERSION);
        } catch (RemoteException | zzbzu | NullPointerException unused) {
            return null;
        }
    }
}
