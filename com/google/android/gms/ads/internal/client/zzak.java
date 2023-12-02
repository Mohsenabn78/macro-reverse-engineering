package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzak extends zzax {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f19060b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzq f19061c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f19062d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzbnw f19063e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzaw f19064f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(zzaw zzawVar, Context context, zzq zzqVar, String str, zzbnw zzbnwVar) {
        this.f19064f = zzawVar;
        this.f19060b = context;
        this.f19061c = zzqVar;
        this.f19062d = str;
        this.f19063e = zzbnwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object a() {
        zzaw.i(this.f19060b, FirebaseAnalytics.Event.APP_OPEN);
        return new zzew();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b(zzce zzceVar) throws RemoteException {
        return zzceVar.zzc(ObjectWrapper.wrap(this.f19060b), this.f19061c, this.f19062d, this.f19063e, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.f19064f.f19092a;
        return zzkVar.zza(this.f19060b, this.f19061c, this.f19062d, this.f19063e, 4);
    }
}
