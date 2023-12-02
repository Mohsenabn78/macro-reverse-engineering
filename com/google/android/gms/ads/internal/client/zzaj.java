package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnw;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaj extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f19055b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzq f19056c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f19057d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzbnw f19058e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzaw f19059f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(zzaw zzawVar, Context context, zzq zzqVar, String str, zzbnw zzbnwVar) {
        this.f19059f = zzawVar;
        this.f19055b = context;
        this.f19056c = zzqVar;
        this.f19057d = str;
        this.f19058e = zzbnwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object a() {
        zzaw.i(this.f19055b, "banner");
        return new zzew();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zzd(ObjectWrapper.wrap(this.f19055b), this.f19056c, this.f19057d, this.f19058e, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.f19059f.f19092a;
        return zzkVar.zza(this.f19055b, this.f19056c, this.f19057d, this.f19058e, 1);
    }
}
