package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzal extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f19065b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzq f19066c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f19067d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzaw f19068e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(zzaw zzawVar, Context context, zzq zzqVar, String str) {
        this.f19068e = zzawVar;
        this.f19065b = context;
        this.f19066c = zzqVar;
        this.f19067d = str;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object a() {
        zzaw.i(this.f19065b, FirebaseAnalytics.Event.SEARCH);
        return new zzew();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zzf(ObjectWrapper.wrap(this.f19065b), this.f19066c, this.f19067d, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.f19068e.f19092a;
        return zzkVar.zza(this.f19065b, this.f19066c, this.f19067d, null, 3);
    }
}
