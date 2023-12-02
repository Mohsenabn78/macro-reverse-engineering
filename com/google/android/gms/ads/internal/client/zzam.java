package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnw;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzam extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f19069b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzq f19070c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f19071d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzbnw f19072e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzaw f19073f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzam(zzaw zzawVar, Context context, zzq zzqVar, String str, zzbnw zzbnwVar) {
        this.f19073f = zzawVar;
        this.f19069b = context;
        this.f19070c = zzqVar;
        this.f19071d = str;
        this.f19072e = zzbnwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object a() {
        zzaw.i(this.f19069b, "interstitial");
        return new zzew();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zze(ObjectWrapper.wrap(this.f19069b), this.f19070c, this.f19071d, this.f19072e, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.f19073f.f19092a;
        return zzkVar.zza(this.f19069b, this.f19070c, this.f19071d, this.f19072e, 2);
    }
}
