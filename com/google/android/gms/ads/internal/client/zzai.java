package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzai extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f19052b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzbnw f19053c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ OnH5AdsEventListener f19054d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(zzaw zzawVar, Context context, zzbnw zzbnwVar, OnH5AdsEventListener onH5AdsEventListener) {
        this.f19052b = context;
        this.f19053c = zzbnwVar;
        this.f19054d = onH5AdsEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @NonNull
    protected final /* synthetic */ Object a() {
        return new zzbjq();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zzk(ObjectWrapper.wrap(this.f19052b), this.f19053c, ModuleDescriptor.MODULE_VERSION, new zzbjd(this.f19054d));
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        try {
            return ((zzbjm) zzbzv.zzb(this.f19052b, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", new zzbzt() { // from class: com.google.android.gms.ads.internal.client.zzah
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzbzt
                public final Object zza(Object obj) {
                    return zzbjl.zzb(obj);
                }
            })).zze(ObjectWrapper.wrap(this.f19052b), this.f19053c, ModuleDescriptor.MODULE_VERSION, new zzbjd(this.f19054d));
        } catch (RemoteException | zzbzu | NullPointerException unused) {
            return null;
        }
    }
}
