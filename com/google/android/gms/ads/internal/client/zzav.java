package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbvz;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzav extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f19088b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f19089c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzbnw f19090d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzaw f19091e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(zzaw zzawVar, Context context, String str, zzbnw zzbnwVar) {
        this.f19091e = zzawVar;
        this.f19088b = context;
        this.f19089c = str;
        this.f19090d = zzbnwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.i(this.f19088b, "rewarded");
        return new zzfc();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zzo(ObjectWrapper.wrap(this.f19088b), this.f19089c, this.f19090d, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        return zzbvz.zza(this.f19088b, this.f19089c, this.f19090d);
    }
}
